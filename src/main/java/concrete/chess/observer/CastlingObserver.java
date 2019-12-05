package concrete.chess.observer;

import bean.Coord;
import board.BoardManager;
import concrete.ConcreteMoveCheckerFactory;
import concrete.chess.piece.ChessPieceEnum;
import history.History;
import observer.Observer;

import java.util.ArrayList;

public class CastlingObserver implements Observer {
    private ConcreteMoveCheckerFactory moveCheckerFactory = new ConcreteMoveCheckerFactory();
    @Override
    public void update(Coord coord) {
        if(BoardManager.getInstance().getBoardInstance().getPieceOn(coord).getType() == ChessPieceEnum.king){

            ArrayList<Coord> isKingThere = moveCheckerFactory.createMoveChecker(BoardManager.getInstance().getBoardInstance().getPieceOn(coord)).getMoveableList(coord);

            for(int i = 0; i< isKingThere.size(); i++){
                if(BoardManager.getInstance().getBoardInstance().getPieceOn(isKingThere.get(i)).getType() == ChessPieceEnum.king) {
                    //checked check
                    //if(History.getInstance().getLast()==null){}
                }
            }

        }

    }
}
