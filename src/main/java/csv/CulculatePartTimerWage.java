package csv;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.exceptions.CsvException;

import bean.AttendancesBean;
import bean.PartTimerBean;
import bean.SalaryDetailBean;

public class CulculatePartTimerWage {
	public static void main(String[] args) {

		final String PART_TIMER = "src/main/file/PartTimers.csv";

		final String ATTENDANCES = "src/main/file/Attendances.csv";

		final String OUTPUT = "src/main/file/output.csv";

		try (Reader partTimerReader = Files.newBufferedReader(Paths.get(PART_TIMER));
				Reader attendancesReader = Files.newBufferedReader(Paths.get(ATTENDANCES));
				Writer writer = Files.newBufferedWriter(Paths.get(OUTPUT));) {
			
			//csv read
			CsvReadWrite csvReadWrite = new CsvReadWrite();
			List<PartTimerBean> partTimers = csvReadWrite.readPartTimer(partTimerReader);
			List<AttendancesBean> attendances = csvReadWrite.readAttendances(attendancesReader);
//			List<PartTimerEntity> pt = csvReadWrite.readCSV(partTimerReader, new PartTimerEntity());
			
			//partTimers join attendances on id = id
			SalaryDetail sal = new SalaryDetail();
			List<SalaryDetailBean> salaryDetail = sal.makeSalaryDetail(attendances, partTimers);
			
			//name list
			List<String> names = new ArrayList<>();
			partTimers.forEach(vals -> names.add(vals.getName()));

			//output
			Output out = new Output(names);
			out.output(salaryDetail);
			CsvReadWrite csv = new CsvReadWrite();
			csv.writerCSV(OUTPUT, salaryDetail);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
