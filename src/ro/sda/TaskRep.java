package ro.sda;

import javax.servlet.http.HttpServlet;
import java.util.*;

public final class TaskRep {
    public static TaskRep instance;

    private Set<Task> taskList = new HashSet<>();

    private TaskRep() {
        addTask(Task.newTask().taskName("spala masina").checked(false).build());
        addTask(Task.newTask().taskName("ia paine").checked(false).build());
        addTask(Task.newTask().taskName("spala hainele").checked(true).build());
        addTask(Task.newTask().taskName("cumpara portocale").checked(false).build());
    }

    // singleton
    public static TaskRep getInstance() {
        if (instance == null) {
            instance = new TaskRep();
        }
        return instance;
    }

    public Collection<Task> getAllTask() {
        return Collections.unmodifiableCollection(this.taskList);
    }


    public Optional<Task> findTask(String s) {
        return taskList.stream()
                .filter(task -> task.getTaskName().equals(s))
                .findFirst();
    }

    public void addTask(Task task) {
        taskList.add(task);
    }


}
//TODO add task, set completed
