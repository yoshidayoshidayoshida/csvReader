package csv;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalaryCulc {

	//salary / day
	public int getSalary(BigDecimal salary, BigDecimal workTime) {
		final BigDecimal EIGHT = new BigDecimal("8.0");
		final BigDecimal OVER_FARE = new BigDecimal("1.25");
		
		WorkTime wt = new WorkTime();
		BigDecimal normalTime = wt.getNormalTime(workTime);
		BigDecimal overTime = wt.getOverTime(normalTime);
		
		normalTime = normalTime.compareTo(EIGHT) >= 0 ? EIGHT : normalTime;
			
		return 	(salary.multiply(normalTime)
				.add(salary.multiply(overTime).multiply(OVER_FARE)))
				.setScale(0,RoundingMode.DOWN).intValue();
	}

}
