package controller;

import bean.Coord;
import concrete.ConcretePieceFactory;
import concrete.PromotionPieceList;
import game.Game;
import piece.Piece;
import view.ListView;
import view.ListViewAdapter;
import view.TableView;

import javax.swing.*;
import java.util.ArrayList;

public class Controller implements TableClickListener, ListClickListener{
    private Game game;
    private TableView tableView;
    private ListView killedListView1, killedListView2, promotionView1, promotionView2;

    private ArrayList<Piece> killed1, killed2;


    public Controller(Game game, TableView tableView){
        this.game = game;
        this.tableView = tableView;
        killed1 = new ArrayList<>();
        killed2 = new ArrayList<>();
        killedListView1 = new ListView(new ListViewAdapter(killed1));
        killedListView2 = new ListView(new ListViewAdapter(killed2));
        promotionView1 = new ListView(new ListViewAdapter(new PromotionPieceList(game.getGameType(), 1)));
        promotionView2 = new ListView(new ListViewAdapter(new PromotionPieceList(game.getGameType(), 2)));
        killedListView1.setVisible(true);
        promotionView1.setVisible(true);
    }

    /* Method */
    @Override
    public void onClick(JPanel jPanel, int position) {

    }

    @Override
    public void onClick(JPanel jPanel, Coord coord) {

    }
}
