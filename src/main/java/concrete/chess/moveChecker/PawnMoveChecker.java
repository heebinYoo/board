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



        Piece malice = BoardManager.getInstance().getBoardInstance().getPieceOn(coord);
        Piece piece;
        try{
            piece=History.getInstance().getLast().getPiece();
        }
        catch (NullPointerException e){
            piece=null;
        }

        //piece.


        if(malice.getPlayer()==1&&coord.getRow()==4){

            Coord coladd=new Coord(coord.getRow(),coord.getCol()+1);
            Piece pieceadd = BoardManager.getInstance().getBoardInstance().getPieceOn(coladd);
            Coord colsub=new Coord(coord.getRow(),coord.getCol()-1);
            Piece piecesub = BoardManager.getInstance().getBoardInstance().getPieceOn(colsub);
            if(pieceadd==piece){
                boolean existpast=false;
                if((ChessPieceEnum)piece.getType()==ChessPieceEnum.pawn) {
                    Iterator<Record> it = History.getInstance().iterator();
                    while(it.hasNext()){

                        if((it.next().getPiece().getId()==Integer.toString(coladd.getCol()))&&
                                (it.next().getPiece().getPlayer() != BoardManager.getInstance().getBoardInstance().getPieceOn(coord).getPlayer())) {
                            existpast=true;
                            break;
                        }
                    }
                    if(existpast==false) {
                        Coord enpassant = new Coord(coladd.getRow() + 1, coladd.getCol());
                        result.add(enpassant);
                    }
                }
            }
            if(piecesub==piece){
                boolean existpast=false;
                if((ChessPieceEnum)piece.getType()==ChessPieceEnum.pawn) {
                    Iterator<Record> it = History.getInstance().iterator();
                    while(it.hasNext()){
                        if((it.next().getPiece().getId()==Integer.toString(colsub.getCol()))&&
                                (it.next().getPiece().getPlayer() != BoardManager.getInstance().getBoardInstance().getPieceOn(coord).getPlayer())) {
                            existpast=true;
                            break;
                        }
                    }
                    if(existpast==false) {
                        Coord enpassant = new Coord(colsub.getRow() + 1, colsub.getCol());
                        result.add(enpassant);
                    }
                }
            }

        }
        if(malice.getPlayer()==2&&coord.getRow()==3){

            Coord coladd=new Coord(coord.getRow(),coord.getCol()+1);
            Piece pieceadd = BoardManager.getInstance().getBoardInstance().getPieceOn(coladd);
            Coord colsub=new Coord(coord.getRow(),coord.getCol()-1);
            Piece piecesub = BoardManager.getInstance().getBoardInstance().getPieceOn(colsub);
            if(pieceadd==piece){
                boolean existpast=false;
                if((ChessPieceEnum)piece.getType()==ChessPieceEnum.pawn) {
                    Iterator<Record> it = History.getInstance().iterator();
                    while(it.hasNext()){
                        if((it.next().getPiece().getId()==Integer.toString(coladd.getCol()))&&
                                (it.next().getPiece().getPlayer() != BoardManager.getInstance().getBoardInstance().getPieceOn(coord).getPlayer())) {
                            existpast=true;
                            break;
                        }
                    }
                    if(existpast==false) {
                        Coord enpassant = new Coord(coladd.getRow() -1, coladd.getCol());
                        result.add(enpassant);
                    }
                }
            }
            if(piecesub==piece){
                boolean existpast=false;
                if((ChessPieceEnum)piece.getType()==ChessPieceEnum.pawn) {
                    Iterator<Record> it = History.getInstance().iterator();
                    while(it.hasNext()){
                        if((it.next().getPiece().getId()==Integer.toString(colsub.getCol()))&&
                                (it.next().getPiece().getPlayer() != BoardManager.getInstance().getBoardInstance().getPieceOn(coord).getPlayer())) {
                            existpast=true;
                            break;
                        }
                    }
                    if(existpast==false) {
                        Coord enpassant = new Coord(colsub.getRow() -1, colsub.getCol());
                        result.add(enpassant);
                    }
                }
            }

        }


        if(malice.getPlayer()==1){
           //2.
            Iterator<Record> it = History.getInstance().iterator();
            boolean existpast=false;
            while(it.hasNext()){

                if((it.next().getPiece().getId()==malice.getId())&& (it.next().getPiece().getPlayer()==1)) {
                    existpast=true;
                    break;
                }
            }
            if(existpast==false) {
                Coord iwanttogo = new Coord(coord.getRow() + 2, coord.getCol());
                result.add(iwanttogo);
            }

            Coord mod0 = new Coord(coord.getRow()+1, coord.getCol() + 1);
            Piece piece0 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod0);
            if(piece0!=null&&piece0.getPlayer()==2){
                result.add(mod0);
            }
            Coord mod1 = new Coord(coord.getRow()+1, coord.getCol() -1);
            Piece piece1 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod1);
            if(piece1!=null&&piece1.getPlayer()==2){
                result.add(mod1);
            }
            Coord mod2 = new Coord(coord.getRow()+1, coord.getCol() );
            Piece piece2 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod2);
            if(piece2==null){
                result.add(mod2);
            }

        }

        if(malice.getPlayer()==2){
            //2.
            Iterator<Record> it = History.getInstance().iterator();
            boolean existpast=false;
            while(it.hasNext()){


                if((it.next().getPiece().getId()==malice.getId())&& (it.next().getPiece().getPlayer()==2)) {
                    existpast=true;
                    break;
                }
            }
            if(existpast==false) {
                Coord iwanttogo = new Coord(coord.getRow() -2, coord.getCol());
                result.add(iwanttogo);
            }
            //1.

            Coord mod0 = new Coord(coord.getRow()-1, coord.getCol()-1);
            Piece piece0 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod0);
            if(piece0!=null&&piece0.getPlayer()==1){
                result.add(mod0);
            }
            Coord mod1 = new Coord(coord.getRow()-1, coord.getCol() +1);
            Piece piece1 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod1);
            if(piece1!=null&&piece1.getPlayer()==1){
                result.add(mod1);
            }
            Coord mod2 = new Coord(coord.getRow()-1, coord.getCol() );
            Piece piece2 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod2);
            if(piece2==null){
                result.add(mod2);
            }

        }

        return result;
    }





    @Override
    public boolean moveableCheck(Coord prev, Coord post) {


        ConcreteMoveCheckerFactory moveCheckerFactory = new ConcreteMoveCheckerFactory();
        ArrayList<Coord> isBishopThere = moveCheckerFactory.createMoveChecker(BoardManager.getInstance().getBoardInstance().getPieceOn(prev)).getMoveableList(prev);
        for (int i = 0; i < isBishopThere.size(); i++) {
            if (isBishopThere.get(i).getRow()==post.getRow()&&isBishopThere.get(i).getCol()==post.getCol()) {
                return true;
            }
        }

        return false;
    }
}
