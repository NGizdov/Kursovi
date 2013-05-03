package nedelin.gizdov.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenu;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;

import nedelin.gizdov.events.DayViewAction;
import nedelin.gizdov.events.MonthViewAction;

public class Main {

	public static JFrame frmCalendar;
	private JPanel monthPanel;
	public static Calendar currentCal;
	public static JInternalFrame internal;
	public static final Calendar todayDate = Calendar.getInstance();
	public static final int todayDay = todayDate.get(Calendar.DATE);
	public static final int todayMonth = todayDate.get(Calendar.MONTH);
	public static final int todayYear = todayDate.get(Calendar.YEAR);
	public static int currentDay;
	public static int currentMonth;
	public static int currentYear;
	public static Map<String, Map<String, String>> tasks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.initialize();
					frmCalendar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initialize() {
		currentDay = todayDay;
		currentMonth = todayMonth;
		currentYear = todayYear;
		frmCalendar = new JFrame();
		frmCalendar.setResizable(true);
		frmCalendar.setTitle("CALENDAR");
		frmCalendar.setBounds(100, 100, 550, 430);
		frmCalendar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loadTasks();

		JMenuBar menuBar = new JMenuBar();

		currentCal = Calendar.getInstance();

		internal = new JInternalFrame("New JInternalFrame");
		internal.setVisible(true);
		GroupLayout groupLayout = new GroupLayout(frmCalendar.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout
				.createParallelGroup(Alignment.LEADING)
				.addComponent(menuBar, GroupLayout.DEFAULT_SIZE, 645,
						Short.MAX_VALUE)
				.addComponent(internal, GroupLayout.DEFAULT_SIZE, 645,
						Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addComponent(menuBar, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(internal, GroupLayout.DEFAULT_SIZE, 553,
								Short.MAX_VALUE)));

		monthPanel = new MonthView(todayDate);
		internal.getContentPane().add(monthPanel, BorderLayout.CENTER);
		internal.setTitle("MONTH VIEW");

		JMenu mnMain = new JMenu("Main");
		menuBar.add(mnMain);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);

		JMenuItem mntmMonthView = new JMenuItem("Month View");
		mntmMonthView.addActionListener(new MonthViewAction(currentCal));
		mnView.add(mntmMonthView);

		JMenuItem mntmDayView = new JMenuItem("Day View");
		mntmDayView.addActionListener(new DayViewAction());
		mnView.add(mntmDayView);
		frmCalendar.getContentPane().setLayout(groupLayout);
	}

	private void loadTasks() {
		tasks = new HashMap<String, Map<String, String>>();
		BufferedReader fr = null;
		try {
			fr = new BufferedReader(new FileReader("tasks"));
//			fr = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("tasks")));
			String line = null;
			while ((line = fr.readLine()) != null) {
				Map<String, String> taskByHours = null;
				String[] fullLine = line.split("\t");
				if (tasks.containsKey(fullLine[0])) {
					taskByHours = tasks.get(fullLine[0]);
				} else {
					taskByHours = new HashMap<String, String>();
				}
				String task = null;
				if (taskByHours.containsKey(fullLine[1])) {
					task = taskByHours.get(fullLine[1]);
				} else {
					task = fullLine[2];
				}
				taskByHours.put(fullLine[1], task);
				tasks.put(fullLine[0], taskByHours);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
