package concrete.chess.observer;

import bean.Coord;
import board.BoardManager;
import concrete.ConcreteMoveCheckerFactory;
import concrete.chess.CheckChecker;
import concrete.chess.piece.ChessPieceEnum;
import controller.BoardEventListner;
import observer.Observer;

import java.util.ArrayList;

public class CheckmateObserver implements Observer {
    private ConcreteMoveCheckerFactory moveCheckerFactory = new ConcreteMoveCheckerFactory();
    private BoardEventListner boardEventListner;
    @Override
    public void update(Coord prev, Coord post) {
        if ((BoardManager.getInstance().getBoardInstance().getPieceOn(post) != null)&&(BoardManager.getInstance().getBoardInstance().getPieceOn(prev)!=null)){
            if (!(BoardManager.getInstance().getBoardInstance().getPieceOn(post).getType() == ChessPieceEnum.king)) {

                ArrayList<Coord> isKingThere = moveCheckerFactory.createMoveChecker(BoardManager.getInstance().getBoardInstance().getPieceOn(post)).getMoveableList(post);
                //checked check
                //if(CheckChecker.isCheck(BoardManager.getInstance().getBoardInstance().getPieceOn(post),post))
                for (int i = 0; i < isKingThere.size(); i++) {
                    if(BoardManager.getInstance().getBoardInstance().getPieceOn(isKingThere.get(i))!=null) {
                        if (BoardManager.getInstance().getBoardInstance().getPieceOn(isKingThere.get(i)).getType() == ChessPieceEnum.king) {
                            ArrayList<Coord> KingLoc = moveCheckerFactory.createMoveChecker(BoardManager.getInstance().getBoardInstance().getPieceOn(isKingThere.get(i))).getMoveableList(isKingThere.get(i));
                            for (int j = 0; j < KingLoc.size(); j++) {
                                for (int k = 0; k < 8; k++) {
                                    for (int l = 0; l < 8; l++) {
                                        Coord BoardCoord = new Coord(k, l);
                                        if ((BoardManager.getInstance().getBoardInstance().getPieceOn(BoardCoord) != null)&&(BoardManager.getInstance().getBoardInstance().getPieceOn(KingLoc.get(j))!=null)) {
                                            if (BoardManager.getInstance().getBoardInstance().getPieceOn(BoardCoord).getPlayer() != BoardManager.getInstance().getBoardInstance().getPieceOn(KingLoc.get(j)).getPlayer()) {
                                                ArrayList<Coord> CheckedOrNot = moveCheckerFactory.createMoveChecker(BoardManager.getInstance().getBoardInstance().getPieceOn(BoardCoord)).getMoveableList(BoardCoord);
                                                for (int m = 0; m < KingLoc.size(); m++) {
                                                    for (int n = 0; n < CheckedOrNot.size(); n++) {
                                                        if (KingLoc.get(m) == CheckedOrNot.get(n)) {
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
                            }

                            if (KingLoc.size() == 0) {
                                //CheckMate!!! exit
                                boardEventListner.onGameOver();
                            }

                        }
                    }
                }

            }

        }
    }

    @Override
    public void setBoardEventListner(BoardEventListner boardEventListner) {
        this.boardEventListner=boardEventListner;
    }
}
