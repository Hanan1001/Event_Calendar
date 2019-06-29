
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit an Event</title>
    </head>
    <body>
        <h1>Please feel free to edit an event ^_^</h1>
        
        <form method ="post" action="MS3_Servlet">
           <div> <p>
                Event Number: <input type="text" name="eID"> <br>
                Event Title: <input type="text" name="eTitle"> <br>
                Description:<br>
                <textarea rows="4" cols="50" name="eDescription">Please write a description</textarea><br>
                Event Date: <input type="text" name="eDate"> <br>
                Event Location: <input type="text" name="eLocation"> <br>
                <input type="submit" value="Edit Event">
            </p></div>
        </form>
    </body>
</html>
