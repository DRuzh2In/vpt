<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>LineData</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }


    </style>

</head>
<body>
<h1>Line Details</h1>

<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Direction</th>
        <th width="80">Count ports</th>
        <th width="80">Count free port</th>
        <th wigth="80">Line length</th>

    </tr>
    <tr>
        <td>${line.idLine}</td>
        <td>${line.directLine}</td>
        <td>${line.countPortLine}</td>
        <td>${line.countFreePortLine}</td>
        <td>${line.lenLine}</td>
    </tr>
</table>
</body>
</html>