package controller;

import bean.Coord;
import concrete.ConcretePieceFactory;
import concrete.PromotionPieceList;
import game.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import piece.Piece;
import view.ListView;
import view.ListViewAdapter;
import view.TableView;

import javax.swing.*;
import java.util.ArrayList;

public class Controller implements TableClickListener{

    static final Logger logger =
            LoggerFactory.getLogger(Controller.class);


    private Game game;
    private TableView tableView;

    private ListView killedListView1, killedListView2, promotionView1, promotionView2;
    private ListClickListener killedListView1Listener = new ListClickListener() {
        @Override
        public void onClick(JPanel jPanel, int position) {
            killed1.get(position);
        }
    };
    private ListClickListener killedListView2Listener = new ListClickListener() {
        @Override
        public void onClick(JPanel jPanel, int position) {
            killed2.get(position);
        }
    };
    private ListClickListener promotionView1Listener = new ListClickListener() {
        @Override
        public void onClick(JPanel jPanel, int position) {
            new PromotionPieceList(game.getGameType(), 1).get(position);
        }
    };
    private ListClickListener promotionView2Listener = new ListClickListener() {
        @Override
        public void onClick(JPanel jPanel, int position) {
            new PromotionPieceList(game.getGameType(), 2).get(position);
        }
    };

    private ArrayList<Piece> killed1, killed2;


    public Controller(Game game, TableView tableView){
        this.game = game;
        this.tableView = tableView;
        this.tableView.setTableClickListener(this::onClick);

        initView();

        killedListView1.setVisible(true);
        killedListView2.setVisible(true);
        promotionView1.setVisible(true);
    }

    /* Method */
    private void initView(){
        killed1 = new ArrayList<>();
        killed2 = new ArrayList<>();
        killedListView1 = new ListView(new ListViewAdapter(killed1), killedListView1Listener);
        killedListView2 = new ListView(new ListViewAdapter(killed2), killedListView2Listener);


        promotionView1 = new ListView(new ListViewAdapter(new PromotionPieceList(game.getGameType(), 1)),promotionView1Listener);
        promotionView2 = new ListView(new ListViewAdapter(new PromotionPieceList(game.getGameType(), 2)),promotionView2Listener);

        killedListView1.setTitle("1Player Killed List");
        killedListView2.setTitle("2Player Killed List");
        promotionView1.setTitle("1Player can Promote");
        promotionView2.setTitle("2Player can Promote");

        int location = 50;
        int size = 600;
        tableView.setLocation(location, location);
        tableView.setSize(size, size);
        tableView.setVisible(true);
        killedListView1.setLocation(location + size, 50);
        killedListView2.setLocation(location + size, location + size/2);
    }

    private ArrayList<Coord> lastMoveableList = null;
    private Coord lastSelectedCoord = null;
    @Override
    public void onClick(JPanel jPanel, Coord coord) {
        logger.debug("data on "+coord + " piece data ");
        /*
        if(lastMoveableList != null && lastMoveableList.contains(coord)){
            game.update(lastSelectedCoord, coord); // use Last list to check coord == clicked
            return; // updated and function end
        }
        if(game.getPiece(coord) == null) //Todo
            return;
        else if(!game.click(coord)){ // clicked coord is not my piece
            lastSelectedCoord = null;
            lastMoveableList = null;
            tableView.notifyUpdated();
            return;
        }


        lastSelectedCoord = coord;
        lastMoveableList = game.getMoveableList(coord);
        tableView.drawMoveablePoint(lastMoveableList);
        */
    }
}
