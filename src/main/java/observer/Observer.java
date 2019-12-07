package observer;

import bean.Coord;
import controller.BoardEventListner;

public interface Observer {
    public void update(Coord prev, Coord post);
    public void setBoardEventListener(BoardEventListner boardEventListner);



}
