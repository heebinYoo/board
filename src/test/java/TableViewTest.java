import bean.Coord;
import board.Board;
import board.BoardManager;
import concrete.ConcretePieceFactory;
import concrete.chess.piece.ChessPieceEnum;
import exception.InvaildMoveException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import piece.Piece;
import piece.PieceFactory;
import view.*;

public class TableViewTest {
    static final Logger logger =
            LoggerFactory.getLogger(ConcreteFactoryTest.class);

    class TestBoard extends Board{
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
    public void testInflate(){
        TestBoard testBoard = new TestBoard();

        new TableView(new TableViewAdapter(testBoard));
        while(true){

        }

    }
}
