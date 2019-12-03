public class Record {
    /* Field */
    Coord prev, post;
    Piece piece;


    /* Constructor */
    public Record(Coord prev, Coord post,){
        this.prev = prev;
        this.post = post;
    }

    /* Method */
    public Coord getPrev(){return  prev;}
    public Coord getPost(){return post;}
    public Piece getPiece(){return piece;}

    @Override
    public String toString(){}
}
