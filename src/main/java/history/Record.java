package history;

import bean.Coord;
import board.BoardManager;
import piece.Piece;

public class Record {
    /* Field */
    Coord prev, post;
    Piece piece;


    /* Constructor */
    public Record(Coord prev, Coord post){
        this.prev = prev;
        this.post = post;
        this.piece = BoardManager.getInstance().getBoardInstance().getPieceOn(post);

    }

    /* Method */
    public Coord getPrev(){return  prev;}
    public Coord getPost(){return post;}
    public Piece getPiece(){return piece;}

    @Override
    public String toString() {
        return "Record{" +
                "prev=" + prev +
                ", post=" + post +
                ", piece=" + piece +
                '}';
    }
}
