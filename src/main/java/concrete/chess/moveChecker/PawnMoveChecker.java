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

//TODO
public class PawnMoveChecker implements MoveChecker {
    @Override
    public ArrayList<Coord> getMoveableList(Coord coord) {
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
        Piece piece=History.getInstance().getLast().getPiece(); //최근 상대
        //piece.

        if(malice.getPlayer()==1&&coord.getRow()==4){  //내가 player1 이고 앙파상의 조건1이 만족
            Coord coladd=new Coord(coord.getRow(),coord.getCol()+1);//내 오른쪽
            Piece pieceadd = BoardManager.getInstance().getBoardInstance().getPieceOn(coladd);
            Coord colsub=new Coord(coord.getRow(),coord.getCol()-1);//내 왼쪽
            Piece piecesub = BoardManager.getInstance().getBoardInstance().getPieceOn(colsub);
            if(pieceadd==piece||piecesub==piece){   //최근 움직인 말이 내 양옆 중 하나에 있다
                if((ChessPieceEnum)piece.getType()==ChessPieceEnum.pawn) {//근데 그게 폰임
                    Iterator<Record> it = History.getInstance().iterator();
                    while(it.hasNext()){
                        if((it.next().getPiece().getPlayer() == BoardManager.getInstance().getBoardInstance().getPieceOn(coord).getPlayer())&&
                                (it.next().getPiece().getType() == ChessPieceEnum.king)) return; //pawn moved before -> not castling
                        Coord enpassant = new Coord(coladd.getRow() + 1, coladd.getCol());
                        result.add(enpassant); //그 뒤쪽으로 갈 수 있다
                    }


                }
            }

        }

        return result;
    }





    @Override
    public boolean moveableCheck(Coord prev, Coord post) {
        return false;
    }
}
