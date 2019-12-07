package concrete.chess.moveChecker;

import concrete.chess.observer.CastlingObserver;
import bean.Coord;
import board.BoardManager;
import concrete.ConcreteMoveCheckerFactory;
import moveChecker.MoveChecker;
import piece.Piece;

import java.util.ArrayList;
public class KingMoveChecker implements MoveChecker {

    @Override
    public ArrayList<Coord> getMoveableList(Coord coord) {
        return null;
    }

    @Override
    public boolean moveableCheck(Coord prev, Coord post) {
        return false;
    }
}
