package sample.DailyStat;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Aleksandr on 29.06.2016.
 */
public class Days {
    private SimpleStringProperty day = new SimpleStringProperty("");
    private SimpleStringProperty number = new SimpleStringProperty("");


    public Days(String day, String number) {
        this.day = new SimpleStringProperty(day);
        this.number = new SimpleStringProperty(number);
    }


    public Days() {
    }


    public String getDay() {
        return day.get();
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

    public SimpleStringProperty dayProperty() {
        return day;
    }

    public void setDay(String day) {
        this.day.set(day);
    }

}
