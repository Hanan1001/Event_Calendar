
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new Event</title>
    </head>
    <body>
        <h1>Please feel free to add a new event ^_^</h1>
        
        <form action="MS3_Servlet" method ="post" >
           <div> <p>
                Event Title: <input type="text" name="aTitle"> <br>
                Description:<br>
                <textarea rows="4" cols="50" name="aDescription">Please write a description</textarea><br>
                Event Date: <input type="text" name="aDate"> <br>
                Event Location: <input type="text" name="aLocation"> <br>
                <input type="submit" value="Add Event">
            </p></div>
        </form>
    </body>
</html>
