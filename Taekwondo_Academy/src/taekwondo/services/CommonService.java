package taekwondo.services;

import java.util.Date;
import java.util.List;

import taekwondo.database.dao.CommonDao;
import taekwondo.database.dao.StudentInfoDao;
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

public class CommonService {
	
	public boolean addStudent(StudentDetails obj,StudentRegistration obj2)
	{
		CommonDao dao= new CommonDao();
		if(dao.addStudent(obj))
		{
			dao.addStudentRegistration(obj2);
		}
		return false;
		
	}
	
	public boolean addParent(ParentDetails obj)
	{
		CommonDao dao= new CommonDao();
		return dao.addParent(obj);
		
	}
	public boolean addStudentParent(StudentParentDetails obj)
	{
		CommonDao dao= new CommonDao();
		return dao.addStudentParent(obj);
		
	}
	
	public boolean addClass(ClassDetails obj)
	{
		CommonDao dao= new CommonDao();
		return dao.addClass(obj);
	}
	
	public boolean addClassAvailabilityDetails(ClassAvailabilityDetails obj)
	{
		CommonDao dao= new CommonDao();
		return dao.addClassAvailabilityDetails(obj);
		
	}
	
	public boolean addClassTakenDetails(ClassTakenDetails obj)
	{
		CommonDao dao= new CommonDao();
		return dao.addClassTakenDetails(obj);
		
	}
	
	public boolean addProduct(ProductDetails obj)
	{
		CommonDao dao= new CommonDao();
		return dao.addProduct(obj);
	}
	
	public int addProductOrder(ProductOrder obj)
	{
		CommonDao dao= new CommonDao();
		return dao.addProductOrder(obj);
	}
	
	public boolean addProductOrderDetails(ProductOrderDetails obj)
	{
		CommonDao dao= new CommonDao();
		return dao.addProductOrderDetails(obj);	
	}
	
	public boolean addStudentAttendance(StudentAttendance obj)
	{
		CommonDao dao= new CommonDao();
		return dao.addStudentAttendance(obj);	
	}
	
	public boolean addRank(BeltRank obj)
	{
		CommonDao dao= new CommonDao();
		return dao.addRank(obj);
	}
	
	public boolean addStudentRank(StudentRank obj)
	{
		CommonDao dao= new CommonDao();
		return dao.addStudentRank(obj);
	}
	
	/*public boolean addStudentRegistration(StudentRegistration obj)
	{
		CommonDao dao= new CommonDao();
		return dao.addStudentRegistration(obj);
	}*/
	
	public List<StudentForCity> getStudentForCity()
	{
		CommonDao dao= new CommonDao();
		return dao.getStudentForCity();
	}
	
	public List<BeltRank> getAllRank()
	{
		CommonDao dao= new CommonDao();
		return dao.getAllRank();
	}
	
	public List<ClassDetails> getAllClassList()
	{
		CommonDao dao= new CommonDao();
		return dao.getAllClassList();
	}
	
	public List<InstructorDetails> getAllInstructorDetails()
	{
		CommonDao dao= new CommonDao();
		return dao.getAllInstructorDetails();
	}
	
	public List<ClassAvailabilityDetails> getClassAvailabilityDetails(int classID)
	{
		CommonDao dao= new CommonDao();
		return dao.getClassAvailabilityDetails(classID);
	}
	
	public List<ProductOrder> getAllOrdersList()
	{
		CommonDao dao= new CommonDao();
		return dao.getAllOrdersList();
	}
	
	public List<ProductDetails> getAllProductList()
	{
		CommonDao dao= new CommonDao();
		return dao.getAllProductList();
	}
	
	
	public List<ProductOrderDetails> getAllProductsOfOrder(int orderID)
	{
		CommonDao dao= new CommonDao();
		return dao.getAllProductsOfOrder(orderID);
	}
	
	public InstructorDetails getInstructorDetails(int instructorID)
	{
		CommonDao dao= new CommonDao();
		return dao.getInstructorDetails(instructorID);
	}
	
	
	public ProductOrder getOrderDetails(int orderID)
	{
		CommonDao dao= new CommonDao();
		return dao.getProductOrder(orderID);
	}
	
