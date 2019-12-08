package concrete.chess.moveChecker;
import concrete.chess.CheckChecker;
import bean.Coord;
import board.BoardManager;
import concrete.ConcreteMoveCheckerFactory;
import concrete.chess.piece.ChessPieceEnum;
import controller.BoardEventListener;
import history.History;
import history.Record;
import moveChecker.MoveChecker;
import piece.Piece;

import java.util.ArrayList;
import java.util.Iterator;

public class KingMoveChecker implements MoveChecker {

    public ArrayList<Coord> getMovableList(Coord coord) {
        ArrayList<Coord> result = new ArrayList<Coord>();
        int rowSize = BoardManager.getInstance().getBoardInstance().getBoardRowSize();
        int colSize = BoardManager.getInstance().getBoardInstance().getBoardColSize();

        Piece malice = BoardManager.getInstance().getBoardInstance().getPieceOn(coord); //나7

        // Piece piece = History.getInstance().getLast().getPiece(); //최근 상대

        //1. 판 위인지
        //2. 캐슬링 만족하는지
        //3. 그 위치 체크 안 당하는지
        //4. 그 위치 비어있거나 적군이 있는지

        //캐슬링인지
        //가려고 하는 곳(캐슬링 가능시)

        Coord CastlingWay1 = new Coord(coord.getRow(), coord.getCol() + 2);
        Coord CastlingWay2 = new Coord(coord.getRow(), coord.getCol() - 2);
        if (coord.getRow() == 0 || coord.getRow() == 7){
            if (update(coord, CastlingWay1)) {
                //캐슬링 가능하면 add
                result.add(CastlingWay1);
            }
        if (update(coord, CastlingWay2)) {
            result.add(CastlingWay2);
        }
    }

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0){
                    Coord mod = new Coord(coord.getRow() + i, coord.getCol() + j);
                    if (mod.getRow() >= 0 && mod.getRow() < rowSize && mod.getCol() >= 0 && mod.getCol() < colSize) {
                        //일단 판위임
                        //비어있거나 적군이 있음
                        Piece modpiece = BoardManager.getInstance().getBoardInstance().getPieceOn(mod);
                        if (modpiece == null || modpiece.getPlayer() != malice.getPlayer()) {
                            //비었거나 적이 있다면
                            //그 위치 체크 당하는지 안 당하는지
                            CheckChecker check=new CheckChecker();
                            if(!check.isCheck(malice,mod))
                                result.add(mod);
                        }

                    }
                }

            }
        }

        return result;
    }


    public boolean movableCheck(Coord prev, Coord post) {


        ArrayList<Coord> isKingThere = this.getMovableList(prev);
        for (int i = 0; i < isKingThere.size(); i++) {
            if (isKingThere.get(i).getRow() == post.getRow() && isKingThere.get(i).getCol() == post.getCol()) { //list 안에 post 좌표값 존재
                return true;
            }
        }
        //list 안에 좌표값 존재 안함
        return false;
    }


    // //추가 함수. prev->post 로 킹이 움직일 수 있는지

    //@Override
    public boolean update(Coord prev, Coord post) {
        /*
룩과 킹이 한번도 움직이지 않았어야 한다.
룩과 킹 사이에 아무것도 있으면 안된다.
현재 킹이 체크되어있으면 안된다.
킹이 통과하는 칸에 적의 말이 이동가능해서는 안된다.*/
        Piece malice = BoardManager.getInstance().getBoardInstance().getPieceOn(prev); //나7

        if (post.getCol() > prev.getCol()) {
            //오른쪽
            Iterator<Record> it = History.getInstance().iterator();
            while (it.hasNext()) {
                Piece piece = it.next().getPiece(); //히스토리 포인터
                if ((piece.getType().equals(ChessPieceEnum.king)) &&
                        (piece.getPlayer() == BoardManager.getInstance().getBoardInstance().getPieceOn(prev).getPlayer())) {//내쪽 킹
                    return false;   //past king moved
                }
                if ((piece.getType().equals(ChessPieceEnum.rukh)) &&
                        (piece.getPlayer() == BoardManager.getInstance().getBoardInstance().getPieceOn(prev).getPlayer())) {//내쪽 룩
                    if (piece.getId()=="1")//오른쪽 룩
                        return false;   //past rukh moved
                }
            }
            for (int j = 1; j < 3; j++) {
                Coord rightexist = new Coord(prev.getRow(), prev.getCol() + j);
                Piece right = BoardManager.getInstance().getBoardInstance().getPieceOn(rightexist);
                if (right != null)
                    return false;
                CheckChecker check = new CheckChecker();
                if (check.isCheck(malice, rightexist)) {
                    return false;   //가는길에 내 킹 체크 있어
                }
            }
            CheckChecker check = new CheckChecker();
            if (check.isCheck(malice, prev)) {
                return false;       //지금 체크라면
            }
        }

        if (post.getCol() < prev.getCol()) {
            //왼쪽
            Iterator<Record> it = History.getInstance().iterator();
            while (it.hasNext()) {
                Piece piece = it.next().getPiece(); //히스토리 포인터
                if ((piece.getType().equals(ChessPieceEnum.king)) &&
                        (piece.getPlayer() == BoardManager.getInstance().getBoardInstance().getPieceOn(prev).getPlayer())) {//내쪽 킹
                    return false;   //past king moved
                }
                if ((piece.getType().equals(ChessPieceEnum.rukh)) &&
                        (piece.getPlayer() == BoardManager.getInstance().getBoardInstance().getPieceOn(prev).getPlayer())) {//내쪽 룩
                    if (piece.getId() == "0")//오른쪽 룩
                        return false;   //past rukh moved
                }
            }
            for (int j = 1; j < 3; j++) {
                Coord leftexist = new Coord(prev.getRow(), prev.getCol() - j);
                Piece right = BoardManager.getInstance().getBoardInstance().getPieceOn(leftexist);
                if (right != null)
                    return false;
                CheckChecker check = new CheckChecker();
                if (check.isCheck(malice, leftexist)) {
                    return false;   //가는길에 내 킹 체크 있어
                }
            }
            CheckChecker check = new CheckChecker();
            if (check.isCheck(malice, prev)) {
                return false;       //지금 체크라면
            }
        }

        return true;
    }

}



