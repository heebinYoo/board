package concrete.twelveJanggi.piece;

import piece.Piece;

public class TwelveJanggiPiece extends Piece {
    /* Field */
    private TwelveJanggiPieceEnum type;

    /* Constructor */
    public TwelveJanggiPiece(int player, TwelveJanggiPieceEnum type, String id){
        this.player = player;
        this.type = type;
        this.id = id;
    }

    /* Method */
    @Override
    public int getPlayer() {
        return super.player;
    }

    @Override
    public Enum getType() {
        return type;
    }
}
