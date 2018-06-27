package nnglebanov.automationtools.driverfactory;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * Created by WE on 23.06.2018.
 */
public class CreateRemoteDriver {

    public static RemoteWebDriver getRemoteDriver(URL remoteMachine,DesiredCapabilities remoteCaps)
    {
        return new RemoteWebDriver(remoteMachine, remoteCaps);
    }

}
