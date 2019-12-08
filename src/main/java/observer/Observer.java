package observer;

import bean.Coord;
import controller.BoardEventListener;

public interface Observer {
    public void update(Coord prev, Coord post);

    public void setBoardEventListener(BoardEventListener boardEventListener);
}
