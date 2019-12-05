package view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListView extends JFrame {

    static final Logger logger =
            LoggerFactory.getLogger(ListView.class);

    public ListView(ListViewAdapter listViewAdapter) throws HeadlessException {
        super("ListView");
        this.setLayout(new FlowLayout());

        listViewAdapter.setListEventListener(new ListEventListener() {
            @Override
            public void onItemClick(JPanel jPanel, int position) {
                logger.debug("data on "+position + " piece data " +listViewAdapter.getPiece(position));
            }
        });

        for (int i = 0; i < listViewAdapter.getItemCount(); i++) {
            ListViewAdapter.ListViewHolder listViewHolder = listViewAdapter.createViewHolder(i);
            listViewAdapter.bindViewHolder(listViewHolder, i);
            this.add(listViewHolder);
        }

        this.setSize(new Dimension(50,300));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}


