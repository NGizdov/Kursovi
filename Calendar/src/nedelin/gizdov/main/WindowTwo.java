package nedelin.gizdov.main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

public class WindowTwo extends JFrame{

	public static void main(String[] args) {
		JTable table = new JTable(6, 7);
		table.setSize(490, 420);
		table.getTableHeader();
		table.setRowHeight(70);
		table.setShowGrid(true);
		table.setCellSelectionEnabled(true);

		JPanel container = new JPanel();
		
		JPanel panelDown = new JPanel();
		JPanel panelUp = new JPanel();
		
		panelDown.setSize(540, 450);
		panelDown.add(table);
		
		panelUp.setSize(540, 120);
		
		container.setLayout((new BoxLayout(container, BoxLayout.Y_AXIS)));

		JButton button = new JButton("Week");
		JToolBar tab = new JToolBar(JToolBar.HORIZONTAL);
		tab.add(new JButton("One"));
		tab.add(new JButton("Two"));
		tab.add(new JButton("Tree"));
		tab.setSize(50, 50);
		tab.setFloatable(false);
		tab.setRollover(true);
		
		panelUp.setPreferredSize(new Dimension(50, 50));
		
		panelUp.add(tab);

		container.add(panelDown);
		container.add(panelUp);
		
		
		
		
		WindowTwo win = new WindowTwo();
		win.setLayout(new BorderLayout(0, 0));
		
//		win.add(table);
		win.setVisible(true);
		win.setName("table");
		win.setSize(540, 500);
		win.add(panelDown, BorderLayout.SOUTH);
		win.add(panelUp, BorderLayout.NORTH);
		win.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
