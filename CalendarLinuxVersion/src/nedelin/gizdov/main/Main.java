package nedelin.gizdov.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

import nedelin.gizdov.events.DayViewAction;
import nedelin.gizdov.events.ExitListener;
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

	private TrayIcon trayIcon;

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
		Image icon = new ImageIcon(getClass().getClassLoader().getResource(
				"date/current/" + currentDay + ".png")).getImage();
		frmCalendar.setIconImage(icon);
		frmCalendar.setResizable(true);
		frmCalendar.setTitle("CALENDAR");
		frmCalendar.setBounds(100, 100, 510, 435);
		// frmCalendar.setExtendedState(JFrame.ICONIFIED);
		frmCalendar.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		loadTasks();

		setSistemTray();

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

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ExitListener());
		mnMain.add(mntmExit);

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

	private void setSistemTray() {
		if (SystemTray.isSupported()) {
			// SystemTray tray = SystemTray.getSystemTray();
			Image icon = new ImageIcon(
					getClass().getClassLoader().getResource(
							"date/current/" + currentDay + ".png"))
					.getImage();
			trayIcon = new TrayIcon(icon, "Calendar");
			trayIcon.setImageAutoSize(true);
			frmCalendar.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent windowEvent) {
					frmCalendar.setExtendedState(JFrame.ICONIFIED);
				}
			});
		}
	}

	private void loadTasks() {
		tasks = new HashMap<String, Map<String, String>>();
		BufferedReader fr = null;
		try {
			fr = new BufferedReader(new FileReader("tasks"));
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
