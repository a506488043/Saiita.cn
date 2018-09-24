package Test;

import java.util.*;

import Saiita.cn.entity.calendar;
import Saiita.cn.service.GetInfo.getCalendarInfo;

public class Test {
	public static void main(String[] args) throws Exception {
		List<calendar> list = getCalendarInfo.getCalendar();
		for (int i = 0; i < list.size(); i++) {
			calendar calendar = (calendar) list.get(i);
			System.out.println(calendar.getDraggableEvents());
		}
	}
}
