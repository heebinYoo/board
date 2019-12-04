package concrete;

import board.Board;
import board.BoardFactory;
import concrete.chess.ChessBoard;
import concrete.shogi.ShogiBoard;
import game.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcreteBoardFactory implements BoardFactory {
    static final Logger logger =
            LoggerFactory.getLogger(ConcreteBoardFactory.class);
    @Override
    public Board createBoard(Game.Accessor accessor, GameList gameList) {
        switch (gameList){
            case chess:
                return new ChessBoard();
            case shogi:
                return new ShogiBoard();
        }
        logger.error("game is not in the enum ConcreteBoardFactory!!!");
        return null;
    }
}
