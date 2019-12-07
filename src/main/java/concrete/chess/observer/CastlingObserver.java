package concrete.chess.observer;

import bean.Coord;
import board.Board;
import board.BoardManager;
import concrete.ConcreteMoveCheckerFactory;
import concrete.chess.piece.ChessPieceEnum;
import controller.BoardEventListner;
import exception.InvaildMoveException;
import observer.Observer;

public class CastlingObserver implements Observer {
    private ConcreteMoveCheckerFactory moveCheckerFactory = new ConcreteMoveCheckerFactory();

    @Override
    public void update(Coord prev, Coord post) {
        boolean rukh1 = false, rukh2 = false;

        if ((BoardManager.getInstance().getBoardInstance().getPieceOn(post) != null) && (BoardManager.getInstance().getBoardInstance().getPieceOn(prev) != null)) {
            if ((BoardManager.getInstance().getBoardInstance().getPieceOn(post).getType() == ChessPieceEnum.king) && (Math.abs(prev.getRow() - post.getRow()) == 2)) {
                //can castling
                //change rukh
                if ((prev.getCol() - post.getCol()) > 0) {
                    Coord prev_rukh = new Coord(BoardManager.getInstance().getBoardInstance().getPieceOn(post).getPlayer() * 7 - 7, 7);
                    Coord post_rukh = new Coord(BoardManager.getInstance().getBoardInstance().getPieceOn(post).getPlayer() * 7 - 7, 5);
                    try {
                        BoardManager.getInstance().getBoardInstance().update(prev_rukh, post_rukh);
                    } catch (InvaildMoveException e) {
                        e.printStackTrace();
                    }
                } else {
                    Coord prev_rukh = new Coord(BoardManager.getInstance().getBoardInstance().getPieceOn(post).getPlayer() * 7 - 7, 0);
                    Coord post_rukh = new Coord(BoardManager.getInstance().getBoardInstance().getPieceOn(post).getPlayer() * 7 - 7, 3);
                    try {
                        BoardManager.getInstance().getBoardInstance().update(prev_rukh, post_rukh);
                    } catch (InvaildMoveException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }




    @Override
    public void setBoardEventListner(BoardEventListner boardEventListner) {

    }
}
