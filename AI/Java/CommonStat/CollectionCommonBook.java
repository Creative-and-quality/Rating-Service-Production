package sample.CommonStat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Keys.Keys;

/**
 * Created by Aleksandr on 29.06.2016.
 */
public class CollectionCommonBook {
    private ObservableList<Common> commonList = FXCollections.observableArrayList();


    public void add(Common common) {
        commonList.add(common);
    }

    public void delete(Common common) {
        commonList.remove(common);
    }

    public ObservableList<Common> getCommonList() {
        return commonList;
    }

    public void fillTestCommonData(){
        commonList.add(new Common("Медведев","456"));
        commonList.add(new Common("Путин","456"));
        commonList.add(new Common("Навальный","456"));

    }
}
