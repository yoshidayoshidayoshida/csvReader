package bean;

import com.opencsv.bean.CsvBindByPosition;

public class PartTimerBean {
	@CsvBindByPosition(position = 0, required = true)
	private String id;

	@CsvBindByPosition(position = 1, required = true)
	private String name;

	@CsvBindByPosition(position = 2, required = true)
	private int salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
