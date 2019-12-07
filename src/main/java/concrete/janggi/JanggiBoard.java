package concrete.janggi;

import bean.Coord;
import board.Board;
import board.BoardManager;
import concrete.ConcreteMoveCheckerFactory;
import concrete.ConcretePieceFactory;
import concrete.chess.observer.PromotionObserver;
import concrete.janggi.piece.JanggiPieceEnum;
import controller.BoardEventListner;
import exception.InvaildMoveException;
import game.Game;
import moveChecker.MoveCheckerFactory;
import observer.Observer;
import piece.Piece;
import piece.PieceFactory;

import java.util.Iterator;

public class JanggiBoard extends Board {

    /* Field */
    private final int RED = 1;
    private final int GREEN = 2;
    private BoardEventListner boardEventListner;

    /* Constructor */
    public JanggiBoard(Game.Accessor accessor){
        super(accessor);
    }

    /* Method */
    @Override
    protected void init() {
        super.pieceData = new Piece[3][4];
        PieceFactory pieceFactory = new ConcretePieceFactory();

        super.pieceData[0][0] = pieceFactory.createPiece(RED, JanggiPieceEnum.sang, "red"+"sang");
        super.pieceData[1][0] = pieceFactory.createPiece(RED, JanggiPieceEnum.wang, "red"+"wang");
        super.pieceData[2][0] = pieceFactory.createPiece(RED, JanggiPieceEnum.jang, "red"+"jang");
        super.pieceData[1][1] = pieceFactory.createPiece(RED, JanggiPieceEnum.za, "red"+"za");

        super.pieceData[0][3] = pieceFactory.createPiece(GREEN, JanggiPieceEnum.jang, "green"+"jang");
        super.pieceData[1][3] = pieceFactory.createPiece(GREEN, JanggiPieceEnum.wang, "green"+"wang");
        super.pieceData[2][3] = pieceFactory.createPiece(GREEN, JanggiPieceEnum.sang, "green"+"sang");
        super.pieceData[1][2] = pieceFactory.createPiece(GREEN, JanggiPieceEnum.za, "green"+"za");

        // TODO make observers
        super.add(new PromotionObserver());

    }

    @Override
    public void update(Coord prev, Coord post) throws InvaildMoveException {
        Piece target = BoardManager.getInstance().getBoardInstance().getPieceOn(prev);

        if(checkSafe(prev, post, target)){
            super.pieceData[prev.getRow()][prev.getCol()] = null;
            if(super.pieceData[post.getRow()][post.getCol()] != null) kill(post);
            super.pieceData[post.getRow()][post.getCol()] = target;
            notifyObserver(prev, post);
        }else throw new InvaildMoveException(prev, post, target);
    }

    @Override
    public void update(Piece piece, Coord coord) {

    }

    @Override
    public void kill(Coord coord) {
        this.boardEventListner.onKilled(super.pieceData[coord.getRow()][coord.getCol()]);
        super.pieceData[coord.getRow()][coord.getCol()] = null;
    }

    @Override
    public void setBoardEventListener(BoardEventListner boardEventListner) {
        this.boardEventListner = boardEventListner;
        Iterator<Observer> iterator = super.observerIterator();
        while (iterator.hasNext())iterator.next().setBoardEventListener(boardEventListner);
    }

    private boolean checkSafe(Coord prev, Coord post, Piece target){
        MoveCheckerFactory moveCheckerFactory = new ConcreteMoveCheckerFactory();
        return moveCheckerFactory.createMoveChecker(target).moveableCheck(prev, post);
    }
}
