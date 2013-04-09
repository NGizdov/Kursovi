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
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main
{

    private JFrame frmCalendar;
	private Calendar cal;
	public static JInternalFrame internal;
	private JPanel month;
	private static String MONTH_VIEW = "MONTH VIEW";
	private static String DAY_VIEW = "DAY VIEW";

	// private int month;
	// private String[] months = { "JANUARY", "FEBRUARY", "MARCH", "APRIL",
	// "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER",
	// "NOVEMBER", "DECEMBER" };

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
        frmCalendar.setResizable(true);
        frmCalendar.setTitle("CALENDAR");
        frmCalendar.setBounds(100, 100, 666, 676);
        frmCalendar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        cal = Calendar.getInstance();
        
        internal = new JInternalFrame("New JInternalFrame");
        internal.setVisible(true);
        GroupLayout groupLayout = new GroupLayout(frmCalendar.getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(menuBar, GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                .addComponent(internal, GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addComponent(menuBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(internal, GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE))
        );
        
        month = new Month(cal, internal);
        internal.getContentPane().add(month, BorderLayout.CENTER);
        internal.setTitle(MONTH_VIEW);

        JMenu mnMain = new JMenu("Main");
        menuBar.add(mnMain);

        JMenu mnEdit = new JMenu("Edit");
        menuBar.add(mnEdit);

        JMenu mnView = new JMenu("View");
        menuBar.add(mnView);
        
        JMenuItem mntmMonthView = new JMenuItem("Month View");
        mntmMonthView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                internal.setContentPane(new Month(cal, internal));
                internal.setTitle(MONTH_VIEW);
                internal.invalidate();
                internal.validate();
            }
        });
        mnView.add(mntmMonthView);
        
        JMenuItem mntmDayView = new JMenuItem("Day View");
        mntmDayView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                internal.setContentPane(new DayView(cal));
                internal.setTitle(DAY_VIEW);
                internal.invalidate();
                internal.validate();
            }
        });
        mnView.add(mntmDayView);
        frmCalendar.getContentPane().setLayout(groupLayout);
    }
}
