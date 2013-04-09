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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DayView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private Calendar date;
	private int day;
	private int month;
	private int year;
	 private String[] weekDays = { "MONDAY", "TUESDAY", "WENDSDAY", "THURSDAY",
     "FRIDAY", "SATURDAY", "SUNDAY" };
	 
	/**
	 * Create the panel.
	 * @param cal 
	 */
	public DayView(Calendar cal) {
	    date = cal;
	    day = date.get(Calendar.DAY_OF_MONTH);
	    month = date.get(Calendar.MONTH);
	    year = date.get(Calendar.YEAR);
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
		
		JPanel bottomPanel = new JPanel();
		
		JButton button = new JButton("PREVIOUS");
		button.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        date.set(year, month, --day);
		        Main.internal.setContentPane(new DayView(date));
		    }
		});
		
		JLabel label = new JLabel(weekDays[cal.get(Calendar.DAY_OF_WEEK)%7] + "    " + day + "-" + month + "-" + year);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton button_1 = new JButton("NEXT");
		button_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        date.set(year, month, ++day);
                Main.internal.setContentPane(new DayView(date));
		    }
		});
		GroupLayout gl_bottomPanel = new GroupLayout(bottomPanel);
		gl_bottomPanel.setHorizontalGroup(
		    gl_bottomPanel.createParallelGroup(Alignment.TRAILING)
		        .addGroup(gl_bottomPanel.createSequentialGroup()
		            .addComponent(button, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
		            .addPreferredGap(ComponentPlacement.RELATED)
		            .addComponent(label, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
		            .addPreferredGap(ComponentPlacement.RELATED)
		            .addComponent(button_1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
		);
		gl_bottomPanel.setVerticalGroup(
		    gl_bottomPanel.createParallelGroup(Alignment.TRAILING)
		        .addGroup(gl_bottomPanel.createSequentialGroup()
		            .addGroup(gl_bottomPanel.createParallelGroup(Alignment.BASELINE)
		                .addComponent(button, GroupLayout.PREFERRED_SIZE, 16, Short.MAX_VALUE)
		                .addComponent(button_1, GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE)
		                .addComponent(label))
		            .addGap(0))
		);
		bottomPanel.setLayout(gl_bottomPanel);
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
		    groupLayout.createParallelGroup(Alignment.LEADING)
		        .addComponent(bottomPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		        .addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
		    groupLayout.createParallelGroup(Alignment.LEADING)
		        .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
		            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
		            .addPreferredGap(ComponentPlacement.RELATED)
		            .addComponent(bottomPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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