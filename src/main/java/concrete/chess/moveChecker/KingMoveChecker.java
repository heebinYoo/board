package concrete.chess.moveChecker;

import bean.Coord;
import board.BoardManager;
import concrete.ConcreteMoveCheckerFactory;
import concrete.chess.piece.ChessPieceEnum;
import history.History;
import history.Record;
import moveChecker.MoveChecker;
import piece.Piece;

import java.util.ArrayList;
import java.util.Iterator;

public class KingMoveChecker implements MoveChecker {

    public ArrayList<Coord> getMoveableList(Coord coord) {
        ArrayList<Coord> result = new ArrayList<Coord>();
        int rowSize = BoardManager.getInstance().getBoardInstance().getBoardRowSize();
        int colSize = BoardManager.getInstance().getBoardInstance().getBoardColSize();

        Piece malice = BoardManager.getInstance().getBoardInstance().getPieceOn(coord); //나
        // Piece piece = History.getInstance().getLast().getPiece(); //최근 상대

        //1. 판 위인지
        //2. 캐슬링 만족하는지
        //3. 그 위치 체크 안 당하는지
        //4. 그 위치 비어있거나 적군이 있는지

        //캐슬링인지
        //가려고 하는 곳(캐슬링 가능시)
        Coord CastlingWay1=new Coord(coord.getRow(),coord.getCol()+3);
        Coord CastlingWay2=new Coord(coord.getRow(),coord.getCol()-2);
        if(update(coord, CastlingWay1)){
            //캐슬링 가능하면 add
            result.add(CastlingWay1);
        }
        if(update(coord, CastlingWay2)){
            result.add(CastlingWay2);
        }
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                if(i==0&&j==0)
                    break;
                Coord mod=new Coord(coord.getRow()+i,coord.getCol()+j);
                if(mod.getRow()>=0&&mod.getRow()<rowSize&&mod.getCol()>=0&&mod.getCol()<colSize){
                    //일단 판위임
                    //비어있거나 적군이 있음
                    Piece modpiece=BoardManager.getInstance().getBoardInstance().getPieceOn(mod);
                    if(mod==null||modpiece.getPlayer()!=malice.getPlayer()) {
                        //그 위치 체크 당하는지 안 당하는지
                        if (update2(coord, mod)) {
                            //체크 아니라면
                            result.add(mod);
                        }
                    }

                }
            }
        }

        return result;
    }


    public boolean moveableCheck(Coord prev, Coord post) {


        ArrayList<Coord> isKingThere = this.getMoveableList(prev);
        for (int i = 0; i < isKingThere.size(); i++) {
            if (isKingThere.get(i).getRow() == post.getRow() && isKingThere.get(i).getCol() == post.getCol()) { //list 안에 post 좌표값 존재
                return true;
            }
        }
        //list 안에 좌표값 존재 안함
        return false;
    }


    // //추가 함수. prev->post 로 킹이 움직일 수 있는지
    public boolean update(Coord prev, Coord post) {
        //prev->post 로 가려고 한다
        ConcreteMoveCheckerFactory moveCheckerFactory = new ConcreteMoveCheckerFactory();
        if (BoardManager.getInstance().getBoardInstance().getPieceOn(post).getType() == ChessPieceEnum.king) {
            Iterator<Record> it = History.getInstance().iterator();
            while (it.hasNext()) {
                if ((it.next().getPiece().getPlayer() == BoardManager.getInstance().getBoardInstance().getPieceOn(post).getPlayer()) &&
                        (it.next().getPiece().getType() == ChessPieceEnum.king))
                    return false; //king moved before -> not castling
                if ((it.next().getPiece().getPlayer() == BoardManager.getInstance().getBoardInstance().getPieceOn(post).getPlayer()) &&
                        (it.next().getPiece().getType() == ChessPieceEnum.rukh))
                    return false; //rukh moved before -> not castling
            }

            ArrayList<Coord> KingsWay = new ArrayList<>();

            if ((prev.getCol() - post.getCol()) > 0) {
                for (int j = 1; j < 3; j++) {
                    Coord way = new Coord(BoardManager.getInstance().getBoardInstance().getPieceOn(post).getPlayer() * 7 - 7, j);
                    KingsWay.add(way);
                }
            } else {
                for (int j = 4; j < 7; j++) {
                    Coord way = new Coord(BoardManager.getInstance().getBoardInstance().getPieceOn(post).getPlayer() * 7 - 7, j);
                    KingsWay.add(way);
                }
            }

            for (int i = 0; i < KingsWay.size(); i++) {
                if (BoardManager.getInstance().getBoardInstance().getPieceOn(KingsWay.get(i)) != null) {
                    return false; //there's other piece between king and rukh -> not castling
                }
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    Coord Board = new Coord(i, j);
                    ArrayList<Coord> obs = moveCheckerFactory.createMoveChecker(BoardManager.getInstance().getBoardInstance().getPieceOn(Board)).getMoveableList(Board);
                    for (int k = 0; k < obs.size(); k++) {
                        for (int l = 0; l < KingsWay.size(); l++) {
                            if (obs.get(k) == KingsWay.get(l)) {
                                return false; //there will be some attack to king -> not castling
                            }
                            if (obs.get(k) == post) {
                                return false; //there will be some attack to king -> not castling
                            }
                        }
                    }
                }
            }

        }
        return true;
    }

    public boolean update2(Coord prev, Coord post) {
        ConcreteMoveCheckerFactory moveCheckerFactory = new ConcreteMoveCheckerFactory();
        if(!(BoardManager.getInstance().getBoardInstance().getPieceOn(post).getType() == ChessPieceEnum.king)){

            ArrayList<Coord> isKingThere = moveCheckerFactory.createMoveChecker(BoardManager.getInstance().getBoardInstance().getPieceOn(post)).getMoveableList(post);
            //checked check
            for(int i = 0; i< isKingThere.size(); i++){
                if(BoardManager.getInstance().getBoardInstance().getPieceOn(isKingThere.get(i)).getType() == ChessPieceEnum.king) {
                    ArrayList<Coord> KingLoc = moveCheckerFactory.createMoveChecker(BoardManager.getInstance().getBoardInstance().getPieceOn(isKingThere.get(i))).getMoveableList(isKingThere.get(i));
                    for(int j = 0; j< KingLoc.size();j++){
                        for(int k = 0;k<8;k++){
                            for(int l = 0; l<8;l++) {
                                Coord BoardCoord = new Coord(k, l);
                                if(BoardManager.getInstance().getBoardInstance().getPieceOn(BoardCoord).getPlayer()!=BoardManager.getInstance().getBoardInstance().getPieceOn(KingLoc.get(j)).getPlayer()) {
                                    ArrayList<Coord> CheckedOrNot = moveCheckerFactory.createMoveChecker(BoardManager.getInstance().getBoardInstance().getPieceOn(BoardCoord)).getMoveableList(BoardCoord);
                                    for(int m = 0;m<KingLoc.size();m++){
                                        for(int n = 0;n<CheckedOrNot.size();n++){
                                            if(KingLoc.get(m)==CheckedOrNot.get(n)) {
                                                //Cannot move to here
                                                KingLoc.remove(m);
                                                return false;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if(KingLoc.size()==0){
                        //CheckMate!!! exit
                        //TODO
                    }

                }
            }

        }
        return true;
    }
}
