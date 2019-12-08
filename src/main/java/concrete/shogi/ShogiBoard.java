package concrete.shogi;

import bean.Coord;
import board.Board;
import controller.BoardEventListener;
import game.Game;
import piece.Piece;

public class ShogiBoard extends Board {
    public ShogiBoard(Game.Accessor accessor){
        super(accessor);
    }

    @Override
    public void setBoardEventListener(BoardEventListener boardEventListener) {

    }

    @Override
    public void init() {

    }

    @Override
    public void update(Coord prev, Coord post) {

    }

    @Override
    public boolean update(Piece piece, Coord coord) {
        return false;
    }

    @Override
    public void kill(Coord coord) {

    }
}
