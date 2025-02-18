package concrete.chess.observer;

import bean.Coord;
import board.BoardManager;
import concrete.ConcreteMoveCheckerFactory;
import concrete.chess.piece.ChessPieceEnum;
import controller.BoardEventListener;
import history.History;
import history.Record;
import observer.Observer;


//BoardManager.getInstance().getBoardInstance().kill(prev);
import java.util.Iterator;


public class EnPassantObserver implements Observer {
    private ConcreteMoveCheckerFactory moveCheckerFactory = new ConcreteMoveCheckerFactory();
    @Override
    public void update(Coord prev, Coord post) {
        if (History.getInstance().getLast() != null) {
            Iterator<Record> it = History.getInstance().iterator();
            if (BoardManager.getInstance().getBoardInstance().getPieceOn(post).getType() == ChessPieceEnum.pawn && History.getInstance().getLast().getPiece().getType() == ChessPieceEnum.pawn) {
                //움직인게 pawn이라면
                if ((prev.getRow() == History.getInstance().getLast().getPost().getRow()) && (post.getCol() == History.getInstance().getLast().getPost().getCol())
                        && (Math.abs(post.getRow() - History.getInstance().getLast().getPost().getRow()) == 1)) {
                    //내 pawn의 움직이기 직전 row좌표와 이전 적의 row좌표가 같고
                    //내 pawn의 움직인 후의 col좌표와 이전 적의 col좌표가 같고
                    //내 pawn의 움직인 후의 row좌표와 이전 적의 row좌표의 차이가 1일때
                    if (Math.abs(History.getInstance().getLast().getPrev().getRow() - History.getInstance().getLast().getPost().getRow()) == 2) {
                            BoardManager.getInstance().getBoardInstance().kill(History.getInstance().getLast().getPost());
                    }
                }
            }
        }
    }

    @Override
    public void setBoardEventListener(BoardEventListener boardEventListener) {

    }
}
