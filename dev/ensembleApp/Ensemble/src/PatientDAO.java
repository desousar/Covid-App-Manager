import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import models.Patient;

/**
 * 
 * @version 1.0
 * */
public class PatientDAO {

	/**
	 * Database connection parameters
	 */
	final static String PORT1 = "8889";
	final static String PORT2 = "3306";
	final static String URL = "jdbc:mysql://localhost:" + PORT2 + "/ensemble";
	final static String LOGIN="root";
	final static String PASS="root";

	
	/**
	 * Class Constructor
	 * 
	 */
	public PatientDAO()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			System.err.println("Error while loading jdbc driver into the project");
		}

	}
	

	/**
	 * Add patient into patient table
	 * @param newPatient : patient to add
	 * @return number of rows created are returned
	 */
	public int addPatient(Patient newPatient)
	{
		Connection con = null;
		PreparedStatement ps = null;
		int rows =0;
		try {
			
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			
			ps = con.prepareStatement("INSERT INTO patient (firstname, lastname, datebirth,namevaccine,nbrdose) VALUES (? ,?, ?, ?, ?)");
			ps.setString(1,newPatient.getFirstname());
			ps.setString(2,newPatient.getLastname());
			ps.setDate(3,newPatient.getDatebirth());
			ps.setString(4,newPatient.getnamevaccine());
			ps.setInt(5,newPatient.getNbrdose());

			rows=ps.executeUpdate();


		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			
			try {if (ps != null)ps.close();} catch (Exception t) {}
			try {if (con != null)con.close();} catch (Exception t) {}
		}
		return rows;

	}
	
	/**
	 * Increment patient nbrdose by 1 in the database
	 * @param id : patient id 
	 */
	public void addDoseToPatient(int id) {
		
		Connection con = null;
		PreparedStatement ps = null;
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("UPDATE patient SET nbrdose = (nbrdose + 1) WHERE id = ?");
			ps.setInt(1,id);
			ps.executeUpdate();

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			try {if (ps != null)ps.close();} catch (Exception t) {}
			try {if (con != null)con.close();} catch (Exception t) {}
		}
	}
	
	/**
	 * Retrieve a patient via his id
	 * @param id of the patient to retrieve
	 * @return Patient object 
	 * @return null if the id doesn't match 
	 */
	public Patient getPatient(int id)
	{

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		Patient pt =null;

		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM patient WHERE id= ?");
			ps.setInt(1,id);

			rs=ps.executeQuery();
		
			if(rs.next())
				pt=new Patient(rs.getInt("id"),rs.getString("firstname"),rs.getString("lastname"),rs.getDate("datebirth"),rs.getString("namevaccine"),rs.getInt("nbrdose"));


		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			
			try {if (rs != null)rs.close();} catch (Exception t) {}
			try {if (ps != null)ps.close();} catch (Exception t) {}
			try {if (con != null)con.close();} catch (Exception t) {}
		}
		return pt;

	}

	/**
	 * get every rows in patient table
	 * @return List of patients
	 */
	public List<Patient> getListPatients()
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<Patient> patientsList=new ArrayList<Patient>();

		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM patient");

			rs=ps.executeQuery();
	
			while(rs.next())
				patientsList.add(new Patient(rs.getInt("id"),rs.getString("firstname"),rs.getString("lastname"),rs.getDate("datebirth"),rs.getString("namevaccine"),rs.getInt("nbrdose")));


		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {

			try {if (rs != null)rs.close();} catch (Exception t) {}
			try {if (ps != null)ps.close();} catch (Exception t) {}
			try {if (con != null)con.close();} catch (Exception t) {}
		}
		return patientsList;

	}
	
	public static void TestAddPatient() {
		
		PatientDAO PatientDAO=new PatientDAO();
		@SuppressWarnings("deprecation")
		Patient a = new Patient(2,"robin","pomme",new Date(2021, 02, 02),"Pfizer",2);
		int nbrow =PatientDAO.addPatient(a);
		System.out.println(nbrow+ " added row");
	}
	
	public static void TestGetPatient() {
		PatientDAO PatientDAO=new PatientDAO();	
		Patient pt = PatientDAO.getPatient(1);
		System.out.println("Patient added : " + pt);
	}
	public static void TestAddDoseToPatient() {
		PatientDAO PatientDAO=new PatientDAO();
		Patient pt = PatientDAO.getPatient(1);
		System.out.println("before: nbrdose = " + pt.getNbrdose());
		
		PatientDAO.addDoseToPatient(1);
		pt = PatientDAO.getPatient(1);
		System.out.println("after: nbrdose = " + pt.getNbrdose());
	}
	
	public static void TestGetListPatients() {
		PatientDAO PatientDAO=new PatientDAO();	
		List<Patient> patientsList=PatientDAO.getListPatients();
		for(Patient pt : patientsList)
		{
			System.out.println(pt.toString());
		}
	}
	
	public static void main(String[] args)  throws SQLException {
			
			/*TestAddPatient();
			TestGetPatient();
			TestAddDoseToPatient();
			TestGetListPatients();*/

	}
}
