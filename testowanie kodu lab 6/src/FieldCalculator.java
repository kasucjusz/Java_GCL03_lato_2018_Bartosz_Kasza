public class FieldCalculator {

    float calculateSquare(float a)
    {
        if(a<=0)
        {
            throw new IllegalArgumentException("Argument has to be positive");
        }
        else
        {
            return (float) Math.pow(a,2);

        }
    }

    float calculateCircle(float r)
    {
        if(r<=0)
        {
            throw new IllegalArgumentException("Both arguments have to be positive");
        }
        else
        {

            return (float) (Math.PI*Math.pow(r,2));


        }
    }

    float calculateTriangle(float a, float h)
    {
        if(a<=0||h<=0)
        {
            throw new IllegalArgumentException("Both arguments are supposed to be positive");
        }
        else
        {
            return (float) (0.5*a*h);

        }
    }

    float calculateRectangle(float a, float b)
    {
        if(a<=0||b<=0)
        {
            throw new IllegalArgumentException("Both arguments have to be positive");

        }
        else
        {
            return a*b;

        }
    }
}
