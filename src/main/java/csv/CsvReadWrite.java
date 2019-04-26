package csv;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import bean.AttendancesBean;
import bean.PartTimerBean;

public class CsvReadWrite {

	// partTimer readCsv
	public List<PartTimerBean> readPartTimer(Reader reader) throws CsvException {
		CsvToBean<PartTimerBean> csvToBean = new CsvToBeanBuilder<PartTimerBean>(reader)
				.withType(PartTimerBean.class).build();
		return csvToBean.parse();
	}

	//attendances readCsv
	public List<AttendancesBean> readAttendances(Reader reader) throws CsvException {
		CsvToBean<AttendancesBean> csvToBean = new CsvToBeanBuilder<AttendancesBean>(reader)
				.withType(AttendancesBean.class).build();
		return csvToBean.parse();
	}

//	ジェネリクス型をreaderにつかいたあああああああああああああああい
	public <T> List<T> readCSV(Reader reader, T t){
		CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader).build();
		return csvToBean.parse();
	}

	//salaryDetail writeCsv
	public <T> void writerCSV(String filePath, List<T> t) throws IOException {
		Writer writer = new FileWriter(filePath);
		StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer)
				.build();
		t.forEach(beans -> {
			try {
				beanToCsv.write((T) beans);
			} catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
				e.printStackTrace();
			}
		});

		writer.close();
	}
}
