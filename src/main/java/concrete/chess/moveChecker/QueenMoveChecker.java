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

        //Insert appropriate for statement to find movable Coord List
        //현재 위치에서 갈 수 있는 좌표 리스트에 add
        //result.add(coord)

        //int k=0;
        //Coord mod[]=new Coord[64];    //지금 움직일 수 있는 곳
        Piece malice = BoardManager.getInstance().getBoardInstance().getPieceOn(coord);
        for (int i = -1, j = 1;  coord.getRow() + i >=0&&coord.getRow() + i < rowSize &&  coord.getCol() + j >=0&&coord.getCol() + j < colSize; i--, j++) {    //벽에 부딪힐 때까지
            Coord mod0 = new Coord(coord.getRow() + i, coord.getCol() + j);    //지금 움직일 수 있는 곳
            Piece piece = BoardManager.getInstance().getBoardInstance().getPieceOn(mod0);
            if (piece != null) {  //가려는 곳에 말이 존재
                if (piece.getPlayer() == malice.getPlayer()) {//그게 우리편. break
                } else {//적팀. add 하고 break
                    result.add(mod0);
                }
                break;
            }
            //말이 존재하지 않아
            result.add(mod0);
            /* mod=null; */
        }

        for (int i = 1, j = 1;  coord.getRow() + i >=0&&coord.getRow() + i < rowSize &&  coord.getCol() + j >=0&&coord.getCol() + j < colSize; i++, j++) {    //벽에 부딪힐 때까지
            //k++;
            Coord mod1 = new Coord(coord.getRow() + i, coord.getCol() + j);    //지금 움직일 수 있는 곳
            Piece piece = BoardManager.getInstance().getBoardInstance().getPieceOn(mod1);
            if (piece != null) {  //가려는 곳에 말이 존재
                if (piece.getPlayer() == malice.getPlayer()) {//그게 우리편. break
                } else {//적팀. add 하고 break
                    result.add(mod1);
                }
                break;
            }
            //말이 존재하지 않아
            result.add(mod1);
        }

        for (int i = -1, j = -1;  coord.getRow() + i >=0&&coord.getRow() + i < rowSize &&  coord.getCol() + j >=0&&coord.getCol() + j < colSize; i--, j--) {    //벽에 부딪힐 때까지
            //k++;
            Coord mod3 = new Coord(coord.getRow() + i, coord.getCol() + j);    //지금 움직일 수 있는 곳
            Piece piece = BoardManager.getInstance().getBoardInstance().getPieceOn(mod3);
            if (piece != null) {  //가려는 곳에 말이 존재
                if (piece.getPlayer() == malice.getPlayer()) {//그게 우리편. break
                } else {//적팀. add 하고 break
                    result.add(mod3);
                }
                break;
            }
            //말이 존재하지 않아
            result.add(mod3);
        }
        for (int i = 1, j = -1;  coord.getRow() + i >=0&&coord.getRow() + i < rowSize &&  coord.getCol() + j >=0&&coord.getCol() + j < colSize; i++, j--) {    //벽에 부딪힐 때까지
            //k++;
            Coord mod2 = new Coord(coord.getRow() + i, coord.getCol() + j);    //지금 움직일 수 있는 곳
            Piece piece = BoardManager.getInstance().getBoardInstance().getPieceOn(mod2);
            if (piece != null) {  //가려는 곳에 말이 존재
                if (piece.getPlayer() == malice.getPlayer()) {//그게 우리편. break
                } else {//적팀. add 하고 break
                    result.add(mod2);
                }
                break;
            }
            //말이 존재하지 않아
            result.add(mod2);
        }
        for (int j=1;coord.getCol()+j<colSize;j++){    //벽에 부딪힐 때까지
            Coord mod4=new Coord(coord.getRow(),coord.getCol()+j);    //지금 움직일 수 있는 곳
            Piece piece = BoardManager.getInstance().getBoardInstance().getPieceOn(mod4);
            if(piece!=null){  //가려는 곳에 말이 존재
                if(piece.getPlayer()==malice.getPlayer()){//그게 우리편. break
                }
                else{//적팀. add 하고 break
                    result.add(mod4);
                }
                break;
            }
            //말이 존재하지 않아
            result.add(mod4);
            /* mod=null; */
        }

        for (int i=1;coord.getRow()+i<rowSize;i++){    //벽에 부딪힐 때까지
            //k++;
            Coord mod1=new Coord(coord.getRow()+i,coord.getCol());    //지금 움직일 수 있는 곳
            Piece piece = BoardManager.getInstance().getBoardInstance().getPieceOn(mod1);
            if(piece!=null){  //가려는 곳에 말이 존재
                if(piece.getPlayer()==malice.getPlayer()){//그게 우리편. break
                }
                else{//적팀. add 하고 break
                    result.add(mod1);
                }
                break;
            }
            //말이 존재하지 않아
            result.add(mod1);
        }

        for (int j=-1;0<=coord.getCol()+j;j--){    //벽에 부딪힐 때까지
            //k++;
            Coord mod3=new Coord(coord.getRow(),coord.getCol()+j);    //지금 움직일 수 있는 곳
            Piece piece = BoardManager.getInstance().getBoardInstance().getPieceOn(mod3);
            if(piece!=null){  //가려는 곳에 말이 존재
                if(piece.getPlayer()==malice.getPlayer()){//그게 우리편. break
                }
                else{//적팀. add 하고 break
                    result.add(mod3);
                }
                break;
            }
            //말이 존재하지 않아
            result.add(mod3);
        }
        for (int i=-1;0<=coord.getRow()+i;i--){    //벽에 부딪힐 때까지
            //k++;
            Coord mod2=new Coord(coord.getRow()+i,coord.getCol());    //지금 움직일 수 있는 곳
            Piece piece = BoardManager.getInstance().getBoardInstance().getPieceOn(mod2);
            if(piece!=null){  //가려는 곳에 말이 존재
                if(piece.getPlayer()==malice.getPlayer()){//그게 우리편. break
                }
                else{//적팀. add 하고 break
                    result.add(mod2);
                }
                break;
            }
            //말이 존재하지 않아
            result.add(mod2);
        }

        //Piece piece = BoardManager.getInstance().getBoardInstance().getPieceOn(coord);
        //can check what is in that place on the board
        //바뀐 좌표에 존재하는 놈-> 우리편? 상대편? 우리편이면 거기서 멈추고 상대편이면 상대편 위치까지

        //TODO
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

