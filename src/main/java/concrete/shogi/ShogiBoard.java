package concrete.shogi;

import bean.Coord;
import board.Board;
import controller.BoardEventListner;
import game.Game;
import piece.Piece;

public class ShogiBoard extends Board {
    public ShogiBoard(Game.Accessor accessor){
        super(accessor);
    }

    @Override
    public void setBoardEventListener(BoardEventListner boardEventListner) {

    }

    @Override
    public void init() {

    }

    @Override
    public void update(Coord prev, Coord post) {

    }

    @Override
    public void update(Piece piece, Coord coord) {

    }

    @Override
    public void kill(Coord coord) {

    }
}
