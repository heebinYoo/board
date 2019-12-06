package observer;

import bean.Coord;

public interface Observer {
    public void update(Coord prev, Coord post);


}
