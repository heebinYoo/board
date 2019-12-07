package history;

import java.util.ArrayList;
import java.util.Iterator;

public class History {
    /* Field */
    private ArrayList<Record> records = new ArrayList<>();

    /* Constructor */
    private History(){}

    /* Inner Class */
    private static class HistoryHolder{
        public static final History INSTANCE = new History();
    }

    /* Method */
    public static History getInstance(){return HistoryHolder.INSTANCE;}

    public void add(Record record){}
    public Record getLast(){
        if(records.size()==0) return null;
        return records.get(records.size()-1);
    }
    public Iterator<Record> iterator(){
        return records.iterator();
    }
}
