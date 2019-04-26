package bean;

import java.math.BigDecimal;

import com.opencsv.bean.CsvBindByPosition;


public class SalaryDetailBean {

	@CsvBindByPosition(position = 0, required = true)
	private String empId;
	@CsvBindByPosition(position = 1, required = true)
	private String name;
	@CsvBindByPosition(position = 2, required = true)
	private String date;
	@CsvBindByPosition(position = 3, required = true)
	private String start;
	@CsvBindByPosition(position = 4, required = true)
	private String end;
	@CsvBindByPosition(position = 5, required = true)
	private BigDecimal overTime;
	@CsvBindByPosition(position = 6, required = true)
	private int salaryOverTime;
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String string) {
		date = string;
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
	public BigDecimal getOverTime() {
		return overTime;
	}
	public void setOverTime(BigDecimal overTime) {
		this.overTime = overTime;
	}
	public int getSalaryOverTime() {
		return salaryOverTime;
	}
	public void setSalaryOverTime(int salaryOverTime) {
		this.salaryOverTime = salaryOverTime;
	}
	
}
