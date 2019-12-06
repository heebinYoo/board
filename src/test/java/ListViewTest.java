import concrete.ConcretePieceFactory;
import concrete.chess.piece.ChessPieceEnum;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import piece.Piece;
import piece.PieceFactory;
import view.ListEventListener;
import view.ListView;
import view.ListViewAdapter;

import javax.swing.*;
import java.util.ArrayList;

public class ListViewTest {
    static final Logger logger =
            LoggerFactory.getLogger(ConcreteFactoryTest.class);
    @Test
    public void testInflate(){
        PieceFactory pieceFactory = new ConcretePieceFactory();
        Piece p1=pieceFactory.createPiece(1, ChessPieceEnum.rukh,"rukh1");
        Piece p2=pieceFactory.createPiece(1, ChessPieceEnum.king,"king1");
        Piece p3=pieceFactory.createPiece(1, ChessPieceEnum.queen,"queen1");
        Piece p4=pieceFactory.createPiece(1, ChessPieceEnum.bishop,"bishop1");
        ArrayList<Piece> pieces = new ArrayList<>();
        pieces.add(p1);
        pieces.add(p2);
        pieces.add(p3);
        pieces.add(p4);

        new ListView(new ListViewAdapter(pieces));
        while(true){

        }

    }
}
