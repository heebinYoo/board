package piece;

public abstract class Piece {
    protected int player;
    protected String id;
    public abstract int getPlayer();

    public abstract Enum getType();

    public String getId() {
        return id;
    }

}
