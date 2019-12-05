import board.BoardFactory;
import concrete.ConcreteBoardFactory;
import concrete.ConcreteMoveCheckerFactory;
import concrete.ConcretePieceFactory;
import moveChecker.MoveCheckerFactory;
import concrete.chess.piece.ChessPieceEnum;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import piece.PieceFactory;

import static org.junit.Assert.assertEquals;
public class ConcreteFactoryTest {

    static final Logger logger =
            LoggerFactory.getLogger(ConcreteFactoryTest.class);
    static PieceFactory pieceFactory;
    static MoveCheckerFactory moveCheckerFactory;
    static BoardFactory boardFactory;
    @BeforeClass
    public static void setupForClass(){
        logger.info("@BeforeClass");
        pieceFactory= new ConcretePieceFactory();
        moveCheckerFactory = new ConcreteMoveCheckerFactory();
        boardFactory =  new ConcreteBoardFactory();
    }

    @Test
    public void testPiece(){
        logger.info("@testPiece");
        assertEquals("rukh is rukh",pieceFactory.createPiece(1, ChessPieceEnum.rukh).getType(),ChessPieceEnum.rukh);
    }



}
