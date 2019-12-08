package concrete;

import concrete.chess.piece.ChessPieceEnum;
import piece.Piece;
import piece.PieceFactory;

import java.util.ArrayList;

public class PromotionPieceList extends ArrayList<Piece> {
    PieceFactory pieceFactory;
    private static int queenCount =2;
    private static int bishopCount =2;
    private static int knightCount =2;
    private static int rukhCount =2;

    public PromotionPieceList(GameList gameType, int player){
        String playerString = player==1 ? "black":"white";

        pieceFactory = new ConcretePieceFactory();
        switch (gameType){
            case chess:
                this.add(pieceFactory.createPiece(player, ChessPieceEnum.queen, playerString+"queenP"+queenCount++));
                this.add(pieceFactory.createPiece(player, ChessPieceEnum.bishop, playerString+"bishopP"+bishopCount++));
                this.add(pieceFactory.createPiece(player, ChessPieceEnum.knight, playerString+"knightP"+knightCount++));
                this.add(pieceFactory.createPiece(player, ChessPieceEnum.rukh, playerString+"rukhP"+rukhCount++));
                break;
            case shogi:
         //TODO
                break;
            case twelveJanggi:
                //nothing
                break;
        }
    }
}
