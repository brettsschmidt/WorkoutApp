import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CSCI239_PTProject {

	public static void main(String[] args) 
	{
		Connection cn = null;
		
		try
			{
			cn = DriverManager.getConnection(WorkoutDB.ConnectionString);
			cn.close();
			System.out.println("Connected!");
			}
		catch (SQLException e)
			{
				e.printStackTrace();
			}
		
		//Queries for whatever STT1_WKOUT_MASTER has as ID 3. 
		//Return: Pushups
		Workout w =  WorkoutDB.Inquire(3);
		
		System.out.println(w.getWKOUT_NAME());
		
		//Updates it to a new name.
		//Return: Jumping Jacks
		w.setWKOUT_NAME("Jumping Jacks");
		
		WorkoutDB.Update(w);
		w = WorkoutDB.Inquire(3);
		System.out.println(w.getWKOUT_NAME());
		
		
		//Sets it back to the original name.
		//Return: Pushups
		w.setWKOUT_NAME("Pushups");
		
		WorkoutDB.Update(w);
		w = WorkoutDB.Inquire(3);
		System.out.println(w.getWKOUT_NAME());
		
		
		//Adds new record to the database and then should return its new ID and its name.
		//Does it three times just to add stuff to the database and give some comparison.
		Workout s = new Workout();
		s.setWKOUT_NAME("Lunges");
		s.setWKOUT_CAT("Legs");
		s.setWKOUT_DESC("Something");
		s.setWKOUT_ADD_USER_ID(1);
		Long numb = WorkoutDB.Add(s);
		WorkoutDB.Add(s);
		System.out.println(numb);
		s = WorkoutDB.Inquire(numb);
		System.out.println(s.getWKOUT_NAME());
		System.out.println("Record q: " + s.getWKOUT_ID());
		System.out.println("Record w: " + WorkoutDB.Add(s));
		
		//Delete function
		//Should delete record q.
		System.out.println("WKOUT ID : " + s.getWKOUT_ID() + " Stat CD: " + s.getWKOUT_STAT_CD());
		WorkoutDB.Delete(s, 1);
		s = WorkoutDB.Inquire(numb);
		System.out.println("WKOUT ID : " + s.getWKOUT_ID() + " Stat CD: " + s.getWKOUT_STAT_CD());
		
		//Undelete function
		//Should change record q's status to A and then change it back to deleted.
		WorkoutDB.UnDelete(s, 1);
		s = WorkoutDB.Inquire(numb);
		System.out.println("WKOUT ID : " + s.getWKOUT_ID() + " Stat CD: " + s.getWKOUT_STAT_CD());
		WorkoutDB.Delete(s, 1);
		s = WorkoutDB.Inquire(numb);
		System.out.println("WKOUT ID : " + s.getWKOUT_ID() + " Stat CD: " + s.getWKOUT_STAT_CD());
		
		//TODO: Fix Purge
		
		//WorkoutDB.Purge(numb);
		//try
		//{
		//s = WorkoutDB.Inquire(numb);
		//}
		//catch(Exception e)
		//{
			//System.out.println("Record " + numb + "is deleted.");
		//}
	}

}
