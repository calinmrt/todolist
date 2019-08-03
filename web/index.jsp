<%@ page import="ro.sda.model.TaskRep" %>
<%@ page import="ro.sda.model.Task" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Collection" %><%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 27-Jul-19
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%!
    public void jspInit() {
    }
%>

<html>
<head>
    <title>TO DO</title>
    <link rel="stylesheet" href="stilizare.css">
    <script src="actions.js"></script>
</head>
<body>

<div id="list">
    <h3 style="color: yellowgreen">My To Do List</h3>
    <form action="${pageContext.request.contextPath}/add-new" method="post" id="sendCompleteForm">
        <input type="hidden" name="action" value="complete"/>
        <table><%
            Collection<Task> tasks = TaskRep.getInstance().getAllTask();
            request.setAttribute("tasks", tasks);
        %>
            <c:forEach var="task" items="${tasks}">
                <tr>
                    <td>
                        <c:out value="${task.taskName}"/>
                    </td>
                    <td>
                        <c:if test="${!task.checked}">
                            <input type="checkbox" name="checked" class="check"
                                   onclick="changeCompleted('${task.taskName}')">
                        </c:if>
                    </td>

                </tr>

            </c:forEach>
        </table>
    </form>
</div>

<br/>
<div id="form">

    <form action="${pageContext.request.contextPath}/add-new" method="post">
        <input type="hidden" name="action" value="add">
        <label for="actionName">Action: </label>

        <input type="text" name="actionName" id="actionName"/>
        <input type="submit" value="Add" class="submit"/>
    </form>
</div>

</body>
</html>
