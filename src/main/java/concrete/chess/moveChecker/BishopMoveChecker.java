package concrete.chess.moveChecker;
import bean.Coord;
import board.BoardManager;
import moveChecker.MoveChecker;
import piece.Piece;

import java.util.ArrayList;

public class BishopMoveChecker implements MoveChecker {
    @Override
    public ArrayList<Coord> getMoveableList(Coord coord) {
        ArrayList<Coord> result = new ArrayList<Coord>();


        int rowSize = BoardManager.getInstance().getBoardInstance().getBoardRowSize();
        int colSize = BoardManager.getInstance().getBoardInstance().getBoardColSize();

        //Insert appropriate for statement to find movable Coord List


        Piece piece = BoardManager.getInstance().getBoardInstance().getPieceOn(coord);
        //can check what is in that place on the board


        //TODO
        return result;
    }

    @Override
    public boolean moveableCheck(Coord prev, Coord post) {
        //TODO
        return false;
    }
}
