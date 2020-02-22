package Utils;

import java.util.Properties;

public class User {
    private final String email;
    private final String password;

    public User(Properties properties) {
        email = properties.getProperty("user.email");
        password = properties.getProperty("user.password");
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
