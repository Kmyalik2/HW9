import java.io.IOException;
import java.io.Serializable;

public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private Address address;

    public Person(){}
    public Person(String firstName, String lastName, Address address) {
        if (firstName == null || lastName == null || address == null){
            try {
                throw new NullFieldException("Person instance fields cannot be empty");
            } catch (NullFieldException e) {
                System.out.println(e.getMessage());
            }
        }
         else {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            PersonIOUtil.writePersons("NewFile.txt",this);
        }
    }


    public void setFirstName(String firstName) throws NullFieldException {
        if (firstName == null)
        {
            try {
                throw new NullFieldException("First Name cannot be empty");
            }
            catch (NullFieldException e) {
                System.out.println(e.getMessage());
            }
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) throws NullFieldException{
        if (lastName == null)
        {
            try {
                throw new NullFieldException("Last Name cannot be empty");
            }
            catch (NullFieldException e) {
                System.out.println(e.getMessage());
            }
        }
        this.lastName = lastName;
    }

    public void setAddress(Address address) throws NullFieldException {
        if (address == null)
        {
            try {
                throw new NullFieldException("Address cannot be empty");
            }
            catch (NullFieldException e) {
                System.out.println(e.getMessage());
            }

        }

        this.address = address;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Address getAddress() {
        return this.address;
    }

    @Override
    public String toString() throws NullFieldException {
        if (firstName == null || lastName == null || address == null) {
            try {
                throw new NullFieldException("Person instance fields cannot be empty");
            } catch (NullFieldException e) {
                return e.getMessage();
            }
        }
        return lastName.toUpperCase() + " " + firstName + ", Address=" + getAddress();
    }

}