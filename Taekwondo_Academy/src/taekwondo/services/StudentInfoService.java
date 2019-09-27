package taekwondo.services;

import java.util.List;

import taekwondo.database.dao.CommonDao;
import taekwondo.database.dao.StudentInfoDao;
import taekwondo.models.ParentDetails;
import taekwondo.models.StudentAttendance;
import taekwondo.models.StudentDetails;
import taekwondo.models.StudentParentDetails;

public class StudentInfoService {

	public int addStudent(StudentDetails student)
	{
		StudentInfoDao dao= new StudentInfoDao();
		return dao.addStudent(student);
	}
	
	public StudentDetails getStudentDetails(int studentID)
	{
		StudentInfoDao dao= new StudentInfoDao();
		return dao.getStudentDetails(studentID);
	}
	
	public List<StudentDetails> getStudentList(int classID)
	{
		StudentInfoDao dao= new StudentInfoDao();
		return dao.getStudentList(classID);
	}
	
	public List<StudentDetails> getStudentListForAttendance(int classID)
	{
		StudentInfoDao dao= new StudentInfoDao();
		return dao.getStudentListForAttendance(classID);
	}
	
	
	
	public List<StudentDetails> getStudentListForRank(int rankID)
	{
		StudentInfoDao dao= new StudentInfoDao();
		return dao.getStudentListForRank(rankID);
	}
	
	public List<StudentDetails> getAllStudentList()
	{
		StudentInfoDao dao= new StudentInfoDao();
		return dao.getAllStudentList();
	}
	
	public List<StudentDetails> getAllBeltRankList()
	{
		StudentInfoDao dao= new StudentInfoDao();
		return dao.getAllStudentList();
	}
	
	public int addParent(ParentDetails parent)
	{
		StudentInfoDao dao= new StudentInfoDao();
		return dao.addParent(parent);
	}
	public List<ParentDetails> getParentList(int studentID)
	{
		StudentInfoDao dao= new StudentInfoDao();
		return dao.getParents(studentID);
	}
	
	public boolean addStudentParentDetails(StudentParentDetails obj)
	{
		StudentInfoDao dao= new StudentInfoDao();
		return dao.addStudentParentDetails(obj);
	}
}
