package nedelin.gizdov.main;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import nedelin.gizdov.events.DayListener;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private JInternalFrame mainFrame;
	/**
	 * Create the panel.
	 * @param mainPanel 
	 */
	public DatesPanel(Calendar cal, JInternalFrame mainPanel) {
	    mainFrame = mainPanel;
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
		int firstDay = date.get(Calendar.DAY_OF_WEEK);
		if (firstDay < weekFirstDay)
			firstDay = firstDay + 7;
		fillPrevMonthDays(weekFirstDay, firstDay, date.get(Calendar.MONTH));
		for (int i = 1; (i <= days) && (number < 42); i++) {
			buttons.get(number).setIcon(
					new ImageIcon("src/nedelin/gizdov/icons/date/actual/" + i
							+ ".png"));
			buttons.get(number).addActionListener(new ActionListener()
            {                
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    Main.internal.setContentPane(new DayView(date));  
                    Main.internal.setTitle("DAY VIEW");
                    Main.internal.invalidate();
                    Main.internal.validate();
                }
            });
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
