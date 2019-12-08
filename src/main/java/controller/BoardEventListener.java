package controller;

import concrete.chess.observer.SelectedListener;
import piece.Piece;

public interface BoardEventListener {
    public void onKilled(Piece piece);
    public void onPromoted(Piece piece, SelectedListener selectedListener);
    public void onGameOver();
}
