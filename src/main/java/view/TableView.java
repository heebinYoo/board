package view;

import bean.Coord;
import concrete.ResourceResolver;
import controller.TableClickListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TableView extends JFrame {

    /* Test */
    static final Logger logger =
            LoggerFactory.getLogger(ListView.class);
    private TableClickListener tableClickListener;
    private TableViewAdapter tableViewAdapter;
    private JPanel mainPanel;

    private final int boardRow;
    private final int boardCol;

    /* Constructor */
    public TableView(TableViewAdapter tableViewAdapter) throws HeadlessException{
        super("TableView");
        boardRow=tableViewAdapter.getItemCount().getRow();
        boardCol=tableViewAdapter.getItemCount().getCol();

        GridLayout layout = new GridLayout(tableViewAdapter.getItemCount().getRow(), tableViewAdapter.getItemCount().getCol());
        mainPanel = new JPanel(layout);
        this.tableViewAdapter = tableViewAdapter;

        tableViewAdapter.setTableEventListener(new TableEventListener(){
            @Override
            public void onItemClick(JPanel jPanel, Coord coord){
                logger.debug("data on "+ coord.getRow() + coord.getCol() + " piece data " + tableViewAdapter.getPiece(coord));
                tableClickListener.onClick(jPanel, coord);
            }
        });

        this.notifyUpdated();

        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(false);
    }

    public void notifyUpdated(){
        for (Component component : mainPanel.getComponents()) {
            mainPanel.remove(component);
        }

        for(int i = 0; i<tableViewAdapter.getItemCount().getRow(); i++)
            for(int j=0;j<tableViewAdapter.getItemCount().getCol();j++){
                Coord coord = new Coord(i,j);
                TableViewAdapter.TableViewHolder tableViewHolder = tableViewAdapter.createViewHolder(coord);
                tableViewAdapter.bindViewHolder(tableViewHolder, coord);
                mainPanel.add(tableViewHolder);
            }
        this.repaint();
    }

    public void drawMoveablePoint(ArrayList<Coord> coords){
        this.notifyUpdated();

        coords.forEach(coord -> {
           TableViewAdapter.TableViewHolder tableViewHolder = (TableViewAdapter.TableViewHolder) mainPanel.getComponent(coord.getRow()*boardCol+coord.getCol());
            tableViewHolder.setImgBtn(ResourceResolver.getAIM());

        });

        this.invalidate();
        this.repaint();
        this.revalidate();

        System.out.println("d");
    }

    public void setTableClickListener(TableClickListener tableClickListener){
        this.tableClickListener=tableClickListener;
    }
}
