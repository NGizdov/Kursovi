package nedelin.gizdov.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTable;

import nedelin.gizdov.main.Main;

public class TaskSaveAction implements ActionListener {

	private JTable table;

	public TaskSaveAction(JTable table) {
		this.table = table;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Writer writer = null;
		try {
			writer = new FileWriter("tasks", true);
			String date = Main.currentDay + "/" + Main.currentMonth + "/"
					+ Main.currentYear;
			Map<String, String> tasksByHours = new HashMap<String, String>();
			for (int i = 0; i < 24; i++) {
				String task = (String) table.getValueAt(i, 1);
				if (!task.isEmpty()) {
					String hour = (String) table.getValueAt(i, 0);
					writer.append(date + "\t" + hour + "\t" + task + "\n");
					tasksByHours.put(hour, task);
				}
			}
			Main.tasks.put(date, tasksByHours);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
