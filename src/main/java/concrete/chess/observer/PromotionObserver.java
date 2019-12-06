package concrete.chess.observer;

import bean.Coord;
import board.Board;
import board.BoardManager;
import concrete.ConcreteMoveCheckerFactory;
import concrete.chess.piece.ChessPieceEnum;
import observer.Observer;

public class PromotionObserver implements Observer{

    @Override
    public void update(Coord prev, Coord post) {
        if(BoardManager.getInstance().getBoardInstance().getPieceOn(post).getType()== ChessPieceEnum.pawn){
            if(post.getRow()==(BoardManager.getInstance().getBoardInstance().getPieceOn(post).getPlayer()*(-7)+14)){
                //promotion active
                //TODO
            }
        }
    }
}
