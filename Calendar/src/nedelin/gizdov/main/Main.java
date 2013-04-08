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
        frmCalendar.setBounds(100, 100, 665, 630);
        frmCalendar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        cal = Calendar.getInstance();
        mainPanel = new Month(cal, mainPanel);
        GroupLayout groupLayout = new GroupLayout(frmCalendar.getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(menuBar, GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addComponent(menuBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                    .addContainerGap())
        );

        JMenu mnMain = new JMenu("Main");
        menuBar.add(mnMain);

        JMenu mnEdit = new JMenu("Edit");
        menuBar.add(mnEdit);

        JMenu mnView = new JMenu("View");
        menuBar.add(mnView);
        frmCalendar.getContentPane().setLayout(groupLayout);
    }
}
