package view;

import bean.Coord;
import board.Board;
import concrete.ResourceResolver;
import piece.Piece;

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

            imgBtn.setFocusPainted(false);
            imgBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    tableItemEventLister.onClick(tableViewHolder, coord);
                }
            });
            this.add(imgBtn);
        }
        public void setSlected(){
            imgBtn.setBackground(new Color(180,150,50));
        }
        public void setImgBtn(String filename){
            imgBtn.setIcon(new ImageIcon(filename));
        }
        public void clearImgBtn(){imgBtn.setIcon(null);}
    }

    /* Methoc */
    public TableViewHolder createViewHolder(Coord coord){

        return new TableViewHolder(coord, this::onClick);
    }

    public void bindViewHolder(TableViewHolder holder, Coord coord){
        if(board.getPieceOn(coord) == null){
            holder.clearImgBtn();
            return;
        }
        holder.setImgBtn(ResourceResolver.resolveIcon(board.getPieceOn(coord)));
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

    /* Test */
    public Piece getPiece(Coord coord){
        return board.getPieceOn(coord);
    }
}

interface TableItemEventLister{
    public void onClick(JPanel jPanel, Coord coord);
}