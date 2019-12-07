package concrete.twelveJanggi.moveChecker;

import bean.Coord;
import moveChecker.MoveChecker;

import java.util.ArrayList;

public class SangMoveChecker implements MoveChecker {
    @Override
    public ArrayList<Coord> getMovableList(Coord coord) {
        return null;
    }

    @Override
    public boolean movableCheck(Coord prev, Coord post) {
        return false;
    }
}
