package controller;

import bean.Coord;
import concrete.PromotionPieceList;
import concrete.chess.observer.SelectedListener;
import game.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import piece.Piece;
import view.ListView;
import view.ListViewAdapter;
import view.TableView;

import javax.swing.*;
import java.util.ArrayList;

public class Controller implements TableClickListener, BoardEventListner{
    /* Test */
    static final Logger logger =
            LoggerFactory.getLogger(Controller.class);

    /* Field */
    private Game game;
    private TableView tableView;

    private ListView killedListView1, killedListView2, promotionView1, promotionView2;
    private ListClickListener killedListView1Listener = new ListClickListener() {
        @Override
        public void onClick(JPanel jPanel, int position) {
            fromKilledList = killed1.get(position);
        }
    };
    private ListClickListener killedListView2Listener = new ListClickListener() {
        @Override
        public void onClick(JPanel jPanel, int position) {
            fromKilledList = killed2.get(position);
        }
    };
    private ListClickListener promotionView1Listener = new ListClickListener() {
        @Override
        public void onClick(JPanel jPanel, int position) {
            promotionView1.setVisible(false);
            selectedListener.onSelect(new PromotionPieceList(game.getGameType(),1).get(position));


        }
    };
    private ListClickListener promotionView2Listener = new ListClickListener() {
        @Override
        public void onClick(JPanel jPanel, int position) {
            promotionView1.setVisible(false);

            selectedListener.onSelect(new PromotionPieceList(game.getGameType(),2).get(position));
        }
    };
    private ArrayList<Piece> killed1, killed2;

    private ArrayList<Coord> movableList = null;
    private Piece fromKilledList = null;
    private Coord postCoord = null;

    private SelectedListener selectedListener;

    /* Constructor */
    public Controller(Game game, TableView tableView){
        this.game = game;
        this.game.setBoardEventListner(this);
        this.tableView = tableView;
        this.tableView.setTableClickListener(this::onClick);

        initView();

        killedListView1.setVisible(true);
        killedListView2.setVisible(true);

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

    private boolean checkMovableList(Coord coord){
        if(movableList != null) {
            for (Coord point : movableList) {
                if (point.getRow() == coord.getRow() && point.getCol() == coord.getCol())
                    return true;
            }
        }
        return false;
    }

    @Override
    public void onClick(JPanel jPanel, Coord coord) {
        logger.debug("data on "+coord + " piece data ");
        if(game.getPiece(coord) == null){
            if(fromKilledList == null){
                if(checkMovableList(coord))
                    game.update(postCoord, coord);
                tableView.notifyUpdated();
                movableList = null; fromKilledList = null;
            }else{
                game.update(fromKilledList, coord);
                tableView.notifyUpdated();
                movableList = null; fromKilledList = null;
            }
        }else{
            if(game.click(coord)){
                movableList = game.getMoveableList(coord);
                tableView.drawMoveablePoint(movableList);
                fromKilledList = null;
            }else{
                if(checkMovableList(coord))
                    game.update(postCoord, coord);
                tableView.notifyUpdated();
                movableList = null; fromKilledList = null;
            }
        }
        postCoord = coord;
    }

    @Override
    public void onKilled(Piece piece) {

        switch(piece.getPlayer()){
        case 1:
            killed1.add(piece);
            killedListView1.notifyUpdated();
            break;
        case 2:
            killed2.add(piece);
            killedListView2.notifyUpdated();
    }


    }

    @Override
    public void onPromoted(Piece piece, SelectedListener callback) {
        this.selectedListener=callback;
        switch(piece.getPlayer()){
            case 1:
                promotionView1.setVisible(true);
                promotionView1.requestFocus();
            case 2:
                promotionView2.setVisible(true);
                promotionView2.requestFocus();
        }

    }


    @Override
    public void onGameOver() {
        tableView.removeAll();
        tableView.invalidate();
        tableView.repaint();
        tableView.revalidate();
    }
}
