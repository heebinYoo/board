package concrete.janggi.piece;

import piece.Piece;

public class JanggiPiece extends Piece {
    /* Field */
    private JanggiPieceEnum type;

    /* Constructor */

    /* Method */
    @Override
    public int getPlayer() {
        return 0;
    }

    @Override
    public Enum getType() {
        return type;
    }
}
