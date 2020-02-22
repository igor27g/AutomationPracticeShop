package Utils;

public class TestDataReader extends FileReader {

    private String testDataLocation;
    private User user;

    public TestDataReader(String testDataLocation) {
        super(testDataLocation);
        this.testDataLocation = testDataLocation;
    }

    void loadData() {
        user = new User(properties);
    }

    public User getUser() {
        return user;
    }

    public String getTestDataLocation() {
        return testDataLocation;
    }



}