	public ProductDetails getProductDetails(int productID)
	{
		CommonDao dao= new CommonDao();
		return dao.getProductDetails(productID);
	}
	
	public List<ProductDetails> getAllProducts()
	{
		CommonDao dao= new CommonDao();
		return dao.getAllProducts();
	}
	
	
	public int addStudent(StudentDetails student)
	{
		StudentInfoDao dao= new StudentInfoDao();
		return dao.addStudent(student);
	}
	
	
	public int addStudentRegistration(StudentRegistration obj)
	{
		StudentInfoDao dao= new StudentInfoDao();
		return dao.addStudentRegistration(obj);
	}
	
	public StudentRegistration getStudentRegistrationDetails(int studentID)
	{
		StudentInfoDao dao= new StudentInfoDao();
		return dao.getStudentRegistrationDetails(studentID);
	}
	
	public StudentDetails getStudentDetails(int studentID)
	{
		StudentInfoDao dao= new StudentInfoDao();
		return dao.getStudentDetails(studentID);
	}
	
	public ClassDetails getClassDetails(int classID)
	{
		CommonDao dao= new CommonDao();
		return dao.getClassDetails(classID);
	}
	
	public StudentParentDetails getStudentParentDetails(int parentID)
	{
		CommonDao dao= new CommonDao();
		return dao.getStudentParentDetails(parentID);
	}
	
	public List<StudentDetails> getStudentList(int classID)
	{
		StudentInfoDao dao= new StudentInfoDao();
		return dao.getStudentList(classID);
	}
	
	public List<StudentDetails> getAllStudentList()
	{
		StudentInfoDao dao= new StudentInfoDao();
		return dao.getAllStudentList();
	}
	
	
	public List<ParentDetails> getParentList(int studentID)
	{
		StudentInfoDao dao= new StudentInfoDao();
		return dao.getParents(studentID);
	}
	
	public  List<BeltRank> getAllBeltRankList()
	{
		CommonDao dao = new CommonDao();
		return dao.getAllBeltRankList();		
	}

	public boolean addFee(StudentFee obj) {
		CommonDao dao= new CommonDao();
		return dao.addFee(obj);
	}

	public List<StudentFee> getAllFeeList() {
		CommonDao dao = new CommonDao();
		return dao.getAllFeeList();	
	}

	public ClassDetails getClass(int classID) {
		CommonDao dao = new CommonDao();
		return dao.getClass(classID);	
	}

	public ClassTakenDetails getClassForStudent(int studentID) {
		CommonDao dao = new CommonDao();
		return dao.getClassForStudent(studentID);
	
	}
	
	public List<StudentAttendance> getStudentAttendanceList(int classID,Date attendanceDate)
	{
		CommonDao dao= new CommonDao();
		return dao.getStudentAttendanceList(classID, attendanceDate);
	}
	
	public List<StudentRank> getStudentRank(int studentID) {
		CommonDao dao = new CommonDao();
		return dao.getStudentRank(studentID);
	}

	public BeltRank getBelt(int rankID) {
		CommonDao dao = new CommonDao();
		return dao.getBelt(rankID);
	}

	public List<?> getStdCountClassWise() {
		CommonDao dao = new CommonDao();
		return dao.getStdCountClassWise();
	}
	
	public List<?> getMonthWiseFee() {
		CommonDao dao = new CommonDao();
		return dao.getMonthWiseFee();
	}
	
	public long getTotalNoOfOrders() {
		CommonDao dao = new CommonDao();
		return dao.getTotalNoOfOrders();
	}
	
	public long getTotalNoOfClasses() {
		CommonDao dao = new CommonDao();
		return dao.getTotalNoOfClasses();
	}
	
	public long getTotalNoOfProducts() {
		CommonDao dao = new CommonDao();
		return dao.getTotalNoOfProducts();
	}
	
	public long getTotalNoOfStudents() {
		CommonDao dao = new CommonDao();
		return dao.getTotalNoOfStudents();
	}
	
}
