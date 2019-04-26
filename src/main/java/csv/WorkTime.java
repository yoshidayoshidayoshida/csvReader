package csv;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class WorkTime {
	public BigDecimal getWorkTime(String start, String end) throws ParseException {
		final BigDecimal TIME = new BigDecimal(1000 * 60 * 60);
		final String SIMPLE_DATE_FORMAT = "hh:mm:ss";
		BigDecimal bdStart = new BigDecimal(new SimpleDateFormat(SIMPLE_DATE_FORMAT).parse(start).getTime()).divide(TIME);
		BigDecimal bdEnd = new BigDecimal(new SimpleDateFormat(SIMPLE_DATE_FORMAT).parse(end).getTime()).divide(TIME);
		BigDecimal result = bdEnd.subtract(bdStart).setScale(2, RoundingMode.DOWN);
		return result;
	}

	public BigDecimal getOverTime(BigDecimal workTime) {
		final BigDecimal EIGHT = new BigDecimal("8.0");
		return workTime.compareTo(EIGHT) >= 0 ? workTime.subtract(EIGHT) : BigDecimal.ZERO;
	}

	public BigDecimal getNormalTime(BigDecimal workTime) {
		BigDecimal normalTime = BigDecimal.ZERO;
		if (workTime.compareTo(new BigDecimal("6.0")) == -1) {
			normalTime = workTime;
		} else if (workTime.compareTo(new BigDecimal("8.0")) == -1) {
			normalTime = workTime.subtract(new BigDecimal("0.75"));
		} else {
			normalTime = workTime.subtract(new BigDecimal("1.0"));
		}
		return normalTime;
	}
}
