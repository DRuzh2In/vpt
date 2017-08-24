<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Zones Page</title>

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

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Zone List</h1>

<c:if test="${!empty listZones}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Zone</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listZones}" var="zone">
            <tr>
                <td>${zone.idZone}</td>
                <td><a href="/zonedata/${zone.idZone}" target="_blank">${zone.nameZone}</a></td>
                <td><a href="<c:url value='/edit/zone/${zone.idZone}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/zone/${zone.idZone}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Zone</h1>

<c:url var="addAction" value="/zones/add"/>

<form:form action="${addAction}" commandName="zone">
    <table>
        <c:if test="${!empty zone.nameZone}">
            <tr>
                <td>
                    <form:label path="idZone">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="idZone" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="idZone"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="nameZone">
                    <spring:message text="Zone"/>
                </form:label>
            </td>
            <td>
                <form:input path="nameZone"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty zone.nameZone}">
                    <input type="submit"
                           value="<spring:message text="Edit Zone"/>"/>
                </c:if>
                <c:if test="${empty zone.nameZone}">
                    <input type="submit"
                           value="<spring:message text="Add Zone"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
