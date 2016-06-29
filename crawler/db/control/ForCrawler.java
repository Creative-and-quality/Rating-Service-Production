package db.control;

import db.model.KeyWords;
import db.model.Persons;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by d.zhuchkov on 27.06.2016.
 */
public class ForCrawler {

    private Collection<String> sites;
    private Collection<Persons> persons;
    private Map<Persons, Collection<KeyWords>> personKeyWords = new HashMap<>();

    //создаем коллекцию MAP (ключевое слово/массив поисковых слов к ключевому)
    public  Map<Persons, Collection<KeyWords>> getPersonKeyWords() {
        for (Persons persona: persons) {
            personKeyWords.put(persona, DBFacade.getInstance().getKeyWordsDao().selectPerson(persona));
        }
        return personKeyWords;
    }
    //получаем список Персон из БД.
    public Collection<Persons> getPersons() {
        return persons=DBFacade.getInstance().getPersonDao().select();
    }
    //получаем ссылки на сайты из справочника
    public Collection<String> getSites() {
        return sites = DBFacade.getInstance().getSitesDao().select();
    }

    //делаем проверку ссылки в БД
    public boolean checkURL() {
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Тест");
    }
}
