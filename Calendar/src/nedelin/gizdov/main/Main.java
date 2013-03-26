package nedelin.gizdov.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenu;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.util.Calendar;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main
{

    private JFrame frmCalendar;
    private JPanel mainPanel;
    private Calendar cal;
    private int month;
    private String[] months = { "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER",
            "NOVEMBER", "DECEMBER" };
    private JLabel lblNewLabel;

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    Main window = new Main();
                    window.frmCalendar.setVisible(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Main()
    {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
        frmCalendar = new JFrame();
        frmCalendar.setResizable(false);
        frmCalendar.setTitle("CALENDAR");
        frmCalendar.setBounds(100, 100, 650, 550);
        frmCalendar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JPanel bottomPanel = new JPanel();

        mainPanel = new JPanel();
        GroupLayout groupLayout = new GroupLayout(frmCalendar.getContentPane());
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(menuBar, GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                .addComponent(bottomPanel, GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
                groupLayout.createSequentialGroup()
                        .addComponent(menuBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(bottomPanel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)));

        cal = Calendar.getInstance();
        month = cal.get(Calendar.MONTH);
        MonthView.fillMainPanel(mainPanel, cal);

        bottomPanel.setLayout(new BorderLayout(0, 0));

        lblNewLabel = new JLabel(months[month] + " - " + cal.get(Calendar.YEAR));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bottomPanel.add(lblNewLabel, BorderLayout.CENTER);

        JButton previous = new JButton("PREVIOUS");
        previous.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                mainPanel.removeAll();
                if (month == 0)
                {
                    month = (months.length - 1);
                    int year = cal.get(Calendar.YEAR);
                    cal.set(--year, month, 1);
                    MonthView.fillMainPanel(mainPanel, cal);
                    lblNewLabel.setText(months[month] + " - " + cal.get(Calendar.YEAR));
                }
                else
                {
                    cal.set(Calendar.MONTH, --month);
                    MonthView.fillMainPanel(mainPanel, cal);
                    lblNewLabel.setText(months[month] + " - " + cal.get(Calendar.YEAR));
                }
            }
        });
        bottomPanel.add(previous, BorderLayout.WEST);

        JButton next = new JButton("NEXT");
        next.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                mainPanel.removeAll();
                if (month == (months.length - 1))
                {
                    month = 0;
                    int year = cal.get(Calendar.YEAR);
                    cal.set(++year, month, 1);
                    MonthView.fillMainPanel(mainPanel, cal);
                    lblNewLabel.setText(months[month] + " - " + cal.get(Calendar.YEAR));
                }
                else
                {
                    cal.set(Calendar.MONTH, ++month);
                    MonthView.fillMainPanel(mainPanel, cal);
                    lblNewLabel.setText(months[month] + " - " + cal.get(Calendar.YEAR));
                }
            }
        });
        bottomPanel.add(next, BorderLayout.EAST);

        JMenu mnMain = new JMenu("Main");
        menuBar.add(mnMain);

        JMenu mnEdit = new JMenu("Edit");
        menuBar.add(mnEdit);

        JMenu mnView = new JMenu("View");
        menuBar.add(mnView);
        frmCalendar.getContentPane().setLayout(groupLayout);
    }
}
