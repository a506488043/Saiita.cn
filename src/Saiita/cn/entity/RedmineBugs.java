package Saiita.cn.entity;
/**
 * 
 * @author www.saiita.cn
 * Redmine
 */
public class RedmineBugs implements CharSequence {
	// ���ⵥ��
	String id;
	// bug����������ͳ������
	String number;
	// ���ⵥ״̬
	String status;
	// ��Ŀ
	String project;
	// ���ⵥ�ȼ�
	String priority;
	// ����
	String tracker;
	// ����
	String author;
	// ����
	String subject;
	// ����
	String description;
	// ��ʼʱ��
	String start_date;
	// ��ɰٷֱ�
	String done_ratio;
	// ����
	String days;
	// ͳ��bug������
	String times;
	// �ѹر�
	String closed;
	// �ѹر�
	String open;
	// �·�
	String month;
	// ��
	String week;
	// ���
	String years;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getTracker() {
		return tracker;
	}

	public void setTracker(String tracker) {
		this.tracker = tracker;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getDone_ratio() {
		return done_ratio;
	}

	public void setDone_ratio(String done_ratio) {
		this.done_ratio = done_ratio;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public String getClosed() {
		return closed;
	}

	public void setClosed(String closed) {
		this.closed = closed;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	@Override
	public char charAt(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CharSequence subSequence(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
}
