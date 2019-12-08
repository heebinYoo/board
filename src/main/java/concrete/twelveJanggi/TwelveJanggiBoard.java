package concrete.twelveJanggi;

import bean.Coord;
import board.Board;
import board.BoardManager;
import concrete.ConcretePieceFactory;
import concrete.twelveJanggi.observer.PromotionObserver;
import concrete.twelveJanggi.observer.SuspendObserver;
import concrete.twelveJanggi.piece.TwelveJanggiPieceEnum;
import controller.BoardEventListener;
import exception.InvaildMoveException;
import game.Game;
import observer.Observer;
import piece.Piece;
import piece.PieceFactory;

import java.util.Iterator;

public class TwelveJanggiBoard extends Board {

    /* Field */
    private final int RED = 1;
    private final int GREEN = 2;
    private BoardEventListener boardEventListener;

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
    public boolean update(Piece piece, Coord coord) {
        if(piece.getType() == TwelveJanggiPieceEnum.hu) {
            super.pieceData[coord.getRow()][coord.getCol()] = piece;
            return true;
        }
        return false;
    }

    @Override
    public void kill(Coord coord) {
        if (super.pieceData[coord.getRow()][coord.getCol()].getType() == TwelveJanggiPieceEnum.wang) boardEventListener.onGameOver();
        if (super.pieceData[coord.getRow()][coord.getCol()].getType() == TwelveJanggiPieceEnum.hu) {
            if(super.pieceData[coord.getRow()][coord.getCol()].getPlayer() == 1)
            super.pieceData[coord.getRow()][coord.getCol()] = new ConcretePieceFactory().createPiece(RED, TwelveJanggiPieceEnum.za, "red" + "za");
            else super.pieceData[coord.getRow()][coord.getCol()] = new ConcretePieceFactory().createPiece(GREEN, TwelveJanggiPieceEnum.za, "green" + "za");
        }
        this.boardEventListener.onKilled(super.pieceData[coord.getRow()][coord.getCol()]);
        super.pieceData[coord.getRow()][coord.getCol()] = null;
    }

    @Override
    public void setBoardEventListener(BoardEventListener boardEventListener) {
        this.boardEventListener = boardEventListener;
        Iterator<Observer> iterator = super.observerIterator();
        while (iterator.hasNext())iterator.next().setBoardEventListener(boardEventListener);
    }
}
