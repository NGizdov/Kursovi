package nedelin.gizdov.main;

import java.util.Calendar;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.TableColumn;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollBar;
import java.awt.Component;
import javax.swing.Box;

public class DayView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	/**
	 * @wbp.nonvisual location=65,59
	 */
	private final Component verticalGlue = Box.createVerticalGlue();

	/**
	 * Create the panel.
	 */
	public DayView() {
		String[] columns = { "hours", "task" };
		String[][] rows = { { "00:00", "" }, { "01:00", "" }, { "02:00", "" },
				{ "03:00", "" }, { "04:00", "" }, { "05:00", "" },
				{ "06:00", "" }, { "07:00", "" }, { "08:00", "" },
				{ "09:00", "" }, { "10:00", "" }, { "11:00", "" },
				{ "12:00", "" }, { "13:00", "" }, { "14:00", "" },
				{ "15:00", "" }, { "16:00", "" }, { "17:00", "" },
				{ "18:00", "" }, { "19:00", "" }, { "20:00", "" },
				{ "21:00", "" }, { "22:00", "" }, { "23:00", "" } };
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
					.addGap(0))
		);
		table = new JTable(rows, columns);
		scrollPane.setViewportView(table);
		
		table.setPreferredScrollableViewportSize(new Dimension(500, 400));
		table.setFillsViewportHeight(true);
		setLayout(groupLayout);

	}

	public static void fillMainPanel(Calendar dayCal) {

	}
}