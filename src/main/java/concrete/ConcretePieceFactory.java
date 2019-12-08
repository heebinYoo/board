package concrete;
import concrete.twelveJanggi.piece.TwelveJanggiPiece;
import concrete.twelveJanggi.piece.TwelveJanggiPieceEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import piece.Piece;
import piece.PieceFactory;
import concrete.chess.piece.ChessPiece;
import concrete.chess.piece.ChessPieceEnum;
import concrete.shogi.ShogiPiece;
import concrete.shogi.ShogiPieceEnum;

public class ConcretePieceFactory implements PieceFactory {
    static final Logger logger =
            LoggerFactory.getLogger(ConcretePieceFactory.class);
    public Piece createPiece(int player, Enum e, String id){
        if (e instanceof ShogiPieceEnum){
            return new ShogiPiece(player,(ShogiPieceEnum) e,id);
        }
        else if(e instanceof ChessPieceEnum){
           return new ChessPiece(player,(ChessPieceEnum) e,id);
        }
        else if(e instanceof TwelveJanggiPieceEnum){
            return new TwelveJanggiPiece(player, (TwelveJanggiPieceEnum)e, id);
        }
        //please add new game
        else{
            logger.error("enum error in ConcretePieceFactory");
            return null;
        }
    }
}
