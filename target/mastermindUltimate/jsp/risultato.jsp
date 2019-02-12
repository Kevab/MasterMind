<%@ page language="java"
         contentType="text/html;
         charset=UTF-8"
         pageEncoding="UTF-8"
%>

<html>
<head>
    <title>Vittoria</title>
</head>
<body>
<h1>Hai vinto</h1>
<p>Nome: <%= session.getAttribute("userNome")%> <br>
    <%= request.getParameter("tent_num1")%>
    <%= request.getParameter("tent_num2")%>
    <%= request.getParameter("tent_num3")%>

    Vuoi rigiocare?
    <form action="/mastermindUltimate_war_exploded/index.jsp" method="post">
    <input type="submit" value="Rigioca">
</form>
</p>
</body>
</html>
