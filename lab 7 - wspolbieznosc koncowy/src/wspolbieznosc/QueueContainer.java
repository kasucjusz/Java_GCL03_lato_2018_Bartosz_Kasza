package wspolbieznosc;

public class QueueContainer {

   public Task task;
    public String taskName;

    QueueContainer(String taskName, Task task)
    {
        this.taskName=taskName;
        this.task=task;
    }

    //settery


    public Task getTask() {
        return task;
    }

    public String getTaskName() {
        return taskName;
    }
}
