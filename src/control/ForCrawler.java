package control;

import model.KeyWords;
import model.Persons;
import model.Sites;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by d.zhuchkov on 27.06.2016.
 */
public class ForCrawler {

     Collection<Sites> sites;
     Collection<Persons> persons;
    Map<Persons, Collection<KeyWords>> personKeyWords = new HashMap<>();

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
    public Collection<Sites> getSites() {
        return sites = DBFacade.getInstance().getSitesDao().select();
    }

    //делаем проверку ссылки в БД
    public boolean checkURL() {
        return true;
    }
}
