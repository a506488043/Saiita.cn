package Saiita.cn.entity;

public class calendar {
	// �ƻ�ID
	int id;
	// ���ϼƻ�
	String DraggableEvents;
	// �ƻ�����
	String title;
	// �ƻ���ʼʱ��
	String start;
	// �ƻ�����ʱ��
	String end;
	// ������ɫ
	String backgroundColor;
	// ������ɫ
	String borderColor;
	// ȫ���¼�
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
