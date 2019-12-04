package concrete;

import concrete.chess.ChessPieceEnum;
import concrete.shogi.ShogiPieceEnum;
import moveChecker.moveChecker;
import moveChecker.moveCheckerFactory;
import piece.Piece;

public class ConcreteMoveCheckerFactory implements moveCheckerFactory {
    @Override
    public moveChecker createMoveChecker(Piece piece) {
        if (piece.getType() instanceof ChessPieceEnum) {
            switch ((ChessPieceEnum) piece.getType()) {
                case bishop:
                    break;
                case king:
                    break;
                case pawn:
                    break;
                case rukh:
                    break;
                case queen:
                    break;
                case knight:
                    break;
            }
        } else if (piece.getType() instanceof ShogiPieceEnum) {
            switch ((ShogiPieceEnum) piece.getType()) {

            }
        }
        //TODO
        return null;
    }
}
