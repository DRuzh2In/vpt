<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Line Page</title>

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

<h1>Line List</h1>

<c:if test="${!empty listLines}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Direction</th>
            <th width="80">Count ports</th>
            <th width="80">Count free port</th>
            <th wigth="80">Line length</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listLines}" var="line">
            <tr>
                <td>${line.idLine}</td>
                <td><a href="/linedata/${line.idLine}" target="_blank">${line.directLine}</a></td>
                <td>${line.countPortLine}</td>
                <td>${line.countFreePortLine}</td>
                <td>${line.lenLine}</td>
                <td><a href="<c:url value='/edit/line/${line.idLine}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/line/${line.idLine}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Cross</h1>

<c:url var="addAction" value="/line/add"/>

<form:form action="${addAction}" commandName="line">
    <table>
        <c:if test="${!empty line.directLine}">
            <tr>
                <td>
                    <form:label path="idLine">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="idLine" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="idLine"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="directLine">
                    <spring:message text="Direction"/>
                </form:label>
            </td>
            <td>
                <form:input path="directLine"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="countPortLine">
                    <spring:message text="Count ports"/>
                </form:label>
            </td>
            <td>
                <form:input path="countPortLine"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="countFreePortLine">
                    <spring:message text="Count free ports"/>
                </form:label>
            </td>
            <td>
                <form:input path="countFreePortLine"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="lenLine">
                    <spring:message text="Line length"/>
                </form:label>
            </td>
            <td>
                <form:input path="lenLine"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty line.directLine}">
                    <input type="submit"
                           value="<spring:message text="Edit Lime"/>"/>
                </c:if>
                <c:if test="${empty line.directLine}">
                    <input type="submit"
                           value="<spring:message text="Add Line"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
