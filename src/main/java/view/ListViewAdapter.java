package view;

import piece.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListViewAdapter implements ItemEventListener {

    private ArrayList<Piece> mData = null;
    private ListEventListener listEventListener = null;

    public Piece getPiece(int i){
        return mData.get(i);
    }

    public void setListEventListener(ListEventListener listEventListener) {
        this.listEventListener = listEventListener;
    }

    @Override
    public void onClick(JPanel jPanel, int position) {
        listEventListener.onItemClick(jPanel, position);
    }

    class ListViewHolder extends JPanel {
        private JButton imgBtn=new JButton();
        private int position;
        private ListViewHolder listViewHolder = this;
        public ListViewHolder(int position, ItemEventListener itemEventListener) {
            super(new BorderLayout(),true);
            this.position=position;

            imgBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    itemEventListener.onClick(listViewHolder, position);
                }
            });
            this.add(imgBtn);
        }

        public void setImgBtn(String filename) {
            imgBtn.setIcon(new ImageIcon(filename));
        }
    }

    public ListViewAdapter(ArrayList<Piece> mData) {
        this.mData = mData;
    }

    public ListViewHolder createViewHolder(int position){
        return new ListViewHolder(position, this::onClick);
    }
    public void bindViewHolder(ListViewHolder listViewHolder, int position){
        //TODO
        mData.get(position).getPlayer();
        mData.get(position).getType();
        listViewHolder.setImgBtn("C:\\Users\\CAU\\Desktop\\d.png");
    }
    public int getItemCount(){
        return mData.size();
    }


}

interface ItemEventListener{
    public void onClick(JPanel jPanel, int position);
}