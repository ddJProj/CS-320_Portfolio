package contactService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/*
 * Singleton service class to manage Contact class objects
 * @author E. Johnson
 */
public class ContactService {

    private static final int MAX_VAR_CHAR_LENGTH = 10;

    // A list of the Contact Objects
    private static List<Contact> contactList = new ArrayList<Contact>();

    // creates a single static ContactService class object
    private static ContactService activeServiceInstance = null;


    /*
     * private constructor to prevent creation of additional/empty object instances
     */
    private ContactService() {
    }


    /*
     * Construct a new contact service or return existing one
     * @return the contact service instance (new or existing)
     */
    public static ContactService getServiceInstance() {

        if (activeServiceInstance == null) { // if service instance does not exist
            activeServiceInstance = new ContactService(); // creates a new instance
        }

        return activeServiceInstance; // returns the existing or new service instance
    }


    /*
     * creates a new contact ID and checks to ensure not duplicate value
     * @return String newly generated ID
     */
    public String createUniqueContactID() {
        String newContactID = null;

        boolean idMatchFound;

        do {
            idMatchFound = false;
            String rawUUIDString = UUID.randomUUID().toString().replace("-", ""); // creates random ID using UUID and removes any - symbols
            newContactID = rawUUIDString.substring(0, MAX_VAR_CHAR_LENGTH); // shortens UUID to first 10 characters

            for (Contact currentContactInstance : contactList) {    // iterates through list of contacts checking for matching contactID
                if (currentContactInstance.getContactID().equals(newContactID)) {    // if contactID parameter is equal to contactID value of currentInstance
                    idMatchFound = true; // sets matchfound to true
                    break; // breaks for each loop to generate a new contactID
                }
            }
        } while(idMatchFound); // continue looping for valid ID until no matches found

        return newContactID;
    }

    /*
     * finds and returns contact object if existing
     * @param String contact identifier
     */
    public Contact findContactObject(String contactID){

        Contact contactObject = null; // creates a null contact object


        // creates an iterator for Contact objects and assigns it the list of contacts to be iterated through
        Iterator<Contact> contactIterator = contactList.iterator();

        while (contactIterator.hasNext()) { // while there is a next object in arrayList

            Contact currentContactInstance = contactIterator.next(); // currentContactInstance is assigned to next object in list

            if (currentContactInstance.getContactID().equals(contactID)) {	// if contactID parameter is equal to contactID value of currentInstance
                contactObject = currentContactInstance; // value of contact is assigned to the existing object
            }
        }
        // if no object is found
        if (contactObject == null) {
            // throws an exception instead of returning a null contact object
            throw new IllegalArgumentException("Contact not found");
        }

        // return the existing contact instance to the caller
        return contactObject;

    }

    /*
     * creates a new contact object
     * @param String first name
     * @param String last name
     * @param String phoneNumber
     * @param String address
     */
    public void addNewContact(String firstName, String lastName, String phoneNumber, String address){
        Contact newContact = new Contact(createUniqueContactID(), firstName, lastName, phoneNumber, address);
        contactList.add(newContact); // add newly instantiated contact object to list of objects
    }

    /*
     * Deletes a contact object from the list using contactID
     * @param String contact identifier
     */
    public void deleteExistingContact(String contactID) {
        contactList.remove(findContactObject(contactID));
    }


    /*
     * Updates firstName attribute of contact object
     * @param String contact identifier
     * @param String first name
     */
    public void updateContactFirstName(String contactID, String firstName){
        findContactObject(contactID).validateFirstName(firstName);
    }



    /*
     * Updates lastName attribute of contact object
     * @param String contact identifier
     * @param String last name
     */
    public void updateContactLastName(String contactID, String lastName){
        findContactObject(contactID).validateLastName(lastName);
    }



    /*
     * Updates phone number attribute of contact object
     * @param String contact identifier
     * @param String phone number
     */
    public void updateContactPhoneNumber(String contactID, String phoneNumber){
        findContactObject(contactID).validatePhoneNumber(phoneNumber);
    }


    /*
     * Updates address attribute of contact object
     * @param String contact identifier
     * @param String address
     */
    public void updateContactAddress(String contactID, String address){
        findContactObject(contactID).validateAddress(address);
    }


    /*
     * getter method for contact list with contacts. Used in testing the list length
     * @return Contact List
     */
    public static List<Contact> getContactList() {
        return contactList;
    }


}


