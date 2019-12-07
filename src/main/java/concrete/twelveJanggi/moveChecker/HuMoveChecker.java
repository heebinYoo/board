package concrete.twelveJanggi.moveChecker;

import bean.Coord;
import board.BoardManager;
import concrete.twelveJanggi.TwelveJanggiBoard;
import moveChecker.MoveChecker;

import java.util.ArrayList;

public class HuMoveChecker extends CheckerBundle implements MoveChecker {
    @Override
    public ArrayList<Coord> getMovableList(Coord coord) {
        return null;
    }

    @Override
    public boolean movableCheck(Coord prev, Coord post) {
        return rangeCheck(post) && pieceCheck(post, twelveJanggiBoard.getPieceOn(prev).getPlayer());
    }
}
