public class ChessPiece extends Piece {
    private ChessPieceEnum type;

    ChessPiece(int player, ChessPieceEnum type){
      this.player = player;
      this.type=type;
    }

    @Override
    public int getPlayer() {
        return super.player;
    }

    public ChessPieceEnum getType() {
        return type;
    }
}
