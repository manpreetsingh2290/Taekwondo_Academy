import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import taekwondo.models.ClassDetails;
import taekwondo.models.ProductDetails;
import taekwondo.models.StudentDetails;
import taekwondo.models.StudentForCity;
import taekwondo.models.UserDetails;

public class TestHibrnate {

	public static void main(String[] args) throws ParseException {
		
		//addUser();
		//getStudents("1");
		/*for(int i=0;i<5;i++)
		{
			addStudent(i);
		}*/
		/*List<StudentForCity> list= getStudentForCity();
		for(StudentForCity obj: list)
		{
		 System.out.println(obj);
		}*/
		//addUser();
		//addClass();
		//getStudents(2);
		/*addStudent(3);
		List<StudentDetails> list= getStudentList(1);
		for(StudentDetails obj: list)
		{
		 System.out.println(obj);
		}*/
		//System.out.println(getStudentDetails(1));
	}
	public static List<?> getMonthWiseFee() {
		List<?> list= null;
		String sqlQuery="select sum(S.feeAmount), MONTH(S.paymentDate),YEAR(S.paymentDate) from StudentFee S group by YEAR(S.paymentDate), MONTH(S.paymentDate)";
		
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
	      }
	return list;
	}
	public static List<StudentForCity> getStudentForCity()
	{
		List<StudentForCity> list= new ArrayList<StudentForCity>();
		String sqlQuery="select S.city, count(*) from StudentDetails S group by S.city";
		
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=null;
	      try {
	    	  tx= session.beginTransaction();
	    	  Query query=session.createQuery(sqlQuery);
	    	  List <?> tempList = query.list();
	    	  for(int i =0 ;i < tempList.size(); i++) {
	    		  Object[] temp = (Object[])tempList.get(i);
	    		  System.out.println(temp[0]+"  "+temp[1]+"\n");
	    		  list.add(new StudentForCity((String)temp[0], (int)(long) temp[1])  );
	    	  }
	         System.out.println(list);
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	return list;
	}
	
	
	public static void addStudent(int i) throws ParseException
	{
		
		StudentDetails obj= new StudentDetails();
		obj.setCity("Windsor"+i);
		obj.setFirstName("John"+i);
		obj.setLastName("Singh"+i);
		obj.setEmailID("abcd"+i+"@gmail.com");
		obj.setDateOfBirth("2019-06-26");
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
	}
	public static void addClass()
	{
		ClassDetails obj= new ClassDetails();
		obj.setClassDescription("Advanced1");
		
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
	}
	public static void addUser()
	{
		UserDetails obj= new UserDetails();
		obj.setUserName("Stephanos");
		obj.setPassword("Stephanos");
		//obj.setInstructorID(1);
		obj.setFirstName("Stephanos");
		obj.setLastName("Mavromoustakos");
		
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
	}
	
	public static List<StudentDetails> getStudentList(int classID)
	{
		List<StudentDetails> list=null;
		String sqlQuery="select S  "
				+ "from StudentDetails S,ClassTakenDetails C where "
				+ "S.studentID=C.studentID "
				+ "AND C.classID=:ID";
		
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=null;
	      try {
	    	  tx= session.beginTransaction();
	    	  Query query=session.createQuery(sqlQuery);
	    	  list = query.setParameter("ID", classID).list();
	         	         
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	return list;
	}
	
	/*
	 * public static List<StudentDetails> getStudents(int classID) {
	 * List<StudentDetails> list=new ArrayList<StudentDetails>(); String
	 * sqlQuery="select StudentDetails " + "from StudentDetails S,ClassTakenD" +
	 * "etails C where " + "S.studentID=C.studentID " + "AND C.classID=2";
	 * 
	 * SessionFactory sf= new Configuration().configure().buildSessionFactory();
	 * Session session = sf.openSession(); Transaction tx=null; try { tx=
	 * session.beginTransaction(); List<StudentDetails> students =
	 * session.createQuery(sqlQuery).list(); for(StudentDetails obj: students) {
	 * System.out.println(obj.getStudentID()); } tx.commit(); } catch
	 * (HibernateException e) { if (tx!=null) tx.rollback(); e.printStackTrace(); }
	 * finally { session.close(); } return list; }
	 */
	
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
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return student;
	
		
	}
	
	public static long getTotalNoOfOrders()
	{
		String sqlQuery="select count(*) from ProductOrderDetails";
		long count=0;
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=null;
	      try {
	    	  tx= session.beginTransaction();
	    	  Query query=session.createQuery(sqlQuery);
	    	  List <?> tempList = query.list();
	    	  if(tempList!=null && tempList.get(0)!=null)
	    	  {
	    		  Object temp = (Object)tempList.get(0);	    		  
	    		  System.out.println("ORDERS:"+(long)temp);
	    		  count= (long)temp;
	    	  }
	    	  
	         tx.commit();
	      } catch (Exception e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	    	  session.close(); 
		         sf.close(); 
	      }
	return count;
	}

}
