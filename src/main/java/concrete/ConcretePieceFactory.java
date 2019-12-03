package concrete;
import piece.Piece;
import piece.PieceFactory;
import concrete.chess.ChessPiece;
import concrete.chess.ChessPieceEnum;
import concrete.shogi.ShogiPiece;
import concrete.shogi.ShogiPieceEnum;

public class ConcretePieceFactory implements PieceFactory {
    public Piece createPiece(int player, Enum e){
        if (e instanceof ShogiPieceEnum){
            return new ShogiPiece(player,(ShogiPieceEnum) e);
        }
        else if(e instanceof ChessPieceEnum){
           return new ChessPiece(player,(ChessPieceEnum) e);
        }
        //please add new game
        else{
            return null;
        }
    }
}
