<%@ page import="com.mysql.cj.Session" %>
<%@ page language="java"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Home</title>
</head>
<body>

    <form action="ServletMain" method="post">
        <h1>Benvenuto in MasterMind</h1>
        <label>Come ti chiami?</label>
        <input id="nome_user" name="nome_user" value= "<%=session.getAttribute("userNome")%>"> <br>
        <input type="submit">
    </form>

</body>
</html>

