package concrete.chess;

import bean.Coord;
import board.Board;
import board.BoardManager;
import concrete.ConcreteMoveCheckerFactory;
import concrete.chess.piece.ChessPieceEnum;
import piece.Piece;

import java.util.ArrayList;

public class CheckChecker {
    public CheckChecker(){

    }
    private ConcreteMoveCheckerFactory moveCheckerFactory = new ConcreteMoveCheckerFactory();

    public boolean isCheck(Piece king, Coord destination){
        ArrayList<Coord> EnemyPiece = new ArrayList<Coord>();
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                Coord allBoard = new Coord(i,j);
                if((BoardManager.getInstance().getBoardInstance().getPieceOn(allBoard)!=null)&&(king.getPlayer()!= BoardManager.getInstance().getBoardInstance().getPieceOn(allBoard).getPlayer())){
                    //enemy check, add enemy piece coord to arraylist
                    EnemyPiece.add(allBoard);
                }
            }
        }
        for(int i=0;i<EnemyPiece.size();i++)if(BoardManager.getInstance().getBoardInstance().getPieceOn(EnemyPiece.get(i)).getType() == king.getType())EnemyPiece.remove(i);
        for(int i = 0;i<EnemyPiece.size();i++){
            ArrayList<Coord> CheckOrNot = moveCheckerFactory.createMoveChecker(BoardManager.getInstance().getBoardInstance().getPieceOn(EnemyPiece.get(i))).getMovableList(EnemyPiece.get(i));
            for(int j = 0; j < CheckOrNot.size(); j++){
                if(CheckOrNot.get(j)==destination){
                    //checked
                    return true;
                }
            }
        }
        return false;
    }
}
