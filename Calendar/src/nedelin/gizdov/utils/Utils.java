package nedelin.gizdov.utils;

import java.awt.Color;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;

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
        fillPrevMonthDays(panel, weekFirstDay, firstDay, cal.get(Calendar.MONTH));
        for (i = firstDay; i < weekLastDay; i++, j++)
        {
//            JButton button = new JButton(String.valueOf(j));
            JButton button = new JButton(new ImageIcon("src/nedelin/gizdov/icons/date/actual/" + j + ".png"));
//            button.setOpaque(true);
//            button.setBackground(Color.GREEN);
//            button.setContentAreaFilled(true);
            panel.add(button);
            count++;
        }
        int remainingDays = days - count;
        int weeks = remainingDays / 7;
        int lastWeekDays = remainingDays % 7;
        if (lastWeekDays != 0)
        {
            for (int k = 1; k <= weeks; k++)
            {
                for (i = 1; i <= 7; i++, j++)
                {
//                    JButton button = new JButton(String.valueOf(j));
                    JButton button = new JButton(new ImageIcon("src/nedelin/gizdov/icons/date/actual/" + j + ".png"));
//                    button.setOpaque(true);
//                    button.setBackground(Color.GREEN);
                    panel.add(button);
                }
            }
            for (i = 1; i <= lastWeekDays; i++, j++)
            {
//                JButton button = new JButton(String.valueOf(j));
                JButton button = new JButton(new ImageIcon("src/nedelin/gizdov/icons/date/actual/" + j + ".png"));
//                button.setOpaque(true);
//                button.setBackground(Color.GREEN);
                panel.add(button);
            }
            for (i = 1; i <= 7 - lastWeekDays; i++)
            {
//                JButton button = new JButton(String.valueOf(i));
                JButton button = new JButton(new ImageIcon("src/nedelin/gizdov/icons/date/old/" + i + ".png"));
//                button.setOpaque(true);
//                button.setBackground(Color.LIGHT_GRAY);
//                button.setUI(ButtonUI.createUI(c));
                panel.add(button);
            }
        }
        else
        {
            for (int k = 1; k <= weeks; k++)
            {
                for (i = 1; i <= 7; i++, j++)
                {
//                    JButton button = new JButton(String.valueOf(j));
                    JButton button = new JButton(new ImageIcon("src/nedelin/gizdov/icons/date/actual/" + j + ".png"));

//                    button.setOpaque(true);
//                    button.setBackground(Color.GREEN);
                    panel.add(button);
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
//            JButton button = new JButton(String.valueOf(stamp));
            JButton button = new JButton(new ImageIcon("src/nedelin/gizdov/icons/date/old/" + stamp + ".png"));
//            button.setText(String.valueOf(stamp));
//            button.setOpaque(true);
//            button.setBackground(Color.LIGHT_GRAY);
            panel.add(button);
        }
    }
}
