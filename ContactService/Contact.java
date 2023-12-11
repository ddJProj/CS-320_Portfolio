/**
 * @author E. Johnson
 */
package contactService;

/**
 * class object to store contact details
 */
public class Contact {

    private static final int MAX_VAR_CHAR_LENGTH = 10;
    private static final int MAX_ADDRESS_CHAR_LENGTH = 30;


    private String contactID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;


    /**
     * private default constructor to stop creation of empty objects
     */
    private Contact(){

    }

    /**
     * Contact class constructor
     * @param contactID
     * @param firstName
     * @param lastName
     * @param phoneNumber
     * @param address
     *
     */
    public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {


        if (contactID == null || contactID.length()>MAX_VAR_CHAR_LENGTH) {
            throw new IllegalArgumentException("Invalid contactID. Expected not null & under 10 characters long");
        }
        this.contactID = contactID;

        validateFirstName(firstName);
        validateLastName(lastName);
        validatePhoneNumber(phoneNumber);
        validateAddress(address);

    }

    /**
     * updates/validates the first name member variable value
     * @param firstName
     */
    protected void validateFirstName(String firstName) {

        if (firstName == null || firstName.length()>MAX_VAR_CHAR_LENGTH) {
            throw new IllegalArgumentException("Invalid first name. Expected not null or over 10 characters long");
        }

        this.firstName = firstName;
    }


    /**
     * updates/validates the last name member variable value
     * @param  lastName
     */
    protected void validateLastName(String lastName) {

        if (lastName == null || lastName.length()>MAX_VAR_CHAR_LENGTH) {
            throw new IllegalArgumentException("Invalid last name. Expected not null or over 10 characters long");
        }
        this.lastName = lastName;

    }


    /**
     * updates/validates the address member variable value
     * @param address
     */
    protected void validateAddress(String address) {

        if (address == null || address.length()>MAX_ADDRESS_CHAR_LENGTH) {
            throw new IllegalArgumentException("Invalid Address. Expected not null or over 30 characters long");
        }
        this.address = address;
    }


    /**
     * updates/validates the phone number variable value
     * @param phoneNumber
     */
    protected void validatePhoneNumber(String phoneNumber) {

        if (phoneNumber == null || phoneNumber.length() != MAX_VAR_CHAR_LENGTH) {
            throw new IllegalArgumentException("Invalid phone number. Expected exactly 10 characters & not null");
        }
        this.phoneNumber = phoneNumber;
    }


    /**
     * getter method for contactID member variable value
     * @return String contactID
     */
    public String getContactID() {
        return contactID;
    }


    /**
     * getter method for first name member variable value
     * @return String firstName
     */
    public String getFirstName() {
        return firstName;
    }


    /**
     * getter method for last name member variable value
     * @return String lastName
     */
    public String getLastName() {
        return lastName;
    }


    /**
     * getter method for phone number member variable value
     * @return String phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }


    /**
     * getter method for address member variable value
     * @return String address
     */
    public String getAddress() {
        return address;
    }
}
