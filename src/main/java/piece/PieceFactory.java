package piece;

import piece.Piece;

public interface PieceFactory {
    public Piece createPiece(int player, Enum e);
}
