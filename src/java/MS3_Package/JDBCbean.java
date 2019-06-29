/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MS3_Package;

/**
 *
 * @author Dosarihanan
 */
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;*/
import java.util.*;
import java.sql.*;

public class JDBCbean {

      private Connection connection ;
       PreparedStatement statement = null;
       ResultSet resultSet = null;
       public List<Javabean> beans;

	//Database connection

	void connectToDB() throws ClassNotFoundException, SQLException
	{
		// Instantiate the driver for MySQL
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
    }
    catch (Exception e) {
      e.printStackTrace();
    }

// Create the connection to the db
    try {
      connection = DriverManager.getConnection ("jdbc:mysql://localhost/ms3_db?user=root");
	//When you upload, use this statement instead:
      //myCon = DriverManager.getConnection("cjdbc:mysql://localhost:3306/ex_cars?user=ex_cars&password=9a0zns83ve40as98345hnv?autoReconnect=true"); //hostgator
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
		
	}

        
        
        //add event
        public void addEvent(Javabean bean) throws SQLException
	{

	// connect to data base
	try {
		connectToDB();
	} catch (ClassNotFoundException e1) {

		e1.printStackTrace();
	}

	// add a user to the DB
	Statement s = null;

	try {
		s = connection.createStatement();
		String query = "INSERT INTO events (id, title,description,date,location)"+
		"VALUES ("+bean.getId()+", '"+bean.getTitle()+"', '"+bean.getDescription()+"','"+bean.getDate()+"','"+bean.getLocation()+"')";
		  s.execute(query);

	} catch (SQLException e) {

		e.printStackTrace();
	       }
	finally {
		 // close both the SQL statement and the DB connection
	      if (s != null) {s.close();}
	      if (connection != null){connection.close();}
	     }
	}
        //end add event
        
        //edit event
        
        	public void editEvent(Javabean bean) throws SQLException
	{

		// connect to data base
		try {
			connectToDB();
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}

		// add a user to the DB
		Statement s = null;
	try {
		String query = "UPDATE [events]"+
		"SET [title] = '"+bean.getTitle()+"'"+", [discription]= '"+bean.getDescription()+"'"+", [date]= '"+bean.getDate()+"'"+", [location]= '"+bean.getLocation()+"'"+
		"WHERE [ID]="+bean.getId();

	    s = connection.createStatement();

		s.execute(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			// close both the SQL statement and the DB connection
		      if (s != null) {s.close();}
		      if (connection != null){connection.close();}
		     }

	}
                //end edit event
                
//select all events from database
                
      public List<Javabean> selectEvents() throws SQLException
	
      {

		// connect to data base
		try {
			connectToDB();
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}

		// add a user to the DB
		Statement s = null;
	try {
		//String query ="SELECT * FROM events";

	    //s = connection.createStatement();

		//s.execute(query);

            statement = connection.prepareStatement("SELECT id, title, description, date,location FROM product");
            resultSet = statement.executeQuery();
     
                
     while (resultSet.next()) {
                Javabean bean = new Javabean();
                bean.setId(resultSet.getInt("id"));
                bean.setTitle(resultSet.getString("name"));
                bean.setDescription(resultSet.getString("description"));
                bean.setDate(resultSet.getString("date"));
                bean.setDate(resultSet.getString("date"));
                
                beans = new ArrayList<Javabean>();
                beans.add(bean);
                Javabeans Listbeans = new Javabeans();
                Listbeans.setEventsList(beans);
                
                
            }
                            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			// close both the SQL statement and the DB connection
		      if (s != null) {s.close();}
		      if (connection != null){connection.close();}
		     }

	
       return beans; 
      }
                //end select event
    
}
