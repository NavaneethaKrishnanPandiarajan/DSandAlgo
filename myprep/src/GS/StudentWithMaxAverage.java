//$Id$
package GoldManSachs;

import java.util.HashMap;
import java.util.Map;

public class StudentWithMaxAverage 
{
	public static void main(String [] args)
	{
		String[][] s= {{"jerry","65"}, {"bob","1"}, {"jerry","23"},{"jerry","23"}, {"jerry","100"}};
		
		Map<String , StudentInfo> studentDetails = new HashMap<String , StudentInfo>();
		
		String studentName = "";
		double maxAverageScore = Double.MIN_VALUE ;
		
		for(int i=0; i< s.length; i++ )
		{
			String name = s[i][0];
			String score = s[i][1];
			
			StudentInfo info = studentDetails.getOrDefault(name, new StudentInfo());
			
			int totalMarks  = info.getTotalMarks() + Integer.parseInt(score);
			int totalSubjectCount  = info.getTotalSubjectCount() + 1;
			int average =  totalMarks / totalSubjectCount ;

			info.setAverage(average);
			info.setTotalSubjectCount(totalSubjectCount);
			info.setTotalMarks(totalMarks);	
			studentDetails.put(name, info);
		}
		
		
		System.out.println("Student Name : " + studentName);
		System.out.println("average mark : " + maxAverageScore);
	}

}

class StudentInfo
{
	int totalMarks = 0;
	int totalSubjectCount = 0;
	double average = 0;

	int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public int getTotalSubjectCount() {
		return totalSubjectCount;
	}
	public void setTotalSubjectCount(int totalSubjectCount) {
		this.totalSubjectCount = totalSubjectCount;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}

}