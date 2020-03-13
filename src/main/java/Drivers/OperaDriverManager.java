package Drivers;

import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaDriverService;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class OperaDriverManager extends DriverManager {

    private OperaDriverService operaService;

    @Override
    public void startService() {
        if (null == operaService) {
            try {
                operaService = new OperaDriverService.Builder()
                        .usingDriverExecutable(new File("src/main/resources/operadriver.exe"))
                        .usingAnyFreePort()
                        .build();
                operaService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stopService() {
        if (null != operaService && operaService.isRunning())
            operaService.stop();
    }

    @Override
    public void createDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.operaBlink();
        OperaOptions options = new OperaOptions();
        options.setCapability("ignoreZoomSetting", true);
        driver = new OperaDriver(operaService,capabilities);
    }

}