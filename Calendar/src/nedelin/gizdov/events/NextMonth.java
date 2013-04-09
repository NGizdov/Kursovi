package nedelin.gizdov.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JLabel;

import nedelin.gizdov.main.DatesPanel;

public class NextMonth implements ActionListener
{
    private Calendar date;
    private String[] months = { "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER",
            "NOVEMBER", "DECEMBER" };
    private DatesPanel datesPanel;
    private JLabel monthLabel;

    public NextMonth(Calendar cal, DatesPanel panel, JLabel label)
    {
        this.date = cal;
        this.datesPanel = panel;
        this.monthLabel = label;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        int month = date.get(Calendar.MONTH);
        if (month == (months.length - 1))
        {
            month = 0;
            int year = date.get(Calendar.YEAR);
            date.set(++year, month, 1);
            datesPanel.redrawDates(date);
            monthLabel.setText(months[month] + " - " + date.get(Calendar.YEAR));
        }
        else
        {
            date.set(Calendar.MONTH, ++month);
            datesPanel.redrawDates(date);
            monthLabel.setText(months[month] + " - " + date.get(Calendar.YEAR));
        }
    }

}
