package concrete.chess.observer;

import bean.Coord;
import board.Board;
import board.BoardManager;
import concrete.ConcreteMoveCheckerFactory;
import concrete.chess.piece.ChessPieceEnum;
import history.History;
import observer.Observer;

//BoardManager.getInstance().getBoardInstance().kill(prev);

public class EnPassantObserver implements Observer {
    private ConcreteMoveCheckerFactory moveCheckerFactory = new ConcreteMoveCheckerFactory();
    @Override
    public void update(Coord prev, Coord post) {
        if(BoardManager.getInstance().getBoardInstance().getPieceOn(post).getType() == ChessPieceEnum.pawn){
            if(History.getInstance().getLast().getPost().getCol()==(BoardManager.getInstance().getBoardInstance().getPieceOn(post).getPlayer()*(-1)+5)){
                //check enemy
            }

        }

    }
}
