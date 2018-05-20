package wspolbieznosc;

public class ClassForTaskYield implements Task{

    @Override
    public void run(int taskNumber) throws InterruptedException {

        long time=System.currentTimeMillis();
        long end=time+10000;
        while(System.currentTimeMillis()<end)
        {

            Thread.yield();//daje procesorowi do zrozumienia, zeby przestał kontrolowac dany tread, i odlozyl go na koneic kolejki
        }
    }
}
