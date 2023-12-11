import java.util.*;
import java.util.stream.Collectors;

public class AddressBookSystem {
    static HashMap<String, AddressBook> mp;
    static HashMap<String,ArrayList<String>> cityOrStateToPerson;
    AddressBookSystem(){
        mp = new HashMap<>();
        cityOrStateToPerson = new HashMap<>();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        AddressBookSystem system = new AddressBookSystem();
        addAddressBooks(system);
        System.out.println("Number of persons in a particular city or state : "+searchPersonInCityOrState());
        viewPersonForCityState();
    }

    public static int searchPersonInCityOrState() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter city name in which you want to search people:");
        String city = sc.next();
        System.out.println("Enter state name in which you want to search people:");
        String state = sc.next();
        int countOfPersons = 0;
        ArrayList<String> personsInCityOrState = new ArrayList<>();
        ArrayList<List<Contacts>> listPersonCityState=new ArrayList<>();
        List<Contacts> listPersons;
        for (Map.Entry<String,AddressBook> m: mp.entrySet()){
            AddressBook book = m.getValue();
            listPersons = (book.arr.stream()
                    .filter(contact -> (contact.city.equals(city) || contact.state.equals(state)))
                    .collect(Collectors.toList()));
            listPersonCityState.add(listPersons);
        }
        for (List<Contacts> l:listPersonCityState){
            for (Contacts c:l){
                personsInCityOrState.add(c.fname);
                countOfPersons++;
            }
        }
        cityOrStateToPerson.put(city+" or "+state,personsInCityOrState);
        return countOfPersons;
    }
    /*
    Method to
    add multiple address books
    to one address book system in sorted order
     */
    public static void addAddressBooks(AddressBookSystem system) {
        System.out.println("How many address books you want to add");
        Scanner sc=new Scanner(System.in);
        int num = sc.nextInt();
        for(int i=0;i<num;i++){
            System.out.println("Enter name of address book "+(i+1));
            String name = sc.next();
            AddressBook book = helperAddAddressBooks();
            Collections.sort(book.arr,Comparator.comparing(contacts -> contacts.fname));
            mp.put(name,book);
            printAllContacts(book);
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

    public static void viewPersonForCityState() {
        for (Map.Entry<String,ArrayList<String>> m: cityOrStateToPerson.entrySet()){
            System.out.println(m.getKey()+" -> "+m.getValue());
        }
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
    /*
    Method to edit contacts
    by taking user's choice to edit
    1- City, 2 - State, 3 - Email, 4 - Zip, 5 - Phone
    */
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
    /*
    Method to Add new Contacts
    and checks if already it exists
    gives the desired message
    */
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

        for (Contacts c:book1.arr){
            if (c.fname.equals(fName) && c.lname.equals(lName)){
                System.out.println("This contact already exist");
                return;
            }
        }
        Contacts contact1 = new Contacts(fName,lName,city,state,email,zip,phone);
        book1.addContact(contact1);
    }
}
