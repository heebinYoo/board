package concrete.twelveJanggi.moveChecker;

import bean.Coord;
import board.BoardManager;
import concrete.twelveJanggi.TwelveJanggiBoard;
import piece.Piece;

import java.util.ArrayList;

public class CheckerBundle {
    /* Field */
    protected TwelveJanggiBoard twelveJanggiBoard = (TwelveJanggiBoard) BoardManager.getInstance().getBoardInstance();
    protected ArrayList<Coord> movableList;

    /* Constructor */
    public CheckerBundle(){
        movableList = new ArrayList<>();
    }

    /* Method */
    protected boolean rangeCheck(Coord coord){
        return coord.getRow() < twelveJanggiBoard.getBoardRowSize() && coord.getRow() >= 0 && coord.getCol() < twelveJanggiBoard.getBoardColSize() && coord.getCol() >=0;
    }

    protected boolean pieceCheck(Coord coord, int player){
        if(twelveJanggiBoard.getPieceOn(coord)==null) return true;
        else if(twelveJanggiBoard.getPieceOn(coord).getPlayer() != player) return true;
        return false;
    }
}
