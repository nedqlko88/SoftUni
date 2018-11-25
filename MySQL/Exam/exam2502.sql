#1
CREATE TABLE users(
	id	INT(11) Primary Key AUTO_INCREMENT,
	username VARCHAR(30) UNIQUE NOT NULL,
	password VARCHAR(30) NOT NULL,
	email VARCHAR(50)
);

CREATE TABLE repositories(
	id	INT(11) Primary Key AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL
	
);

CREATE TABLE repositories_contributors(
	repository_id INT(11),
	contributor_id INT(11)
);

CREATE TABLE issues(
	id	INT(11) Primary Key AUTO_INCREMENT,
	title VARCHAR(255) NOT NULL,
	issue_status VARCHAR(6) NOT NULL,
	repository_id INT(11) NOT NULL,
	assignee_id	INT(11) NOT NULL
);

CREATE TABLE commits(
	id	INT(11) Primary Key AUTO_INCREMENT,
	message VARCHAR(255) NOT NULL,
	issue_id INT(11),
	repository_id INT(11) NOT NULL,
	contributor_id	INT(11) NOT NULL
);

CREATE TABLE files(
	id	INT(11) Primary Key AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	size DECIMAL(10,2) NOT NULL,
	parent_id INT(11),
	commit_id INT(11) NOT NULL
);

ALTER TABLE repositories_contributors
ADD CONSTRAINT fk_repositories_contributors_users
FOREIGN KEY repositories_contributors(contributor_id)
REFERENCES users(id);

ALTER TABLE repositories_contributors 
ADD CONSTRAINT fk_repositories_contributors_repositories
FOREIGN KEY repositories_contributors(repository_id)
REFERENCES repositories(id);

ALTER TABLE issues 
ADD CONSTRAINT fk_issues_repositories
FOREIGN KEY issues(repository_id)
REFERENCES repositories(id);

ALTER TABLE issues 
ADD CONSTRAINT fk_issues_users
FOREIGN KEY issues(assignee_id)
REFERENCES users(id);

ALTER TABLE commits 
ADD CONSTRAINT fk_commits_issues
FOREIGN KEY commits(issue_id)
REFERENCES issues(id);

ALTER TABLE commits 
ADD CONSTRAINT fk_commits_repositories
FOREIGN KEY commits(repository_id)
REFERENCES repositories(id);

ALTER TABLE commits 
ADD CONSTRAINT fk_commits_users
FOREIGN KEY commits(contributor_id)
REFERENCES users(id);

ALTER TABLE files 
ADD CONSTRAINT fk_files_commits
FOREIGN KEY files(commit_id)
REFERENCES commits(id);

ALTER TABLE files 
ADD CONSTRAINT fk_files_files
FOREIGN KEY files(parent_id)
REFERENCES files(id);


#2
INSERT INTO issues(title, issue_status, repository_id, assignee_id)

		SELECT
			CONCAT('Critical Problem With ', f.name, '!'),
			'open' AS issue_status,
			CEILING(f.id * 2 / 3) AS repository_id,
			c.contributor_id
		FROM files f
		JOIN commits c
		ON c.id = f.commit_id
        WHERE f.id BETWEEN 46 AND 50;


#3
INSERT INTO repositories_contributors(contributor_id, repository_id)  
SELECT *
FROM (
		SELECT contributor_id
		FROM repositories_contributors
		WHERE contributor_id = repository_id
	) AS t1
CROSS JOIN (
		SELECT MIN(r.id) as `repository_id`
		FROM repositories r
		LEFT JOIN repositories_contributors rc
		ON r.id = rc.repository_id
		WHERE rc.repository_id IS NULL
		) as t2
WHERE t2.repository_id IS NOT NULL;


#4
DELETE FROM repositories
WHERE id NOT IN ( 
	SELECT repository_id
    FROM issues
    );


#5
SELECT id, username
FROM users
ORDER BY id;


#6
SELECT *
FROM repositories_contributors
WHERE repository_id = contributor_id
ORDER BY repository_id;


#7
SELECT id, name, size
FROM files
WHERE size > 1000 AND name LIKE '%html%'
ORDER BY size DESC;


