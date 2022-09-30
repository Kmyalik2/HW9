import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException,NullFieldException, EmptySourceFileException {

        Person person1 = new Person(null, "null", new Address("Minsk", "Backer Street", 12));
        Person person2 = new Person("Jane", "White", new Address("Minsk", "Independence", 12));
        Person person3 = new Person("Kate", "Bow", new Address("Moskow","New Street",12));

        // check on not null exception for the set methods
        person2.setAddress(null);
        person1.setFirstName(null);

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);

        PersonIOUtil.readPersons("NewFile.txt");

        //to demonstrate the empty file exception
        FileWriter writer = new FileWriter("NewFile2.txt");
        PersonIOUtil.readPersons("NewFile2.txt");

        //to demonstrate file not found exception
        PersonIOUtil.readPersons("NewFile3.txt");


    }
}