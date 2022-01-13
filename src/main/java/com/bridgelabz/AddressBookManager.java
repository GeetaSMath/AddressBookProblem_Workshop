package com.bridgelabz;

import com.bridgelabz.com.bridgelabz.addressbookcontact;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookManager {
    public ArrayList<addressbookcontact> detailedEntries = new ArrayList<>();
   public Map<String, ArrayList<addressbookcontact>> book = new HashMap<>();
    public Map<String, ArrayList<addressbookcontact>> cityList = new HashMap<>();
    public Map<String, ArrayList<addressbookcontact>> stateList = new HashMap<>();

    Scanner sc = new Scanner(System.in);
    public void callAddressBookBluePrint(){
        //Enter the Book name before detailed Entries
        System.out.println("Enter Address Book Name");
        String BookName = sc.next();
        //Enter the detailed Entries
        System.out.println("Enter you first name");
        String FirstName = sc.next();
        System.out.println("Enter you last name");
        String LastName = sc.next();
        sc.nextLine();
        System.out.println("Enter you Address name");
        String Address = sc.nextLine();
        System.out.println("Enter you zip ");
        int Zip = sc.nextInt();
        System.out.println("Enter you city name");
        String City = sc.next();
        System.out.println("Enter you state name");
        String State = sc.next();
        sc.nextLine();
        System.out.println("Enter you phone number");
        long PhoneNumber = sc.nextLong();
        sc.nextLine();
        System.out.println("Enter you email name");
        String Email = sc.nextLine();

        //Checking name of the person to avoid duplicate Entries
        if (check(FirstName)){
            callAddressBookTemp(BookName, FirstName, LastName, Address, City, Zip, State, PhoneNumber, Email);
            System.out.println("AddressBookBluePrint{" + "firstName='" + FirstName + '\'' + ", lastName='" + LastName + '\'' + ", address='" + Address + '\'' + ", city='" + City + '\'' + ", state='" + State + '\'' + ", eMail='" + Email + '\'' + ", zip=" + Zip + ", mobileNum=" + PhoneNumber + '}');
        }
        else
            System.out.println("The "+FirstName+" already exist in contacts please use different name");
    }

  //  //Checking duplicate Entries
    private boolean check(String firstName){
        Boolean check = true;
        if (detailedEntries.stream().anyMatch(person -> person.getFirstName().equals(firstName))){
            check = false;
            return check;
        }else {
            return check;
        }
    }

    private void callAddressBookTemp(String bookName,
                                     String firstName, String lastName,
                                     String address, String city, int zip,
                                     String state, long phoneNumber, String email) {
        addressbookcontact adder = new addressbookcontact(bookName, firstName, lastName, address, city, zip, state, phoneNumber, email);
        //adder.toString();
        detailedEntries.add(adder);
        book.put(firstName, detailedEntries);
        cityList.put(city, detailedEntries);
        stateList.put(state, detailedEntries);
    }

    public boolean takeOption(){
        System.out.println("enter 1:add_contact");
        int opt = sc.nextInt();
        boolean condition = true;
        switch (opt){
            case 1:
                callAddressBookBluePrint();
                break;
            case 0:
                condition = false;
                break;
            default:
                System.out.println("invalid input");
        }
        return condition;
    }
}
