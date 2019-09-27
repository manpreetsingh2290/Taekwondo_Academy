package taekwondo.database.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import taekwondo.models.BeltRank;
import taekwondo.models.ClassAvailabilityDetails;
import taekwondo.models.ClassDetails;
import taekwondo.models.ClassTakenDetails;
import taekwondo.models.InstructorDetails;
import taekwondo.models.ParentDetails;
import taekwondo.models.ProductDetails;
import taekwondo.models.ProductOrder;
import taekwondo.models.ProductOrderDetails;
import taekwondo.models.StudentAttendance;
import taekwondo.models.StudentDetails;
import taekwondo.models.StudentFee;
import taekwondo.models.StudentForCity;
import taekwondo.models.StudentParentDetails;
import taekwondo.models.StudentRank;
import taekwondo.models.StudentRegistration;

public class CommonDao {

	
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
	
	public  List<StudentForCity> getStudentForCity()
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
	      } catch (Exception e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	    	  session.close(); 
		         sf.close(); 
	      }
	return list;
	}
	
	
	
	public boolean addStudent(StudentDetails obj)
	{
		try
		{
			System.out.println(obj);
			SessionFactory sf=  new Configuration().configure().buildSessionFactory();			
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
			
			session.close(); 
	         sf.close();
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean addParent(ParentDetails obj)
	{
		try
		{
			System.out.println(obj);
			SessionFactory sf=  new Configuration().configure().buildSessionFactory();			
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
			
			session.close(); 
	         sf.close();
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean addStudentParent(StudentParentDetails obj)
	{
		try
		{
			System.out.println(obj);
			SessionFactory sf=  new Configuration().configure().buildSessionFactory();			
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
			
			session.close(); 
	         sf.close();
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean addClass(ClassDetails obj)
	{
		try
		{
			System.out.println(obj);
			SessionFactory sf=  new Configuration().configure().buildSessionFactory();			
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
			
			session.close(); 
	         sf.close();
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;		
	}
	
	public boolean addClassAvailabilityDetails(ClassAvailabilityDetails obj)
	{
		try
		{
			System.out.println(obj);
			SessionFactory sf=  new Configuration().configure().buildSessionFactory();			
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
			
			session.close(); 
	         sf.close();
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean addClassTakenDetails(ClassTakenDetails obj)
	{
		try
		{
			System.out.println(obj);
			SessionFactory sf=  new Configuration().configure().buildSessionFactory();			
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
			//System.out.println(obj);
			
			session.close(); 
	         sf.close();
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean addProduct(ProductDetails obj)
	{
		try
		{
			System.out.println(obj);
			SessionFactory sf=  new Configuration().configure().buildSessionFactory();			
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
			
			session.close(); 
	         sf.close();
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;		
	}
	
	public int addProductOrder(ProductOrder obj)
	{
		int generatedID=-1;
		try
		{
			System.out.println(obj);
			SessionFactory sf=  new Configuration().configure().buildSessionFactory();			
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(obj);
			generatedID= obj.getOrderID();
			
			System.out.println("Generated ID of order is :("+generatedID+")");
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
	
	public boolean addProductOrderDetails(ProductOrderDetails obj)
	{
		try
		{
			System.out.println(obj);
			SessionFactory sf=  new Configuration().configure().buildSessionFactory();			
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
			
			session.close(); 
	         sf.close();
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;		
	}
	
	public boolean addStudentAttendance(StudentAttendance obj)
	{
		try
		{
			System.out.println(obj);
			SessionFactory sf=  new Configuration().configure().buildSessionFactory();			
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
			
			session.close(); 
	         sf.close();
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;		
	}
	
	public boolean addRank(BeltRank obj)
	{
		try
		{
			System.out.println(obj);
			SessionFactory sf=  new Configuration().configure().buildSessionFactory();			
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
			
			session.close(); 
	         sf.close();
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;		
	}
	
	public boolean addStudentRank(StudentRank obj)
	{
		try
		{
			System.out.println(obj);
			SessionFactory sf=  new Configuration().configure().buildSessionFactory();			
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
			
			session.close(); 
	         sf.close();
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;		
	}
	
	public boolean addStudentRegistration(StudentRegistration obj)
	{
		try
		{
			System.out.println(obj);
			SessionFactory sf=  new Configuration().configure().buildSessionFactory();			
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
			
			session.close(); 
	         sf.close();
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;		
	}
	
	
	public static List<BeltRank> getAllRank()
	{
		List<BeltRank> list=null;
		String sqlQuery="select C from BeltRank C order by C.rankID";
		
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
	
	
	public static List<ClassDetails> getAllClassList()
	{
		List<ClassDetails> list=null;
		String sqlQuery="select C from ClassDetails C order by C.classID";
		
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
	
	public static List<InstructorDetails> getAllInstructorDetails()
	{
		List<InstructorDetails> list=null;
		String sqlQuery="select C from InstructorDetails C order by C.instructorID";
		
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
	
	public static List<ClassAvailabilityDetails> getClassAvailabilityDetails(int classID)
	{
		List<ClassAvailabilityDetails> list=null;
		String sqlQuery="select C from ClassAvailabilityDetails C where C.classID=:ID order by C.classID";
		
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=null;
	      try {
	    	  tx= session.beginTransaction();
	    	  Query query=session.createQuery(sqlQuery);
	    	  list = query.setParameter("ID", classID).list();
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
	
	public static List<ProductOrder> getAllOrdersList()
	{
		List<ProductOrder> list=null;
		String sqlQuery="select C from ProductOrder C order by C.orderID desc";
		
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
	
	public static List<ProductDetails> getAllProductList()
	{
		List<ProductDetails> list=null;
		String sqlQuery="select P from ProductDetails P order by P.productID";
		
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
	
	public static List<ProductOrderDetails> getAllProductsOfOrder(int orderID)
	{
		List<ProductOrderDetails> list=null;
		String sqlQuery="select P from ProductOrderDetails P where P.orderID=:ID order by P.orderID";
		
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=null;
	      try {
	    	  tx= session.beginTransaction();
	    	  Query query=session.createQuery(sqlQuery);
	    	  
	    	  list = session.createQuery(sqlQuery).setParameter("ID", orderID).list();
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
	
	public static InstructorDetails getInstructorDetails(int instructorID)
	{
		List<InstructorDetails> list=null;
		InstructorDetails obj=null;
		String sqlQuery="select P from InstructorDetails P where P.instructorID=:ID";
		
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=null;
	      try {
	    	  tx= session.beginTransaction();
	    	  Query query=session.createQuery(sqlQuery);
	    	  
	    	  list = session.createQuery(sqlQuery).setParameter("ID", instructorID).list();
	    	  obj= list.get(0);
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
	
	public static List<ProductDetails> getAllProducts()
	{
		List<ProductDetails> list=null;
		String sqlQuery="select P from ProductDetails P order by P.productID";
		
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=null;
	      try {
	    	  tx= session.beginTransaction();
	    	  Query query=session.createQuery(sqlQuery);
	    	  
	    	  list = session.createQuery(sqlQuery).list();
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
	
	
	public static ProductOrder getProductOrder(int orderID)
	{

		ProductOrder obj=null;
		String sqlQuery="select S from ProductOrder S WHERE S.orderID=:ID ";
		
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=null;
	      try {
	    	  tx= session.beginTransaction();
	    	  Query query=session.createQuery(sqlQuery);
	    	  
	         List<ProductOrder> list = session.createQuery(sqlQuery).setParameter("ID", orderID).list();
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
	
	
	public static ProductDetails getProductDetails(int productID)
	{

		ProductDetails obj=null;
		String sqlQuery="select S from ProductDetails S WHERE S.productID=:ID ";
		
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=null;
	      try {
	    	  tx= session.beginTransaction();
	    	  Query query=session.createQuery(sqlQuery);
	    	  
	         List<ProductDetails> list = session.createQuery(sqlQuery).setParameter("ID", productID).list();
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
	
	public  List<BeltRank> getAllBeltRankList()
	{
		List<BeltRank> list=null;
		String sqlQuery="select S from BeltRank S order by S.rankID";
		
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
	
	public static StudentParentDetails getStudentParentDetails(int parentID)
	{
		List<StudentParentDetails> list=null;
		StudentParentDetails obj=null;
		String sqlQuery="select SP from StudentParentDetails SP where SP.parentID=:ID";
		
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=null;
	      try {
	    	  tx= session.beginTransaction();
	    	  Query query=session.createQuery(sqlQuery);
	    	  
	    	  list = session.createQuery(sqlQuery).setParameter("ID", parentID).list();
	    	  obj= list.get(0);
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
		public boolean addFee(StudentFee obj) {
		try
		{
			System.out.println(obj);
			SessionFactory sf=  new Configuration().configure().buildSessionFactory();			
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
			
			session.close(); 
	         sf.close();
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}



	public List<StudentFee> getAllFeeList() {
		List<StudentFee> list=null;
		String sqlQuery="select S from StudentFee S order by S.paymentDate";
		
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



	public ClassDetails getClass(int classID) {
		ClassDetails obj=null;
		String sqlQuery="select S from ClassDetails S WHERE S.classID=:ID ";
		
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=null;
	      try {
	    	  tx= session.beginTransaction();
	    	  Query query=session.createQuery(sqlQuery);
	    	  
	         List<ClassDetails> list = session.createQuery(sqlQuery).setParameter("ID", classID).list();
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



	public ClassTakenDetails getClassForStudent(int studentID) {
		ClassTakenDetails obj=null;
		String sqlQuery="select S from ClassTakenDetails S WHERE S.studentID=:ID order by S.beginDate desc";
		
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=null;
	      try {
	    	  tx= session.beginTransaction();
	    	  Query query=session.createQuery(sqlQuery);
	    	  
	         List<ClassTakenDetails> list = session.createQuery(sqlQuery).setParameter("ID", studentID).list();
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
	
	public  List<StudentAttendance> getStudentAttendanceList(int classID,Date attendanceDate)
	{
		List<StudentAttendance> list=null;
		String sqlQuery="select P from StudentAttendance P "
				+ " where P.classID=:ID "
				+ " AND P.classDate=:atnDATE"
				+ " order by P.studentID ";
		
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=null;
	      try {
	    	  tx= session.beginTransaction();
	    	  Query query=session.createQuery(sqlQuery);
	    	  
	    	  list = session.createQuery(sqlQuery).setParameter("ID", classID).
	    			  setParameter("atnDATE", attendanceDate).list();
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
	
		public List<StudentRank> getStudentRank(int studentID) {
		List <StudentRank> list=null;
		String sqlQuery="select S from StudentRank S WHERE S.studentID=:ID order by S.rankAttainDate";
		
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=null;
	      try {
	    	  tx= session.beginTransaction();
	    	  Query query=session.createQuery(sqlQuery);
	    	  
	         list = session.createQuery(sqlQuery).setParameter("ID", studentID).list();
	         
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

	public BeltRank getBelt(int rankID) {
		BeltRank obj=null;
		String sqlQuery="select S from BeltRank S WHERE S.rankID=:ID";
		
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=null;
	      try {
	    	  tx= session.beginTransaction();
	    	  Query query=session.createQuery(sqlQuery);
	    	  
	         List<BeltRank> list = session.createQuery(sqlQuery).setParameter("ID", rankID).list();
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

	public List<?> getStdCountClassWise() {
		List<?> list= null;
		String sqlQuery="select S.classID, count(*) from ClassTakenDetails S group by S.classID";
		
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
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	    	  session.close(); 
		         sf.close();
	      }
	      return obj;
	
		
	}
	
	
	public static long getTotalNoOfOrders()
	{
		String sqlQuery="select count(*) from ProductOrder";
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
	
	public List<?> getMonthWiseFee() {
		List<?> list= null;
		String sqlQuery="select sum(S.feeAmount),extract(month from S.paymentDate) as month,extract(year from S.paymentDate) as  year from StudentFee S group by YEAR(S.paymentDate), MONTH(S.paymentDate) order by  YEAR(S.paymentDate), MONTH(S.paymentDate)";
		
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
	
	public  long getTotalNoOfStudents()
	{
		String sqlQuery="select count(*) from StudentDetails";
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
	
	public  long getTotalNoOfClasses()
	{
		String sqlQuery="select count(*) from ClassDetails";
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
	
	public  long getTotalNoOfProducts()
	{
		String sqlQuery="select count(*) from ProductDetails";
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
