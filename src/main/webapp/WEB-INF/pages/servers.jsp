<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Servers Page</title>

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

<h1>Server List</h1>

<c:if test="${!empty listServers}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Server</th>
            <th width="120">Address</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listServers}" var="server">
            <tr>
                <td>${server.idServer}</td>
                <td><a href="/serverdata/${server.idServer}" target="_blank">${server.nameServer}</a></td>
                <td>${server.addressServer}</td>
                <td><a href="<c:url value='/edit/server/${server.idServer}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/server/${server.idServer}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Server</h1>

<c:url var="addAction" value="/server/add"/>

<form:form action="${addAction}" commandName="server">
    <table>
        <c:if test="${!empty server.nameServer}">
            <tr>
                <td>
                    <form:label path="idServer">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="idServer" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="idServer"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="nameServer">
                    <spring:message text="Server"/>
                </form:label>
            </td>
            <td>
                <form:input path="nameServer"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="addressServer">
                    <spring:message text="Addrss"/>
                </form:label>
            </td>
            <td>
                <form:input path="addressServer"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty server.nameServer}">
                    <input type="submit"
                           value="<spring:message text="Edit Server"/>"/>
                </c:if>
                <c:if test="${empty server.nameServer}">
                    <input type="submit"
                           value="<spring:message text="Add Server"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
