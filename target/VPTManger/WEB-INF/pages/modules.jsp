<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Modules Page</title>

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

<h1>Module List</h1>

<c:if test="${!empty listModules}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="80">Count ports</th>
            <th width="80">Empty ports</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listModules}" var="module">
            <tr>
                <td><a href="/moduledata/${module.idModule}" target="_blank">${module.idModule}</a></td>
                <td>${module.countPortModule}</td>
                <td>${module.countEmptyPortModule}</td>
                <td><a href="<c:url value='/edit/module/${module.idModule}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/module/${module.idModule}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Module</h1>

<c:url var="addAction" value="/module/add"/>

<form:form action="${addAction}" commandName="module">
    <table>
        <c:if test="${!empty module.countPortModule}">
            <tr>
                <td>
                    <form:label path="idModule">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="idModule" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="idModule"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="countPortModule">
                    <spring:message text="Count Ports"/>
                </form:label>
            </td>
            <td>
                <form:input path="countPortModule"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="countEmptyPortModule">
                    <spring:message text="Empty Module"/>
                </form:label>
            </td>
            <td>
                <form:input path="countEmptyPortModule"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty module.countPortModule}">
                    <input type="submit"
                           value="<spring:message text="Edit Module"/>"/>
                </c:if>
                <c:if test="${empty module.countPortModule}">
                    <input type="submit"
                           value="<spring:message text="Add Module"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
