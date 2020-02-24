package Utils;

public class TestDataReader extends FileReader {

    private String testDataLocation;
    private User user;
    private ClaimInformation claimInformation;

    public TestDataReader(String testDataLocation) {
        super(testDataLocation);
        this.testDataLocation = testDataLocation;
    }

    void loadData() {
        user = new User(properties);
        claimInformation = new ClaimInformation(properties);
    }

    public User getUser() {
        return user;
    }

    public ClaimInformation getClaimInformation() {
        return claimInformation;
    }

    public String getTestDataLocation() {
        return testDataLocation;
    }



}
