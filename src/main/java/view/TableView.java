package view;

import bean.Coord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class TableView extends JFrame {

    /* Test */
    static final Logger logger =
            LoggerFactory.getLogger(ListView.class);


    /* Field */
    private ArrayList<JPanel> jPanels;
    private JPanel mainPanel;

    /* Constructor */
    public TableView(TableViewAdapter tableViewAdapter) throws HeadlessException{
        super("TableView");
        GridLayout layout = new GridLayout();
        mainPanel = new JPanel(layout);
        jPanels = new ArrayList<>();

        tableViewAdapter.setTableEventListener(new TableEventListener(){
            @Override
            public void onItemClick(JPanel jPanel, Coord coord){

            }
        });

        for(int i=0;i<tableViewAdapter.getItemCount().getRow();i++)
            for(int j=0;j<tableViewAdapter.getItemCount().getCol();j++){
                Coord coord = new Coord(i,j);
                TableViewAdapter.TableViewHolder tableViewHolder = tableViewAdapter.createViewHolder(coord);
                tableViewAdapter.bindViewHolder(tableViewHolder, coord);
                this.add(tableViewHolder);
            }

        buildFrame();
    }

    /* Method */
    private void buildFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* 창의 사이즈와 관련된 함수들 */
        this.setBounds(50,50,1100,1100); // x, y는 시작 위치, width, height는 창의 크기. 0이여도 내부 구성물의 최소 크기만큼 표시된다.
        //this.pack(); // 최소 크기로 실행.
        this.setVisible(true);
    }
}
