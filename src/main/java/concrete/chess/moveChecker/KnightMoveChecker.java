package concrete.chess.moveChecker;

import bean.Coord;
import board.BoardManager;
import concrete.ConcreteMoveCheckerFactory;
import moveChecker.MoveChecker;
import piece.Piece;

import java.util.ArrayList;
//TODO
public class KnightMoveChecker implements MoveChecker {
    @Override
    public ArrayList<Coord> getMoveableList(Coord coord) {
        ArrayList<Coord> result = new ArrayList<Coord>();


        int rowSize = BoardManager.getInstance().getBoardInstance().getBoardRowSize();
        int colSize = BoardManager.getInstance().getBoardInstance().getBoardColSize();


        Piece malice = BoardManager.getInstance().getBoardInstance().getPieceOn(coord);

        Coord mod0 = new Coord(coord.getRow() -2, coord.getCol() + 1);
        Piece piece0 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod0);
        if(!(piece0!=null&&piece0.getPlayer()==malice.getPlayer())){
            result.add(mod0);
        }
        Coord mod1 = new Coord(coord.getRow() -1, coord.getCol() + 2);
        Piece piece1 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod1);
        if(!(piece1!=null&&piece1.getPlayer()==malice.getPlayer())){
            result.add(mod1);
        }
        Coord mod2 = new Coord(coord.getRow()+1, coord.getCol() +2);
        Piece piece2 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod2);
        if(!(piece2!=null&&piece2.getPlayer()==malice.getPlayer())){
            result.add(mod2);
        }
        Coord mod3 = new Coord(coord.getRow()+2, coord.getCol() +1);
        Piece piece3 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod3);
        if(!(piece3!=null&&piece3.getPlayer()==malice.getPlayer())){
            result.add(mod3);
        }
        Coord mod4 = new Coord(coord.getRow()+2, coord.getCol() -1);
        Piece piece4 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod4);
        if(!(piece4!=null&&piece4.getPlayer()==malice.getPlayer())){
            result.add(mod4);
        }
        Coord mod5 = new Coord(coord.getRow()+1, coord.getCol() -2);
        Piece piece5 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod5);
        if(!(piece5!=null&&piece5.getPlayer()==malice.getPlayer())){
            result.add(mod5);
        }
        Coord mod6 = new Coord(coord.getRow()-1, coord.getCol() -2);
        Piece piece6 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod6);
        if(!(piece6!=null&&piece6.getPlayer()==malice.getPlayer())){
            result.add(mod6);
        }
        Coord mod7 = new Coord(coord.getRow()-2, coord.getCol() -1);
        Piece piece7 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod7);
        if(!(piece7!=null&&piece7.getPlayer()==malice.getPlayer())){
            result.add(mod7);
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
