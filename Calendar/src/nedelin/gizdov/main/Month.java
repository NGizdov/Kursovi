package nedelin.gizdov.main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class Month extends JPanel
{
    private Calendar cal;
    private int month;
    private String[] months = { "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER",
            "NOVEMBER", "DECEMBER" };
    private JLabel monthLabel;
    private JPanel datesPanel;
    /**
     * Create the panel.
     */
    public Month(Calendar date, JPanel main)
    {
        cal = date;
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

        datesPanel = new DatesPanel(date);
        datesPanel.setLayout(new GridLayout(6, 7, 3, 3));
        
        JPanel panel = new JPanel();
        GroupLayout gl_mainPanel = new GroupLayout(this);
        gl_mainPanel.setHorizontalGroup(
            gl_mainPanel.createParallelGroup(Alignment.LEADING)
                .addComponent(weekDaysPanel, GroupLayout.PREFERRED_SIZE, 500, Short.MAX_VALUE)
                .addComponent(datesPanel, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addComponent(panel, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        gl_mainPanel.setVerticalGroup(
            gl_mainPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_mainPanel.createSequentialGroup()
                    .addComponent(weekDaysPanel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(datesPanel, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(panel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        );        
        monthLabel = new JLabel("MONTH");
        
        JButton previousButton = new JButton("PREVIOUS");
        previousButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                removeAll();
                if (month == 0)
                {
                    month = (months.length - 1);
                    int year = cal.get(Calendar.YEAR);
                    cal.set(--year, month, 1);
                    MonthView.fillMainPanel(datesPanel, cal);
                    monthLabel.setText(months[month] + " - " + cal.get(Calendar.YEAR));
                }
                else
                {
                    cal.set(Calendar.MONTH, --month);
                    MonthView.fillMainPanel(datesPanel, cal);
                    monthLabel.setText(months[month] + " - " + cal.get(Calendar.YEAR));
                }
            }
        });
        
        JButton nextButton = new JButton("NEXT");
        nextButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                removeAll();
                if (month == (months.length - 1))
                {
                    month = 0;
                    int year = cal.get(Calendar.YEAR);
                    cal.set(++year, month, 1);
                    MonthView.fillMainPanel(datesPanel, cal);
                    monthLabel.setText(months[month] + " - " + cal.get(Calendar.YEAR));
                }
                else
                {
                    cal.set(Calendar.MONTH, ++month);
                    MonthView.fillMainPanel(datesPanel, cal);
                    monthLabel.setText(months[month] + " - " + cal.get(Calendar.YEAR));
                }
            }
        });
        
        
        monthLabel.setHorizontalAlignment(SwingConstants.CENTER);
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
            gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
                    .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(monthLabel, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(nextButton, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
        );
        gl_panel.setVerticalGroup(
            gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
                    .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(previousButton, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                        .addComponent(nextButton, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(3)
                            .addComponent(monthLabel, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)))
                    .addGap(0))
        );
        panel.setLayout(gl_panel);
        setLayout(gl_mainPanel);

    }
}
