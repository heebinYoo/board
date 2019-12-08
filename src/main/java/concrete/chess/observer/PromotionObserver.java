package concrete.chess.observer;

import bean.Coord;
import board.BoardManager;
import concrete.chess.piece.ChessPieceEnum;
import controller.BoardEventListener;
import observer.Observer;
import piece.Piece;

public class PromotionObserver implements Observer, SelectedListener {
    private Piece lastPiece;
    private Coord lastCoord;

    BoardEventListener boardEventListener;

    @Override
    public void setBoardEventListener(BoardEventListener boardEventListener) {
        this.boardEventListener = boardEventListener;
    }

    @Override
    public void onSelect(Piece piece) {
        BoardManager.getInstance().getBoardInstance().kill(lastCoord);
        BoardManager.getInstance().getBoardInstance().update(piece, lastCoord);
        lastCoord = null;
        lastPiece = null;
    }

    @Override
    public void update(Coord prev, Coord post) {
        if (BoardManager.getInstance().getBoardInstance().getPieceOn(post).getType() == ChessPieceEnum.pawn) {
            if (post.getRow() == 0 || post.getRow() == 7) {
                lastPiece = BoardManager.getInstance().getBoardInstance().getPieceOn(post);
                lastCoord = post;
                boardEventListener.onPromoted(lastPiece, this);
            }
        }
    }
}
