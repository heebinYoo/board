package game;

import bean.Coord;
import board.BoardManager;
import concrete.ConcreteBoardFactory;
import concrete.ConcreteMoveCheckerFactory;
import concrete.ConcretePieceFactory;
import concrete.GameList;
import exception.InvaildMoveException;
import history.History;
import history.Record;

import java.util.ArrayList;

public class Game {

    /* Accessor for Board init */
    public static final class Accessor{
        private Accessor(){

        }
    }
    private static final Accessor accessor = new Accessor();

    /* Field */
    private Concrete concrete;
    private GameList gameType;

    private int turn;

    public int getTurn() {
        return turn;
    }

    /* Constructor */
    public Game(GameList gameList, ConcreteBoardFactory boardFactory){
        concrete = new Concrete();
        gameType = gameList;
        concrete.boardFactory = boardFactory;
        turn = 1;
        BoardManager.getInstance().initBoard(accessor, gameType, concrete.boardFactory);
    }

    /* Method */
    //true if user click user's piece
    public boolean click(Coord coord){
        if(turn == BoardManager.getInstance().getBoardInstance().getPieceOn(coord).getPlayer()){
            return true;
        }
        return false;
    }

    public ArrayList<Coord> getMoveableList(Coord coord){
        return concrete.moveCheckerFactory.createMoveChecker(BoardManager.getInstance().getBoardInstance().getPieceOn(coord)).getMoveableList(coord);
    }

    public void update(Coord prev, Coord post){
        try {
            BoardManager.getInstance().getBoardInstance().update(prev,post);
            History.getInstance().add(new Record(prev, post));
            turn = turn==1 ? 2 : 1;
        } catch (InvaildMoveException e) {
            e.printStackTrace();
        }

    }

    public GameList getGameType() {
        return gameType;
    }

    //public Concrete getFactories(){return concrete;}
    //it is redundent, Factory can be easily and not irritatably generated
    /* Inner Class */
    private class Concrete{
        private ConcreteBoardFactory boardFactory;
        private ConcreteMoveCheckerFactory moveCheckerFactory = new ConcreteMoveCheckerFactory();
        //public ConcretePieceFactory pieceFactory = new ConcretePieceFactory();
    }
}
