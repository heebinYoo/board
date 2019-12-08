package concrete.twelveJanggi;

import bean.Coord;
import board.Board;
import board.BoardManager;
import concrete.ConcreteMoveCheckerFactory;
import concrete.ConcretePieceFactory;
import concrete.chess.observer.PromotionObserver;
import concrete.twelveJanggi.observer.SuspendObserver;
import concrete.twelveJanggi.piece.TwelveJanggiPieceEnum;
import controller.BoardEventListner;
import exception.InvaildMoveException;
import game.Game;
import moveChecker.MoveCheckerFactory;
import observer.Observer;
import piece.Piece;
import piece.PieceFactory;

import java.util.Iterator;

public class TwelveJanggiBoard extends Board {

    /* Field */
    private final int RED = 1;
    private final int GREEN = 2;
    private BoardEventListner boardEventListner;

    /* Constructor */
    public TwelveJanggiBoard(Game.Accessor accessor){
        super(accessor);
    }

    /* Method */
    @Override
    protected void init() {
        super.pieceData = new Piece[3][4];
        PieceFactory pieceFactory = new ConcretePieceFactory();

        super.pieceData[0][0] = pieceFactory.createPiece(RED, TwelveJanggiPieceEnum.sang, "red"+"sang");
        super.pieceData[1][0] = pieceFactory.createPiece(RED, TwelveJanggiPieceEnum.wang, "red"+"wang");
        super.pieceData[2][0] = pieceFactory.createPiece(RED, TwelveJanggiPieceEnum.jang, "red"+"jang");
        super.pieceData[1][1] = pieceFactory.createPiece(RED, TwelveJanggiPieceEnum.za, "red"+"za");

        super.pieceData[0][3] = pieceFactory.createPiece(GREEN, TwelveJanggiPieceEnum.jang, "green"+"jang");
        super.pieceData[1][3] = pieceFactory.createPiece(GREEN, TwelveJanggiPieceEnum.wang, "green"+"wang");
        super.pieceData[2][3] = pieceFactory.createPiece(GREEN, TwelveJanggiPieceEnum.sang, "green"+"sang");
        super.pieceData[1][2] = pieceFactory.createPiece(GREEN, TwelveJanggiPieceEnum.za, "green"+"za");

        super.add(new PromotionObserver());
        super.add(new SuspendObserver());
    }

    @Override
    public void update(Coord prev, Coord post) throws InvaildMoveException {
        Piece target = BoardManager.getInstance().getBoardInstance().getPieceOn(prev);
        super.pieceData[prev.getRow()][prev.getCol()] = null;
        if(super.pieceData[post.getRow()][post.getCol()] != null) kill(post);
        super.pieceData[post.getRow()][post.getCol()] = target;
        notifyObserver(prev, post);
    }

    @Override
    public void update(Piece piece, Coord coord) {
        if(piece.getType() == TwelveJanggiPieceEnum.hu)
        super.pieceData[coord.getRow()][coord.getCol()] = null;
    }

    @Override
    public void kill(Coord coord) {
        if (super.pieceData[coord.getRow()][coord.getCol()].getType() == TwelveJanggiPieceEnum.wang) boardEventListner.onGameOver();
        this.boardEventListner.onKilled(super.pieceData[coord.getRow()][coord.getCol()]);
        super.pieceData[coord.getRow()][coord.getCol()] = null;
    }

    @Override
    public void setBoardEventListener(BoardEventListner boardEventListner) {
        this.boardEventListner = boardEventListner;
        Iterator<Observer> iterator = super.observerIterator();
        while (iterator.hasNext())iterator.next().setBoardEventListener(boardEventListner);
    }
}
