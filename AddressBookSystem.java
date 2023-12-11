import java.util.*;
public class AddressBookSystem {
    HashMap<String, AddressBook> mp;
    AddressBookSystem(){
        mp = new HashMap<>();
    }
    
    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");
        AddressBookSystem system = new AddressBookSystem();
        addAddressBooks(system);
    }

    public static void addAddressBooks(AddressBookSystem system) {
        System.out.println("How many address books you want to add");
        Scanner sc=new Scanner(System.in);
        int num = sc.nextInt();
        for(int i=0;i<num;i++){
            System.out.println("Enter name of address book "+(i+1));
            String name = sc.next();
            AddressBook book = helperAddAddressBooks();
            system.mp.put(name,book);
        }
    }

    public static AddressBook helperAddAddressBooks(){
        AddressBook book1 = new AddressBook();
        System.out.println("How many contacts you want to add");
        Scanner sc=new Scanner(System.in);
        int num = sc.nextInt();
        for(int i=0;i<num;i++){
            addNewContact(book1);
        }
        return book1;
    }
    public static void printAllContacts(AddressBook book){
        for(Contacts c:book.arr){
            System.out.println(c.fname+" "+c.lname+" , "+c.phone+" , "+c.city+" , "+c.state+" , "+c.email+" , "+c.zip);
        }
    }
    public static void  deleteContact(AddressBook book){
        System.out.println("Enter the name whose contact to delete");
        Scanner sc = new Scanner(System.in);
        String fname = sc.next();
        String lname = sc.next();
        for (Contacts c: book.arr){
            if(c.fname.equals(fname) && c.lname.equals(lname)){
                book.arr.remove(c);
            }
        }
    }
    public static void editContact(AddressBook book1){
        System.out.println("Enter name whose contact you want to edit");
        Scanner sc = new Scanner(System.in);
        String fname = sc.next();
        String lname = sc.next();
        System.out.println("Enter which option you want to edit");
        System.out.println("1)City 2)State 3)Email 4)Zip 5)Phone");
        int choice = sc.nextInt();
        for(Contacts c : book1.arr){
            if(c.fname.equals(fname) && c.lname.equals(lname)){
                switch (choice){
                    case 1:
                        System.out.println("Enter edited city :");
                        c.city = sc.next();
                        break;
                    case 2:
                        System.out.println("Enter edited state :");
                        c.state = sc.next();
                        break;
                    case 3:
                        System.out.println("Enter edited email :");
                        c.email = sc.next();
                        break;
                    case 4:
                        System.out.println("Enter edited zip :");
                        c.zip = sc.nextInt();
                        break;
                    case 5:
                        System.out.println("Enter edited phone number :");
                        c.phone = sc.nextInt();
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        }
    }

    public static void addNewContact(AddressBook book1) {
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
