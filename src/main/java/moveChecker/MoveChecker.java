package moveChecker;

import bean.Coord;

import java.util.ArrayList;

public interface MoveChecker {
    public ArrayList<Coord> getMoveableList(Coord coord);
    public boolean moveableCheck(Coord prev, Coord post);
}
