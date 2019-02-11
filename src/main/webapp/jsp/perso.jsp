<%@ page language="java"
         contentType="text/html;
         charset=UTF-8"
         pageEncoding="UTF-8"
%>

<html>
<head>
    <title>Sconfitta</title>
</head>
<body>
    <h1>Hai perso <%request.getParameter("user_name"); %> </h1> <br>
        <form action="/mastermindUltimate_war_exploded/index.jsp" method="post">
            <input type="submit" value="Rigioca">
        </form>
</body>
</html>
