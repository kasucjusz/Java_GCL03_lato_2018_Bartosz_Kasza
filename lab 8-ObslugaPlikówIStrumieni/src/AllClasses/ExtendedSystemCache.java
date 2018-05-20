package AllClasses;

import java.io.*;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;


public class ExtendedSystemCache extends SystemCache implements Serializable {


    private static final String NEW_LINE_SEPARATOR = "\n";
    SystemCache cache;
    double[] tab;
    double[] returnTab;
    //double[] tabForReading=0;
    double outputForReading=1;

    public ExtendedSystemCache(SystemCache cache, double[] tab)
    {

        this.cache=cache;
        this.tab=tab;
    }
    public ExtendedSystemCache(SystemCache cache)
    {
        this.cache=cache;
    }
    public ExtendedSystemCache()
    {
        this(new SystemCache());
    }

                           ////////////////////////////////////////////////////EXPORTY

    void exportCSV( String path ) throws Exception
    {
        double[] input = tab;
        Double output=cache.get(input);
        FileWriter pw = new FileWriter(path,true);
        StringBuilder sb = new StringBuilder();


        for(int i=0; i<3; i++)
        {
            if (i < 2) {
                sb.append(input[i]);
                sb.append('\n');

                pw.write(sb.toString());
                pw.flush();
            }
            else {
                sb.append(output);
                sb.append('\n');
                sb.append('\n');

                pw.write(sb.toString());
                pw.close();
            }

        }
    }

    void exportCSV( File file ) throws Exception
    {
        double[] input = tab;
        Double output=cache.get(input);
        FileWriter pw = new FileWriter(file,true);
        StringBuilder sb = new StringBuilder();


        for(int i=0; i<3; i++)
        {
            if (i < 2) {
                sb.append(input[i]);
                sb.append('\n');

                pw.write(sb.toString());
                pw.flush();
            }
            else {
                sb.append(output);
                sb.append('\n');
                sb.append('\n');

                pw.write(sb.toString());
                pw.close();
            }

        }
    }
    void exportCSV( OutputStream stream ) throws Exception
    {
        double[] input = tab;
        Double output=cache.get(input);
        FileWriter pw = new FileWriter(String.valueOf(stream),true);
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<3; i++)
        {
            if (i < 2) {
                sb.append(input[i]);
                sb.append('\n');

                pw.write(sb.toString());
                pw.flush();
            }
            else {
                sb.append(output);
                sb.append('\n');
                sb.append('\n');

                pw.write(sb.toString());
                pw.close();
            }

        }
    }
                       //////////////////////////////////////////////////////////IMPORTY
        void importCSV(String path) throws IOException {
        ////METODA FILE READEREM OMAWIA POSLUSZENSTWA

        File file = new File(path);
        Scanner in = new Scanner(file);

        int i=1;
        double x;
        double[]tab= new double[2];
        while(in.hasNext()) {
            if (i % 3 == 0) {
                x = Double.parseDouble(in.next());
                System.out.println(x);
                cache.put( tab, x);
                i=0;

            }
            else {
                if (i % 2 == 0) {
                    x = Double.parseDouble(in.next());
                    System.out.println(x);
                    tab[1] = x;
                } else {
                    x = Double.parseDouble(in.next());
                    System.out.println(x);
                    tab[0] = x;
                }
            }
            i++;
        }
        in.close();
    }

    void importCSV(File file) throws IOException {
        ////METODA FILE READEREM OMAWIA POSLUSZENSTWA

        File plik = new File(String.valueOf(file));
        Scanner in = new Scanner(plik);

        int i=1;
        double x;
        double[]tab= new double[2];
        while(in.hasNext()) {
            if (i % 3 == 0) {
                x = Double.parseDouble(in.next());
                System.out.println(x);
                cache.put( tab, x);
                i=0;

            }
            else {
                if (i % 2 == 0) {
                    x = Double.parseDouble(in.next());
                    System.out.println(x);
                    tab[1] = x;
                } else {
                    x = Double.parseDouble(in.next());
                    System.out.println(x);
                    tab[0] = x;
                }
            }
            i++;
        }
        in.close();
    }
    void importCSV(FileInputStream stream) throws IOException {
        ////METODA FILE READEREM OMAWIA POSLUSZENSTWA

        File plik = new File(String.valueOf(stream));
        Scanner in = new Scanner(plik);

        int i=1;
        double x;
        double[]tab= new double[2];
        while(in.hasNext()) {
            if (i % 3 == 0) {
                x = Double.parseDouble(in.next());
                System.out.println(x);
                cache.put( tab, x);
                i=0;

            }
            else {
                if (i % 2 == 0) {
                    x = Double.parseDouble(in.next());
                    System.out.println(x);
                    tab[1] = x;
                } else {
                    x = Double.parseDouble(in.next());
                    System.out.println(x);
                    tab[0] = x;
                }
            }
            i++;
        }
        in.close();
    }

                       ///////////////////////////////////////////////////////////SERIALIZACJE
    void serialize( String path ) throws IOException
    {
        FileOutputStream fos=new FileOutputStream(path);
        serialize(fos);
        fos.close();

    }
    void serialize( FileOutputStream file) throws IOException
    {
        ObjectOutputStream oos=new ObjectOutputStream(file);
        serialize(oos);
        oos.close();
        ///przerobic zamykanie try with finally


    }
    void serialize(ObjectOutputStream stream) throws IOException {
        stream.writeObject(cache);
    }

                     ///////////////////////////////////////////////////////////DESERIALIZACJE


    void deserialize(String path)
    {
        try
        {

            FileInputStream file = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(file);

            cache = (SystemCache) in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");

        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    void deserialize(FileInputStream file1) throws IOException
    {
        try
        {

            ObjectInputStream in = new ObjectInputStream(file1);

            cache = (SystemCache) in.readObject();

            in.close();
            file1.close();

            System.out.println("Object has been deserialized ");

        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    void deserialize(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        try {
            cache = (SystemCache) stream.readObject();
            System.out.println("Object has been deserialized ");
stream.close();

        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
