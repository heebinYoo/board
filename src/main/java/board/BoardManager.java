package board;

import concrete.GameList;
import game.Game;

public class BoardManager {
    private BoardManager(){}

    private static class BoardManagerHolder{
        private static final BoardManager boardManager = new BoardManager();
    }

    public static BoardManager getInstance() {
        return BoardManagerHolder.boardManager;
    }

    private Board board;
    public void initBoard(Game.Accessor accessor, GameList gameList , BoardFactory boardFactory){
        board =boardFactory.createBoard(accessor, gameList);
    }
    public Board getBoardInstance(){
        return board;
    }
}
