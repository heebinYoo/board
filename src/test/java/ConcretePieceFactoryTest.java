import concrete.ConcretePieceFactory;
import concrete.chess.piece.ChessPieceEnum;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import piece.PieceFactory;

import static org.junit.Assert.assertEquals;
public class ConcretePieceFactoryTest {

    static final Logger logger =
            LoggerFactory.getLogger(ConcretePieceFactoryTest.class);
    static PieceFactory pieceFactory;

    @BeforeClass
    public static void setupForClass(){
        logger.info("@BeforeClass");
        pieceFactory= new ConcretePieceFactory();
    }

    @Test
    public void test1(){
        logger.info("@Test1");
        assertEquals("rukh is rukh",pieceFactory.createPiece(1, ChessPieceEnum.rukh).getType(),ChessPieceEnum.rukh);
        // fail(String)
        // assertTrue(true);
        // assertEquals([String message], expected, actual)
        // assertEquals([String message], expected, actual, tolerance)
        // assertNull([message], object)
        // assertNotNull([message], object)
        // assertSame([String], expected, actual)
        // assertNotSame([String], expected, actual)
        // assertTrue([message], boolean condition)

    }


}
