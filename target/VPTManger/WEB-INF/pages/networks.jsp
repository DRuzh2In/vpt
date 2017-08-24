<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Networks Page</title>

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

<h1>Network List</h1>

<c:if test="${!empty listNetworks}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Network</th>
            <th width="120">City</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listNetworks}" var="network">
            <tr>
                <td>${network.idNetwork}</td>
                <td><a href="/networkdata/${network.idNetwork}" target="_blank">${network.nameNetwork}</a></td>
                <td>${network.cityNetwork}</td>
                <td><a href="<c:url value='/edit/network/${network.idNetwork}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/network/${network.idNetwork}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Network</h1>

<c:url var="addAction" value="/networks/add"/>

<form:form action="${addAction}" commandName="network">
    <table>
        <c:if test="${!empty network.nameNetwork}">
            <tr>
                <td>
                    <form:label path="idNetwork">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="idNetwork" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="idNetwork"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="nameNetwork">
                    <spring:message text="Network"/>
                </form:label>
            </td>
            <td>
                <form:input path="nameNetwork"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="cityNetwork">
                    <spring:message text="City"/>
                </form:label>
            </td>
            <td>
                <form:input path="cityNetwork"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty network.nameNetwork}">
                    <input type="submit"
                           value="<spring:message text="Edit Network"/>"/>
                </c:if>
                <c:if test="${empty network.nameNetwork}">
                    <input type="submit"
                           value="<spring:message text="Add Network"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
