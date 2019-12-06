package view;

import bean.Coord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TableView extends JFrame {

    /* Test */
    static final Logger logger =
            LoggerFactory.getLogger(ListView.class);

    /* Constructor */
    public TableView(TableViewAdapter tableViewAdapter) throws HeadlessException{
        super("TableView");
        GridLayout layout = new GridLayout(tableViewAdapter.getItemCount().getRow(), tableViewAdapter.getItemCount().getCol());
        JPanel mainPanel = new JPanel(layout);

        tableViewAdapter.setTableEventListener(new TableEventListener(){
            @Override
            public void onItemClick(JPanel jPanel, Coord coord){
                logger.debug("data on "+ coord.getRow() + coord.getCol() + " piece data " + tableViewAdapter.getPiece(coord));
            }
        });

        for(int i=0;i<tableViewAdapter.getItemCount().getRow();i++)
            for(int j=0;j<tableViewAdapter.getItemCount().getCol();j++){
                Coord coord = new Coord(i,j);
                TableViewAdapter.TableViewHolder tableViewHolder = tableViewAdapter.createViewHolder(coord);
                tableViewAdapter.bindViewHolder(tableViewHolder, coord);
                mainPanel.add(tableViewHolder);
            }

        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(50,50,600,600);
        this.setVisible(true);
    }
}
