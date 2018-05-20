package wspolbieznosc;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Worker wrk=new Worker("Rafał");






        wrk.setListener(new WorkerListener() {
            @Override
            public void onWorkerStarted() {
                System.out.println("The work has been started");
            }

            @Override
            public void onWorkerStoped() {
                System.out.println("The work has been stopped");

            }

            @Override
            public void onTaskStarted(int taskNumber, String taskName) {
                System.out.println("The task " + taskName + " "+ taskNumber+" has been started");

            }

            @Override
            public void onTaskCompleted(int taskNumber, String taskName) {
                System.out.println("The task " + taskName + " "+ taskNumber+" is now completed");


            }
        });



        wrk.enqueueTask("0",new ClassForTask());
        wrk.enqueueTask("1",new ClassForTask());
        wrk.enqueueTask("2",new ClassForTask());

        wrk.enqueueTask("3", new ClassForTask100());
        wrk.enqueueTask("4", new ClassForTaskYield());

        wrk.start();

        //System.out.println("Spimy 15s");

        wrk.enqueueTask("0",new ClassForTask());
        wrk.enqueueTask("0",new ClassForTask());
        wrk.enqueueTask("0",new ClassForTask());
        wrk.enqueueTask("0",new ClassForTask());
        wrk.enqueueTask("0",new ClassForTask());


        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {//troche oszukiwanko, bo trzeba czekac dlugo zanim mozna wywolac stopa, inaczej wyrzuca bledy...
            e.printStackTrace();
        }

        wrk.stop();

        System.out.println("End of the main thread");











    }
}
