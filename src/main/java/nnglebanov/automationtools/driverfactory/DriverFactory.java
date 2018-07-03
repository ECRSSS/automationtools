package nnglebanov.automationtools.driverfactory;

import nnglebanov.automationtools.G_VARIABLES;
import nnglebanov.automationtools.driverfactory.enums.Browsers;
import nnglebanov.automationtools.driverfactory.enums.Environment;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.io.FileInputStream;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Carl Cocchiaro
 *
 * Selenium Driver Class
 *
 */
public class DriverFactory {
    // local variables
    private static DriverFactory instance = null;
    private static final int IMPLICIT_TIMEOUT = 0;

    private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
    private ThreadLocal<String> sessionId = new ThreadLocal<String>();
    private ThreadLocal<String> sessionBrowser = new ThreadLocal<String>();
    private ThreadLocal<String> sessionPlatform = new ThreadLocal<String>();
    private ThreadLocal<String> sessionVersion = new ThreadLocal<String>();

    private Environment getEnv = null;
    private Properties props = new Properties();

    // constructor
    private DriverFactory() {
    }

    /**
     * getInstance method to retrieve active driver instance
     *
     * @return DriverFactory
     */
    public static DriverFactory getInstance() {
        if ( instance == null ) {
            instance = new DriverFactory();
        }

        return instance;
    }

    /**
     * setDriver method to create driver instance
     *
     * @param browser
     * @param environment
     * @param platform
     * @param optPreferences
     * @throws Exception
     */
    @SafeVarargs
    public final void setDriver(Browsers browser,
                                String platform,
                                Environment environment,
                                Map<String, Object>... optPreferences)
            throws Exception {

        MutableCapabilities caps = null;
        String getPlatform = null;
        props.load(new FileInputStream(G_VARIABLES.SE_PROPS));

        if(environment.equals(Environment.LOCAL)) {
            switch (browser) {
                case FIREFOX:

                    caps = OptionsFactory.getOptions(browser);

                        System.setProperty("webdriver.gecko.driver", props.getProperty("gecko.driver.windows.path"));
                        webDriver.set(new FirefoxDriver((FirefoxOptions) caps));

                    break;
                case CHROME:

                    caps = OptionsFactory.getOptions(browser);

                        System.setProperty("webdriver.chrome.driver", props.getProperty("chrome.driver.windows.path"));
                        webDriver.set(new ChromeDriver((ChromeOptions) caps));

                    break;
                case IE:

                    caps = OptionsFactory.getOptions(browser);



                        System.setProperty("webdriver.ie.driver", props.getProperty("ie.driver.windows.path"));
                        webDriver.set(new InternetExplorerDriver((InternetExplorerOptions) caps));

                    break;
            }
        }else if(environment.equals(Environment.REMOTE))
        {
                caps=OptionsFactory.getOptions(browser);
                String url=props.getProperty("remote.url");
                RemoteWebDriver driver = new RemoteWebDriver(new URL(url), caps);
                webDriver.set(driver);
        }

        getEnv = environment;
        getPlatform = platform;
        sessionId.set(((RemoteWebDriver) webDriver.get()).getSessionId().toString());
        sessionBrowser.set(caps.getBrowserName());
        sessionVersion.set(caps.getVersion());
        sessionPlatform.set(getPlatform);

        System.out.println("\n*** TEST ENVIRONMENT = "
                + getSessionBrowser().toUpperCase()
                + "/" + getSessionPlatform().toUpperCase()
                + "/" + getEnv.toString()
                + "/Selenium Version=" + props.getProperty("selenium.revision")
                + "/Session ID=" + getSessionId() + "\n");

        getDriver().manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
    }

    /**
     * getDriver method to retrieve active driver
     *
     * @return WebDriver
     */
    public WebDriver getDriver() {
        return webDriver.get();
    }

    /**
     * closeDriver method to close active driver
     *
     */
    public void closeDriver() {
        try {
            getDriver().quit();
        }

        catch ( Exception e ) {
            // do something
        }
    }

    /**
     * getSessionId method to retrieve active id
     *
     * @return String
     * @throws Exception
     */
    public String getSessionId() throws Exception {
        return sessionId.get();
    }

    /**
     * getSessionBrowser method to retrieve active browser
     * @return String
     * @throws Exception
     */
    public String getSessionBrowser() throws Exception{
        return sessionBrowser.get();
    }

    /**
     * getSessionVersion method to retrieve active version
     *
     * @return String
     * @throws Exception
     */
    public String getSessionVersion() throws Exception {
        return sessionVersion.get();
    }

    /**
     * getSessionPlatform method to retrieve active platform
     * @return String
     * @throws Exception
     */
    public String getSessionPlatform() throws Exception {
        return sessionPlatform.get();
    }

}