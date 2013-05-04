package nedelin.gizdov.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.Map;

import javax.swing.JOptionPane;

import nedelin.gizdov.main.Main;

public class ExitListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int option = JOptionPane.showConfirmDialog(null,
				"Saving tasks and closing");
		if (option == JOptionPane.OK_OPTION) {
			Writer writer = null;
			try {
				String inputFile = getClass().getClassLoader().getResource("tasks")
						.toURI().getPath();
				writer = new FileWriter(inputFile, true);
				for (Map.Entry<String, Map<String, String>> entry : Main.tasks
						.entrySet()) {
					for (Map.Entry<String, String> task : entry.getValue()
							.entrySet()) {
						writer.append(entry.getKey() + "\t" + task.getKey()
								+ "\t" + task.getValue() + "\n");
					}
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			} catch (URISyntaxException ex) {
				ex.printStackTrace();
			} finally {
				if (writer != null) {
					try {
						writer.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
				System.exit(0);
			}
		} else if (option == JOptionPane.NO_OPTION) {
			System.exit(0);
		}
	}
}
