package concrete.shogi;
import piece.Piece;

public class ShogiPiece extends Piece {
    private ShogiPieceEnum type;

    public ShogiPiece(int player, ShogiPieceEnum type){
        this.player = player;
        this.type=type;
    }

    @Override
    public int getPlayer() {
        return super.player;
    }

    @Override
    public ShogiPieceEnum getType() {
        return type;
    }
}
