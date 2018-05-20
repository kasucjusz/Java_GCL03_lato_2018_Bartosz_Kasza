package AllClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {


        ////FILE OUTPUT STTREAM
        /////

        ScatterSystem system = new ScatterSystem(); // można umieścić wewnątrz dowolną funkcję matematyczną
        SystemCache cache = new SystemCache();


        Random r = new Random();
        double[] tab = new double[2];
        for(int i=0;i<2;i++)
        {
            tab[i]=r.nextDouble();
        }

        double[] input = tab;
        Double output = cache.get( input );

        if( output == null )
        {
            output = system.makeOperation( input );
            cache.put( input, output );
        }

        ExtendedSystemCache extension = new ExtendedSystemCache(cache, input);
        File file= new File("C:\\\\Users\\\\barto\\\\IdeaProjects\\\\ObslugaPlikówIStrumieni\\\\exportViaFile.csv");
        FileOutputStream fileForSerialization= new FileOutputStream("C:\\\\Users\\\\barto\\\\IdeaProjects\\\\ObslugaPlikówIStrumieni\\\\forSerialization.txt");

       FileInputStream fileForDeserialization=new FileInputStream("C:\\\\Users\\\\barto\\\\IdeaProjects\\\\ObslugaPlikówIStrumieni\\\\forSerialization.txt");
       extension.exportCSV(file);
       extension.serialize(fileForSerialization);
       extension.deserialize(fileForDeserialization);
        extension.importCSV(file);
        ExtendedSystemCache extension1= new ExtendedSystemCache(cache, input);



      //extension.exportCSV("C:\\Users\\barto\\IdeaProjects\\ObslugaPlikówIStrumieni\\exportViaPath.csv");
      //  extension.serialize("serializationViaPath.txt");
       // extension.deserialize("serializationViaPath.txt");
      // extension.importCSV("C:\\Users\\barto\\IdeaProjects\\ObslugaPlikówIStrumieni\\exportViaPath.csv");

        //ExtendedSystemCache extension1=new ExtendedSystemCache();
        //extension.importCSV("testowy.csv");

      //  extension1.get(input);
        //nie koniecznie txt co do serializacji






    }
}


