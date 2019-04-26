package csv;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.SalaryDetailBean;

public class Output {
	//name, salary
	Map<String, Integer> names = new HashMap<String, Integer>();

	//set name
	public Output(List<String> names) {
		for (String vals : names) {
			this.names.put(vals, 0);
		}
	}

	//output name : salary
	void output(List<SalaryDetailBean> sal) {
		for (SalaryDetailBean vals : sal) {
			int salary = this.names.get(vals.getName());
			this.names.put(vals.getName(), salary + vals.getSalaryOverTime());
		}

		for (Map.Entry<String, Integer> vals : this.names.entrySet()) {
			System.out.println(vals.getKey() + "\t" + vals.getValue());
		}
	}

}
