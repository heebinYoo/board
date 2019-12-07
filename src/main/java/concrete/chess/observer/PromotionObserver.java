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
    private Piece lastPiece;
    private Coord lastCoord;

    BoardEventListner boardEventListner;
    @Override
    public void setBoardEventListner(BoardEventListner boardEventListner){
        this.boardEventListner=boardEventListner;
    }
    @Override
    public void onSelect(Piece piece){
        BoardManager.getInstance().getBoardInstance().kill(lastCoord);
        BoardManager.getInstance().getBoardInstance().update(lastPiece,lastCoord);
        lastCoord=null;
        lastPiece=null;
    }
    @Override
    public void update(Coord prev, Coord post) {
        if(BoardManager.getInstance().getBoardInstance().getPieceOn(post).getType()== ChessPieceEnum.pawn){
            if(post.getRow()==(BoardManager.getInstance().getBoardInstance().getPieceOn(post).getPlayer()*(-7)+14)){
                lastPiece = BoardManager.getInstance().getBoardInstance().getPieceOn(post);
                lastCoord = post;
                boardEventListner.onPromoted(lastPiece,this);
            }
        }
    }
}
