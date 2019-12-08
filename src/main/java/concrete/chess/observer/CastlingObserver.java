package concrete.chess.observer;

import bean.Coord;
import board.BoardManager;
import concrete.ConcreteMoveCheckerFactory;
import concrete.chess.piece.ChessPieceEnum;
import controller.BoardEventListener;
import exception.InvaildMoveException;
import observer.Observer;

public class CastlingObserver implements Observer {
    private ConcreteMoveCheckerFactory moveCheckerFactory = new ConcreteMoveCheckerFactory();

    @Override
    public void update(Coord prev, Coord post) {
        boolean rukh1 = false, rukh2 = false;

        if (BoardManager.getInstance().getBoardInstance().getPieceOn(post) != null && BoardManager.getInstance().getBoardInstance().getPieceOn(post).getType() == ChessPieceEnum.king){
            if(Math.abs(prev.getCol() - post.getCol()) == 2){
                if ((prev.getCol() - post.getCol()) > 0) { // 왼쪽
                    Coord prev_rukh = new Coord(post.getRow(),0);
                    Coord post_rukh = new Coord(post.getRow(), post.getCol()+1);
                    try {
                        BoardManager.getInstance().getBoardInstance().update(prev_rukh, post_rukh);
                    } catch (InvaildMoveException e) {
                        e.printStackTrace();
                    }
                } else { // 오른쪽
                    Coord prev_rukh = new Coord(post.getRow(), 7);
                    Coord post_rukh = new Coord(post.getRow(), post.getCol()-1);
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
    public void setBoardEventListener(BoardEventListener boardEventListener) {

    }
}
