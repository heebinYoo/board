package exception;

import bean.Coord;
import piece.Piece;

public class InvaildMoveException extends Exception {
    public InvaildMoveException(Coord prev, Coord post, Piece target) {
        super("ChessBoard.update::it is not safe move!!!! prev : "+prev.toString()+" post : "+post.toString()+" piece : "+target.toString());
    }
}
