package concrete.chess.observer;

import bean.Coord;
import board.Board;
import board.BoardManager;
import concrete.ConcreteMoveCheckerFactory;
import concrete.chess.CheckChecker;
import concrete.chess.piece.ChessPieceEnum;
import controller.BoardEventListener;
import javafx.scene.layout.BorderImage;
import observer.Observer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import piece.Piece;
import view.ListView;

import javax.swing.*;
import java.util.ArrayList;

public class CheckmateObserver implements Observer {
    /* Test */
    static final Logger logger =
            LoggerFactory.getLogger(ListView.class);

    private ConcreteMoveCheckerFactory moveCheckerFactory = new ConcreteMoveCheckerFactory();
    private BoardEventListener boardEventListener;

    @Override
    public void update(Coord prev, Coord post) {
        CheckChecker check = new CheckChecker();
        Coord king;

        ArrayList<Coord> kingMove = moveCheckerFactory.createMoveChecker(BoardManager.getInstance().getBoardInstance().getPieceOn(post)).getMovableList(post);
        for(Coord coord : kingMove) {
            if (BoardManager.getInstance().getBoardInstance().getPieceOn(coord) != null && BoardManager.getInstance().getBoardInstance().getPieceOn(coord).getType() == ChessPieceEnum.king) {
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        if (coord.getRow() + k < 8 && coord.getRow() + k >= 0 && coord.getCol() + l < 8 && coord.getCol() + l >= 0) {
                            if(BoardManager.getInstance().getBoardInstance().getPieceOn(new Coord(coord.getRow() + k, coord.getCol() + l)) == null) {
                                if (!check.isCheck(BoardManager.getInstance().getBoardInstance().getPieceOn(coord), new Coord(coord.getRow() + k, coord.getCol() + l)))
                                    return;
                            }
                        }
                    }
                }
                boardEventListener.onGameOver();
            }
        }
    }

    @Override
    public void setBoardEventListener(BoardEventListener boardEventListener) {
        this.boardEventListener = boardEventListener;
    }

}
