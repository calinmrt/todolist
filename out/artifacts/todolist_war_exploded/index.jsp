<%@ page import="ro.sda.TaskRep" %>
<%@ page import="ro.sda.Task" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Collection" %><%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 27-Jul-19
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>TO DO</title>
    <link rel="stylesheet" href="stilizare.css">
</head>
<body>

<div id="list">
    <h3>My To Do List</h3>
    <form>
        <table><%
          if (request.getMethod().equalsIgnoreCase("post")) {
            String t = request.getParameter("tName");
            TaskRep.getInstance().addTask(Task.newTask().taskName(t).checked(false).build());
          }
        %>


            <%

                Collection<Task> tasks = TaskRep.getInstance().getAllTask();
                for (Task task : tasks) {
            %>
            <tr>
                <td><%=task.getTaskName()%>
                </td>
                <td class="checkBoxes"><input type="checkbox" onclick="(......)"
                                              name="<%=task.getTaskName()%>" <%=task.isChecked() ? "checked" : ""%>>
                  //TODO functia in java script
                </td>

            </tr>

            <%
                }
            %>
        </table>
    </form>
</div>

<br/>
<div id="form">
    <form action="index.jsp" method="post">
        Add new task: <input type="text" name="tName">
        <input type="submit" value="Add">
    </form>
</div>

</body>
</html>
