package Utils;

public class TestDataReader extends FileReader {

    private String testDataLocation;
    private User user;
    private ClaimInformation claimInformation;
    private Product product;

    public TestDataReader(String testDataLocation) {
        super(testDataLocation);
        this.testDataLocation = testDataLocation;
    }

    void loadData() {
        user = new User(properties);
        claimInformation = new ClaimInformation(properties);
        product = new Product(properties);
    }

    public User getUser() {
        return user;
    }

    public ClaimInformation getClaimInformation() {
        return claimInformation;
    }

    public Product getProduct() {
        return product;
    }

    public String getTestDataLocation() {
        return testDataLocation;
    }



}
