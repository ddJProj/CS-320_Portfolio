package contactService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author E. Johnson
 */

public class ContactServiceTest {
    private static ContactService testContactService;
    private Contact validTestContact;

    /**
     * starts Contact service, and creates a test Contact object for use in tests by adding it to the service list
     */
    @BeforeEach
    void setUp() {
        testContactService = null;
        validTestContact = null;

        testContactService = ContactService.getServiceInstance();
        testContactService.addNewContact("FirstName","LastName","0123456789","123 Test Lane");
        int lastContactIndex = ContactService.getContactList().size() - 1;
        validTestContact = ContactService.getContactList().get(lastContactIndex);
    }


    /**
     * deletes the test object from service list
     */
    @AfterEach
    void tearDown() {
        if (validTestContact != null) {
            String testContactID = validTestContact.getContactID();
            testContactService.deleteExistingContact(testContactID);
        }
    }


    /**
     * asserts that attempting to find an objectID that is not in the list throws an exception
     */
    @Test
    void findInvalidContactIDThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {
            String nullContactObject = "5555555555";
            testContactService.findContactObject(nullContactObject);
        });
    }
    /**
     * adds a new Contact to the service list of Contacts, tests that the values match parameters used to create
     */
    @Test
    void addNewContactDoesNotThrowException() {

        assertDoesNotThrow(() -> {
            testContactService.addNewContact("John","Doe","9876543210","321 Test Way");

            int newContactIndex = ContactService.getContactList().size() - 1;
            String addContactTestId = ContactService.getContactList().get(newContactIndex).getContactID();

            assertEquals(2, ContactService.getContactList().size());
            assertEquals(ContactService.getContactList().get(newContactIndex).getFirstName(), "John");

            testContactService.deleteExistingContact(addContactTestId);
        });
    }


    /**
     * adds a new Contact to list of Contacts, deletes the Contact, asserts new list size is initial size - 1
     */
    @Test
    void deleteContactObjectDoesNotThrowException() {
        assertDoesNotThrow(() -> {
            testContactService.addNewContact("Edgar","Poe","4323543210","321 Test Pkwy");
            int initialListSize = ContactService.getContactList().size();
            String deleteContactTestId = ContactService.getContactList().get(initialListSize - 1).getContactID();

            testContactService.deleteExistingContact(deleteContactTestId);

            assertEquals(initialListSize - 1, ContactService.getContactList().size());
        });
    }

    /**
     * asserts that changing the first name with valid string will not throw exception
     */
    @Test
    void updateContactFirstNameDoesNotThrowException() {

        assertDoesNotThrow(() -> {
            assertEquals("FirstName", validTestContact.getFirstName());
            String updateContactFirstName = "Fred";

            testContactService.updateContactFirstName(validTestContact.getContactID(), updateContactFirstName);

            assertEquals(updateContactFirstName, validTestContact.getFirstName());
        });
    }

    /**
     * asserts that attempting to change the Contact first name to a value that exceeds limit throws an exception
     */
    @Test
    void updateContactFirstNameInvalidLengthThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {
            String updateContactFirstNameInvalid = "ThisNameIsTooLongToUpdate";
            testContactService.updateContactFirstName(validTestContact.getContactID(), updateContactFirstNameInvalid);
        });
    }


    /**
     * asserts that attempting to change the Contact first name to a null value throws an exception
     */
    @Test
    void updateContactFirstNameNullThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {
            testContactService.updateContactFirstName(validTestContact.getContactID(), null);
        });
    }

    /**
     * checks Contact last nome, changes the Contact's last name, then asserts that the name change has worked
     */
    @Test
    void updateContactLastNameDoesNotThrowException() {
        assertDoesNotThrow(() -> {
            assertEquals("LastName", validTestContact.getLastName());
            String updateLastNameTest = "Farmer";

            testContactService.updateContactLastName(validTestContact.getContactID(), updateLastNameTest);

            assertEquals("Farmer", validTestContact.getLastName());
        });
    }

    /**
     * asserts that attempting to change the Contact Last name to with a string that exceeds limit throws an exception
     */
    @Test
    void updateContactLastNameInvalidLengthThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {
            String updateLengthNameTest = "ThisLastNameIsTooLongAndExceedsTheLimit";
            testContactService.updateContactLastName(validTestContact.getContactID(), updateLengthNameTest);
        });
    }


    /**
     * asserts that attempting to change the Contact last name to a null value throws an exception
     */
    @Test
    void UpdateContactLastNameNullThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {
            testContactService.updateContactLastName(validTestContact.getContactID(), null);
        });
    }



    /**
     * asserts that changing phone number to a valid string will not throw exception
     */
    @Test
    void updateContactPhoneNumberDoesNotThrowException() {

        assertDoesNotThrow(() -> {
            assertEquals("0123456789", validTestContact.getPhoneNumber());
            String updateContactPhoneNumber = "9873456789";

            testContactService.updateContactPhoneNumber(validTestContact.getContactID(), updateContactPhoneNumber);

            assertEquals("9873456789", validTestContact.getPhoneNumber());
        });
    }

    /**
     * asserts that attempting to change the Contact phone number to a value that exceeds limit throws an exception
     */
    @Test
    void updateContactPhoneNumberInvalidLengthThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {
            String updateContactPhoneNumberInvalid = "987645231373264";
            testContactService.updateContactPhoneNumber(validTestContact.getContactID(), updateContactPhoneNumberInvalid);
        });
    }


    /**
     * asserts that attempting to change the Contact phone number to a null value throws an exception
     */
    @Test
    void updateContactPhoneNumberNullThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {
            testContactService.updateContactPhoneNumber(validTestContact.getContactID(), null);
        });
    }

////
    /**
     * asserts that changing the address with valid string will not throw exception
     */
    @Test
    void updateContactAddressDoesNotThrowException() {

        assertDoesNotThrow(() -> {
            assertEquals("123 Test Lane", validTestContact.getAddress());
            String updateContactAddress = "987 Updated Address Ln";

            testContactService.updateContactAddress(validTestContact.getContactID(), updateContactAddress);

            assertEquals(updateContactAddress, validTestContact.getAddress());
        });
    }

    /**
     * asserts that attempting to change the Contact address to a value that exceeds limit throws an exception
     */
    @Test
    void updateContactAddressInvalidLengthThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {
            String updateContactAddressInvalid = "ThisAddressIsTooLongAndExceedsTheLimit0987654321";
            testContactService.updateContactAddress(validTestContact.getContactID(), updateContactAddressInvalid);
        });
    }


    /**
     * asserts that attempting to change the Contact address to a null value throws an exception
     */
    @Test
    void updateContactAddressNullThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {
            testContactService.updateContactAddress(validTestContact.getContactID(), null);
        });
    }
}
