package sample.Sites;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Aleksandr on 29.06.2016.
 */
public class Sites {
    private SimpleStringProperty site = new SimpleStringProperty("");


    public Sites(String site) {
        this.site = new SimpleStringProperty(site);
    }


    public Sites() {
    }

    public String getSite() {
        return site.get();
    }

    public SimpleStringProperty siteProperty() {
        return site;
    }

    public void setSite(String site) {
        this.site.set(site);
    }
}
