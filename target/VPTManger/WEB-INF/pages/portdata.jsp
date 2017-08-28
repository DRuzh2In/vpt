<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Port Data</title>

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
<h1>Port Details</h1>

<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="80">Port</th>
        <th width="80">Port is empty</th>
        <th width="80">ID next port</th>
        <th width="80">ID prev port</th>
        <th width="120">Connection</th>
        <th width="120">Service</th>
        <th width="120">Type port</th>
        <th width="200">Comments</th>
    </tr>
    <tr>
        <td>${port.idPort}</td>
        <td>${port.numPort}</td>
        <td>${port.emptyPort}</td>
        <td>${port.idNextPort}</td>
        <td>${port.idPrevPort}</td>
        <td>${port.connect}</td>
        <td>${port.service}</td>
        <td>${port.typePort}</td>
        <td>${port.comment}</td>
    </tr>
</table>
</body>
</html>