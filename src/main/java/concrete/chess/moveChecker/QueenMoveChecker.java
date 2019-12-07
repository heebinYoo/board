package concrete.chess.moveChecker;


import bean.Coord;
import board.BoardManager;
import concrete.ConcreteMoveCheckerFactory;
import moveChecker.MoveChecker;
import piece.Piece;

import java.util.ArrayList;
//TODO
public class QueenMoveChecker implements MoveChecker {
    @Override
    public ArrayList<Coord> getMoveableList(Coord coord) {

        ArrayList<Coord> result = new ArrayList<Coord>();


        int rowSize = BoardManager.getInstance().getBoardInstance().getBoardRowSize();
        int colSize = BoardManager.getInstance().getBoardInstance().getBoardColSize();


        Piece malice = BoardManager.getInstance().getBoardInstance().getPieceOn(coord);
        for (int i = -1, j = 1; coord.getRow() + i < rowSize && coord.getCol() + j < colSize; i--, j++) {
            Coord mod0 = new Coord(coord.getRow() + i, coord.getCol() + j);
            Piece piece = BoardManager.getInstance().getBoardInstance().getPieceOn(mod0);
            if (piece != null) {
                if (piece.getPlayer() == malice.getPlayer()) {
                } else {
                    result.add(mod0);
                }
                break;
            }

            result.add(mod0);

        }

        for (int i = 1, j = 1; coord.getRow() + i < rowSize && coord.getCol() + j < colSize; i++, j++) {
            Coord mod1 = new Coord(coord.getRow() + i, coord.getCol() + j);
            Piece piece = BoardManager.getInstance().getBoardInstance().getPieceOn(mod1);
            if (piece != null) {
                if (piece.getPlayer() == malice.getPlayer()) {
                } else {
                    result.add(mod1);
                }
                break;
            }

            result.add(mod1);
        }

        for (int i = -1, j = -1; coord.getRow() + i < rowSize && coord.getCol() + j < colSize; i--, j--) {
            //k++;
            Coord mod3 = new Coord(coord.getRow() + i, coord.getCol() + j);
            Piece piece = BoardManager.getInstance().getBoardInstance().getPieceOn(mod3);
            if (piece != null) {
                if (piece.getPlayer() == malice.getPlayer()) {
                } else {
                    result.add(mod3);
                }
                break;
            }
            result.add(mod3);
        }
        for (int i = 1, j = -1; coord.getRow() + i < rowSize && coord.getCol() + j < colSize; i++, j--) {
            //k++;
            Coord mod2 = new Coord(coord.getRow() + i, coord.getCol() + j);
            Piece piece = BoardManager.getInstance().getBoardInstance().getPieceOn(mod2);
            if (piece != null) {
                if (piece.getPlayer() == malice.getPlayer()) {
                } else {
                    result.add(mod2);
                }
                break;
            }

            result.add(mod2);
        }
        for (int j=1;coord.getCol()+j<colSize;j++){
            Coord mod4=new Coord(coord.getRow(),coord.getCol()+j);
            Piece piece = BoardManager.getInstance().getBoardInstance().getPieceOn(mod4);
            if(piece!=null){
                if(piece.getPlayer()==malice.getPlayer()){
                }
                else{
                    result.add(mod4);
                }
                break;
            }

            result.add(mod4);
            /* mod=null; */
        }

        for (int i=1;coord.getRow()+i<rowSize;i++){
            //k++;
            Coord mod1=new Coord(coord.getRow()+i,coord.getCol());
            Piece piece = BoardManager.getInstance().getBoardInstance().getPieceOn(mod1);
            if(piece!=null){
                if(piece.getPlayer()==malice.getPlayer()){
                }
                else{
                    result.add(mod1);
                }
                break;
            }

            result.add(mod1);
        }

        for (int j=-1;coord.getCol()+j<colSize;j--){
            //k++;
            Coord mod3=new Coord(coord.getRow(),coord.getCol()+j);
            Piece piece = BoardManager.getInstance().getBoardInstance().getPieceOn(mod3);
            if(piece!=null){
                if(piece.getPlayer()==malice.getPlayer()){
                }
                else{
                    result.add(mod3);
                }
                break;
            }

            result.add(mod3);
        }
        for (int i=-1;coord.getRow()+i<rowSize;i--){
            //k++;
            Coord mod2=new Coord(coord.getRow()+i,coord.getCol());
            Piece piece = BoardManager.getInstance().getBoardInstance().getPieceOn(mod2);
            if(piece!=null){
                if(piece.getPlayer()==malice.getPlayer()){
                }
                else{
                    result.add(mod2);
                }
                break;
            }

            result.add(mod2);
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

