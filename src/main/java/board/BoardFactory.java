package board;


import concrete.GameList;
import game.Game;

public interface BoardFactory {
    public Board createBoard(Game.Accessor accessor, GameList gameList);
}
