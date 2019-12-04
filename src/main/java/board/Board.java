package board;

import bean.Coord;
import observer.Observer;
import piece.Piece;

import java.util.ArrayList;

public abstract class Board implements Publisher{
    private Piece[][] pieceData;
    private ArrayList<Observer> observers;
    public abstract void init();

    public static Board getInstance() {
        return null;
    }

    public Board(){
        observers = new ArrayList<>();
        init();
    }

    public Piece status(Coord coord){
       return pieceData[coord.getRow()][coord.getCol()];
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
