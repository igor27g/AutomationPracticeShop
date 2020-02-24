package Utils;

import java.util.Properties;

public class ClaimInformation {

    private final String orderNumber;
    private final String filePath;
    private final String textMessage;
    private final String twitterUrl;


    public ClaimInformation(Properties properties) {
        orderNumber = properties.getProperty("claimInformation.orderNumber");
        filePath = properties.getProperty("claimInformation.filePath");
        textMessage = properties.getProperty("claimInformation.textMessage");
        twitterUrl = properties.getProperty("claimInformation.twitterUrl");
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public String getTwitterUrl() {
        return twitterUrl;
    }

}
