package nedelin.gizdov.main;

import java.util.Calendar;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.TableColumn;

import nedelin.gizdov.events.TaskSaveAction;

import java.awt.Dimension;

public class DayView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JLabel dayLabel;
	private Calendar date;
	private String[] weekDays = { "MONDAY", "TUESDAY", "WENDSDAY", "THURSDAY",
			"FRIDAY", "SATURDAY", "SUNDAY" };

	public DayView(int day, int month, int year) {
		Main.currentDay = day;
		Main.currentMonth = month;
		Main.currentYear = year;
		date = Calendar.getInstance();
		date.set(Main.currentDay, Main.currentMonth, Main.currentYear);
		Main.currentCal = date;
		date.setFirstDayOfWeek(Calendar.MONDAY);
		int weekFirstDay = date.getFirstDayOfWeek();
		int theDay = date.get(Calendar.DAY_OF_WEEK);
		if (theDay < weekFirstDay)
			theDay = theDay + 7;
		int weekDay = theDay - weekFirstDay;
		String[] columns = { "hour", "task" };
		String[][] rows = fillTable();

		JScrollPane scrollPane = new JScrollPane();

		JPanel bottomPanel = new JPanel();

		dayLabel = new JLabel(weekDays[weekDay] + "    " + day + "-"
				+ (month + 1) + "-" + year);
		dayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		GroupLayout gl_bottomPanel = new GroupLayout(bottomPanel);
		gl_bottomPanel.setHorizontalGroup(
			gl_bottomPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_bottomPanel.createSequentialGroup()
					.addGap(129)
					.addComponent(dayLabel, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
					.addGap(142))
		);
		gl_bottomPanel.setVerticalGroup(
			gl_bottomPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_bottomPanel.createSequentialGroup()
					.addComponent(dayLabel)
					.addGap(3))
		);
		bottomPanel.setLayout(gl_bottomPanel);

		JButton saveButton = new JButton("Save");
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout
				.createParallelGroup(Alignment.LEADING)
				.addComponent(bottomPanel, Alignment.TRAILING,
						GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 453,
						Short.MAX_VALUE)
				.addGroup(
						groupLayout
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(saveButton,
										GroupLayout.DEFAULT_SIZE, 429,
										Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.TRAILING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
								280, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(saveButton, GroupLayout.PREFERRED_SIZE,
								19, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(bottomPanel, GroupLayout.PREFERRED_SIZE,
								20, GroupLayout.PREFERRED_SIZE)));
		table = new JTable(rows, columns);
		TableColumn columnOne = table.getColumnModel().getColumn(0);
		columnOne.setPreferredWidth(70);
		TableColumn columnTwo = table.getColumnModel().getColumn(1);
		columnTwo.setPreferredWidth(530);
		scrollPane.setViewportView(table);

		table.setPreferredScrollableViewportSize(new Dimension(500, 400));
		table.setFillsViewportHeight(true);
		saveButton.addActionListener(new TaskSaveAction(table));
		setLayout(groupLayout);
	}

	private String[][] fillTable() {
		String[][] rows = { { "00:00", "" }, { "01:00", "" }, { "02:00", "" },
				{ "03:00", "" }, { "04:00", "" }, { "05:00", "" },
				{ "06:00", "" }, { "07:00", "" }, { "08:00", "" },
				{ "09:00", "" }, { "10:00", "" }, { "11:00", "" },
				{ "12:00", "" }, { "13:00", "" }, { "14:00", "" },
				{ "15:00", "" }, { "16:00", "" }, { "17:00", "" },
				{ "18:00", "" }, { "19:00", "" }, { "20:00", "" },
				{ "21:00", "" }, { "22:00", "" }, { "23:00", "" } };
		String date = Main.currentDay + "/" + Main.currentMonth + "/"
				+ Main.currentYear;
		if (Main.tasks.containsKey(date)) {
			Map<String, String> tasks = Main.tasks.get(date);
			for (int i = 0; i < rows.length; i++) {
				if (tasks.containsKey(rows[i][0]))
				{
					String task = tasks.get(rows[i][0]);
					rows[i][1] = task;
				}
			}
		}
		return rows;
	}
}
