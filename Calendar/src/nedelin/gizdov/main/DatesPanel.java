package nedelin.gizdov.main;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import nedelin.gizdov.events.DayViewSelect;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Calendar;

public class DatesPanel extends JPanel
{
    /**
     * 
     */
    private static final long serialVersionUID = 5920242753952594968L;
    private Calendar date;
    private int month;
    private int year;
    // private String[] months = { "JANUARY", "FEBRUARY", "MARCH", "APRIL",
    // "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER",
    // "NOVEMBER", "DECEMBER" };
    private ArrayList<JButton> buttons;
    public static int number;

    /**
     * Create the panel.
     * 
     * @param mainPanel
     */
    public DatesPanel(Calendar cal)
    {
        number = 0;
        setLayout(new GridLayout(6, 7, 3, 3));
        buttons = new ArrayList<JButton>(42);
        for (int i = 0; i < 42; i++)
        {
            buttons.add(new JButton());
        }
        for (JButton button : buttons)
        {
            add(button);
        }
        drawDates(cal);
    }

    public void redrawDates(Calendar cal)
    {
        number = 0;
        drawDates(cal);
    }

    private void drawDates(Calendar cal)
    {
        date = cal;
        month = date.get(Calendar.MONTH);
        year = date.get(Calendar.YEAR);
        date.set(Calendar.DAY_OF_MONTH, 1);
        date.setFirstDayOfWeek(Calendar.MONDAY);
        int days = date.getActualMaximum(Calendar.DAY_OF_MONTH);
        int weekFirstDay = date.getFirstDayOfWeek();
        int firstDay = date.get(Calendar.DAY_OF_WEEK);
        if (firstDay < weekFirstDay)
            firstDay = firstDay + 7;
        fillPrevMonthDays(weekFirstDay, firstDay, date.get(Calendar.MONTH));
        if (isCurrentMonth(cal))
        {
            for (int i = 1; (i <= days) && (number < 42); i++)
            {
                if (isToday(i))
                {
                    buttons.get(number).setIcon(new ImageIcon("src/nedelin/gizdov/icons/date/current/" + i + ".png"));
                    buttons.get(number).addActionListener(new DayViewSelect(i, month, year));
                    number++;
                }
                else
                {
                    buttons.get(number).setIcon(new ImageIcon("src/nedelin/gizdov/icons/date/actual/" + i + ".png"));
                    buttons.get(number).addActionListener(new DayViewSelect(i, month, year));
                    number++;
                }
            }
        }
        else
        {
            for (int i = 1; (i <= days) && (number < 42); i++)
            {
                buttons.get(number).setIcon(new ImageIcon("src/nedelin/gizdov/icons/date/actual/" + i + ".png"));
                buttons.get(number).addActionListener(new DayViewSelect(i, month, year));
                number++;
            }
        }
        for (int i = 1; number < 42; i++)
        {
            buttons.get(number).setIcon(new ImageIcon("src/nedelin/gizdov/icons/date/old/" + i + ".png"));
            buttons.get(number).setSelected(false);
            number++;
        }
    }

    private boolean isToday(int day)
    {
        if (Main.currentDay == day)
            return true;
        return false;
    }

    private boolean isCurrentMonth(Calendar date)
    {
        if ((Main.currentMonth == date.get(Calendar.MONTH)) && (Main.currentYear == date.get(Calendar.YEAR)))
            return true;
        return false;
    }

    private void fillPrevMonthDays(int weekFirstDay, int firstWeekDayCurMonth, int currentMonth)
    {
        Calendar prevMonth = Calendar.getInstance();
        prevMonth.set(Calendar.MONTH, currentMonth - 1);
        prevMonth.setFirstDayOfWeek(Calendar.MONDAY);
        int prevMonthDays = prevMonth.getActualMaximum(Calendar.DAY_OF_MONTH);
        int stamp = prevMonthDays - firstWeekDayCurMonth + weekFirstDay + 1;
        for (int i = weekFirstDay; (stamp <= prevMonthDays) && (i < firstWeekDayCurMonth) && number < 42; i++, stamp++)
        {
            buttons.get(number).setIcon(new ImageIcon("src/nedelin/gizdov/icons/date/old/" + stamp + ".png"));
            buttons.get(number).setSelected(false);
            number++;
        }
    }
}
