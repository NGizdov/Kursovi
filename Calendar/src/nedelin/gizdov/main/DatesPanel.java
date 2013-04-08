package nedelin.gizdov.main;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Calendar;

public class DatesPanel extends JPanel
{
    private Calendar date;
    private int month;
    private String[] months = { "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER",
            "NOVEMBER", "DECEMBER" };
    private ArrayList<JButton> buttons;
    public static int number;

    /**
     * Create the panel.
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

    public void reDrawDates(Calendar cal)
    {
        number = 0;
        drawDates(cal);
    }
    
    private void drawDates(Calendar cal)
    {
        Calendar newCal = cal;
//        date = cal;
        newCal.set(Calendar.DAY_OF_MONTH, 1);
        newCal.setFirstDayOfWeek(Calendar.MONDAY);
        int days = newCal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int weekFirstDay = newCal.getFirstDayOfWeek();
        int weekLastDay = weekFirstDay + 7;
        int firstDay = newCal.get(Calendar.DAY_OF_WEEK);
        if (firstDay < weekFirstDay){
            firstDay = firstDay + 7;
        }
        
        int count = 0;
        int i, j = 1;
        int week = 0;
        fillPrevMonthDays(weekFirstDay, firstDay, newCal.get(Calendar.MONTH));
        for (i = firstDay; i < weekLastDay && number < 42; i++, j++)
        {
            buttons.get(number).setIcon(new ImageIcon("src/nedelin/gizdov/icons/date/actual/" + j + ".png"));
            number++;
            count++;
        }
        week++;
        int remainingDays = days - count;
        int weeks = remainingDays / 7;
        week += weeks;
        int lastWeekDays = remainingDays % 7;
        if (lastWeekDays != 0)
        {
            for (int k = 1; k <= weeks && number < 42; k++)
            {
                for (i = 1; i <= 7 && number < 42; i++, j++)
                {
                    buttons.get(number).setIcon(new ImageIcon("src/nedelin/gizdov/icons/date/actual/" + j + ".png"));
//                    add(button);
                    number++;
                }
                
            }
            for (i = 1; i <= lastWeekDays && number < 42; i++, j++)
            {
                buttons.get(number).setIcon(new ImageIcon("src/nedelin/gizdov/icons/date/actual/" + j + ".png"));
//                add(button);
                number++;
            }
            for (i = 1, j = 1; i <= 7 - lastWeekDays && number < 42; i++, j++)
            {
                buttons.get(number).setIcon(new ImageIcon("src/nedelin/gizdov/icons/date/old/" + j + ".png"));
//                add(button);
                number++;
            }
            week++;
            if (week < 6)
            {
                for (int k = week; k < 6 && number < 42; k++)
                {
                    for (i = 1; i <= 7; i++, j++)
                    {
                        buttons.get(number).setIcon(new ImageIcon("src/nedelin/gizdov/icons/date/old/" + j + ".png"));
//                        add(button);
                        number++;
                    }
                    
                }
            }
        }
        else
        {
            for (int k = 1; k <= weeks && number < 42; k++)
            {
                for (i = 1; i <= 7; i++, j++)
                {
                    buttons.get(number).setIcon(new ImageIcon("src/nedelin/gizdov/icons/date/actual/" + j + ".png"));
//                    add(button);
                    number++;
                }
            }
            if (week < 6)
            {
                j = 1;
                for (int k = week; k < 6 && number < 42; k++)
                {
                    for (i = 1; i <= 7 && number < 42; i++, j++)
                    {
                        buttons.get(number).setIcon(new ImageIcon("src/nedelin/gizdov/icons/date/old/" + j + ".png"));
//                        add(button);
                        number++;
                    }
                    
                }
            }
        }
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
//            add(buttons.get(number));
            number++;
        }
    }

}
