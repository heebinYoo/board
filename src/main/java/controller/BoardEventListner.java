package controller;

import concrete.chess.observer.SelectedListener;
import piece.Piece;

public interface BoardEventListner {
    public void onKilled(Piece piece);
    public void onPromoted(Piece piece, SelectedListener selectedListener);
}
