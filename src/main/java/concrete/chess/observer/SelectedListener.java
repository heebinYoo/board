package concrete.chess.observer;

import piece.Piece;

public interface SelectedListener{
    public void onSelect(Piece piece);
}