#8
SELECT i.id, CONCAT(u.username,' : ',i.title)
FROM issues i 
JOIN users u
ON i.assignee_id = u.id
ORDER BY i.id DESC;


#9
SELECT d.id, d.name AS `Name`, CONCAT(d.size, 'KB') AS `size`
FROM files f
RIGHT JOIN files d
ON f.parent_id = d.id
WHERE f.id is NULL;


#10
SELECT i.repository_id AS `id`,r.name, COUNT(i.id) AS `issues`
FROM issues i
JOIN repositories r
ON i.repository_id = r.id 
GROUP BY i.repository_id
ORDER BY issues DESC, id
LIMIT 5;


#11
SELECT r.id, 
	r.name, 
    (
		SELECT COUNT(*) 
        FROM commits 
        WHERE commits.repository_id = r.id
	) AS `commits`, 
    COUNT(u.id) AS `contributors`
    
FROM users u
JOIN repositories_contributors rc
ON rc.contributor_id = u.id
JOIN repositories r
ON r.id = rc.repository_id
GROUP BY r.id
ORDER BY contributors DESC, r.id
LIMIT 1;


#12
SELECT u.id, 
	u.username, 
    ( 
		SELECT COUNT(c.id)
        FROM commits AS c
        JOIN issues AS i 
        ON i.id = c.issue_id
        WHERE i.assignee_id = u.id AND c.contributor_id = u.id
	) AS `com`
FROM users AS u
ORDER BY com DESC, u.id;


#13
 SELECT LEFT(f1.name, LOCATE('.', f1.name) - 1) AS `file`, 
	( 
		SELECT COUNT(*)
        FROM commits c
        WHERE c.message LIKE CONCAT('%', f1.name, '%')
	) AS `count`
 FROM files f1
 JOIN files f2
 ON f1.parent_id = f2.id AND f2.parent_id = f1.id AND f1.id != f2.id
 #JOIN commits c
 #ON c.message LIKE concat('%', f1.name, '%')
 GROUP BY f1.id
 ORDER BY f1.name;


#14
SELECT r.id, r.name, COUNT(DISTINCT c.contributor_id) AS `users`
FROM repositories r
LEFT JOIN commits c
ON r.id = c.repository_id
GROUP BY r.id
ORDER BY users DESC, r.id;


#15
DROP PROCEDURE udp_commit;
DELIMITER $$
CREATE PROCEDURE udp_commit(
	username VARCHAR(30), 
	password VARCHAR(30), 
    message VARCHAR(255), 
    issue_id INT)
BEGIN
	DECLARE repository_id INT;
    DECLARE user_id INT;

      
	IF 1 <> (SELECT COUNT(*) FROM users WHERE users.username = username)
    THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'No such user!';
	END IF;
	
	IF 1 <> (SELECT COUNT(*) FROM users WHERE users.username = username AND users.password = password)
    THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Password is incorrect!';
	END IF;
    
	IF 1 <> (SELECT COUNT(*) FROM issues WHERE issues.id = issue_id)
    THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'The issue does not exist!';
	END IF;

	SET user_id := (
		SELECT u.id
        FROM users u
        WHERE u.username = username
	);
	SET repository_id := (
		SELECT i.repository_id
        FROM issues i
        WHERE i.id = issue_id
	);
    
    INSERT INTO commits (repository_id, contributor_id, issue_id, message)
    VALUES (repository_id, user_id, issue_id, message);
    
END $$
DELIMITER ;
CALL udp_commit('WhoDenotesfsBel', 'ajmISQi', 'MEssage 2', 2534634);
CALL udp_commit('WhoDenoteBel', 'ajmISQi*', 'Fixed issue: Invalid welcoming message in READ.html', 223423);


#16
DROP PROCEDURE udp_findbyextension;
DELIMITER $$
CREATE PROCEDURE udp_findbyextension(extension VARCHAR(100))
BEGIN
	SELECT id, name AS `caption`, CONCAT(size, 'KB') AS `user`
    FROM files
    WHERE name LIKE CONCAT('%.',extension);
END $$
DELIMITER ;
CALL udp_findbyextension('html');




















