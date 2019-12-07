package concrete;

import concrete.chess.piece.ChessPieceEnum;
import piece.Piece;
import piece.PieceFactory;

import java.util.ArrayList;

public class PromotionPieceList extends ArrayList<Piece> {
    PieceFactory pieceFactory;

    public PromotionPieceList(GameList gameType, int player){
        pieceFactory = new ConcretePieceFactory();
        switch (gameType){
            case chess:
                this.add(pieceFactory.createPiece(player, ChessPieceEnum.queen));
                this.add(pieceFactory.createPiece(player, ChessPieceEnum.bishop));
                this.add(pieceFactory.createPiece(player, ChessPieceEnum.knight));
                this.add(pieceFactory.createPiece(player, ChessPieceEnum.rukh));
                break;
            case shogi:
         //TODO
                break;
        }
    }
}
