package concrete.twelveJanggi.observer;

import bean.Coord;
import board.BoardManager;
import concrete.ConcretePieceFactory;
import concrete.twelveJanggi.piece.TwelveJanggiPieceEnum;
import controller.BoardEventListener;
import observer.Observer;
import piece.Piece;

public class PromotionObserver  implements Observer {
    @Override
    public void update(Coord prev, Coord post) {
        Piece piece = BoardManager.getInstance().getBoardInstance().getPieceOn(post);
        if(piece.getType() == TwelveJanggiPieceEnum.za){
            if(piece.getPlayer() == 1){
                if(post.getCol() == 3){
                    BoardManager.getInstance().getBoardInstance().update(new ConcretePieceFactory().createPiece(piece.getPlayer(), TwelveJanggiPieceEnum.hu, "red-hu"), post);
                }

            }else{
                if(post.getCol() == 0) BoardManager.getInstance().getBoardInstance().update(new ConcretePieceFactory().createPiece(piece.getPlayer(), TwelveJanggiPieceEnum.hu, "green-hu"), post);
            }
        }
    }

    @Override
    public void setBoardEventListener(BoardEventListener boardEventListener) {

    }
}
