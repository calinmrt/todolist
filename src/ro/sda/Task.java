package ro.sda;

import java.util.Objects;

public class Task {
    private String taskName;
    private boolean checked;

    private Task(Builder builder) {
        this.taskName = builder.taskName;
        this.checked = builder.checked;
    }

    public static Builder newTask() {
        return new Builder();
    }

    public String getTaskName() {
        return taskName;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Task(String taskName, boolean checked) {
        this.taskName = taskName;
        this.checked = checked;
    }

    public static final class Builder {
        private String taskName;
        private boolean checked;

        private Builder() {
        }

        public Task build() {
            return new Task(this);
        }

        public Builder taskName(String taskName) {
            this.taskName = taskName;
            return this;
        }

        public Builder checked(boolean checked) {
            this.checked = checked;
            return this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return taskName.equals(task.taskName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskName);
    }
}
