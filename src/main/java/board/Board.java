package board;

import bean.Coord;
import exception.InvaildMoveException;
import observer.Observer;
import piece.Piece;

import java.util.ArrayList;

public abstract class Board implements Publisher{
    protected Piece[][] pieceData;//row, col
    private ArrayList<Observer> observers;
    protected abstract void init();

    public abstract void update(Coord prev, Coord post) throws InvaildMoveException;

    public Board(){
        observers = new ArrayList<>();
        init();
    }

    public Piece getPieceOn(Coord coord){
       return pieceData[coord.getRow()][coord.getCol()];
    }
    public int getBoardColSize(){
        return pieceData.length;
    }
    public int getBoardRowSize(){
        return pieceData[0].length;
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
