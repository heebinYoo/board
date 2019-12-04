package concrete.chess;
import bean.Coord;
import moveChecker.moveChecker;

import java.util.ArrayList;

public class bishopMoveChecker implements moveChecker {
    @Override
    public ArrayList<Coord> getMoveableList(Coord coord) {
        return null;
    }

    @Override
    public boolean moveableCheck(Coord prev, Coord post) {
        return false;
    }
}
