package com.ral1996.sv.browsers;

/*
    Documentation: https://docs.saucelabs.com/web-apps/automated-testing/selenium/
    Developer: Mts. Ing. Raúl Mauricio Portillo Muñoz
    Description: Can you use this Class for run test on remote browser (Saucelabs)
 */

import com.ral1996.sv.utilities.ProgramConstants;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Saucelabs {
    public static RemoteWebDriver getRemoteWebDriver() throws MalformedURLException {

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName(ProgramConstants.SET_PLATFORM_NAME);
        browserOptions.setBrowserVersion(ProgramConstants.SET_BROWSER_VERSION);
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put(ProgramConstants.SAUCE_OPTION_USERNAME, "<your username>");
        sauceOptions.put(ProgramConstants.SAUCE_OPTION_ACCESSKEY, "<your access key>");
        sauceOptions.put(ProgramConstants.SAUCE_OPTION_BUILD, "<your build id>");
        sauceOptions.put(ProgramConstants.SAUCE_OPTION_TESTNAME, "<your test name>");
        browserOptions.setCapability(ProgramConstants.SAUCE_OPTIONS, sauceOptions);

        URL url = new URL(ProgramConstants.SAUCE_HUB);

        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(url, browserOptions);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }
}
