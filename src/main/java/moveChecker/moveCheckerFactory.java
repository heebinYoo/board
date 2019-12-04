package moveChecker;

import piece.Piece;

public interface moveCheckerFactory {
    public moveChecker createMoveChecker(Piece piece);
}
