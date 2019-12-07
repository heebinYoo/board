import bean.Coord;
import board.Board;
import board.BoardManager;
import concrete.ConcreteBoardFactory;
import concrete.ConcreteMoveCheckerFactory;
import concrete.GameList;
import concrete.PromotionPieceList;
import game.Game;
import history.History;
import history.Record;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import view.ListView;

import java.util.ArrayList;
import java.util.Iterator;

public class HistoryTset {
    static final Logger logger =
            LoggerFactory.getLogger(ListView.class);

    @Test
    public void test1(){

        Game game = new Game(GameList.chess, new ConcreteBoardFactory(), new ConcreteMoveCheckerFactory());

        int row = BoardManager.getInstance().getBoardInstance().getBoardRowSize();
        int col = BoardManager.getInstance().getBoardInstance().getBoardColSize();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                History.getInstance().add(new Record(new Coord(j,i), new Coord(i,j)));}}


        Iterator<Record> it = History.getInstance().iterator();

        while(it.hasNext()){
            Record record = it.next();
            logger.debug(record.getPrev() + "" + record.getPost());
            if(record.getPiece()!=null)logger.debug(record.getPiece().toString());
        }
    }
}
