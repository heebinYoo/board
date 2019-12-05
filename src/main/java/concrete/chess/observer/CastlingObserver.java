package concrete.chess.observer;

import bean.Coord;
import board.BoardManager;
import observer.Observer;

public class CastlingObserver implements Observer {
    @Override
    public void update(Coord coord) {
        BoardManager.getInstance().getBoardInstance().getPieceOn(coord);

    }
}
