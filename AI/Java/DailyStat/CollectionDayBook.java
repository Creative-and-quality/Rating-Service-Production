package sample.DailyStat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Keys.Keys;

/**
 * Created by Aleksandr on 29.06.2016.
 */
public class CollectionDayBook {
    private ObservableList<Days> dayList = FXCollections.observableArrayList();


    public void add(Days days) {
        dayList.add(days);
    }

    public void delete(Days days) {
        dayList.remove(days);
    }

    public ObservableList<Days> getDayList() {
        return dayList;
    }

    public void fillTestDaysData(){
        dayList.add(new Days("01.01.2001","3564"));
        dayList.add(new Days("02.02.2002","1"));
        dayList.add(new Days("03.03.2003","456"));
        dayList.add(new Days("04.04.2004","777"));
        dayList.add(new Days("05.05.2005","99"));

    }
}
