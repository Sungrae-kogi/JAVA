package DataStructure;

public class EX_Student {
	public static void main(String[] args) {
		StudentInfo s_i = new StudentInfo("��ǻ�Ͱ��а�","20163159","������");
		StudentScore s_s = new StudentScore("��ǻ�Ͱ��а�","20163159","������",91,80,95);
		
		
		
		s_i.getStdInfo();	System.out.println();
		s_s.getStdInfo();
		s_s.getStdScore();
	}
}
