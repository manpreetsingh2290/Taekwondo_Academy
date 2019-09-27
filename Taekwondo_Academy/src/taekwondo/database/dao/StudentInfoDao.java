package taekwondo.database.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import taekwondo.models.ClassDetails;
import taekwondo.models.ParentDetails;
import taekwondo.models.StudentDetails;
import taekwondo.models.StudentParentDetails;
import taekwondo.models.StudentRegistration;

public class StudentInfoDao {

	/*
	 * public List<StudentDetails> getStudents(String classID) {
	 * List<StudentDetails> list=new ArrayList<StudentDetails>(); String
	 * sqlQuery="select Student_ID,Student_FirstName,Student_LastName,Student_DOB,Email_ID,"
	 * +
	 * "Addrs_HouseNumber,Addrs_Street,Addrs_City,Addrs_State,Addrs_PostalCode,STATUS "
	 * + "from STUDENT_DETAILS S,CLASS_TAKEN C where " +
	 * "S.Student_ID=C.Student_ID " + "AND Class_ID=?"; DatabaseConnection dbcon =
	 * new DatabaseConnection(); Connection con=dbcon.getDatabaseConnection();
	 * StudentDetails student; try { String
	 * slqQuery="select Instructor_FirstName,Instructor_LastName,Instructor_UserID,"
	 * + "Instructor_Password from INSTRUCTOR_DETAILS " +
	 * " where Instructor_UserID=? AND Instructor_Password=?"; PreparedStatement
	 * statement=con.prepareStatement(slqQuery); statement.setString(1,classID);
	 * ResultSet rs=statement.executeQuery(); while(rs.next()) { student = new
	 * Student(); student. } statement.close(); con.close(); } catch (SQLException
	 * e) {
	 * 
	 * e.printStackTrace(); } return instructInfo; }
	 */
	
	
	/*public boolean addStudent(StudentDetails student)
	{
		try
		{
			System.out.println(student);
			SessionFactory sf=  new Configuration().configure().buildSessionFactory();			
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
		
	}*/
	
	public int addStudent(StudentDetails obj)
	{
		int generatedID=-1;
		try
		{
			System.out.println(obj);
			SessionFactory sf=  new Configuration().configure().buildSessionFactory();			
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(obj);
			generatedID= obj.getStudentID();
			
			System.out.println("Generated ID is :("+generatedID+")");
			session.getTransaction().commit();
			
			return generatedID;
		}
		catch(Exception e)
		{
			generatedID=-1;
			e.printStackTrace();
		}
		return generatedID;		
	}
	
	public int addStudentRegistration(StudentRegistration obj)
	{
		int generatedID=-1;
		try
		{
			System.out.println(obj);
			SessionFactory sf=  new Configuration().configure().buildSessionFactory();			
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(obj);
			generatedID= obj.getStudentID();
			
			System.out.println("Generated ID is :("+generatedID+")");
			session.getTransaction().commit();
			
			session.close(); 
	         sf.close();
			
			return generatedID;
		}
		catch(Exception e)
		{
			generatedID=-1;
			e.printStackTrace();
			
		}
		return generatedID;		
	}
	
	public static StudentRegistration getStudentRegistrationDetails(int studentID)
	{

		StudentRegistration obj=null;
		String sqlQuery=" from StudentRegistration S WHERE S.studentID=:ID order by joiningDate desc";
		
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=null;
	      try {
	    	  tx= session.beginTransaction();
	    	  Query query=session.createQuery(sqlQuery);
	    	  
	         List<StudentRegistration> list = session.createQuery(sqlQuery).setParameter("ID", studentID).list();
	         obj = list.get(0);
	         tx.commit(); 
	      } catch (Exception e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	    	  session.close(); 
		         sf.close();
	      }
	      return obj;
	
		
	}
	
	public static StudentDetails getStudentDetails(int studentID)
	{

		StudentDetails student=null;
		String sqlQuery=" from StudentDetails S WHERE S.studentID=:ID ";
		
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=null;
	      try {
	    	  tx= session.beginTransaction();
	    	  Query query=session.createQuery(sqlQuery);
	    	  
	         List<StudentDetails> students = session.createQuery(sqlQuery).setParameter("ID", studentID).list();
	         student = students.get(0);
	         tx.commit(); 
	      } catch (Exception e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	    	  session.close(); 
		         sf.close();
	      }
	      return student;
	
		
	}
	
	public static ClassDetails getClassDetails(int classID)
	{

		ClassDetails obj=null;
		String sqlQuery=" from ClassDetails S WHERE S.classID=:ID ";
		
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=null;
	      try {
	    	  tx= session.beginTransaction();
	    	  Query query=session.createQuery(sqlQuery);
	    	  
	         List<ClassDetails> students = session.createQuery(sqlQuery).setParameter("ID", classID).list();
	         obj = students.get(0);
	         tx.commit(); 
	      } catch (Exception e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	    	  session.close(); 
		         sf.close();
	      }
	      return obj;
		
	}
	
