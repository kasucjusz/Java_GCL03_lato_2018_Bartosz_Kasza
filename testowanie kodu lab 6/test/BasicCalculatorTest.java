import org.junit.*;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;



import static org.junit.Assert.*;

public class BasicCalculatorTest extends BasicCalculator {
    float result;

    private BasicCalculator calculate;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeClass
    public static void onceExecutedBeforeAll(){
        System.out.println("@BeforeClass: onceExecutedBeforeAll BASIC");
    }

    @Before
    public void setUp() throws Exception {

         calculate= new BasicCalculator();
        System.out.println("@Before: using Basic Calculator");


    }

@After
public void finish() throws  Exception{
        calculate=null;
    System.out.println("@After: cleaning after Basic Calculator");


}

    @AfterClass
    public static void onceExecutedAfterAll() {
        System.out.println("@AfterClass: onceExecutedAfterAll BASIC");
    }




    @Test
    public void calculateAssertSum() {

        assertEquals(5.0, calculate.calculateSum(2,3),0.0001);
        assertEquals(321, calculate.calculateSum(150,171),0.0001);
        assertEquals(-4577, calculate.calculateSum(-10,-4567),0.0001);


    }

    @Test
    public void testSum()
    {
     calculateSum(3,2);
     calculateSum(150,171);
     calculateSum(-10,-4567);
    }

    @Test
    public void isNotNull()
    {
        assertNotNull("object calculator is not null",calculate);

    }



    /////////////////////////////////////////// 8
///////////RECZNE TESTY////////////////////
///////////////////////////////////////////


    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void calculateAssertDifference() {

        assertEquals(3,calculate.calculateDifference(5,2),0.00001);
        assertEquals(4,calculate.calculateDifference(6,2),0.00001);
        assertEquals(-1,calculate.calculateDifference(2,3),0.00001);

    }
    @Test
    public void testDiff()
    {
        calculateDifference(5,2);
        calculateDifference(6,2);
        calculateDifference(2,3);
    }

    @Test
    public void calculateAssertMultiplication() {
        assertEquals(10,calculate.calculateMultiplication(5,2),0.00001);
        assertEquals(25,calculate.calculateMultiplication(5,5),0.00001);
        assertEquals(-100,calculate.calculateMultiplication(-50,2),0.00001);


    }
    @Test
    public void testMultiplication()
    {
        calculateMultiplication(5,2);
        calculateMultiplication(5,5);
        calculateMultiplication(-50,2);
    }

    @Test
    public void calculateAsserDivision() {
        assertEquals(1,calculate.calculateDivision(6,6),0.0000001);
        assertEquals(1,calculate.calculateDivision(-6,-6),0.0000001);
        assertEquals(90,calculate.calculateDivision(90,1),0.0000001);

    }
    @Test
    public void testDivision()
    {
        calculateDivision(6,6);
        calculateDivision(-6,-6);
        calculateDivision(90,1);
    }

    @Test
    public void throwIllegalArgIfBIsZero()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("second argument can not be zero");
        calculate.calculateDivision(3,0);
    }

    @Test
    public void calculateAssertPow() {
        assertEquals(81,calculate.calculatePow(9,2),0.0000001);
        assertEquals(4,calculate.calculatePow(2,2),0.0000001);
        assertEquals(-1000,calculate.calculatePow(-10,3),0.0000000001);
    }
    @Test
    public void testPow()
    {
        calculatePow(9,2);
        calculatePow(2,2);
        calculatePow(-10,3);
    }

    @Test
    public void calculateAssertSqlr() {
        assertEquals(9,calculate.calculateSqlr(81),0.0000001);
        assertEquals(2,calculate.calculateSqlr(4),0.0000001);
        assertEquals(132,calculate.calculateSqlr(17424),0.0000001);

    }

    @Test
    public void throwIllegalIfArgIsNegative()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Argument is negative");
        calculate.calculateSqlr(-120);

    }
    @Test
    public void testSqlr()
    {
        calculateSqlr(81);
        calculateSqlr(4);
        calculateSqlr(17424);
    }
}