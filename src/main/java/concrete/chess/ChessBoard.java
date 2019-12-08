package concrete.chess;

import bean.Coord;
import board.Board;
import board.BoardManager;
import concrete.ConcreteMoveCheckerFactory;
import concrete.ConcretePieceFactory;
import concrete.chess.observer.*;
import concrete.chess.piece.ChessPieceEnum;
import controller.BoardEventListener;
import exception.InvaildMoveException;

import game.Game;
import moveChecker.MoveCheckerFactory;
import observer.Observer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import piece.Piece;
import piece.PieceFactory;

import java.util.Iterator;

public class ChessBoard extends Board {
    static final Logger logger = LoggerFactory.getLogger(ChessBoard.class);

    private final int BLACK = 1;
    private final int WHITE = 2;
    private BoardEventListener boardEventListener;
    public ChessBoard(Game.Accessor accessor){
        super(accessor);
    }


    //0,0 black-p1 ruke
    //7,7 white-p2 ruke

    @Override
    public void init() {



        super.pieceData = new Piece[8][8];//row, col
        PieceFactory pieceFactory = new ConcretePieceFactory();

        //make piceData
        //for player 1 and player 2
        //put in pieceData, in appropriate place
        super.pieceData[0][0] = pieceFactory.createPiece(BLACK, ChessPieceEnum.rukh, "black"+"rukh"+0);
        super.pieceData[0][1] = pieceFactory.createPiece(BLACK, ChessPieceEnum.knight, "black"+"knight"+0);
        super.pieceData[0][2] = pieceFactory.createPiece(BLACK, ChessPieceEnum.bishop, "black"+"bishop"+0);
        super.pieceData[0][3] = pieceFactory.createPiece(BLACK, ChessPieceEnum.king, "black"+"king"+0);
        super.pieceData[0][4] = pieceFactory.createPiece(BLACK, ChessPieceEnum.queen, "black"+"queen"+0);
        super.pieceData[0][5] = pieceFactory.createPiece(BLACK, ChessPieceEnum.bishop, "black"+"bishop"+1);
        super.pieceData[0][6] = pieceFactory.createPiece(BLACK, ChessPieceEnum.knight, "white"+"knight"+1);
        super.pieceData[0][7] = pieceFactory.createPiece(BLACK, ChessPieceEnum.rukh, "black"+"rukh"+1);

        for(int i = 0; i < 8 ; i++) {
            super.pieceData[1][i] = pieceFactory.createPiece(BLACK, ChessPieceEnum.pawn, "black"+"pawn"+i);
        }


        super.pieceData[7][0] = pieceFactory.createPiece(WHITE, ChessPieceEnum.rukh, "white"+"rukh"+ 0);
        super.pieceData[7][1] = pieceFactory.createPiece(WHITE, ChessPieceEnum.knight, "white"+"knight"+0);
        super.pieceData[7][2] = pieceFactory.createPiece(WHITE, ChessPieceEnum.bishop, "white"+"bishop"+0);
        super.pieceData[7][3] = pieceFactory.createPiece(WHITE, ChessPieceEnum.king, "white"+"king"+0);
        super.pieceData[7][4] = pieceFactory.createPiece(WHITE, ChessPieceEnum.queen, "white"+"queen"+0);
        super.pieceData[7][5] = pieceFactory.createPiece(WHITE, ChessPieceEnum.bishop, "white"+"bishop"+1);
        super.pieceData[7][6] = pieceFactory.createPiece(WHITE, ChessPieceEnum.knight, "white"+"knight"+1);
        super.pieceData[7][7] = pieceFactory.createPiece(WHITE, ChessPieceEnum.rukh, "white"+"rukh"+1);

        for(int i = 0; i < 8 ; i++) {
            super.pieceData[6][i]=pieceFactory.createPiece(WHITE, ChessPieceEnum.pawn, "white"+"pawn"+i);
        }

        //make observers
        super.add(new CheckmateObserver());
        super.add(new CastlingObserver());
        super.add(new EnPassantObserver());
        super.add(new PromotionObserver());
    }

    //recursivily called
    @Override
    public void update(Coord prev, Coord post) throws InvaildMoveException {
        Piece target = BoardManager.getInstance().getBoardInstance().getPieceOn(prev);

        /*
        if(checkSafe(prev,post,target)) {

         */
            super.pieceData[prev.getRow()][prev.getCol()] = null;
            if(super.pieceData[post.getRow()][post.getCol()]!=null)
                if(super.pieceData[post.getRow()][post.getCol()].getType() == ChessPieceEnum.king)this.boardEventListener.onGameOver();
                else this.boardEventListener.onKilled(super.pieceData[post.getRow()][post.getCol()]);
            super.pieceData[post.getRow()][post.getCol()] = target;
            notifyObserver(prev, post);
            /*
        }
        else{
            throw new InvaildMoveException(prev, post, target);
        }

             */

    }

    @Override
    public boolean update(Piece piece, Coord coord) {
        if(piece.getType()!=ChessPieceEnum.pawn){
            if( piece.getId().indexOf('0')==-1 && piece.getId().indexOf('1')==-1 ) {
                super.pieceData[coord.getRow()][coord.getCol()] = piece;
                return true;
            }
        }
        return false;
    }

    @Override
    public void kill(Coord coord) {
        this.boardEventListener.onKilled(super.pieceData[coord.getRow()][coord.getCol()]);
        super.pieceData[coord.getRow()][coord.getCol()] = null;
    }

    private boolean checkSafe(Coord prev, Coord post, Piece target){
        MoveCheckerFactory moveCheckerFactory = new ConcreteMoveCheckerFactory();
        return moveCheckerFactory.createMoveChecker(target).movableCheck(prev,post);
    }

    @Override
    public void setBoardEventListener(BoardEventListener boardEventListener) {
        this.boardEventListener = boardEventListener;
        Iterator<Observer> iterator =  super.observerIterator();
        while(iterator.hasNext()){
            iterator.next().setBoardEventListener(boardEventListener);
        }
    }

}
