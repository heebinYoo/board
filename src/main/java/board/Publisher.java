package board;

import bean.Coord;
import observer.Observer;

public interface Publisher {
    public void add(Observer observer);
    public void delete(Observer observer);
    public void notifyObserver(Coord prev, Coord post);

    }
