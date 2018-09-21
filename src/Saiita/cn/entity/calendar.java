package Saiita.cn.entity;

public class calendar {
	// 计划ID
	int id;
	// 可拖计划
	String DraggableEvents;
	// 计划标题
	String title;
	// 计划开始时间
	String start;
	// 计划结束时间
	String end;
	// 背景颜色
	String backgroundColor;
	// 背景颜色
	String borderColor;
	// 全天事件
	String allDay;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDraggableEvents() {
		return DraggableEvents;
	}

	public void setDraggableEvents(String draggableEvents) {
		DraggableEvents = draggableEvents;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public String getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}

	public String getAllDay() {
		return allDay;
	}

	public void setAllDay(String allDay) {
		this.allDay = allDay;
	}

}
