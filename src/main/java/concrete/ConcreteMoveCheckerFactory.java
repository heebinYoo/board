package concrete;

import concrete.chess.moveChecker.*;
import concrete.chess.piece.ChessPieceEnum;
import concrete.shogi.ShogiPieceEnum;
import concrete.twelveJanggi.moveChecker.*;
import concrete.twelveJanggi.piece.TwelveJanggiPieceEnum;
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
        } else if (piece.getType() instanceof TwelveJanggiPieceEnum){
            switch ((TwelveJanggiPieceEnum)piece.getType()){
                case jang:
                    return new JangMoveChecker();
                case sang:
                    return new SangMoveChecker();
                case wang:
                    return new WangMoveChecker();
                case za:
                    return new ZaMoveChecker();
                case hu:
                    return new HuMoveChecker();
            }
        }

        return null;
    }
}
