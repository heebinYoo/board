package concrete.twelveJanggi.observer;

import bean.Coord;
import board.Board;
import board.BoardManager;
import concrete.twelveJanggi.piece.TwelveJanggiPieceEnum;
import controller.BoardEventListner;
import history.History;
import history.Record;
import observer.Observer;

import java.util.Iterator;

public class SuspendObserver implements Observer {
    /* Field */
    BoardEventListner boardEventListner;

    @Override
    public void update(Coord prev, Coord post) {
        Record record = History.getInstance().getLast();
        if(record != null && record.getPiece().getType() == TwelveJanggiPieceEnum.wang)
            if(record.getPiece().getPlayer()==1 && record.getPost().getCol()==3){
               if(record.getPiece().equals(BoardManager.getInstance().getBoardInstance().getPieceOn(record.getPost()))) boardEventListner.onGameOver();
            }else if(record.getPiece().getPlayer()==2 && record.getPost().getCol()==0){
                if(record.getPiece().equals(BoardManager.getInstance().getBoardInstance().getPieceOn(record.getPost()))) boardEventListner.onGameOver();
            }
    }

    @Override
    public void setBoardEventListener(BoardEventListner boardEventListner) {
        this.boardEventListner = boardEventListner;
    }
}
