package nedelin.gizdov.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import nedelin.gizdov.main.Main;
import nedelin.gizdov.main.MonthView;

public class NextMonth implements ActionListener
{
    private Calendar date;
    private String[] months = { "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER",
            "NOVEMBER", "DECEMBER" };

    public NextMonth(Calendar cal)
    {
        this.date = cal;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        int month = date.get(Calendar.MONTH);
        if (month == (months.length - 1))
        {
            month = 0;
            int year = date.get(Calendar.YEAR);
            year++;
            Main.currentYear = year;
            Main.currentDay = date.get(Calendar.DATE);
            Main.currentMonth = month;
            date.set(year, month, 1);
            Main.currentCal = date;
            Main.internal.setContentPane(new MonthView(date));
            Main.internal.setTitle("MONTH VIEW");
            Main.frmCalendar.invalidate();
            Main.frmCalendar.validate();
            Main.internal.invalidate();
            Main.internal.validate();
        }
        else
        {
        	month++;
        	Main.currentYear = date.get(Calendar.YEAR);
            Main.currentDay = 1;
            Main.currentMonth = month;
            date.set(Calendar.MONTH, month);
            Main.currentCal.set(Main.currentYear, month, Main.currentDay);
            Main.internal.setContentPane(new MonthView(date));
            Main.internal.setTitle("MONTH VIEW");
            Main.frmCalendar.invalidate();
            Main.frmCalendar.validate();
            Main.internal.invalidate();
            Main.internal.validate();
        }
    }

}
