import java.util.*;
public class AddressBookSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        addNewContact();
    }

    public static void addNewContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First Name");
        String fName = sc.next();

        System.out.println("Enter Last Name");
        String lName = sc.next();

        System.out.println("Enter City");
        String city = sc.next();

        System.out.println("Enter State");
        String state = sc.next();

        System.out.println("Enter Email");
        String email = sc.next();

        System.out.println("Enter Zip");
        int zip = sc.nextInt();

        System.out.println("Enter Phone Number");
        int phone = sc.nextInt();

        AddressBook book1 = new AddressBook();
        Contacts contact1 = new Contacts(fName,lName,city,state,email,zip,phone);
        book1.addContact(contact1);
    }
}

class AddressBook{
    ArrayList<Contacts> arr;
    AddressBook(){
        arr = new ArrayList<>();
    }
    public void addContact(Contacts c){
        arr.add(c);
        System.out.println(c.fname+" "+c.lname+" added");
    }

}
class Contacts{
    String fname, lname, city, state, email;
    int zip, phone;
    Contacts(String first,String last,String city_add,String state_add,String mail,int zip_add, int phoneNo){
        fname = first;
        lname = last;
        city = city_add;
        state = state_add;
        email = mail;
        zip = zip_add;
        phone = phoneNo;
    }
}


