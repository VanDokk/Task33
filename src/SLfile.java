import java.io.*;
import java.util.ArrayList;

public class SLfile
{
    public static void saveFile(String dataSquare, String dataPrism)
    {
        try (FileWriter wr = new FileWriter(Long.toString(System.currentTimeMillis()), false))
        {
            wr.write(dataSquare);
            wr.write(dataPrism);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList loadFile(String fileName)
    {
        ArrayList objects = new ArrayList();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String[] line = new String[3];
            line = reader.readLine().split("\\|");
            objects.add(new Square(Integer.parseInt(line[1])));
            objects.add(new SquarePrism(Integer.parseInt(line[2]), Integer.parseInt((line[3]))));

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return objects;
    }
}