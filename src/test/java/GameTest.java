import bean.Coord;
import concrete.ConcreteBoardFactory;
import concrete.ConcreteMoveCheckerFactory;
import concrete.GameList;
import game.Game;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import view.ListView;

public class GameTest {
    static final Logger logger =
            LoggerFactory.getLogger(ListView.class);
    @Test
    public void test1(){
        Game game = new Game(GameList.chess, new ConcreteBoardFactory(), new ConcreteMoveCheckerFactory());

        if(game.click(new Coord(1,0)))logger.debug("Player 1");

        game.update(new Coord(1,0), new Coord(2,0));

        if(game.click(new Coord(6,0)))logger.debug("Player 2");
    }
}
