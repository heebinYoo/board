package concrete;

import board.Board;
import board.BoardFactory;
import game.Game;

public class ConcreteBoardFactory implements BoardFactory {
    @Override
    public Board createBoard(Game.Accessor accessor, GameList gameList) {
        return null;
    }
}
