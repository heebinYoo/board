package game;

import bean.Coord;
import concrete.ConcreteMoveCheckerFactory;
import concrete.ConcretePieceFactory;
import concrete.GameList;

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

    public int turn;


    /* Constructor */
    public Game(GameList gameList){
        concrete = new Concrete();
        gameType = gameList;
        turn = 1;
    }

    /* Method */
    public boolean click(Coord coord){
        // TODO
        return true;
    }

    public ArrayList<Coord> getMoveableList(Coord coord){
        // TODO
        return null;
    }

    public void update(Coord prev, Coord post){

    }

    /* Inner Class */
    private class Concrete{
        public ConcreteBoardFactory boardFactory = new ConcreteBoardFactory();
        public ConcreteMoveCheckerFactory moveCheckerFactory = new ConcreteMoveCheckerFactory();
        public ConcretePieceFactory pieceFactory = new ConcretePieceFactory();
    }
}
