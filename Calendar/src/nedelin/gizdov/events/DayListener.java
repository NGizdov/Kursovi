package nedelin.gizdov.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import nedelin.gizdov.main.DayView;

public class DayListener implements ActionListener {

	private JPanel mainPanlel;
	public DayListener(JPanel panel)
	{
		mainPanlel = panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
//		mainPanlel = new DayView();
	}

}