	public static List<ParentDetails> getParents(int studentID)
	{

		List<ParentDetails> parents=null;
		String sqlQuery=" Select P from ParentDetails P,StudentParentDetails SP WHERE "
				+ " P.parentID=SP.parentID "
				+ " AND SP.studentID=:ID ";
		
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=null;
	      try {
	    	  tx= session.beginTransaction();
	    	  Query query=session.createQuery(sqlQuery);
	    	  
	    	  parents = session.createQuery(sqlQuery).setParameter("ID", studentID).list();
	         tx.commit(); 
	      } catch (Exception e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	    	  session.close(); 
		         sf.close(); 
	      }
	      return parents;
	
		
	}
	
	public static List<StudentDetails> getStudentList(int classID)
	{
		List<StudentDetails> list=null;
		String sqlQuery="select S  "
				+ "from StudentDetails S,ClassTakenDetails C where "
				+ "S.studentID=C.studentID "
				+ "AND C.classID=:ID order by S.studentID";
		
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=null;
	      try {
	    	  tx= session.beginTransaction();
	    	  Query query=session.createQuery(sqlQuery);
	    	  list = query.setParameter("ID", classID).list();
	         	         
	         tx.commit();
	      } catch (Exception e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	    	  session.close(); 
		         sf.close(); 
	      }
	return list;
	}
	
	public static List<StudentDetails> getStudentListForAttendance(int classID)
	{
		List<StudentDetails> list=null;
		String sqlQuery="select S  "
				+ "from StudentDetails S,ClassTakenDetails C where "
				+ "S.studentID=C.studentID "
				+ "AND C.classID=:ID AND status='1' order by S.studentID ";
		
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=null;
	      try {
	    	  tx= session.beginTransaction();
	    	  Query query=session.createQuery(sqlQuery);
	    	  list = query.setParameter("ID", classID).list();
	         	         
	         tx.commit();
	      } catch (Exception e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	    	  session.close(); 
		         sf.close(); 
	      }
	return list;
	}
	
	
	
	
	public static List<StudentDetails> getStudentListForRank(int rankID)
	{
		List<StudentDetails> list=null;
		String sqlQuery="select S  "
				+ "from StudentDetails S,StudentRank C where "
				+ "S.studentID=C.studentID "
				+ "AND C.rankID=:ID order by S.studentID";
		
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=null;
	      try {
	    	  tx= session.beginTransaction();
	    	  Query query=session.createQuery(sqlQuery);
	    	  list = query.setParameter("ID", rankID).list();
	         	         
	         tx.commit();
	      } catch (Exception e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	    	  session.close(); 
		         sf.close(); 
	      }
	return list;
	}
	public static List<StudentDetails> getAllStudentList()
	{
		List<StudentDetails> list=null;
		String sqlQuery="select S from StudentDetails S order by S.studentID";
		
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=null;
	      try {
	    	  tx= session.beginTransaction();
	    	  Query query=session.createQuery(sqlQuery);
	    	  list = query.list();
	         System.out.println(list);
	         tx.commit();
	      } catch (Exception e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	    	  session.close(); 
		         sf.close();
	      }
	return list;
	}
	
	
	
	
	
	public int addParent(ParentDetails obj)
	{
		int generatedID=-1;
		try
		{
			System.out.println(obj);
			SessionFactory sf=  new Configuration().configure().buildSessionFactory();			
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(obj);
			generatedID= obj.getParentID();
			
			System.out.println("Generated ID is :("+generatedID+")");
			session.getTransaction().commit();
			
			session.close(); 
	         sf.close();
			return generatedID;
		}
		catch(Exception e)
		{
			generatedID=-1;
			e.printStackTrace();
		}
		return generatedID;		
	}
	
	public boolean addStudentParentDetails(StudentParentDetails obj)
	{
		//int generatedID=-1;
		try
		{
			System.out.println(obj);
			SessionFactory sf=  new Configuration().configure().buildSessionFactory();			
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(obj);
			//generatedID= obj.getParentID();
			
			//System.out.println("Generated ID is :("+generatedID+")");
			session.getTransaction().commit();
			
			session.close(); 
	         sf.close();
			
			return true;
		}
		catch(Exception e)
		{
			//generatedID=-1;
			e.printStackTrace();
		}
		return false;		
	}
	
	/*
	 * public List<StudentDetails> getStudentsList(int classID) {
	 * List<StudentDetails> list=new ArrayList<StudentDetails>(); String
	 * sqlQuery="select Student_ID,Student_FirstName,Student_LastName,Student_DOB,Email_ID,"
	 * +
	 * "Addrs_HouseNumber,Addrs_Street,Addrs_City,Addrs_State,Addrs_PostalCode,STATUS "
	 * + "from STUDENT_DETAILS S,CLASS_TAKEN C where " +
	 * "S.Student_ID=C.Student_ID " + "AND Class_ID=?";
	 * 
	 * SessionFactory sf= new Configuration().configure().buildSessionFactory();
	 * Session session = sf.openSession(); Transaction tx=null; try { tx=
	 * session.beginTransaction(); List<StudentDetails> students =
	 * session.createQuery(sqlQuery).list(); for(StudentDetails obj: students) {
	 * System.out.println(obj.getFirstName()); } tx.commit(); return students; }
	 * catch (HibernateException e) { if (tx!=null) tx.rollback();
	 * e.printStackTrace(); } finally { session.close(); } return list; }
	 */
	
}
