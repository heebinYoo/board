package concrete;

import concrete.chess.piece.ChessPieceEnum;
import concrete.shogi.ShogiPieceEnum;
import concrete.twelveJanggi.TwelveJanggiBoard;
import concrete.twelveJanggi.piece.TwelveJanggiPieceEnum;
import piece.Piece;

import static concrete.twelveJanggi.piece.TwelveJanggiPieceEnum.*;

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
    //p1
    private static final String RED_JANG_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\twelveJanggi\\icon\\red-jang.PNG";
    private static final String RED_SANG_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\twelveJanggi\\icon\\red-sang.PNG";
    private static final String RED_WANG_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\twelveJanggi\\icon\\red-wang.PNG";
    private static final String RED_ZA_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\twelveJanggi\\icon\\red-za.PNG";
    private static final String RED_HU_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\twelveJanggi\\icon\\red-hu.PNG";
    //p2
    private static final String GREEN_JANG_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\twelveJanggi\\icon\\green-jang.PNG";
    private static final String GREEN_SANG_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\twelveJanggi\\icon\\green-sang.PNG";
    private static final String GREEN_WANG_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\twelveJanggi\\icon\\green-wang.PNG";
    private static final String GREEN_ZA_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\twelveJanggi\\icon\\green-za.PNG";
    private static final String GREEN_HU_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\twelveJanggi\\icon\\green-hu.PNG";

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
            TwelveJanggiPieceEnum type = (TwelveJanggiPieceEnum) piece.getType();
            if(piece.getPlayer()==1){
                switch (type){
                    case jang:
                        return RED_JANG_ICON;
                    case sang:
                        return RED_SANG_ICON;
                    case wang:
                        return RED_WANG_ICON;
                    case za:
                        return RED_ZA_ICON;
                    case hu:
                        return RED_HU_ICON;
                }
            }
            else{
                switch (type) {
                    case jang:
                        return GREEN_JANG_ICON;
                    case sang:
                        return GREEN_SANG_ICON;
                    case wang:
                        return GREEN_WANG_ICON;
                    case za:
                        return GREEN_ZA_ICON;
                    case hu:
                        return GREEN_HU_ICON;
                }
            }
        }
        throw new IllegalArgumentException();
    }
}
