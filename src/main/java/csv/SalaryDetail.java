package csv;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import bean.AttendancesBean;
import bean.PartTimerBean;
import bean.SalaryDetailBean;

public class SalaryDetail {

	//partTimers join attendances on id = id
	// set Salary
	public List<SalaryDetailBean> makeSalaryDetail(List<AttendancesBean> attend, List<PartTimerBean> part)
			throws ParseException {

		List<SalaryDetailBean> salaryDetail = new ArrayList<>();
		for (AttendancesBean aVals : attend) {
			SalaryDetailBean sal = new SalaryDetailBean();
			sal.setEmpId(aVals.getEmpId());
			sal.setDate(aVals.getDate());
			sal.setStart(aVals.getStart());
			sal.setEnd(aVals.getEnd());
			String name = "";
			BigDecimal salary = BigDecimal.ZERO;
			for (PartTimerBean ptVals : part) {
				if (aVals.getEmpId().equals(ptVals.getId())) {
					name = ptVals.getName();
					salary = new BigDecimal(ptVals.getSalary());
					break;
				}
			}
			sal.setName(name);
			WorkTime wt = new WorkTime();
			BigDecimal workTime = wt.getWorkTime(aVals.getStart(), aVals.getEnd());
			BigDecimal normalTime = wt.getNormalTime(workTime);
			BigDecimal overTime = wt.getOverTime(normalTime);
			SalaryCulc sc = new SalaryCulc();
			int salaryOverTime = sc.getSalary(salary, workTime);
			sal.setSalaryOverTime(salaryOverTime);
			sal.setOverTime(overTime);
			salaryDetail.add(sal);
		}
		return salaryDetail;
	}

}
