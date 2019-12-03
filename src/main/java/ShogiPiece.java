public class ShogiPiece extends Piece {
    private ShogiPieceEnum type;

    ShogiPiece(int player, ShogiPieceEnum type){
        this.player = player;
        this.type=type;
    }

    @Override
    public int getPlayer() {
        return super.player;
    }

    public ShogiPieceEnum getType() {
        return type;
    }
}
