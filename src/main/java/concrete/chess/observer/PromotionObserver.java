package concrete.chess.observer;

import bean.Coord;
import board.Board;
import board.BoardManager;
import concrete.ConcreteMoveCheckerFactory;
import concrete.chess.piece.ChessPieceEnum;
import controller.BoardEventListner;
import observer.Observer;
import piece.Piece;

public class PromotionObserver implements Observer, SelectedListener{
    BoardEventListner boardEventListner;
    @Override
    public void setBoardEventListner(BoardEventListner boardEventListner){
        this.boardEventListner=boardEventListner;

        //boardEventListner.onPromoted(); notify promotion to view
        //then onSelected(Piece piece) called when user finish answer
    }
    @Override
    public void onSelect(Piece piece){

    }
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
