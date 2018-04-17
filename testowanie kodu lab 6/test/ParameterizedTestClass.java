
import java.util.Arrays;
import java.util.Collection;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedTestClass{
    private float inputNumber, inputNumber2, inputExpected;
    private BasicCalculator classUnderTest;
    @Before
    public void initialize() {
        classUnderTest=new BasicCalculator();
    }
    public  ParameterizedTestClass(float inputNumber, float inputNumber2, float inputExpected){
        this.inputNumber = inputNumber;
        this.inputNumber2=inputNumber2;
        this.inputExpected=inputExpected;
    }

    @Parameterized.Parameters
    public static Collection testingSum(){
        return Arrays.asList(new Object[][]{
                {0,0,0},
                {6,7,13},
                {-1,5,4},
                {100,100,200},
                {32,4,36}
        });
    }

    @Test
    public void testSumParametrized(){
        assertEquals(inputExpected,classUnderTest.calculateSum(inputNumber,inputNumber2),0);
    }

    @After
    public void cleanUp()
    {
        classUnderTest=null;
    }

}
