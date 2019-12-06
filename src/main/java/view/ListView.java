package view;

import controller.ListClickListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListView extends JFrame {
    private ListViewAdapter listViewAdapter;

    static final Logger logger =
            LoggerFactory.getLogger(ListView.class);

    public ListView(ListViewAdapter listViewAdapter, ListClickListener listClickListener) throws HeadlessException {
        this.setLayout(new FlowLayout());

        this.listViewAdapter = listViewAdapter;
        listViewAdapter.setListEventListener(new ListEventListener() {
            @Override
            public void onItemClick(JPanel jPanel, int position) {
                logger.debug("data on "+position + " piece data " +listViewAdapter.getPiece(position));
                listClickListener.onClick(jPanel, position);
            }
        });

        notifyUpdated();

        this.setSize(new Dimension(50,300));
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void notifyUpdated(){
        this.getContentPane().removeAll();
        for (int i = 0; i < listViewAdapter.getItemCount(); i++) {
            ListViewAdapter.ListViewHolder listViewHolder = listViewAdapter.createViewHolder(i);
            listViewAdapter.bindViewHolder(listViewHolder, i);
            this.add(listViewHolder);
        }
        this.repaint();
    }

}


