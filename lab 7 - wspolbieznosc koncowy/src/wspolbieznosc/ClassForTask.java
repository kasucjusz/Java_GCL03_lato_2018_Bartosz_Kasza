package wspolbieznosc;

public class ClassForTask implements Task {
    @Override
    public void run(int taskNumber) throws InterruptedException {
        Thread.sleep(10000);

    }
}



