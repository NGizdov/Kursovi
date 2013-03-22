package nedelin.gizdov.main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

public class WindowTwo extends JFrame
{

    public static void main(String[] args)
    {
        JTable table = new JTable(6, 7);
        // table.setSize(490, 420);
        // table.getTableHeader();
        table.setRowHeight(70);
        // table.setShowGrid(true);
        table.setCellSelectionEnabled(true);

        JPanel container = new JPanel();

        JPanel panelDown = new JPanel();
        JPanel panelUp = new JPanel();

        panelDown.add(table);

        container.setLayout((new BoxLayout(container, BoxLayout.Y_AXIS)));

         JButton monthView = new JButton("                Month                ");
         JButton weekView = new JButton("                Week                ");
         JButton dayView = new JButton("                 Day                 ");

//        JButton monthView = new JButton("Month");
//        monthView.setPreferredSize(new Dimension(170, 50));
//        JButton weekView = new JButton("Week");
//        weekView.setPreferredSize(new Dimension(170, 50));
//        JButton dayView = new JButton("Day");
//        dayView.setPreferredSize(new Dimension(170, 50));


        JToolBar tab = new JToolBar(JToolBar.HORIZONTAL);
        tab.add(monthView);
        tab.add(weekView);
        tab.add(dayView);
        // tab.setSize(500, 50);
        tab.setFloatable(false);
        // tab.setRollover(true);

        panelUp.add(tab);

        container.add(panelDown);
        container.add(panelUp);

        WindowTwo win = new WindowTwo();
        win.setLayout(new BorderLayout(0, 0));

        win.setVisible(true);
        win.setResizable(false);
        win.setName("table");
        win.setSize(540, 510);
        win.add(panelDown, BorderLayout.SOUTH);
        win.add(panelUp, BorderLayout.NORTH);
        win.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
