package nedelin.gizdov.main;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Calendar;

public class DatesPanel extends JPanel {
	private Calendar date;
	// private int month;
	// private String[] months = { "JANUARY", "FEBRUARY", "MARCH", "APRIL",
	// "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER",
	// "NOVEMBER", "DECEMBER" };
	private ArrayList<JButton> buttons;
	public static int number;

	/**
	 * Create the panel.
	 */
	public DatesPanel(Calendar cal) {
		number = 0;
		setLayout(new GridLayout(6, 7, 3, 3));
		buttons = new ArrayList<JButton>(42);
		for (int i = 0; i < 42; i++) {
			buttons.add(new JButton());
		}
		for (JButton button : buttons) {
			add(button);
		}
		drawDates(cal);
	}

	public void redrawDates(Calendar cal) {
		number = 0;
		drawDates(cal);
	}

	private void drawDates(Calendar cal) {
		date = cal;
		date.set(Calendar.DAY_OF_MONTH, 1);
		date.setFirstDayOfWeek(Calendar.MONDAY);
		int days = date.getActualMaximum(Calendar.DAY_OF_MONTH);
		int weekFirstDay = date.getFirstDayOfWeek();
		// int weekLastDay = weekFirstDay + 7;
		int firstDay = date.get(Calendar.DAY_OF_WEEK);
		if (firstDay < weekFirstDay)
			firstDay = firstDay + 7;
		fillPrevMonthDays(weekFirstDay, firstDay, date.get(Calendar.MONTH));
		for (int i = 1; (i <= days) && (number < 42); i++) {
			buttons.get(number).setIcon(
					new ImageIcon("src/nedelin/gizdov/icons/date/actual/" + i
							+ ".png"));
			number++;
		}
		for (int i = 1; number < 42; i++) {
			buttons.get(number).setIcon(
					new ImageIcon("src/nedelin/gizdov/icons/date/old/" + i
							+ ".png"));
			number++;
		}
	}

	private void fillPrevMonthDays(int weekFirstDay, int firstWeekDayCurMonth,
			int currentMonth) {
		Calendar prevMonth = Calendar.getInstance();
		prevMonth.set(Calendar.MONTH, currentMonth - 1);
		prevMonth.setFirstDayOfWeek(Calendar.MONDAY);
		int prevMonthDays = prevMonth.getActualMaximum(Calendar.DAY_OF_MONTH);
		int stamp = prevMonthDays - firstWeekDayCurMonth + weekFirstDay + 1;
		for (int i = weekFirstDay; (stamp <= prevMonthDays)
				&& (i < firstWeekDayCurMonth) && number < 42; i++, stamp++) {
			buttons.get(number).setIcon(
					new ImageIcon("src/nedelin/gizdov/icons/date/old/" + stamp
							+ ".png"));
			number++;
		}
	}

}
