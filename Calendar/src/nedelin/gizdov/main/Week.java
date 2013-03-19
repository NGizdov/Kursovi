package nedelin.gizdov.main;

import java.util.ArrayList;
import java.util.List;

enum WeekDays{MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY};
public class Week {
	private final int number;
	List<Day> days = null;
	public Week(int number) {
		this.number = number;
		days = new ArrayList<Day>();
	}
}
