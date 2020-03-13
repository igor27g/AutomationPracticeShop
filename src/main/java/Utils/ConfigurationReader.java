package Utils;

public class ConfigurationReader extends FileReader {

    private String configurationLocation;

    private String baseUrl;

    public ConfigurationReader(String configurationLocation) {
        super(configurationLocation);
        this.configurationLocation = configurationLocation;
    }

    void loadData() {
        baseUrl = properties.getProperty("baseUrl");
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getConfigurationLocation() {
        return configurationLocation;
    }

}