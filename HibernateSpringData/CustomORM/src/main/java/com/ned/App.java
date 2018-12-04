package com.ned;

import com.ned.db.EntityDbContext;
import com.ned.db.base.DbContext;
import com.ned.entities.Department;
import com.ned.entities.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class App {
    private static final String CONNECTION_STRING =
            "jdbc:mysql://localhost:3306/soft_uni_simple";

    public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        Connection connection = getConnection();

        DbContext<User> usersDbContext =
                getDbContext(connection, User.class);

        DbContext<Department> departmentDbContext =
                getDbContext(connection, Department.class);

        User user = new User("Pesho", "Peshev");
        user.setAge(25);
        user.setUcn("1234567890");

        User pena = new User("Pena", "Penewa");

//        usersDbContext.persist(user);
        usersDbContext.persist(pena);

//        usersDbContext.delete("first_name LIKE ('P%')");

//        User pesho = usersDbContext.findById(1);
//        pesho.setLastName("PESHEV");
//
//        usersDbContext.persist(pesho);
//
//        usersDbContext.find()
//                .forEach(System.out::println);
//        User user = usersDbContext.findFirst();
//        System.out.println(user);
//        user.setLastName("Wse taq");S
//
//        usersDbContext.persist(user);
//                DbContext<Department> departmentDbContext
//                = getDbContext(connection, Department.class);
//        departmentDbContext.find()
//                .forEach(System.out::println);

//        connection.close();
    }

    private static <T> DbContext<T> getDbContext(Connection connection, Class<T> klass) throws SQLException {
        return new EntityDbContext<>(connection, klass);
    }

    private static Connection getConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "881223");

        return DriverManager.getConnection(
                CONNECTION_STRING,
                props
        );
    }
}
