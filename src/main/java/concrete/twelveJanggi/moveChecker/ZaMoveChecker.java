package concrete.twelveJanggi.moveChecker;

import bean.Coord;
import board.BoardManager;
import concrete.twelveJanggi.TwelveJanggiBoard;
import moveChecker.MoveChecker;
import piece.Piece;

import java.util.ArrayList;

public class ZaMoveChecker extends CheckerBundle implements MoveChecker {
    @Override
    public ArrayList<Coord> getMovableList(Coord coord) {
        Piece piece = twelveJanggiBoard.getPieceOn(coord);

        if(piece.getPlayer()==1){
            if(movableCheck(coord, new Coord(coord.getRow(), coord.getCol()+1))) movableList.add(new Coord(coord.getRow(), coord.getCol()+1));
        }
        else{
            if(movableCheck(coord, new Coord(coord.getRow(), coord.getCol()-1))) movableList.add(new Coord(coord.getRow(), coord.getCol()-1));
        }

        return movableList;
    }

    @Override
    public boolean movableCheck(Coord prev, Coord post) {
        return rangeCheck(post) && pieceCheck(post, twelveJanggiBoard.getPieceOn(prev).getPlayer());
    }
}
