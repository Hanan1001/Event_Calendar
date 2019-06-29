<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Events Page</title>
    </head>
    <body>
        <h1>Events</h1>
        <form method="post" action="Add_Event.jsp">
            <p>
                If you want to add a new event please click on the "Add Event" button<br>
                <input type="submit" value="Add Event"/>
            </p>
     </form>
        
        
                <form method="post" action="Edit_Event.jsp">
            <p>
                If you want to Edit an event please Type the event Title and Number<br> then click on the "Add Event" button<br>
                Event Title: <input type="text" name="Event_Title">
                Event Number: <input type="text" name="Event_Number">
                <input type="submit" value="Edit Event"/>
            </p>
     </form>
        
        <table border="1" name="table">
            <tr>
                <td>Event Number</td>
                <td>Event Title</td>
                <td>Description</td>
                <td>Event Date</td>
                <td>Location</td>
               
            <tr>
           <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
...
    <c:forEach items="${beans}" var="event">
        <tr>
            <td>${event.id}</td>
            <td>${event.title}</td>
            <td>${event.description}</td>
            <td>${event.date}</td>
            <td>${event.location}</td>
        </tr>
    </c:forEach>

        </table>
    </body>
</html>
