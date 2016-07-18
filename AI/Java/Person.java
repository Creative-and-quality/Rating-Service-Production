package sample;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Aleksandr on 23.06.2016.
 */
public class Person {

    private SimpleStringProperty fio = new SimpleStringProperty("");


    public Person(String fio) {
        this.fio = new SimpleStringProperty(fio);
    }


    public Person() {
    }


    public String getFio() {
        return fio.get();
    }

    public void setFio(String fio) {
        this.fio.set(fio);
    }

    public SimpleStringProperty fioProperty() {
        return fio;
    }
}
