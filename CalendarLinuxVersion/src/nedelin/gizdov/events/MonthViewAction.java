package nedelin.gizdov.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import nedelin.gizdov.main.Main;
import nedelin.gizdov.main.MonthView;

public class MonthViewAction implements ActionListener
{
    private Calendar cal;
    public MonthViewAction(Calendar cal)
    {
        this.cal = cal;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Main.internal.setContentPane(new MonthView(cal));
        Main.internal.setTitle("MONTH VIEW");
        Main.frmCalendar.invalidate();
        Main.frmCalendar.validate();
        Main.internal.invalidate();
        Main.internal.validate();
    }
}
