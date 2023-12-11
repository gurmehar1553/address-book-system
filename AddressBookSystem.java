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
        HashMap<String,ArrayList<String>> cityToPerson = new HashMap<>();
        HashMap<String,ArrayList<String>> stateToPerson = new HashMap<>();
        searchPerson(book1,"rjp",cityToPerson,stateToPerson,"pb");
        viewPersonForCityState(book1,"rjp",cityToPerson,stateToPerson,"pb");
        countByCity(book1,"rjp",cityToPerson);
        countByState(book1,"pb",stateToPerson);
    }
    /*
    Method to
    add multiple address books
    to one address book system
     */
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
    public static void countByCity(AddressBook book1, String city, HashMap<String, ArrayList<String>> cityToPerson) {
        ArrayList<String> listPersonCity = cityToPerson.get(city);
        System.out.println("Number of persons in "+city+" : "+listPersonCity.size());
    }
    public static void countByState(AddressBook book1, String state, HashMap<String, ArrayList<String>> stateToPerson) {
        ArrayList<String> listPersonState = stateToPerson.get(state);
        System.out.println("Number of persons in "+state+" : "+listPersonState.size());
    }


    public static void viewPersonForCityState(AddressBook book1, String city, HashMap<String,
            ArrayList<String>> cityToPerson, HashMap<String, ArrayList<String>> stateToPerson, String state) {

        ArrayList<String> listPersonCity = cityToPerson.get(city);
        System.out.print(city+" : ");
        for (String s:listPersonCity){
            System.out.print(s+",");
        }
        System.out.println();
        ArrayList<String> listPersonState = stateToPerson.get(state);
        System.out.print(state+" : ");
        for (String s:listPersonState){
            System.out.print(s+" , ");
        }
        System.out.println();
    }

    public static void printAllContacts(AddressBook book){
        for(Contacts c:book.arr){
            System.out.println(c.fname+" "+c.lname+" , "+c.phone+" , "+c.city+" , "+c.state+" , "+c.email+" , "+c.zip);
        }
    }
    public static void searchPerson(AddressBook book,String city,HashMap<String,ArrayList<String>> cityToPerson,
                                    HashMap<String,ArrayList<String>> stateToPerson,String state){
        System.out.println("Persons who live in this city:");
        ArrayList<String> listPersonCity=new ArrayList<>();
        ArrayList<String> listPersonState=new ArrayList<>();
        for (Contacts c:book.arr){
            if (c.city.equals(city)){
                listPersonCity.add(c.fname);
            }
            if (c.state.equals(state)){
                listPersonState.add(c.fname);
            }
        }
        cityToPerson.put(city,listPersonCity);
        stateToPerson.put(state,listPersonState);
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
