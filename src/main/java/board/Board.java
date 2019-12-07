package board;

import bean.Coord;
import exception.InvaildMoveException;
import game.Game;
import observer.Observer;
import piece.Piece;

import java.util.ArrayList;

public abstract class Board implements Publisher{
    protected Piece[][] pieceData;//row, col
    private ArrayList<Observer> observers;
    protected abstract void init();

    public abstract void update(Coord prev, Coord post) throws InvaildMoveException;
    public abstract void update(Piece piece, Coord coord);
    public Board(Game.Accessor accessor){
        observers = new ArrayList<>();
        init();
    }

    public Piece getPieceOn(Coord coord){
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
    public void notifyObserver(Coord prev, Coord post) {
        observers.forEach(observer -> observer.update(prev,post));
    }

    public int getBoardRowSize() {
        return pieceData.length;
    }

    public int getBoardColSize() {
        return pieceData[0].length;
    }
}
