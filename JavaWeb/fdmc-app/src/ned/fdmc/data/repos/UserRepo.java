package ned.fdmc.data.repos;

import ned.fdmc.data.models.User;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UserRepo {
    private Set<User> users;

    public UserRepo() {
        this.users = new HashSet<>();
    }

    public User getByUsername(String username) {
        return this.users.stream()
                .filter(x -> x.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public Set<User> getAllUsers() {
        return Collections.unmodifiableSet(this.users);
    }

    public boolean userExists(String username) {
        return this.getByUsername(username) != null;
    }

    public boolean isValidCredentials(String username, String password) {
        return this.userExists(username) &&
                this.getByUsername(username).getPassword().equals(password);
    }


}
