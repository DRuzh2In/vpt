<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Port Page</title>

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

<h1>Port List</h1>

<c:if test="${!empty listPorts}">
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
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listPorts}" var="port">
            <tr>
                <td>${port.idPort}</td>
                <td><a href="/portdata/${port.idPort}" target="_blank">${port.numPort}</a></td>
                <td>${port.emptyPort}</td>
                <td>${port.idNextPort}</td>
                <td>${port.idPrevPort}</td>
                <td>${port.connect}</td>
                <td>${port.service}</td>
                <td>${port.typePort}</td>
                <td>${port.comment}</td>
                <td><a href="<c:url value='/edit/port/${port.idPort}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/port/${port.idPort}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Port</h1>

<c:url var="addAction" value="/port/add"/>

<form:form action="${addAction}" commandName="port">
    <table>
        <c:if test="${!empty port.numPort}">
            <tr>
                <td>
                    <form:label path="idPort">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="idPort" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="idPort"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="numPort">
                    <spring:message text="Port"/>
                </form:label>
            </td>
            <td>
                <form:input path="numPort"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="emptyPort">
                    <spring:message text="Port is Empty"/>
                </form:label>
            </td>
            <td>
                <form:input path="emptyPort"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="idNextPort">
                    <spring:message text="ID next port"/>
                </form:label>
            </td>
            <td>
                <form:input path="idNextPort"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="idPrevPort">
                    <spring:message text="ID prev port"/>
                </form:label>
            </td>
            <td>
                <form:input path="idPrevPort"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="connect">
                    <spring:message text="Connection"/>
                </form:label>
            </td>
            <td>
                <form:input path="connect"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="service">
                    <spring:message text="Service"/>
                </form:label>
            </td>
            <td>
                <form:input path="service"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="typePort">
                    <spring:message text="Type port"/>
                </form:label>
            </td>
            <td>
                <form:input path="typePort"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="comment">
                    <spring:message text="Comments"/>
                </form:label>
            </td>
            <td>
                <form:input path="comment"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty port.service}">
                    <input type="submit"
                           value="<spring:message text="Edit Port"/>"/>
                </c:if>
                <c:if test="${empty port.service}">
                    <input type="submit"
                           value="<spring:message text="Add Port"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
