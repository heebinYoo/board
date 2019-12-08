import board.BoardManager;
import concrete.ConcreteBoardFactory;
import concrete.ConcreteMoveCheckerFactory;
import concrete.GameList;
import controller.Controller;
import game.Game;
import view.TableView;
import view.TableViewAdapter;

public class main {
    public static void main(String[] args){
        Game game = new Game(GameList.twelveJanggi, new ConcreteBoardFactory(), new ConcreteMoveCheckerFactory());
        TableView view = new TableView(new TableViewAdapter(game.getBoard()));
        Controller controller = new Controller(game, view);
    }
}
