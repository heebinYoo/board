package concrete.chess.moveChecker;
import bean.Coord;
import board.BoardManager;
import concrete.chess.piece.ChessPieceEnum;
import history.History;
import history.Record;
import javafx.scene.transform.Scale;
import moveChecker.MoveChecker;
import piece.Piece;


import java.util.ArrayList;
import java.util.Iterator;


//TODO
public class PawnMoveChecker implements MoveChecker {
    @Override
    public ArrayList<Coord> getMovableList(Coord coord) {
        ArrayList<Coord> result = new ArrayList<Coord>();

        int rowSize = BoardManager.getInstance().getBoardInstance().getBoardRowSize();
        int colSize = BoardManager.getInstance().getBoardInstance().getBoardColSize();

        //폰 history-> null(시작) 이면 앞 2칸
        //그 외엔 1칸
        //대각선에 적이 있다면 그 위치로 옮길 수 있음음
        //1. 최근 history->(상대) 폰 처음으로 2칸 움직였을때 -> 아군의 체스가 그 바로 옆에 있는 경우->그 폰 뒤로 이동 가능
        //2. 대각선에 적 있을때 대각선 이동 가능
        //3. 그 외의 경우 1칸 전진 맨 처음 움직일때 폰 앞으로 2칸 /1칸 전진 가능

        //앙파상 조건1 player1->row4 조건2 최근 상대 폰->내 양옆에 위치.
        Piece malice = BoardManager.getInstance().getBoardInstance().getPieceOn(coord); //나
        Piece piece;
        if(History.getInstance().getLast()!=null){
            piece=History.getInstance().getLast().getPiece(); //최근 상대
        }else piece=null;

        if(malice.getPlayer()==1&&coord.getRow()==4) {  //내가 player1 이고 앙파상의 조건1이 만족

            Coord coladd = new Coord(coord.getRow(), coord.getCol() + 1);//내 오른쪽
            Coord colsub = new Coord(coord.getRow(), coord.getCol() - 1);//내 왼쪽
            if (coladd.getRow() < 8 && coladd.getRow() >= 0 && coladd.getCol() < 8 && coladd.getCol() >= 0 && colsub.getRow() < 8 && colsub.getRow() >= 0 && colsub.getCol() < 8 && colsub.getCol() >= 0) {
                Piece pieceadd = BoardManager.getInstance().getBoardInstance().getPieceOn(coladd);
                Piece piecesub = BoardManager.getInstance().getBoardInstance().getPieceOn(colsub);
                if (pieceadd != null && pieceadd.equals(piece)) {   //최근 움직인 말이 내 오른쪽에 있다
                    boolean existpast = false;    //과거에 움직인적이 있나요?
                    if ((ChessPieceEnum) piece.getType() == ChessPieceEnum.pawn) {//근데 그게 폰임
                        Iterator<Record> it = History.getInstance().iterator();

                        while (it.hasNext()) {
                            //특정폰. 이 id의 상대폰
                            Piece piecepawn = it.next().getPiece();
                            if ((piecepawn.getId() == Integer.toString(coladd.getCol())) &&
                                    (piecepawn.getPlayer() != BoardManager.getInstance().getBoardInstance().getPieceOn(coord).getPlayer())) {//과거 기록중 이 특정 폰 존재(움직임)
                                existpast = true;
                                break;//처음 움직인게 아니랍니다
                            }

                            if (existpast == false) {//처음움직인거래
                                Coord enpassant = new Coord(coladd.getRow() + 1, coladd.getCol());
                                result.add(enpassant); //그 뒤쪽으로 갈 수 있다
                            }
                        }
                    }
                } else if (piecesub != null && piecesub.equals(piece)) {   //최근 움직인 말이 내 왼쪽에 있다
                    boolean existpast = false;    //과거에 움직인적이 있나요?
                    if ((ChessPieceEnum) piece.getType() == ChessPieceEnum.pawn) {//근데 그게 폰임
                        Iterator<Record> it = History.getInstance().iterator();

                        while (it.hasNext()) {
                            //특정폰. 이 id의 상대폰
                            Piece piecepawn = it.next().getPiece();
                            if ((piecepawn.getId() == Integer.toString(colsub.getCol())) &&
                                    (piecepawn.getPlayer() != BoardManager.getInstance().getBoardInstance().getPieceOn(coord).getPlayer())) {//과거 기록중 이 특정 폰 존재(움직임)
                                existpast = true;
                                break;//처음 움직인게 아니랍니다
                            }
                            piecepawn = it.next().getPiece();
                        }
                        if (existpast == false) {//처음움직인거래
                            Coord enpassant = new Coord(colsub.getRow() + 1, colsub.getCol());
                            result.add(enpassant); //그 뒤쪽으로 갈 수 있다
                        }
                    }
                }
            }
        }


        if(malice.getPlayer()==2&&coord.getRow()==3) {  //내가 player2 이고 앙파상의 조건1이 만족

            Coord coladd = new Coord(coord.getRow(), coord.getCol() + 1);//내 오른쪽
            Piece pieceadd = BoardManager.getInstance().getBoardInstance().getPieceOn(coladd);
            Coord colsub = new Coord(coord.getRow(), coord.getCol() - 1);//내 왼쪽
            Piece piecesub = BoardManager.getInstance().getBoardInstance().getPieceOn(colsub);
            if (piece != null) {
                if (piece.equals(pieceadd)) {   //최근 움직인 말이 내 오른쪽에 있다
                    boolean existpast = false;    //과거에 움직인적이 있나요?
                    if ((ChessPieceEnum) piece.getType() == ChessPieceEnum.pawn) {//근데 그게 폰임
                        Iterator<Record> it = History.getInstance().iterator();

                        while (it.hasNext()) {
                            //특정폰. 이 id의 상대폰
                            Piece piecepawn = it.next().getPiece();
                            if ((piecepawn.getId() == Integer.toString(coladd.getCol())) &&
                                    (piecepawn.getPlayer() != BoardManager.getInstance().getBoardInstance().getPieceOn(coord).getPlayer())) {//과거 기록중 이 특정 폰 존재(움직임)
                                existpast = true;
                                break;//처음 움직인게 아니랍니다
                            }
                        }
                        if (existpast == false) {//처음움직인거래
                            Coord enpassant = new Coord(coladd.getRow() - 1, coladd.getCol());
                            result.add(enpassant); //그 뒤쪽으로 갈 수 있다
                        }
                    }
                }
                if (piece.equals(piecesub)) {   //최근 움직인 말이 내 왼쪽에 있다
                    boolean existpast = false;    //과거에 움직인적이 있나요?
                    if ((ChessPieceEnum) piece.getType() == ChessPieceEnum.pawn) {//근데 그게 폰임
                        Iterator<Record> it = History.getInstance().iterator();

                        while (it.hasNext()) {
                            Piece piecepawn = it.next().getPiece();
                            //특정폰. 이 id의 상대폰
                            if ((piecepawn.getId() == Integer.toString(colsub.getCol())) &&
                                    (piecepawn.getPlayer() != BoardManager.getInstance().getBoardInstance().getPieceOn(coord).getPlayer())) {//과거 기록중 이 특정 폰 존재(움직임)
                                existpast = true;
                                break;//처음 움직인게 아니랍니다
                            }
                        }
                        if (existpast == false) {//처음움직인거래
                            Coord enpassant = new Coord(colsub.getRow() - 1, colsub.getCol());
                            result.add(enpassant); //그 뒤쪽으로 갈 수 있다
                        }
                    }
                }

            }
        }
        //대각선에 적이 있을때 그쪽 이동 가능
        //1. 대각선. 앞 한칸씩 add
        //2. 처음이었다면 앞 2칸 add
        if(malice.getPlayer()==1){
           //2.
            Iterator<Record> it = History.getInstance().iterator();

            boolean existpast=false;    //과거에 움직인적이 있나요?
            while(it.hasNext()){
                //나
                //그전의 기록에서 내가 있는지
                Piece piecepawn = it.next().getPiece();
                if(piecepawn.getType() == malice.getType() && (piecepawn.getId()==malice.getId())&& (piecepawn.getPlayer()==1)) {//player1 의 내 폰 id
                    existpast=true;
                    break;//처음 움직인게 아니랍니다
                }
            }
            if(existpast==false) {//처음움직인거래
                Coord iwanttogo = new Coord(coord.getRow() + 2, coord.getCol()); //그럼 앞2칸 추가
                if(BoardManager.getInstance().getBoardInstance().getPieceOn(iwanttogo)==null||BoardManager.getInstance().getBoardInstance().getPieceOn(iwanttogo).getPlayer()!=malice.getPlayer())
                result.add(iwanttogo); //그 뒤쪽으로 갈 수 있다
            }
            //1.

            if(coord.getRow() + 1 >=0&&coord.getRow() + 1 < rowSize &&  coord.getCol() + 1 >=0&&coord.getCol() + 1 < colSize) {
                Coord mod0 = new Coord(coord.getRow() + 1, coord.getCol() + 1);    //지금 움직일 수 있는 곳
                Piece piece0 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod0);  //그곳에 무언가
                if (piece0 != null && piece0.getPlayer() == 2) {//누가 있는데 적이다
                    result.add(mod0);
                }
            }
            if(coord.getRow() + 1 >=0&&coord.getRow() + 1 < rowSize &&  coord.getCol() -1 >=0&&coord.getCol() -1 < colSize) {
                Coord mod1 = new Coord(coord.getRow() + 1, coord.getCol() - 1);    //지금 움직일 수 있는 곳
                Piece piece1 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod1);  //그곳에 무언가
                if (piece1 != null && piece1.getPlayer() == 2) {//누가 있는데 적이다
                    result.add(mod1);
                }
            }
            if(coord.getRow() + 1 >=0&&coord.getRow() + 1 < rowSize ) {
                Coord mod2 = new Coord(coord.getRow() + 1, coord.getCol());    //지금 움직일 수 있는 곳
                Piece piece2 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod2);  //그곳에 무언가
                if (piece2 == null) {//앞에 아무도 없어
                    result.add(mod2);
                }
            }

        }

        if(malice.getPlayer()==2){
            //2.
            Iterator<Record> it = History.getInstance().iterator();
            boolean existpast=false;    //과거에 움직인적이 있나요?
            while(it.hasNext()){
                //나
                //그전의 기록에서 내가 있는지
                Piece piecepawn = it.next().getPiece();
                if((piecepawn.getType() == malice.getType() && piecepawn.getId()==malice.getId())&& (piecepawn.getPlayer()==2)) {//player2 의 내 폰 id
                    existpast=true;
                    break;//처음 움직인게 아니랍니다
                }
            }
            if(existpast==false) {//처음움직인거래
                Coord iwanttogo = new Coord(coord.getRow() -2, coord.getCol()); //그럼 앞2칸 추가
                if(BoardManager.getInstance().getBoardInstance().getPieceOn(iwanttogo)==null||BoardManager.getInstance().getBoardInstance().getPieceOn(iwanttogo).getPlayer()!=malice.getPlayer())
                result.add(iwanttogo); //그 뒤쪽으로 갈 수 있다
            }
            //1.

            if(coord.getRow() - 1 >=0&&coord.getRow() - 1 < rowSize &&  coord.getCol() - 1 >=0&&coord.getCol() - 1 < colSize) {
                Coord mod0 = new Coord(coord.getRow() - 1, coord.getCol() - 1);    //지금 움직일 수 있는 곳
                Piece piece0 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod0);  //그곳에 무언가
                if (piece0 != null && piece0.getPlayer() == 1) {//누가 있는데 적이다
                    result.add(mod0);
                }
            }
            if(coord.getRow() -1 >=0&&coord.getRow() -1 < rowSize &&  coord.getCol() +1 >=0&&coord.getCol() +1 < colSize) {
                Coord mod1 = new Coord(coord.getRow() - 1, coord.getCol() + 1);    //지금 움직일 수 있는 곳
                Piece piece1 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod1);  //그곳에 무언가
                if (piece1 != null && piece1.getPlayer() == 1) {//누가 있는데 적이다
                    result.add(mod1);
                }
            }
            if(coord.getRow() -1 >=0&&coord.getRow() - 1 < rowSize) {
                Coord mod2 = new Coord(coord.getRow() - 1, coord.getCol());    //지금 움직일 수 있는 곳
                Piece piece2 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod2);  //그곳에 무언가
                if (piece2 == null) {//앞에 아무도 없어
                    result.add(mod2);
                }
            }

        }

        return result;
    }

    @Override
    public boolean movableCheck(Coord prev, Coord post) {
        //TODO
        //prev->post 로 가려고 한다!
        //없으면 false
        //list 있으면 true


        ArrayList<Coord> isPawnThere = this.getMovableList(prev);
        for (int i = 0; i < isPawnThere.size(); i++) {
            if (isPawnThere.get(i).getRow()==post.getRow()&&isPawnThere.get(i).getCol()==post.getCol()) { //list 안에 post 좌표값 존재
                return true;
            }
        }
        //list 안에 좌표값 존재 안함
        return false;
    }
}
