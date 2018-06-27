package nnglebanov.automationtools.driverfactory.enums;

/**
 * Created by WE on 26.06.2018.
 */
public enum Browsers {
    CHROME("chrome"),FIREFOX("firefox"),IE("internet explorer"),EDGE("edge"),OPERA_BLINK("opera blink");

    private Browsers(String name)
    {
        this.name=name;
    }

    private final String name;

    @Override
    public String toString() {
        return this.name;
    }

}