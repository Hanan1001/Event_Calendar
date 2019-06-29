/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dosarihanan
 */

@WebServlet(name = "myServlet", urlPatterns = {"/myServlet"})
public class myServlet extends HttpServlet {
private Connection myCon;
private Statement myStmt;


/**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
        //get Parameters from Add_Event.JSP
    String aTitle = request.getParameter("aTitle");
    String aDescription = request.getParameter("aDescription");
    String aDate = request.getParameter("aDate");
    String aLocation = request.getParameter("aLocation");
      //end geting parameters from Add_Event.JSP
    
            //get Parameters from Edit_Event.JSP
    String eTitle = request.getParameter("eTitle");
    String eDescription = request.getParameter("eDescription");
    String eDate = request.getParameter("eDate");
    String eLocation = request.getParameter("eLocation");
      //end geting parameters from Edit_Event.JSP
    
    //Write your sql query: (concat with param1 if needed)
  String query = "INSERT INTO events VALUES ('','"+aTitle+"','"+aDescription+"','"+aDate+"','"+aLocation+"')";
  String query2 ="SELECT * FROM events";
  String query3 ="UPDATE events SET title ="+eTitle+", description="+eDescription+", date="+eDate+", location="+eLocation+" WHERE id = row number";
  //Perform the query:
    try {
	//Depending on your query, if it's an update (INSERT or UPDATE) then use:
     myStmt.executeUpdate(query);
	//Or if it's a SELECT, use:
    ResultSet  result = myStmt.executeQuery(query2);
	//If it's a select (i.e. there is a 'result') you can get the result meta data (names of the columns and number of returned rows):
	//Get the result's metadata and the number of columns
     ResultSetMetaData resultMd = result.getMetaData();
     int numCols = resultMd.getColumnCount();
	//  You can loop through the resultSet using this code:
      while (result.next()) {
		// Loop to produce the data of a row of the result
		for (int index = 1; index <= numCols; index++) {
		// To get the name of the column:
            String colName = resultMd.getColumnLabel(index);
           String data = result.getString(index);
           
        out.println("<table border='1' name='table'>");
        out.print( "<tr>");
                out.println("<td>colName</td>");
        //out.println("<td>Event Title</td>");
        //out.println("<td>Description</td>");
        //out.println("<td>Event Date</td>");
        //out.println("<td>Location</td>"); 
        //out.println("<td>Edit Event?</td>");
        out.println("</tr>");
              out.print( "<tr>");
              out.println("<td>data</td>");
                     out.print( "</tr>");
        
         out.println("</table>");              
          //out.println(colName+": "+dat + "<br/>");
         }  //** end of for (index = 0; ...
      }  //** end of while (result.next()) ...
	  
	   }  //** end of try

    catch (Exception e) {
      e.printStackTrace();
       out.println("<p>Error</p>");
      out.println("<p>"+e.getLocalizedMessage()+"</p>");
    }  //** end of catch
        /* try {
            /* TODO output your page here. You may use following sample code. */
           /* out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet myServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet myServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();*/
        }
   

    //-----------THIRD: Add this method to the class:-----------

// The init method - instantiate the db driver, connect to the
//  db, and create a statement for an SQL command
    @Override
  public void init() {

// Instantiate the driver for MySQL
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
    }
    catch (Exception e) {
      e.printStackTrace();
    }

// Create the connection to the db
    try {
     myCon = DriverManager.getConnection ("jdbc:mysql://localhost/ms3_db?user=root");
    }
    catch(SQLException e) {
      e.printStackTrace();
    }

// Create the statement for SQL queries
    try {
      myStmt = myCon.createStatement();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }  //** end of the init method
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
} 