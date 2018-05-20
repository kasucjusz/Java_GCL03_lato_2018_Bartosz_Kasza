package wspolbieznosc;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;



public class Worker {


    String workerName;
    public int taskNumber=0;
    final ExecutorService executor = Executors.newFixedThreadPool(1);
    private final AtomicBoolean running = new AtomicBoolean(false);
    public LinkedBlockingQueue<QueueContainer> allTasks;
    Thread worker;
    public WorkerListener listener;

    Worker(String workerName)
    {
        this.workerName=workerName;

        allTasks=new LinkedBlockingQueue<QueueContainer>();
    }

    public void setListener(WorkerListener object)
    {
        listener=object;
    }

    public void enqueueTask(String taskName, Task task) throws InterruptedException {
        QueueContainer object=new QueueContainer(taskName,task);
        allTasks.put(object);
    }



    boolean isStarted()
    {
        if(running.get())
        {
            return true;
        }
        else return false;
    }


    public void stop()
    {
       // if(worker==null)
         //   return;


        if(!running.get())
            return;
        running.set(false);

        listener.onWorkerStoped();
        worker.interrupt();
      //  worker=null;

    }

    void doSpania(int time) throws InterruptedException {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start()
    {

       // if(worker!=null)
       // {
       //     return;
     //   }
        String name=("Worker name is "+workerName+" thread");
            if(running.get())
            return;
        running.set(true);


        worker=new Thread(name){
            @Override
            public void run()
            {
                listener.onWorkerStarted();
                while(running.get()==true) {

                    try {
                        QueueContainer object = allTasks.take();
                        listener.onTaskStarted(taskNumber, object.getTaskName());
                        object.getTask().run(taskNumber);
                        listener.onTaskCompleted(taskNumber, object.getTaskName());
                        taskNumber++;
                    } catch (InterruptedException e) {
                        break;

                    }

                }

            }
        };
        worker.start();
    }



}
