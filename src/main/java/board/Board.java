package board;

import bean.Coord;
import observer.Observer;

import java.util.ArrayList;

public abstract class Board implements Publisher{
    private int[][] pieceData;
    private ArrayList<Observer> observers;
    public abstract void init();


    public Board(){
        observers = new ArrayList<>();
        init();
    }



    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void delete(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(Coord dst) {
        observers.forEach(observer -> observer.update(dst));
    }
}
