import bean.Coord;
import board.Board;
import board.BoardManager;
import concrete.ConcreteBoardFactory;
import concrete.ConcretePieceFactory;
import concrete.GameList;
import concrete.PromotionPieceList;
import concrete.chess.piece.ChessPieceEnum;
import controller.Controller;
import exception.InvaildMoveException;
import game.Game;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import piece.Piece;
import piece.PieceFactory;
import view.TableView;
import view.TableViewAdapter;

public class ControllerTest {
    static final Logger logger =
            LoggerFactory.getLogger(ConcreteFactoryTest.class);

    @Test
    public void test1(){
        // TODO not fixed yet
        //Game game = new Game(GameList.chess,new ConcreteBoardFactory());

        new PromotionPieceList(GameList.chess, 1).forEach(piece -> logger.debug(piece.toString()));

        //new Controller(new Game(GameList.chess,new ConcreteBoardFactory()),  new TableView(new TableViewAdapter(BoardManager.getInstance().getBoardInstance())));
        while(true){

        }
    }
}
