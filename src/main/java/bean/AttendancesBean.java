package bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.opencsv.bean.CsvBindByPosition;

public class AttendancesBean {
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

	@CsvBindByPosition(position = 0, required = true)
	private String date;
	
	@CsvBindByPosition(position = 1, required = true)
	private String empId;
	
	@CsvBindByPosition(position = 2, required = true)
	private String start;
	
	@CsvBindByPosition(position = 3, required = true)
	private String end;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) throws ParseException {
		this.start = start;

	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) throws ParseException {
		this.end = end;
	}
}
