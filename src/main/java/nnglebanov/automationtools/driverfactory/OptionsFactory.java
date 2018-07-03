package nnglebanov.automationtools.driverfactory;

/**
 * Created by WE on 22.06.2018.
 */
import nnglebanov.automationtools.driverfactory.enums.Browsers;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Optional;
import sun.security.krb5.internal.crypto.Des;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WE on 22.06.2018.
 */
public class OptionsFactory {

    public static MutableCapabilities getOptions(Browsers browser)
    {

        switch(browser)
        {
            case FIREFOX:
            {
                DesiredCapabilities caps = DesiredCapabilities.firefox();

                FirefoxOptions ffOpts = new FirefoxOptions();
                FirefoxProfile ffProfile = new FirefoxProfile();

                ffProfile.setPreference("browser.autofocus", true);
                ffProfile.setPreference("browser.tabs.remote.autostart.2", false);

                caps.setCapability(FirefoxDriver.PROFILE, ffProfile);
                caps.setCapability("marionette", true);
                ffOpts=ffOpts.merge(caps);
                return ffOpts;
            }
            case CHROME:
            {
                DesiredCapabilities caps = DesiredCapabilities.chrome();

                ChromeOptions chOptions = new ChromeOptions();
                Map<String, Object> chromePrefs = new HashMap<String, Object>();

                chromePrefs.put("credentials_enable_service", false);

                chOptions.setExperimentalOption("prefs", chromePrefs);
                chOptions.addArguments("--disable-plugins", "--disable-extensions", "--disable-popup-blocking");

                caps.setCapability(ChromeOptions.CAPABILITY, chOptions);
                caps.setCapability("applicationCacheEnabled", false);

                chOptions=chOptions.merge(caps);

                return chOptions;
            }
            case IE:
            {
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();

                caps.setCapability("nativeEvents", false);
                caps.setCapability("unexpectedAlertBehaviour", "accept");
                caps.setCapability("ignoreProtectedModeSettings", true);
                caps.setCapability("disable-popup-blocking", true);
                caps.setCapability("enablePersistentHover", true);
                caps.setCapability("ignoreZoomSetting", true);

                InternetExplorerOptions ieOpts = new InternetExplorerOptions();

                ieOpts.requireWindowFocus();
                ieOpts.merge(caps);

                caps.setCapability("requireWindowFocus", true);
                ieOpts=ieOpts.merge(caps);

                return ieOpts;
            }
            case EDGE:
            {
                DesiredCapabilities caps=DesiredCapabilities.edge();
                EdgeOptions eOpts=new EdgeOptions();
                eOpts=eOpts.merge(caps);
                return eOpts;
            }
            case OPERA_BLINK:
            {
                DesiredCapabilities caps=DesiredCapabilities.operaBlink();
                OperaOptions oOpts=new OperaOptions();
                oOpts=oOpts.merge(caps);
                return oOpts;
            }
        }
        return null;
    }
}