package sample.Keys;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Aleksandr on 29.06.2016.
 */
public class Keys {
    private SimpleStringProperty key = new SimpleStringProperty("");


    public Keys(String key) {
        this.key = new SimpleStringProperty(key);
    }


    public Keys() {
    }


    public String getKey() {
        return key.get();
    }

    public SimpleStringProperty keyProperty() {
        return key;
    }

    public void setKey(String key) {
        this.key.set(key);
    }

}
