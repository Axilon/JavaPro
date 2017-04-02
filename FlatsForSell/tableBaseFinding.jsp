<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"
         import="ru.bk.rom4ik2103.Flat"
         import="java.util.ArrayList" %>
<html>
<head>
    <title>Table Base</title>
</head>
<body>
<table width='30%' align='center' border='2' cellpadding='5'>
    <caption><h3>The result of search</h3></caption>
    <tr>
        <th>ID</th>
        <th>Number rooms</th>
        <th>Address</th>
        <th>Floor</th>
        <th>Prise</th>
    </tr>
    <%
        ArrayList<Flat> listResult = (ArrayList<Flat>) request.getAttribute("listResult");
        if (listResult!=null){
            for (Flat apartment : listResult) {
                out.println("<tr>");
                out.println("<td>" + apartment.getDiscription() + "</td>" +
                        "<td>" + apartment.getRoomAmount() + "</td>" +
                        "<td>" + apartment.getAdress() + "</td>" +
                        "<td>" + apartment.getFloor() + "</td>" +
                        "<td>" + apartment.getPrice() + "</td>");
                out.println("</tr>");
            }
        }
    %>
</table>
<p><strong> <a href="/estateAgency?a=main">Click</a> to get to the main page.</strong></p>
</body>
</html>
