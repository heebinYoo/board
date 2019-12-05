package concrete;

import concrete.chess.moveChecker.*;
import concrete.chess.piece.ChessPieceEnum;
import concrete.shogi.ShogiPieceEnum;
import moveChecker.MoveChecker;
import moveChecker.MoveCheckerFactory;
import piece.Piece;

public class ConcreteMoveCheckerFactory implements MoveCheckerFactory {
    @Override
    public MoveChecker createMoveChecker(Piece piece) {
        if (piece.getType() instanceof ChessPieceEnum) {
            switch ((ChessPieceEnum) piece.getType()) {
                case bishop:
                    return new BishopMoveChecker();
                case king:
                    return new KingMoveChecker();
                case pawn:
                    return new PawnMoveChecker();
                case rukh:
                    return new RukhMoveChecker();
                case queen:
                    return new QueenMoveChecker();
                case knight:
                    return new KnightMoveChecker();
            }
        } else if (piece.getType() instanceof ShogiPieceEnum) {
            switch ((ShogiPieceEnum) piece.getType()) {
                //TODO
            }
        }

        return null;
    }
}
