package concrete.chess.observer;

import bean.Coord;
import board.BoardManager;
import concrete.ConcreteMoveCheckerFactory;
import concrete.chess.CheckChecker;
import concrete.chess.piece.ChessPieceEnum;
import controller.BoardEventListener;
import observer.Observer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import view.ListView;

import java.util.ArrayList;

public class CheckmateObserver implements Observer {
    /* Test */
    static final Logger logger =
            LoggerFactory.getLogger(ListView.class);

    private ConcreteMoveCheckerFactory moveCheckerFactory = new ConcreteMoveCheckerFactory();
    private BoardEventListener boardEventListener;
    @Override
    public void update(Coord prev, Coord post) {
        if ((BoardManager.getInstance().getBoardInstance().getPieceOn(post) != null)&&(BoardManager.getInstance().getBoardInstance().getPieceOn(prev)!=null)){
            if(BoardManager.getInstance().getBoardInstance().getPieceOn(prev).getType()==ChessPieceEnum.king){
                CheckChecker check = new CheckChecker();
                //checked check
                if(check.isCheck(BoardManager.getInstance().getBoardInstance().getPieceOn(post),post)) {
                    ArrayList<Coord> KingMove = moveCheckerFactory.createMoveChecker(BoardManager.getInstance().getBoardInstance().getPieceOn(post)).getMovableList(post);
                    for(int i = 0;i<8;i++){
                        for(int j = 0;j<8;j++){
                            Coord Board = new Coord(i,j);
                            if((BoardManager.getInstance().getBoardInstance().getPieceOn(Board)!=null)&&(BoardManager.getInstance().getBoardInstance().getPieceOn(Board).getPlayer()!=BoardManager.getInstance().getBoardInstance().getPieceOn(post).getPlayer())){
                                ArrayList<Coord> EnemyMove = moveCheckerFactory.createMoveChecker(BoardManager.getInstance().getBoardInstance().getPieceOn(Board)).getMovableList(Board);
                                for(int k = 0;k<EnemyMove.size();k++){
                                    for(int l = 0;l<KingMove.size();l++){
                                        if(EnemyMove.get(k)==KingMove.get(l)){
                                            //CheckMate!!! exit
                                            boardEventListener.onGameOver();
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
                if((BoardManager.getInstance().getBoardInstance().getPieceOn(post).getType()==ChessPieceEnum.king)&&(BoardManager.getInstance().getBoardInstance().getPieceOn(prev).getPlayer()!=BoardManager.getInstance().getBoardInstance().getPieceOn(post).getPlayer())){
                    //checkMate!!! exit
                    boardEventListener.onGameOver();
                    logger.debug("Call GameOver");
                }
            }
        }
    }

    @Override
    public void setBoardEventListener(BoardEventListener boardEventListener) {
        this.boardEventListener = boardEventListener;
    }

}
