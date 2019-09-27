package taekwondo.database.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import taekwondo.models.StudentDetails;
import taekwondo.models.UserDetails;

public class LoginInfoDao {
	

	/*public InstructorDetails checkLogin(String userID,String password)
	{
		DatabaseConnection dbcon = new DatabaseConnection();
		InstructorDetails instructInfo= new InstructorDetails();
		Connection con=dbcon.getDatabaseConnection();
		try {
			String slqQuery="select Instructor_FirstName,Instructor_LastName,Instructor_UserID,"
					+ "Instructor_Password from INSTRUCTOR_DETAILS "
					+ " where Instructor_UserID=? AND Instructor_Password=?";
			PreparedStatement statement=con.prepareStatement(slqQuery);
			statement.setString(1,userID);
			statement.setString(2,password);
			ResultSet rs=statement.executeQuery();
			if(rs.next())
			{				
				instructInfo.setFirstName(rs.getString(1));
				instructInfo.setLastName(rs.getString(2));
				instructInfo.setUserID(rs.getString(3));
				instructInfo.setPassword(rs.getString(4));
			}
			statement.close();
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return instructInfo;
	}*/
	
	public  UserDetails checkLogin(String userName,String password)
	{

		UserDetails obj=null;
		String sqlQuery=" from UserDetails U WHERE U.userName=:ID AND U.password=:PWD";
		
		SessionFactory sf=  new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=null;
	      try {
	    	  tx= session.beginTransaction();
	    	  Query query=session.createQuery(sqlQuery);	    	  
	         List<UserDetails> students = query.setParameter("ID", userName)
	        		 .setParameter("PWD", password).list();
	         obj = students.get(0);
	         System.out.println("User:"+obj);
	         tx.commit(); 
	      } catch (Exception e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		/*if(obj!=null && obj.getUserName() !=null && !"".equalsIgnoreCase(obj.getUserName()))
		{
		   return true;
		}*/
	      return obj;
	
		
	}
}
