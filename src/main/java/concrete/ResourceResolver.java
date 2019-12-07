package concrete;

import concrete.chess.piece.ChessPieceEnum;
import concrete.shogi.ShogiPieceEnum;
import concrete.twelveJanggi.piece.TwelveJanggiPieceEnum;
import piece.Piece;

public class ResourceResolver {

    /* Chess Data */
    private static final int BLACK =1;
    private static final int WHITE =2;
    //p1
    private static final String BLACK_KING_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\chess\\icon\\black-king.PNG";
    private static final String BLACK_QUEEN_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\chess\\icon\\black-queen.PNG";
    private static final String BLACK_RUKH_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\chess\\icon\\black-rukh.PNG";
    private static final String BLACK_BISHOP_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\chess\\icon\\black-bishop.PNG";
    private static final String BLACK_KNIGHT_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\chess\\icon\\black-knight.PNG";
    private static final String BLACK_PAWN_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\chess\\icon\\black-pawn.PNG";
    //p2
    private static final String WHITE_KING_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\chess\\icon\\white-king.PNG";
    private static final String WHITE_QUEEN_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\chess\\icon\\white-queen.PNG";
    private static final String WHITE_RUKH_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\chess\\icon\\white-rukh.PNG";
    private static final String WHITE_BISHOP_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\chess\\icon\\white-bishop.PNG";
    private static final String WHITE_KNIGHT_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\chess\\icon\\white-knight.PNG";
    private static final String WHITE_PAWN_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\chess\\icon\\white-pawn.PNG";

    /* TwelveJanggi Data */
    private static final int RED = 1;
    private static final int Green = 2;
    // TODO add icon data

    public static String resolveIcon(Piece piece){
        if(piece.getType() instanceof ChessPieceEnum) {
            ChessPieceEnum type = (ChessPieceEnum) piece.getType();
            if (piece.getPlayer() == BLACK) {
                switch (type) {
                    case pawn:
                        return BLACK_PAWN_ICON;
                    case bishop:
                        return BLACK_BISHOP_ICON;
                    case king:
                        return BLACK_KING_ICON;
                    case rukh:
                        return BLACK_RUKH_ICON;
                    case queen:
                        return BLACK_QUEEN_ICON;
                    case knight:
                        return BLACK_KNIGHT_ICON;
                }
            } else if (piece.getPlayer() == WHITE) {
                switch (type) {
                    case pawn:
                        return WHITE_PAWN_ICON;
                    case bishop:
                        return WHITE_BISHOP_ICON;
                    case king:
                        return WHITE_KING_ICON;
                    case rukh:
                        return WHITE_RUKH_ICON;
                    case queen:
                        return WHITE_QUEEN_ICON;
                    case knight:
                        return WHITE_KNIGHT_ICON;
                }
            }

        }
        else if (piece.getType() instanceof ShogiPieceEnum){
            if(piece.getPlayer()==1){

            }
            else if(piece.getPlayer()==2){

            }

        }
        else if (piece.getType() instanceof TwelveJanggiPieceEnum){
            if(piece.getPlayer()==1){

            }
            else{

            }
        }
        throw new IllegalArgumentException();
    }
}
