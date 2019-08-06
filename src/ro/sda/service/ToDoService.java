package ro.sda.service;

import ro.sda.model.Task;
import ro.sda.model.TaskRep;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class ToDoService extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String actionName = req.getParameter("actionName");
        TaskRep.getInstance()
                .addTask(Task.newTask()
                        .checked(false)
                        .taskName(actionName)
                        .build());

        resp.sendRedirect(req.getContextPath() + "/index.jsp");

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actionName = req.getParameter("actionName");
        Optional<Task> task = TaskRep.getInstance().findTask(actionName);
        task.ifPresent(item -> item.setChecked(!item.isChecked()));
    }
}
