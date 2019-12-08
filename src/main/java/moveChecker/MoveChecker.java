package moveChecker;

import bean.Coord;

import java.util.ArrayList;

public interface MoveChecker {
    public ArrayList<Coord> getMovableList(Coord coord);
    public boolean movableCheck(Coord prev, Coord post);
}
