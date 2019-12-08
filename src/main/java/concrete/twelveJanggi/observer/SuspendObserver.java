package concrete.twelveJanggi.observer;

import bean.Coord;
import board.BoardManager;
import concrete.twelveJanggi.piece.TwelveJanggiPieceEnum;
import controller.BoardEventListener;
import history.History;
import history.Record;
import observer.Observer;

public class SuspendObserver implements Observer {
    /* Field */
    BoardEventListener boardEventListener;

    @Override
    public void update(Coord prev, Coord post) {
        Record record = History.getInstance().getLast();
        if(record != null && record.getPiece().getType() == TwelveJanggiPieceEnum.wang)
            if(record.getPiece().getPlayer()==1 && record.getPost().getCol()==3){
               if(record.getPiece().equals(BoardManager.getInstance().getBoardInstance().getPieceOn(record.getPost()))) boardEventListener.onGameOver();
            }else if(record.getPiece().getPlayer()==2 && record.getPost().getCol()==0){
                if(record.getPiece().equals(BoardManager.getInstance().getBoardInstance().getPieceOn(record.getPost()))) boardEventListener.onGameOver();
            }
    }

    @Override
    public void setBoardEventListener(BoardEventListener boardEventListener) {
        this.boardEventListener = boardEventListener;
    }
}
