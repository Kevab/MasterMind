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

    <form action="ServletClassifica" method="post">
        <input type="submit" id="classifica_user" name="classifica_user" value="Classifica Utenti">
        <input type="submit" id="classifica_tentativo" name="classifica_tentativo" value="Classifica Tentativi">
    </form>





    <form action="ServletMain" method="post">
        <h1>Benvenuto in MasterMind</h1>
        <label>Come ti chiami?</label>
        <input id="nome_user" name="nome_user" value= "<%=session.getAttribute("userNome")%>"> <br>

        <h3>Vuoi giocare con i colori o con i numeri?</h3>
        SI = 0 oppure NO = 1
        <input id="scelta" name="scelta" pattern=[0-1]{1} value= "<%=session.getAttribute("sceltaColNum")%>"> <br>
        <input type="submit">
    </form>

</body>
</html>

