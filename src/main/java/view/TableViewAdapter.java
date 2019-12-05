package view;

import bean.Coord;
import board.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableViewAdapter implements TableItemEventLister {

    /* Field */
    private Board board = null;
    private TableEventListener tableEventListener = null;

    /* Constructor */
    public TableViewAdapter(Board board){
        this.board = board;
    }

    /* Inner Class */
    public class TableViewHolder extends JPanel{
        private JButton imgBtn = new JButton();
        private Coord coord;
        private TableViewHolder tableViewHolder = this;

        public TableViewHolder(Coord coord, TableItemEventLister tableItemEventLister){
            super(new BorderLayout(), true);
            this.coord=coord;

            imgBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    tableItemEventLister.onClick(tableViewHolder, coord);
                }
            });
            this.add(imgBtn);
        }

        public void setImgBtn(String filename){
            imgBtn.setIcon(new ImageIcon(filename));
        }
    }

    /* Methoc */
    public TableViewHolder createViewHolder(Coord coord){

        return new TableViewHolder(coord, this::onClick);
    }

    public void bindViewHolder(TableViewHolder holder, Coord coord){
        String type = board.getPieceOn(coord).getType().toString();
        int player = board.getPieceOn(coord).getPlayer();
        holder.setImgBtn("C:\\Users\\CAU\\Desktop\\d.jpg");
    }

    public Coord getItemCount(){
        return new Coord(board.getBoardRowSize(),board.getBoardColSize());
    }

    public void setTableEventListener(TableEventListener tableEventListener) {
        this.tableEventListener = tableEventListener;
    }

    @Override
    public void onClick(JPanel jPanel, Coord coord) {
        tableEventListener.onItemClick(jPanel, coord);
    }
}

interface TableItemEventLister{
    public void onClick(JPanel jPanel, Coord coord);
}