package concrete;

import concrete.chess.piece.ChessPieceEnum;
import concrete.shogi.ShogiPieceEnum;
import piece.Piece;

public class ResourceResolver {
    private static final int BLACK =1;
    private static final int WHITE =2;
    //p1
    private static final String BLACK_KING_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\chess\\icon\\queen.PNG";
    private static final String BLACK_QUEEN_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\chess\\icon\\queen.PNG";
    private static final String BLACK_RUKH_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\chess\\icon\\queen.PNG";
    private static final String BLACK_BISHOP_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\chess\\icon\\queen.PNG";
    private static final String BLACK_KNIGHT_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\chess\\icon\\queen.PNG";
    private static final String BLACK_PAWN_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\chess\\icon\\queen.PNG";
    //p2
    private static final String WHITE_KING_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\chess\\icon\\queen.PNG";
    private static final String WHITE_QUEEN_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\chess\\icon\\queen.PNG";
    private static final String WHITE_RUKH_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\chess\\icon\\queen.PNG";
    private static final String WHITE_BISHOP_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\chess\\icon\\queen.PNG";
    private static final String WHITE_KNIGHT_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\chess\\icon\\queen.PNG";
    private static final String WHITE_PAWN_ICON = System.getProperty("user.dir") + "\\src\\main\\resources\\chess\\icon\\queen.PNG";

    private static final String AIM = System.getProperty("user.dir") + "\\src\\main\\resources\\chess\\icon\\pointed.PNG";

    public static String getAIM() {
        return AIM;
    }

    public static String resolveIcon(Piece piece){
        if(piece.getType() instanceof ChessPieceEnum){
            ChessPieceEnum type = (ChessPieceEnum) piece.getType();
            if(piece.getPlayer()==BLACK){
                switch (type){
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
            }
            else if(piece.getPlayer()==WHITE){
                switch (type){
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
        throw new IllegalArgumentException();
    }
}
