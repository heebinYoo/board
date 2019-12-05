package concrete.chess.moveChecker;
import bean.Coord;
import board.BoardManager;
import concrete.ConcreteMoveCheckerFactory;
import history.History;
import moveChecker.MoveChecker;
import piece.Piece;


import java.util.ArrayList;
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
        /*
        History.getInstance().getLast()
        if()
*/

       return result;
    }

    @Override
    public boolean moveableCheck(Coord prev, Coord post) {
        return false;
    }
}
