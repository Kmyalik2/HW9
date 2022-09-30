import java.io.*;
import java.util.ArrayList;

public class PersonIOUtil {
    public static void writePersons(String fileName, Person person) {
        try (FileWriter writer = new FileWriter(fileName,true))
        {
            String text = String.valueOf(person) + "\n";
            writer.write(text);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
   public static void readPersons(String fileName) throws IOException, EmptySourceFileException {
       try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
           ArrayList<String> personsArray = new ArrayList<>();
           String s = reader.readLine();
           if ( s == null) {
               throw new EmptySourceFileException( fileName + ": The file is empty");
           }
           int i = 0;
           while (s != null) {
               personsArray.add(s);
               System.out.println(i + ": " + personsArray.get(i));
               i++;
               s = reader.readLine();
           }
        }
        catch (EmptySourceFileException | FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
   }
}

