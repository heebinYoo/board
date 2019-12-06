package view;

import bean.Coord;

import javax.swing.*;

public interface TableEventListener {
    public void onItemClick(JPanel jPanel, Coord coord);
}
