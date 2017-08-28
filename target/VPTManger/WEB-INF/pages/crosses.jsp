<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Cross Page</title>

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

<h1>Cross List</h1>

<c:if test="${!empty listCrosses}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Cross</th>
            <th width="120">Cabinet</th>
            <th width="80">Count modules</th>
            <th width="80">Free modules</th>
            <th width="120">Changed date</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listCrosses}" var="cross">
            <tr>
                <td>${cross.idCross}</td>
                <td><a href="/crossdata/${cross.idCross}" target="_blank">${cross.nameCross}</a></td>
                <td>${cross.tcName}</td>
                <td>${cross.countMod}</td>
                <td>${cross.freeMod}</td>
                <td>${cross.dateChange}</td>
                <td><a href="<c:url value='/edit/cross/${cross.idCross}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/cross/${cross.idCross}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Cross</h1>

<c:url var="addAction" value="/cross/add"/>

<form:form action="${addAction}" commandName="cross">
    <table>
        <c:if test="${!empty cross.nameCross}">
            <tr>
                <td>
                    <form:label path="idCross">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="idCross" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="idCross"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="nameCross">
                    <spring:message text="Cross"/>
                </form:label>
            </td>
            <td>
                <form:input path="nameCross"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="tcName">
                    <spring:message text="Cabinet"/>
                </form:label>
            </td>
            <td>
                <form:input path="tcName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="countMod">
                    <spring:message text="Count modules"/>
                </form:label>
            </td>
            <td>
                <form:input path="countMod"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="freeMod">
                    <spring:message text="Free modules"/>
                </form:label>
            </td>
            <td>
                <form:input path="freeMod"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="dateChange">
                    <spring:message text="Changed date"/>
                </form:label>
            </td>
            <td>
                <form:input path="dateChange"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty cross.nameCross}">
                    <input type="submit"
                           value="<spring:message text="Edit Cross"/>"/>
                </c:if>
                <c:if test="${empty cross.nameCross}">
                    <input type="submit"
                           value="<spring:message text="Add Cross"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
