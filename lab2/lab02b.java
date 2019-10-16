

import java.util.ArrayList;
import java.util.Random;

class Student {

	public String studentNo,studnetName,studnetLastName;
        boolean studentActive;
        
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public void setStudentName(String studentName) {
		this.studnetName = studentName;
	}
        public void setStudentLastName(String studentLastName) {
		this.studnetLastName = studentLastName;
	}
        public void setStudentActive(boolean studentActive){
            this.studentActive = studentActive;
        }
	public String getStudentNo() {
		return this.studentNo;
	}
	public String getStudentName() {
		return this.studnetName;
	}
        public String getStudentLastName() {
		return this.studnetLastName;
	}
        public boolean getStudentActive() {
            return this.studentActive;
        }
        

}

public class lab02b {

	static int students_count = 10;

	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<Student>();
                Random rand = new Random();
                String[] Name = new String[] {"Mateusz", "Erwin", "Kuba","Ala","Ela","Zofia","Mieszko","Michał","Władysław","Janusz"};
		String[] LastName = new String[] { "von Clausewitz","Patton","Nietzsche","Churchill","Rommel","Liniarski","Prawdzic-Szlaski","Zawadzki"};
		for(int i = 0; i < students_count; i++) {
			Student student = new Student();
                        
                        student.setStudentName(Name[rand.nextInt(10)]);
                        student.setStudentLastName(LastName[rand.nextInt(8)]);
                        student.setStudentActive(rand.nextBoolean());
			student.setStudentNo(getRandomStudentNumber());
			students.add(student);
		}
		
		System.out.println("aktywni studenci:");
		
		for(int i = 0; i < students.size(); i++) {
			Student student = students.get(i);
                        if(student.studentActive){
                         System.out.println(student.getStudentNo()+" "+student.getStudentName()+" "+student.getStudentLastName());
                         
                        } 

                        
			
		}
	}

	protected static String getRandomStudentNumber() {
		Random rand = new Random();
		return String.valueOf(rand.nextInt(2000) + 38000);
	}
}