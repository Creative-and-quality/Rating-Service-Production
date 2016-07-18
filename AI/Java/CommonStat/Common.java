package sample.CommonStat;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Aleksandr on 29.06.2016.
 */
public class Common {
    private SimpleStringProperty name = new SimpleStringProperty("");
    private SimpleStringProperty number = new SimpleStringProperty("");


    public Common(String name, String number) {
        this.name = new SimpleStringProperty(name);
        this.number = new SimpleStringProperty(number);
    }


    public Common() {
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getNumber() {
        return number.get();
    }

    public SimpleStringProperty numberProperty() {
        return number;
    }

    public void setNumber(String number) {
        this.number.set(number);
    }
}
