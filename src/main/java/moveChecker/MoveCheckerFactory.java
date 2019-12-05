package moveChecker;

import piece.Piece;

public interface MoveCheckerFactory {
    public MoveChecker createMoveChecker(Piece piece);
}
