package nedelin.gizdov.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import nedelin.gizdov.main.DayView;
import nedelin.gizdov.main.Main;

public class NextDay implements ActionListener {
	private int day;
	private int month;
	private int year;
	private Calendar date;
	private String[] months = { "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER",
            "NOVEMBER", "DECEMBER" };

	public NextDay(Calendar date) {
		this.day = date.get(Calendar.DATE);
		this.month = date.get(Calendar.MONTH);
		this.year = date.get(Calendar.YEAR);
		this.date = date;
	}

	@Override
    public void actionPerformed(ActionEvent e)
    {
		int maxDays = date.getActualMaximum(Calendar.DAY_OF_MONTH);
    	if (day == maxDays)
    	{
    		day = 1;
    		if (month == (months.length - 1))
    		{
    			month = 0;
    			Main.internal.setContentPane(new DayView(day, month, year));
    	        Main.internal.setTitle("DAY VIEW");
    	        Main.internal.invalidate();
    	        Main.internal.validate();
    		}
    		else
    		{
    			Main.internal.setContentPane(new DayView(day, month, year));
    	        Main.internal.setTitle("DAY VIEW");
    	        Main.internal.invalidate();
    	        Main.internal.validate();
    		}
    	}
    	else
    	{
    		day = day + 1;
    		if (month == (months.length - 1))
    		{
    			month = 0;
    			Main.internal.setContentPane(new DayView(day, month, year));
    	        Main.internal.setTitle("DAY VIEW");
    	        Main.internal.invalidate();
    	        Main.internal.validate();
    		}
    		else
    		{
    			Main.internal.setContentPane(new DayView(day, month, year));
    	        Main.internal.setTitle("DAY VIEW");
    	        Main.internal.invalidate();
    	        Main.internal.validate();
    		}
    	}
//        Main.internal.setContentPane(new DayView(day, month, year));
//        Main.internal.setTitle("DAY VIEW");
//        Main.internal.invalidate();
//        Main.internal.validate();
    }
}
