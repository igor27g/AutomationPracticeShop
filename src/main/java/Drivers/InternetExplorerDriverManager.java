package Drivers;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class InternetExplorerDriverManager extends DriverManager {

    private InternetExplorerDriverService iEService;

    @Override
    public void startService() {
        if (null == iEService) {
            try {
                iEService = new InternetExplorerDriverService.Builder()
                        .usingDriverExecutable(new File("src/main/resources/IEDRiverServer.exe"))
                        .usingAnyFreePort()
                        .build();
                iEService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stopService() {
        if (null != iEService && iEService.isRunning())
            iEService.stop();
    }

    @Override
    public void createDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.setCapability("ignoreZoomSetting", true);
        driver = new InternetExplorerDriver(iEService,capabilities);
    }

}