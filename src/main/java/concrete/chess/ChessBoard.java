package concrete.chess;

import bean.Coord;
import board.Board;
import board.BoardManager;
import concrete.ConcreteMoveCheckerFactory;
import concrete.ConcretePieceFactory;
import concrete.chess.observer.CastlingObserver;
import concrete.chess.observer.CheckmateObserver;
import concrete.chess.observer.EnPassantObserver;
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
        super.pieceData[0][0] = pieceFactory.createPiece(BLACK, ChessPieceEnum.rukh);
        super.pieceData[0][1] = pieceFactory.createPiece(BLACK, ChessPieceEnum.knight);
        super.pieceData[0][2] = pieceFactory.createPiece(BLACK, ChessPieceEnum.bishop);
        super.pieceData[0][3] = pieceFactory.createPiece(BLACK, ChessPieceEnum.king);
        super.pieceData[0][4] = pieceFactory.createPiece(BLACK, ChessPieceEnum.queen);
        super.pieceData[0][5] = pieceFactory.createPiece(BLACK, ChessPieceEnum.bishop);
        super.pieceData[0][6] = pieceFactory.createPiece(BLACK, ChessPieceEnum.rukh);

        for(int i = 0; i < 7 ; i++) {
            super.pieceData[1][i] = pieceFactory.createPiece(BLACK, ChessPieceEnum.pawn);
        }


        super.pieceData[7][0] = pieceFactory.createPiece(WHITE, ChessPieceEnum.rukh);
        super.pieceData[7][1] = pieceFactory.createPiece(WHITE, ChessPieceEnum.knight);
        super.pieceData[7][2] = pieceFactory.createPiece(WHITE, ChessPieceEnum.bishop);
        super.pieceData[7][3] = pieceFactory.createPiece(WHITE, ChessPieceEnum.king);
        super.pieceData[7][4] = pieceFactory.createPiece(WHITE, ChessPieceEnum.queen);
        super.pieceData[7][5] = pieceFactory.createPiece(WHITE, ChessPieceEnum.bishop);
        super.pieceData[7][6] = pieceFactory.createPiece(WHITE, ChessPieceEnum.rukh);

        for(int i = 0; i < 7 ; i++) {
            super.pieceData[6][i]=pieceFactory.createPiece(WHITE, ChessPieceEnum.pawn);
        }

        //make observers
        super.add(new CastlingObserver());
        super.add(new CheckmateObserver());
        super.add(new EnPassantObserver());
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
