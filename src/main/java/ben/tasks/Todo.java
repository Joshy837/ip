package ben.tasks;

public class Todo extends Task {
  public Todo(boolean isDone, String description) {
    super(isDone, description);
  }

  @Override
  public String saveTask() {
    return "T | " + super.saveTask();
  }

  @Override
  public String toString() {
    return "[T]" + super.toString();
  }
}
