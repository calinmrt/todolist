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

        String action = req.getParameter("action");
        String actionName = req.getParameter("actionName");
        switch (action) {
            case "add":
                TaskRep.getInstance()
                        .addTask(Task.newTask()
                                .checked(false)
                                .taskName(actionName)
                                .build());
                break;
            case "complete":
                Optional<Task> task = TaskRep.getInstance().findTask(actionName);
                task.ifPresent(item -> item.setChecked(true));
                break;
        }






        resp.sendRedirect(req.getContextPath() + "/index.jsp");

    }

}
