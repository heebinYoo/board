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

        //Insert appropriate for statement to find movable Coord List
        //현재 위치에서 갈 수 있는 좌표 리스트에 add

        Piece malice = BoardManager.getInstance().getBoardInstance().getPieceOn(coord);

        if(coord.getRow()-2>=0&&coord.getRow()-2<rowSize&&coord.getCol()+1>=0&&coord.getCol()+1<colSize) {
            Coord mod0 = new Coord(coord.getRow() - 2, coord.getCol() + 1);    //지금 움직일 수 있는 곳
            Piece piece0 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod0);
            if (!(piece0 != null && piece0.getPlayer() == malice.getPlayer())) {//누가 있는데 우리편 아님 or 비어있음
                result.add(mod0);
            }
        }
        if(coord.getRow()-1>=0&&coord.getRow()-1<rowSize&&coord.getCol()+2>=0&&coord.getCol()+2<colSize) {
            Coord mod1 = new Coord(coord.getRow() - 1, coord.getCol() + 2);    //지금 움직일 수 있는 곳
            Piece piece1 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod1);
            if (!(piece1 != null && piece1.getPlayer() == malice.getPlayer())) {//누가 있는데 우리편 아님 or 비어있음
                result.add(mod1);
            }
        }
        if(coord.getRow()+1>=0&&coord.getRow()+1<rowSize&&coord.getCol()+2>=0&&coord.getCol()+2<colSize) {
            Coord mod2 = new Coord(coord.getRow() + 1, coord.getCol() + 2);    //지금 움직일 수 있는 곳
            Piece piece2 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod2);
            if (!(piece2 != null && piece2.getPlayer() == malice.getPlayer())) {//누가 있는데 우리편 아님 or 비어있음
                result.add(mod2);
            }
        }
        if(coord.getRow()+2>=0&&coord.getRow()+2<rowSize&&coord.getCol()+1>=0&&coord.getCol()+1<colSize) {
            Coord mod3 = new Coord(coord.getRow() + 2, coord.getCol() + 1);    //지금 움직일 수 있는 곳
            Piece piece3 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod3);
            if (!(piece3 != null && piece3.getPlayer() == malice.getPlayer())) {//누가 있는데 우리편 아님 or 비어있음
                result.add(mod3);
            }
        }
        if(coord.getRow()+2>=0&&coord.getRow()+2<rowSize&&coord.getCol()-1>=0&&coord.getCol()-1<colSize) {
            Coord mod4 = new Coord(coord.getRow() + 2, coord.getCol() - 1);    //지금 움직일 수 있는 곳
            Piece piece4 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod4);
            if (!(piece4 != null && piece4.getPlayer() == malice.getPlayer())) {//누가 있는데 우리편 아님 or 비어있음
                result.add(mod4);
            }
        }
        if(coord.getRow()+1>=0&&coord.getRow()+1<rowSize&&coord.getCol()-2>=0&&coord.getCol()-2<colSize) {
            Coord mod5 = new Coord(coord.getRow() + 1, coord.getCol() - 2);    //지금 움직일 수 있는 곳
            Piece piece5 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod5);
            if (!(piece5 != null && piece5.getPlayer() == malice.getPlayer())) {//누가 있는데 우리편 아님 or 비어있음
                result.add(mod5);
            }
        }
        if(coord.getRow()-1>=0&&coord.getRow()-1<rowSize&&coord.getCol()-2>=0&&coord.getCol()-2<colSize) {
            Coord mod6 = new Coord(coord.getRow() - 1, coord.getCol() - 2);    //지금 움직일 수 있는 곳
            Piece piece6 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod6);
            if (!(piece6 != null && piece6.getPlayer() == malice.getPlayer())) {//누가 있는데 우리편 아님 or 비어있음
                result.add(mod6);
            }
        }
        if(coord.getRow()-2>=0&&coord.getRow()-2<rowSize&&coord.getCol()-1>=0&&coord.getCol()-1<colSize) {
            Coord mod7 = new Coord(coord.getRow() - 2, coord.getCol() - 1);    //지금 움직일 수 있는 곳
            Piece piece7 = BoardManager.getInstance().getBoardInstance().getPieceOn(mod7);
            if (!(piece7 != null && piece7.getPlayer() == malice.getPlayer())) {//누가 있는데 우리편 아님 or 비어있음
                result.add(mod7);
            }
        }



        return result;

    }

    @Override
    public boolean moveableCheck(Coord prev, Coord post) {
        //TODO
        //prev->post 로 가려고 한다!
        //없으면 false
        //list 있으면 true

        ConcreteMoveCheckerFactory moveCheckerFactory = new ConcreteMoveCheckerFactory();
        ArrayList<Coord> isBishopThere = moveCheckerFactory.createMoveChecker(BoardManager.getInstance().getBoardInstance().getPieceOn(prev)).getMoveableList(prev);
        for (int i = 0; i < isBishopThere.size(); i++) {
            if (isBishopThere.get(i).getRow()==post.getRow()&&isBishopThere.get(i).getCol()==post.getCol()) { //list 안에 post 좌표값 존재
                return true;
            }
        }
        //list 안에 좌표값 존재 안함
        return false;
    }
}
