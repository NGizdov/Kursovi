package nedelin.gizdov.main;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nedelin.gizdov.utils.Utils;

import java.awt.GridLayout;
import java.util.Calendar;

public class MonthView
{
    public static void fillMainPanel(JPanel mainPanel, Calendar cal)
    {
        JPanel weekDaysPanel = new JPanel();
        weekDaysPanel.setLayout(new GridLayout(1, 7, 3, 3));

        JLabel label = new JLabel("MONDAY");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        weekDaysPanel.add(label);

        JLabel label_1 = new JLabel("TUESDAY");
        label_1.setHorizontalAlignment(SwingConstants.CENTER);
        weekDaysPanel.add(label_1);

        JLabel label_2 = new JLabel("WEDNESDAY");
        label_2.setHorizontalAlignment(SwingConstants.CENTER);
        weekDaysPanel.add(label_2);

        JLabel label_3 = new JLabel("THURSDAY");
        label_3.setHorizontalAlignment(SwingConstants.CENTER);
        weekDaysPanel.add(label_3);

        JLabel label_4 = new JLabel("FRIDAY");
        label_4.setHorizontalAlignment(SwingConstants.CENTER);
        weekDaysPanel.add(label_4);

        JLabel label_5 = new JLabel("SATURDAY");
        label_5.setHorizontalAlignment(SwingConstants.CENTER);
        weekDaysPanel.add(label_5);

        JLabel label_6 = new JLabel("SUNDAY");
        label_6.setHorizontalAlignment(SwingConstants.CENTER);
        weekDaysPanel.add(label_6);

        JPanel monthDaysPanel = new JPanel();
        monthDaysPanel.setLayout(new GridLayout(0, 7, 3, 3));
        GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
        gl_mainPanel.setHorizontalGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
                .addComponent(monthDaysPanel, GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                .addComponent(weekDaysPanel, GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE));
        gl_mainPanel.setVerticalGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING).addGroup(
                gl_mainPanel.createSequentialGroup()
                        .addComponent(weekDaysPanel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(monthDaysPanel, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)));
        mainPanel.setLayout(gl_mainPanel);
        Utils.drawMonth(monthDaysPanel, cal);
    }

}
