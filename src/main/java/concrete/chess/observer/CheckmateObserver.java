package concrete.chess.observer;

import bean.Coord;
import board.BoardManager;
import concrete.ConcreteMoveCheckerFactory;
import concrete.chess.piece.ChessPieceEnum;
import observer.Observer;

import java.util.ArrayList;

public class CheckmateObserver implements Observer {
    private ConcreteMoveCheckerFactory moveCheckerFactory = new ConcreteMoveCheckerFactory();
    @Override
    public void update(Coord coord) {
        if(!(BoardManager.getInstance().getBoardInstance().getPieceOn(coord).getType() == ChessPieceEnum.king)){

           ArrayList<Coord> isKingThere = moveCheckerFactory.createMoveChecker(BoardManager.getInstance().getBoardInstance().getPieceOn(coord)).getMoveableList(coord);
           //checked check
           for(int i = 0; i< isKingThere.size(); i++){
               if(BoardManager.getInstance().getBoardInstance().getPieceOn(isKingThere.get(i)).getType() == ChessPieceEnum.king) {
                   ArrayList<Coord> KingLoc = moveCheckerFactory.createMoveChecker(BoardManager.getInstance().getBoardInstance().getPieceOn(isKingThere.get(i))).getMoveableList(isKingThere.get(i));
                   for(int j = 0; j< KingLoc.size();j++){
                       for(int k = 0;k<8;k++){
                           for(int l = 0; l<8;l++) {
                               Coord BoardCoord = new Coord(k, l);
                               if(BoardManager.getInstance().getBoardInstance().getPieceOn(BoardCoord).getPlayer()!=BoardManager.getInstance().getBoardInstance().getPieceOn(KingLoc.get(j)).getPlayer()) {
                                   ArrayList<Coord> CheckedOrNot = moveCheckerFactory.createMoveChecker(BoardManager.getInstance().getBoardInstance().getPieceOn(BoardCoord)).getMoveableList(BoardCoord);
                                   for(int m = 0;m<KingLoc.size();m++){
                                       for(int n = 0;n<CheckedOrNot.size();n++){
                                           if(KingLoc.get(m)==CheckedOrNot.get(n)) {
                                               //Cannot move to here
                                               KingLoc.remove(m);
                                               break;
                                           }
                                       }
                                   }
                               }
                           }
                       }
                   }

                   if(KingLoc.size()==0){
                       //CheckMate!!! exit
                       //TODO
                   }

               }
           }

        }

    }
}
