package concrete.chess.observer;

import bean.Coord;
import board.BoardManager;
import concrete.ConcreteMoveCheckerFactory;
import concrete.chess.piece.ChessPiece;
import concrete.chess.piece.ChessPieceEnum;
import exception.InvaildMoveException;
import history.History;
import history.Record;
import observer.Observer;

import java.util.ArrayList;
import java.util.Iterator;

public class CastlingObserver implements Observer {
    private ConcreteMoveCheckerFactory moveCheckerFactory = new ConcreteMoveCheckerFactory();
    @Override
    public void update(Coord prev, Coord post) {
        if(BoardManager.getInstance().getBoardInstance().getPieceOn(post).getType() == ChessPieceEnum.king){
            Iterator<Record> it = History.getInstance().iterator();
            while(it.hasNext()){
                if((it.next().getPiece().getPlayer() == BoardManager.getInstance().getBoardInstance().getPieceOn(post).getPlayer())&&
                        (it.next().getPiece().getType() == ChessPieceEnum.king)) return; //king moved before -> not castling
                if((it.next().getPiece().getPlayer() == BoardManager.getInstance().getBoardInstance().getPieceOn(post).getPlayer())&&
                        (it.next().getPiece().getType() == ChessPieceEnum.rukh)) return; //rukh moved before -> not castling
            }

            ArrayList<Coord> KingsWay = new ArrayList<>();

            if((prev.getRow()-post.getRow())>0){
                for(int i = 1;i<4;i++){
                    Coord way = new Coord(BoardManager.getInstance().getBoardInstance().getPieceOn(post).getPlayer()*7-7,i);
                    KingsWay.add(way);
                }
            }
            else{
                for(int i = 5;i<7;i++){
                    Coord way = new Coord(BoardManager.getInstance().getBoardInstance().getPieceOn(post).getPlayer()*7-7,i);
                    KingsWay.add(way);
                }
            }

            for(int i = 0;i<KingsWay.size();i++){
                if(BoardManager.getInstance().getBoardInstance().getPieceOn(KingsWay.get(i))!=null){
                    return; //there's other piece between king and rukh -> not castling
                }
            }

            for(int i = 0;i<8;i++){
                for(int j = 0;j<8;j++){
                    Coord Board = new Coord(i,j);
                    ArrayList<Coord> obs = moveCheckerFactory.createMoveChecker(BoardManager.getInstance().getBoardInstance().getPieceOn(Board)).getMoveableList(Board);
                    for(int k=0;k<obs.size();k++){
                        for(int l=0;l<KingsWay.size();l++){
                            if(obs.get(k)==KingsWay.get(l)){
                                return; //there will be some attack to king -> not castling
                            }
                            if(obs.get(k)==post){
                                return; //there will be some attack to king -> not castling
                            }
                        }
                    }
                }
            }

            //can castling
            //change rukh
            if((prev.getRow()-post.getRow())>0){
                Coord prev_rukh = new Coord(BoardManager.getInstance().getBoardInstance().getPieceOn(post).getPlayer()*7-7,7);
                Coord post_rukh = new Coord(BoardManager.getInstance().getBoardInstance().getPieceOn(post).getPlayer()*7-7,5);
                try {
                    BoardManager.getInstance().getBoardInstance().update(prev_rukh,post_rukh);
                } catch (InvaildMoveException e) {
                    e.printStackTrace();
                }
            }
            else{
                Coord prev_rukh = new Coord(BoardManager.getInstance().getBoardInstance().getPieceOn(post).getPlayer()*7-7,0);
                Coord post_rukh = new Coord(BoardManager.getInstance().getBoardInstance().getPieceOn(post).getPlayer()*7-7,3);
                try {
                    BoardManager.getInstance().getBoardInstance().update(prev_rukh,post_rukh);
                } catch (InvaildMoveException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
