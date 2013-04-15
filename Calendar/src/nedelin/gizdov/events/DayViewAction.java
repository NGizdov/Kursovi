package nedelin.gizdov.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import nedelin.gizdov.main.DayView;
import nedelin.gizdov.main.Main;

public class DayViewAction implements ActionListener
{
    private int day;
    private int month;
    private int year;

    public DayViewAction(int day, int month, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Main.internal.setContentPane(new DayView(day, month, year));
        Main.internal.setTitle("DAY VIEW");
        Main.frmCalendar.invalidate();
        Main.frmCalendar.validate();
        Main.internal.invalidate();
        Main.internal.validate();
        
    }
}
