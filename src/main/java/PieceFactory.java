public class PieceFactory {
    public Piece createPiece(GameType gameType, Enum e){
        if (e instanceof ShogiPieceEnum){

        }
        else if(e instanceof ChessPieceEnum){

        }
        else{
            return null;
        }
    }
}
