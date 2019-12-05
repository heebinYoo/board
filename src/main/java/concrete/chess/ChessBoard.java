package concrete.chess;

import bean.Coord;
import board.Board;
import board.BoardManager;
import concrete.ConcreteMoveCheckerFactory;
import concrete.ConcretePieceFactory;
import concrete.chess.piece.ChessPieceEnum;
import exception.InvaildMoveException;
import history.History;
import history.Record;
import moveChecker.MoveCheckerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import piece.Piece;
import piece.PieceFactory;

public class ChessBoard extends Board {
    static final Logger logger = LoggerFactory.getLogger(ChessBoard.class);

    private final int BLACK = 1;
    private final int WHITE = 2;

    //0,0 black-1 ruke
    //7,7 white-2 ruke

    @Override
    public void init() {
        super.pieceData = new Piece[8][8];//row, col
        PieceFactory pieceFactory = new ConcretePieceFactory();

        //make piceData
        //for player 1 and player 2
        //put in pieceData, in appropriate place
        Piece piece = pieceFactory.createPiece(BLACK, ChessPieceEnum.rukh);
        super.pieceData[0][0] = piece;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //make observers
        //TODO


    }

    //recursivily called
    @Override
    public void update(Coord prev, Coord post) throws InvaildMoveException {
        Piece target = BoardManager.getInstance().getBoardInstance().getPieceOn(prev);
        if(checkSafe(prev,post,target)) {
            super.pieceData[prev.getRow()][prev.getCol()] = null;
            super.pieceData[post.getRow()][prev.getCol()] = target;
            notifyObserver(post);
        }
        else{
            throw new InvaildMoveException(prev, post, target);
        }



    }
    private boolean checkSafe(Coord prev, Coord post, Piece target){
        MoveCheckerFactory moveCheckerFactory = new ConcreteMoveCheckerFactory();
        return moveCheckerFactory.createMoveChecker(target).moveableCheck(prev,post);
    }
}
