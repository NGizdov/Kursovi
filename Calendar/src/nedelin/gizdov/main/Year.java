package nedelin.gizdov.main;

import java.util.ArrayList;
import java.util.List;

public class Year {
	List<Month> months = null;
	List<Day> days = null;
	public Year(){
		months = new ArrayList<Month>();
		days = new ArrayList<Day>();
	}
}
