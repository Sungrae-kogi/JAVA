package DataStructure;

public class EX_Student {
	public static void main(String[] args) {
		StudentInfo s_i = new StudentInfo("컴퓨터과학과","20163159","조성래");
		StudentScore s_s = new StudentScore("컴퓨터과학과","20163159","조성래",91,80,95);
		
		
		
		s_i.getStdInfo();	System.out.println();
		s_s.getStdInfo();
		s_s.getStdScore();
	}
}
