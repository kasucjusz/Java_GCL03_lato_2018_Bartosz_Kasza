package AllClasses;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Random;

import static org.junit.Assert.*;

public class ExtendedSystemCacheTest {
    SystemCache cache1;
    SystemCache cache2;
    ScatterSystem system;
    static int i = 0;
    File file= new File("C:\\\\Users\\\\barto\\\\IdeaProjects\\\\ObslugaPlikówIStrumieni\\\\exportViaFile.csv");

    ExtendedSystemCache ex1;
    ExtendedSystemCache ex2;
    double[] input={1,2,3,4,56};

    @Before
    public void setUp() throws Exception {

       ex1=new ExtendedSystemCache();
       ex2= new ExtendedSystemCache();


    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void exporting()
    {

        Double output=system.makeOperation(input);
        


    }
/*
    @Test
    public void exportCSV() {
    }

    @Test
    public void exportCSV1() {
    }

    @Test
    public void exportCSV2() {
    }

    @Test
    public void importCSV() {
    }

    @Test
    public void importCSV1() {
    }

    @Test
    public void importCSV2() {
    }

    @Test
    public void serialize() {
    }

    @Test
    public void serialize1() {
    }

    @Test
    public void serialize2() {
    }

    @Test
    public void deserialize() {
    }

    @Test
    public void deserialize1() {
    }

    @Test
    public void deserialize2() {
    }

    @Test
    public void deserialize3() {
    }
    */
}