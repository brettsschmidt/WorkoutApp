
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class WorkoutDB 
{

	//public static String ConnectionString = "jdbc:ucanaccess://C:\\Users\\brett\\Documents\\STB001_TRAINER_MASTER.accdb; memory=true;";
	public static String ConnectionString = String.format( "jdbc:ucanaccess://%s\\DB\\STB001_TRAINER_MASTER.accdb; memory=true;", System.getProperty("user.dir"));
	/**
	 * @param rs
	 * @return
	 */
	public static Workout Create( ResultSet rs )
	{
		Workout workout = new Workout();
		
		try
		{
			workout.setWKOUT_ID(rs.getLong("WKOUT_ID"));
			workout.setWKOUT_NAME( rs.getString("WKOUT_NAME") );
			workout.setWKOUT_VIDEO( rs.getString("WKOUT_VIDEO") );
			workout.setWKOUT_DESC( rs.getString("WKOUT_DESC") );
			workout.setWKOUT_CAT( rs.getString("WKOUT_CAT") );
			workout.setWKOUT_ADD_USER_ID( rs.getLong("WKOUT_ADD_USER_ID") );
			workout.setWKOUT_ADD_DTM( rs.getTimestamp("WKOUT_ADD_DTM") );
			workout.setWKOUT_CHG_USER_ID( rs.getLong("WKOUT_CHG_USER_ID") );
			workout.setWKOUT_CHG_DTM( rs.getTimestamp("WKOUT_CHG_DTM") );
			workout.setWKOUT_STAT_CD( rs.getString("WKOUT_STAT_CD").charAt(0) );
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			workout = null; 
		}
		
		return workout; 
	}
	
	/**
	 * @param student
	 */
	public static void Update( Workout workout )
	{
		Connection cn = null;
		PreparedStatement ps = null;
		
		StringBuilder strSQL =  new StringBuilder("UPDATE STT001_WKOUT_MASTER ");
		       strSQL.append("SET ");
		       strSQL.append("WKOUT_NAME = ?, ");
		       strSQL.append("WKOUT_VIDEO = ?, ");
		       strSQL.append("WKOUT_DESC = ?, ");
		       strSQL.append("WKOUT_CAT = ?, ");
		       strSQL.append("WKOUT_CHG_USER_ID = ?, ");
		       strSQL.append("WKOUT_CHG_DTM = NOW() ");
		       strSQL.append("WHERE WKOUT_ID = ?;");
		       
		try
		{
			cn = DriverManager.getConnection(ConnectionString);
			ps = cn.prepareStatement(strSQL.toString());
			
			ps.setString(1, workout.getWKOUT_NAME());
			ps.setString(2, workout.getWKOUT_VIDEO());
			ps.setString(3,  workout.getWKOUT_DESC());
			ps.setString(4,  workout.getWKOUT_CAT());
			ps.setLong(5,  workout.getWKOUT_CHG_USER_ID());
			ps.setLong(6, workout.getWKOUT_ID());
			
			ps.executeUpdate();
		}
		catch(Exception ex )
		{
			ex.printStackTrace();
		}
		finally
		{
			try 
			{
				ps.close();
				cn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		       
	}

	// TODO: Add login feature to UI that links to STT3_USER_MASTER and pulls ID from login to input 
		// change ID here.
	/**
	 * @param student
	 */
	public static void Delete( Workout workout, long CHG_USER_ID )
	{
		Connection cn = null;
		PreparedStatement ps = null;
		
		String strSQL =  "{ call qryDelete(?, ?) }";
		       
		try
		{
			cn = DriverManager.getConnection(ConnectionString);
			ps = cn.prepareStatement(strSQL);
			ps.setLong(1,  CHG_USER_ID);
			ps.setLong(2, workout.getWKOUT_ID());
			ps.executeUpdate();
		}
		catch(Exception ex )
		{
			ex.printStackTrace();
		}
		finally
		{
			try 
			{
				ps.close();
				cn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		       
	}
	
	// TODO: Add login feature to UI that links to STT3_USER_MASTER and pulls ID from login to input 
	// change ID here.
	/**
	 * @param workout
	 */ 
	public static void UnDelete( Workout workout, long CHG_USER_ID )
	{
		Connection cn = null;
		PreparedStatement ps = null;
		
		String strSQL =  "{ call qryUndelete(?, ?) }";
		       
		try
		{
			cn = DriverManager.getConnection(ConnectionString);
			ps = cn.prepareStatement(strSQL);
			ps.setLong(1,  CHG_USER_ID);
			ps.setLong(2, workout.getWKOUT_ID());
			
			ps.executeUpdate();
		}
		catch(Exception ex )
		{
			ex.printStackTrace();
		}
		finally
		{
			try 
			{
				ps.close();
				cn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		       
	}

	/**
	 * @param student
	 */
	public static void Purge( Workout workout )
	{
		Purge(workout.getWKOUT_ID());
	}

	/**
	 * @param STUD_ID
	 */
	public static void Purge( Long WKOUT_ID )
	{
		Connection cn = null;
		PreparedStatement ps = null;
		
		String strSQL =  "{ call qryPurge(?) }";
		
		
		try
		{
			cn = DriverManager.getConnection(ConnectionString);
			ps = cn.prepareStatement(strSQL);
			ps.setInt(1, (int)WKOUT_ID.intValue());
			
			ps.executeUpdate();
		}
		catch(Exception ex )
		{
			ex.printStackTrace();
		}
		finally
		{
			try 
			{
				ps.close();
				cn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		       
	}	
	
	
	/**
	 * @param student
	 * @return
	 */
	public static long Add( Workout workout )
	{
		long newId = 0; 
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		
		StringBuilder strSQL =  new StringBuilder("INSERT INTO STT001_WKOUT_MASTER ");
		       strSQL.append("(");
		       strSQL.append("WKOUT_NAME, ");
		       strSQL.append("WKOUT_VIDEO, ");
		       strSQL.append("WKOUT_DESC, ");
		       strSQL.append("WKOUT_CAT, ");
		       strSQL.append("WKOUT_ADD_USER_ID ");
		       strSQL.append(") ");
		       strSQL.append("VALUES ");
		       strSQL.append("( ");
		       strSQL.append("?, ");
		       strSQL.append("?, ");
		       strSQL.append("?, ");
		       strSQL.append("?, ");
		       strSQL.append("? ");
		       strSQL.append(");");
		       
		try
		{
			cn = DriverManager.getConnection(ConnectionString);
			ps = cn.prepareStatement(strSQL.toString());
			
			ps.setString(1, workout.getWKOUT_NAME());
			ps.setString(2, workout.getWKOUT_VIDEO());
			ps.setString(3, workout.getWKOUT_DESC());
			ps.setString(4, workout.getWKOUT_CAT());
			ps.setLong(5, workout.getWKOUT_ADD_USER_ID());
			
			ps.executeUpdate();
			
			ps.close();
			
			ps = cn.prepareStatement("SELECT @@IDENTITY AS NEW_ID");
			rs = ps.executeQuery();
			if(rs.next())
			{
				newId = rs.getLong("NEW_ID");
			}
			
		}
		catch(Exception ex )
		{
			ex.printStackTrace();
		}
		finally
		{
			try 
			{
				rs.close();
				ps.close();
				cn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return newId;
		
	}
	
	
	/**
	 * @param MAJOR_CD
	 * @return
	 */
	public static Workout[] List(String WKOUT_CAT)
	{
		LinkedList<Workout> list = new LinkedList<Workout>(); 
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 

		// TODO:  remove * and list fields needed by the query...
		// 
		String strSQL = "SELECT * FROM STT001_WKOUT_MASTER WHERE WKOUT_CAT = ? ORDER BY WKOUT_NAME, WKOUT_ID;";
		
		try
		{
			cn = DriverManager.getConnection(ConnectionString);
			ps = cn.prepareStatement(strSQL);
			ps.setString(1, WKOUT_CAT);
			rs = ps.executeQuery();
			
			while( rs.next() )
			{
				list.addLast(WorkoutDB.Create(rs)); 
			}
			
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
		finally
		{
			try 
			{
				rs.close();
				ps.close();
				cn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}

		}		
		
		return list.toArray(new Workout[list.size()]);
	}
	
	
	/**
	 * @param student
	 * @return
	 */
	public static Workout Inquire( Workout workout )
	{
		return Inquire(workout.getWKOUT_ID());
	}
	
	/**
	 * @param STUD_ID
	 * @return
	 */
	public static Workout Inquire(long STUD_ID)
	{
		
		Workout workout = null; 
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 

		// TODO:  REMOVE * AND REPLACE WITH FIELD NAMES!!!
		//
		
		// Always use parameterized SQL to avoid SQL-injection...
		//String strSQL = "SELECT * FROM STT001_STUDENT_MASTER WHERE STUD_ID = ?;";
		
		// Stored Procedures are better! 
		String strSQL = "{ call qryStudent(?) }";
		
		try
		{
			cn = DriverManager.getConnection(ConnectionString);
			ps = cn.prepareStatement(strSQL);
			ps.setLong(1, STUD_ID);
			rs = ps.executeQuery();
			
			if( rs.next() )
			{
				workout = WorkoutDB.Create(rs); 
			}
			
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
			workout = null;
		}
		finally
		{
			try 
			{
				rs.close();
				ps.close();
				cn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}

		}
		
		
		return workout; 
		
	}
	
}
