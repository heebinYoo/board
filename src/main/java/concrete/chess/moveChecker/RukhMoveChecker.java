package concrete.chess.moveChecker;

import bean.Coord;
import moveChecker.MoveChecker;

import java.util.ArrayList;
//TODO
public class RukhMoveChecker implements MoveChecker {
    @Override
    public ArrayList<Coord> getMoveableList(Coord coord) {
        return null;
    }

    @Override
    public boolean moveableCheck(Coord prev, Coord post) {
        return false;
    }
}
