import java.io.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException, NullFieldException, EmptySourceFileException {

        Person person1 = new Person(null, "null", new Address("Minsk", "Backer Street", 12));
        Person person2 = new Person("Jane", "White", new Address("Minsk", "Independence", 12));
        Person person3 = new Person("Kate", "Bow", new Address("Moskow", "New Street", 12));

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

        // HW10 - Task1

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new java.io.FileOutputStream("state.bin"));
            oos.writeObject(new Person("Name1", "Surname1", new Address("Minsk", "Street1", 1)));
            oos.flush();
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new java.io.FileInputStream("state.bin"));
            System.out.println("Person2 deserialized: " + (Person) ois.readObject());
            ois.close();

        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }

       //HW10 - files list
       writeFolderFiles("."); // у меня этот метод выдаёт null в консоле, при этом в файл вроде всё правильно записыват, не могу понять почему null
    }


    public static void writeFolderFiles (String pathname) throws NullPointerException {
        try (FileWriter writer = new FileWriter("files.txt", true)) {
            File path = new File(pathname);
            File[] list = path.listFiles();
            String s;
            for (int j = 0; j < list.length; j++) {
                    if (list[j].isDirectory()) {
                        writeFolderFiles(list[j].getName());
                    } else {
                        s = list[j].getName() + '\n';
                        writer.write(s);
                    }
                }
            }
        catch (IOException | NullPointerException e) {
            System.out.println(e.getMessage());
            }
        }
    }

