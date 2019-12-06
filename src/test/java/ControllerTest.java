import bean.Coord;
import board.Board;
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

    class TestBoard extends Board {

        @Override
        protected void init() {
            pieceData = new Piece[3][3];
            PieceFactory pieceFactory = new ConcretePieceFactory();
            Piece p1=pieceFactory.createPiece(1, ChessPieceEnum.rukh);
            Piece p2=pieceFactory.createPiece(1, ChessPieceEnum.king);
            Piece p3=pieceFactory.createPiece(1, ChessPieceEnum.queen);
            Piece p4=pieceFactory.createPiece(1, ChessPieceEnum.bishop);
            pieceData[0][0] = p1;
            pieceData[0][1] = null;
            pieceData[0][2] = null;
            pieceData[1][0] = p2;
            pieceData[1][1] = p3;
            pieceData[1][2] = null;
            pieceData[2][0] = null;
            pieceData[2][1] = p4;
            pieceData[2][2] = null;
        }

        @Override
        public void update(Coord prev, Coord post) throws InvaildMoveException {

        }
    }

    @Test
    public void test1(){

        new PromotionPieceList(GameList.chess, 1).forEach(piece -> logger.debug(piece.toString()));

        new Controller(new Game(GameList.chess,new ConcreteBoardFactory()),  new TableView(new TableViewAdapter(new TestBoard())));
        while(true){

        }
    }
}
