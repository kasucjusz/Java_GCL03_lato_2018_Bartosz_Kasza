package AllClasses;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class SystemCache implements Serializable
{
    private HashMap<Parameter, Double> cache = new HashMap<>();
    public void put( double[] input, double output )
    {
        this.cache.put( new Parameter( input ), output );
    }
    public Double get( double[] input )
    {
        return this.cache.get( new Parameter( input ) );
    }
    public void show() {
        System.out.println(cache.values());
        System.out.println(cache.size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemCache that = (SystemCache) o;
        return Objects.equals(cache, that.cache);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cache);
    }

    public class Parameter implements Serializable
    {
        private double[] values;
        public Parameter( double[] values )
        {
            this.values = values;
        }
        @Override
        public int hashCode()
        {
            return 31 + Arrays.hashCode( this.values );
        }

        @Override
        public boolean equals( Object obj )
        {
            if ( this == obj )
                return true;
            if ( obj == null )
                return false;
            if ( this.getClass() != obj.getClass() )
                return false;
            Parameter other = (Parameter) obj;
            if ( !Arrays.equals( this.values, other.values ) )
                return false;
            return true;
        }
    }
}