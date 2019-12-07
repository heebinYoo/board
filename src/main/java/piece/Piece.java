package piece;

import java.util.Objects;

public abstract class Piece {
    protected int player;
    protected String id;
    public abstract int getPlayer();

    public abstract Enum getType();

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return player == piece.player &&
                id.equals(piece.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, id);
    }
}
