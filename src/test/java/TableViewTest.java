import bean.Coord;
import board.Board;
import board.BoardManager;
import concrete.ConcreteBoardFactory;
import concrete.ConcretePieceFactory;
import concrete.GameList;
import concrete.chess.piece.ChessPieceEnum;
import controller.TableClickListener;
import exception.InvaildMoveException;
import game.Game;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import piece.Piece;
import piece.PieceFactory;
import view.*;

import javax.swing.*;
import java.util.ArrayList;

public class TableViewTest {
    static final Logger logger =
            LoggerFactory.getLogger(ConcreteFactoryTest.class);


    private ArrayList<Coord> lastMoveableList;
    private Coord lastSelectedCoord;

    class TestClickListener implements TableClickListener {
        @Override
        public void onClick(JPanel jPanel, Coord coord) {
            logger.debug("data on "+coord + " piece data ");
        }
    }

    @Test
    public void testInflate(){
//        Game game = new Game(GameList.chess,new ConcreteBoardFactory());
//
//        TestClickListener tableClickListener = new TestClickListener();
//
//        lastMoveableList = new ArrayList<>();
//        lastMoveableList.add(new Coord(0, 0));
//        lastMoveableList.add(new Coord(2,2));
//        lastMoveableList.add(new Coord(0, 1));
//
//        new TableView(new TableViewAdapter(BoardManager.getInstance().getBoardInstance())).setTableClickListener(tableClickListener);

        while(true){

        }

    }
}
