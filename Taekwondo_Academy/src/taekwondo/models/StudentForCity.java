package taekwondo.models;

public class StudentForCity {
	
	String city;
	int studentCount;
	
	
	
	public StudentForCity(String city, int studentCount) {
		super();
		this.city = city;
		this.studentCount = studentCount;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public int getStudentCount() {
		return studentCount;
	}
	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}
	@Override
	public String toString() {
		return "StudentForCity [city=" + city + ", studentCount=" + studentCount + "]";
	}
	
	
	
}
