package ned.fdmc.data.models;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    private void setPassword(String password) {
        this.password = password;
    }
}
