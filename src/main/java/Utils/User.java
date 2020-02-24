package Utils;

import java.util.Properties;

public class User {
    private final String email;
    private final String password;
    private final String name;
    private final String lastName;
    private final String street;



    private final String city;
    private final String postalCode;
    private final String mobilePhone;

    public User(Properties properties) {
        email = properties.getProperty("user.email");
        password = properties.getProperty("user.password");
        name = properties.getProperty("user.name");
        lastName = properties.getProperty("user.lastName");
        street = properties.getProperty("user.street");
        city = properties.getProperty("user.city");
        postalCode = properties.getProperty("user.postalCode");
        mobilePhone = properties.getProperty("user.mobilePhone");
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

}


