package concrete.chess.piece;

import piece.Piece;

public class ChessPiece extends Piece {
    private ChessPieceEnum type;

    public ChessPiece(int player, ChessPieceEnum type){
      this.player = player;
      this.type=type;
    }

    @Override
    public int getPlayer() {
        return super.player;
    }
    @Override
    public ChessPieceEnum getType() {
        return type;
}

    @Override
    public String toString() {
        return "ChessPiece{" +
                "type=" + type +
                ", player=" + player +
                '}';
    }
}
