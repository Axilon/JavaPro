<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"
import="ru.bk.rom4ik2103.EstateAgency"
import="ru.bk.rom4ik2103.Flat"%>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Estate Agency</title>
</head>
<body>
    <table width="30%" align='center' border="1" cellpadding="3">
        <caption><h3>The list of apartments</h3></caption>
        <tr>
            <th>Description</th>
            <th>Number rooms</th>
            <th>Address</th>
            <th>Floor</th>
            <th>Prise</th>
        </tr>
        <%
            EstateAgency list = (EstateAgency) request.getAttribute("list");
            if (list != null){
                for (Flat apartment : list.getListFlat()) {
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
    <p> <form action="/finding" method="get">
        <strong>Enter the address to save base to xml<br>
        <input type="text" name="saveToXml">
        <input type="submit" value="Save"></strong>
    </form>


</body>
</html>
