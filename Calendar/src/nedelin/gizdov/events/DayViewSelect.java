package nedelin.gizdov.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import nedelin.gizdov.main.DayView;
import nedelin.gizdov.main.Main;

public class DayViewSelect implements ActionListener
{
    private int day;
    private int month;
    private int year;
    private Calendar date;
    public static final String NEXT = "Next";
    public static final String PREVIOUS = "Previous";
    
    public DayViewSelect(Calendar cal, String event)
    {
        this.date = cal;
        if (NEXT.equals(event))
        {
            date.add(Calendar.DATE, 1);
        }
        else if (PREVIOUS.equals(event))
        {
            date.add(Calendar.DATE, -1);
        }
        this.day = date.get(Calendar.DATE);
        this.month = date.get(Calendar.MONTH);
        this.year = date.get(Calendar.YEAR);
    }
    
    public DayViewSelect(int day, int month, int year)
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
        Main.internal.invalidate();
        Main.internal.validate();        
    }

}
