package nedelin.gizdov.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import nedelin.gizdov.main.DayView;
import nedelin.gizdov.main.Main;

public class DayViewAction implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		Main.internal.setContentPane(new DayView(Main.currentDay,
				Main.currentMonth, Main.currentYear));
		Main.internal.setTitle("DAY VIEW");
		Main.frmCalendar.invalidate();
		Main.frmCalendar.validate();
		Main.internal.invalidate();
		Main.internal.validate();
	}
}
