package nedelin.gizdov.utils;

import java.util.Calendar;
import javax.swing.*;

public class Utils
{
    public static void drawMonth(JPanel panel, Calendar cal)
    {
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int weekFirstDay = cal.getFirstDayOfWeek();
        int weekLastDay = weekFirstDay + 7;
        int firstDay = cal.get(Calendar.DAY_OF_WEEK);
        if (firstDay < weekFirstDay){
            firstDay = firstDay + 7;
        }
        
        int count = 0;
        int i, j = 1;
        int week = 0;
        fillPrevMonthDays(panel, weekFirstDay, firstDay, cal.get(Calendar.MONTH));
        for (i = firstDay; i < weekLastDay; i++, j++)
        {
            JButton button = new JButton(new ImageIcon("src/nedelin/gizdov/icons/date/actual/" + j + ".png"));
            panel.add(button);
            count++;
        }
        week++;
        int remainingDays = days - count;
        int weeks = remainingDays / 7;
        week += weeks;
        int lastWeekDays = remainingDays % 7;
        if (lastWeekDays != 0)
        {
            for (int k = 1; k <= weeks; k++)
            {
                for (i = 1; i <= 7; i++, j++)
                {
                    JButton button = new JButton(new ImageIcon("src/nedelin/gizdov/icons/date/actual/" + j + ".png"));
                    panel.add(button);
                }
                
            }
            for (i = 1; i <= lastWeekDays; i++, j++)
            {
                JButton button = new JButton(new ImageIcon("src/nedelin/gizdov/icons/date/actual/" + j + ".png"));
                panel.add(button);
            }
            for (i = 1, j = 1; i <= 7 - lastWeekDays; i++, j++)
            {
                JButton button = new JButton(new ImageIcon("src/nedelin/gizdov/icons/date/old/" + j + ".png"));
                panel.add(button);
            }
            week++;
            if (week < 6)
            {
                for (int k = week; k < 6; k++)
                {
                    for (i = 1; i <= 7; i++, j++)
                    {
                        JButton button = new JButton(new ImageIcon("src/nedelin/gizdov/icons/date/old/" + j + ".png"));
                        panel.add(button);
                    }
                    
                }
            }
        }
        else
        {
            for (int k = 1; k <= weeks; k++)
            {
                for (i = 1; i <= 7; i++, j++)
                {
                    JButton button = new JButton(new ImageIcon("src/nedelin/gizdov/icons/date/actual/" + j + ".png"));
                    panel.add(button);
                }
            }
            if (week < 6)
            {
                j = 1;
                for (int k = week; k < 6; k++)
                {
                    for (i = 1; i <= 7; i++, j++)
                    {
                        JButton button = new JButton(new ImageIcon("src/nedelin/gizdov/icons/date/old/" + j + ".png"));
                        panel.add(button);
                    }
                    
                }
            }
        }
    }

    private static void fillPrevMonthDays(JPanel panel, int weekFirstDay, int firstWeekDayCurMonth, int currentMonth)
    {
        Calendar prevMonth = Calendar.getInstance();
        prevMonth.set(Calendar.MONTH, currentMonth - 1);
        prevMonth.setFirstDayOfWeek(Calendar.MONDAY);
        int prevMonthDays = prevMonth.getActualMaximum(Calendar.DAY_OF_MONTH);
        int stamp = prevMonthDays - firstWeekDayCurMonth + weekFirstDay + 1;
        for (int i = weekFirstDay; (stamp <= prevMonthDays) && (i < firstWeekDayCurMonth); i++, stamp++)
        {
            JButton button = new JButton(new ImageIcon("src/nedelin/gizdov/icons/date/old/" + stamp + ".png"));
            panel.add(button);
        }
    }
}
