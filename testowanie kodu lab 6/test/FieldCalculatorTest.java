import org.junit.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

public class FieldCalculatorTest extends FieldCalculator {

private double delta=0.000001;
private double deltaForCircle=0.1;
    private FieldCalculator calculate;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeClass
    public static void onceExecutedBeforeAll(){
        System.out.println("@BeforeClass: onceExecutedBeforeAll FIELD");
    }

    @Before
    public void setUp() throws Exception {
        calculate = new FieldCalculator();
        System.out.println("@Before: using Field Calculator");

    }

    @After
    public void tearDown() throws Exception {
calculate=null;
        System.out.println("@After: cleaning after Field Calculator");


    }

    @AfterClass
    public static void onceExecutedAfterAll() {
        System.out.println("@AfterClass: onceExecutedAfterAll FIELD");
    }


    @Test
    public void calculateAssertSquare() {
        assertEquals(81,calculate.calculateSquare(9),delta);
        assertEquals(4,calculate.calculateSquare(2),delta);
        assertEquals(100,calculate.calculateSquare(10),delta);

    }
    @Test
    public void testSquare()
    {
        calculateSquare(9);
        calculateSquare(2);
        calculateSquare(10);


    }

    @Test
    public void throwIllegalArgumentExceptionIfArgsAreNegativeForSquare()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Argument has to be positive");  //////TESTOWANIE CZY WYJATEK SE DZIALA
        calculate.calculateSquare(-2);
    }


        @Test
    public void calculateAssertCircle() {
        assertEquals(12.56,calculate.calculateCircle(2),deltaForCircle  );
        assertEquals(3.14,calculate.calculateCircle(1),deltaForCircle);
        assertEquals(78.5,calculate.calculateCircle(5),deltaForCircle);
    }

    @Test
    public void testCircle()
    {
        calculateCircle((float) 12.56);
        calculateCircle((float) 3.14);
        calculateCircle((float) 78.6);
    }
    @Test
    public void throwIllegalArgumentExceptionIfArgsAreNegativeForCircle()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Both arguments have to be positive");
        calculate.calculateCircle(-1);
    }







    @Test
    public void calculateAssertTriangle() {
        assertEquals(2,calculate.calculateTriangle(2,2),delta);
        assertEquals(9,calculate.calculateTriangle(9,2),delta);
        assertEquals(8,calculate.calculateTriangle(4,4),delta);
    }

    @Test
    public void testTriangle()
    {
        calculateTriangle(2,2);
        calculateTriangle(9,2);
        calculateTriangle(4,4);

    }

    @Test
    public void throwIllegalArgumentExceptionIfArgsAreNegativeForTriangle(){

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Both arguments are supposed to be positive");  //////TESTOWANIE CZY WYJATEK SE DZIALA
        calculate.calculateTriangle(-2,-2);

    }






    @Test
    public void calculateAssertRectangle() {
        assertEquals(4444,calculate.calculateRectangle(2222,2),delta);
        assertEquals(100,calculate.calculateRectangle(50,2),delta);
        assertEquals(120,calculate.calculateRectangle(3,40),delta);
    }

    @Test
    public void testRectangle()
    {
        calculateRectangle(2222,2);
        calculateRectangle(50,2);
        calculateRectangle(3,40);

    }
    @Test
    public void throwIllegalArgumentExceptionIfArgsAreNegativeForRectangle()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Both arguments have to be positive");
        calculate.calculateRectangle(-2,-2);
    }
    }
