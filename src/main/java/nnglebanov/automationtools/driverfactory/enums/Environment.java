package nnglebanov.automationtools.driverfactory.enums;

/**
 * Created by WE on 26.06.2018.
 */
public enum Environment {
    LOCAL("local"),REMOTE("remote");

    private Environment(String name)
    {
        this.name=name;
    }

    private final String name;

    @Override
    public String toString() {
        return this.name;
    }

}
