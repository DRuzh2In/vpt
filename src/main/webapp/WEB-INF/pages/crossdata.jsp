<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>CrossData</title>

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
<h1>Cross Details</h1>

<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Cross</th>
        <th width="120">Cabinet</th>
        <th width="80">Count modules</th>
        <th width="80">Free modules</th>
        <th width="120">Changed date</th>
    </tr>
    <tr>
        <td>${cross.idCross}</td>
        <td>${cross.nameCross}</td>
        <td>${cross.tcName}</td>
        <td>${cross.countMod}</td>
        <td>${cross.freeMod}</td>
        <td>${cross.dateChange}</td>
    </tr>
</table>
</body>
</html>