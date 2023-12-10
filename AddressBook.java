import java.util.ArrayList;

public class AddressBook {
        ArrayList<Contacts> arr;
        AddressBook(){
            arr = new ArrayList<>();
        }
        public void addContact(Contacts c){
            arr.add(c);
            System.out.println(c.fname+" "+c.lname+" added");
        }
}
