package contactService;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/*
 * @author E. Johnson
 */
public class ContactTest {


    /**
     * Attempts to create a Contact object for reuse in tests
     * @return created Contact object
     */
    private Contact createContact() {
        return new Contact("0123456789", "FirstName", "LastName", "0123456789", "123 Test Lane");
    }


    /**
     * Asserts that each of the values a contact object was instantiated with match the getVariable accessor value
     */
    @Test
    void contactValidInstantiationDoesNotThrowException() {

        assertDoesNotThrow(() -> {
            Contact validContact = createContact();

            assertEquals("0123456789", validContact.getContactID());
            assertEquals("FirstName", validContact.getFirstName());
            assertEquals("LastName", validContact.getLastName());
            assertEquals("0123456789", validContact.getPhoneNumber());
            assertEquals("123 Test Lane", validContact.getAddress());
        }, "This message indicates an unexpected Exception was thrown");
    }


    /**
     * Asserts that attempting to create a Contact object with a null Id will throw an exception.
     */
    @Test
    void contactInstantiateNullIdThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Contact ContactTestNullId = new Contact(null, "FirstName", "LastName", "0123456789", "123 Test Lane");
        });
    }

    /**
     * Asserts that attempting to create a Contact object with an Id that is too long will throw an exception.
     */
    @Test
    void contactInstantiateIdTooLongThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Contact ContactTestIdLength = new Contact("IdTooLong123", "FirstName", "LastName", "0123456789", "123 Test Lane");
        });
    }


    /**
     * Asserts that attempting to update a Contact with a valid firstName does not throw an exception.
     */
    @Test
    void validateValidFirstNameDoesNotThrowException() {
        assertDoesNotThrow(() -> {
            Contact validContact = createContact();
            String FirstNameValidLength = "Bob";

            validContact.validateFirstName(FirstNameValidLength);

            assertEquals(FirstNameValidLength, validContact.getFirstName());
        }, "This message indicates an unexpected Exception was thrown");
    }

    /**
     * Asserts that attempting to update a Contact with a firstName that is null throws an exception.
     */
    @Test
    void validateFirstNameNullThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {
            Contact ContactTest = createContact();
            ContactTest.validateFirstName(null);
        });
    }

    /**
     * Asserts that attempting to update a Contact with a firstName that is too long throws an exception.
     */
    @Test
    void validateFirstNameTooLongThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {
            Contact ContactTest = createContact();
            String FirstNameTooLong = "ThisNameIsPastTheCharacterLimit";
            ContactTest.validateFirstName(FirstNameTooLong);
        });
    }


    /**
     * Asserts that attempting to update a Contact with a valid lost name does not throw an exception.
     */
    @Test
    void validateValidLastNameDoesNotThrowException() {
        assertDoesNotThrow(() -> {
            Contact validContact = createContact();
            String lastNameValidLength = "Bob";

            validContact.validateLastName(lastNameValidLength);

            assertEquals(lastNameValidLength, validContact.getLastName());
        }, "This message indicates an unexpected Exception was thrown");
    }

    /**
     * Asserts that attempting to update a Contact with a lost name  that is null throws an exception.
     */
    @Test
    void validateLastNameNullThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {
            Contact ContactTest = createContact();
            ContactTest.validateLastName(null);
        });
    }

    /**
     * Asserts that attempting to update a Contact with a lost name that is too long throws an exception.
     */
    @Test
    void validateLastNameTooLongThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {
            Contact ContactTest = createContact();
            String lastNameTooLong = "ThisNameIsPastTheCharacterLimit";
            ContactTest.validateLastName(lastNameTooLong);
        });

    }



    /**
     * Asserts that attempting to update a Contact with a valid phone number does not throw an exception.
     */
    @Test
    void validateValidPhoneNumberDoesNotThrowException() {
        assertDoesNotThrow(() -> {
            Contact validContact = createContact();
            String lastNameValidLength = "Bob";

            validContact.validateLastName(lastNameValidLength);

            assertEquals(lastNameValidLength, validContact.getLastName());
        }, "This message indicates an unexpected Exception was thrown");
    }

    /**
     * Asserts that attempting to update a Contact with a phone number that is null throws an exception.
     */
    @Test
    void validatePhoneNumberNullThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {
            Contact ContactTest = createContact();
            ContactTest.validateLastName(null);
        });
    }

    /**
     * Asserts that attempting to update a Contact with a phone number that is too long throws an exception.
     */
    @Test
    void validatePhoneNumberTooLongThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {
            Contact ContactTest = createContact();
            String lastNameTooLong = "ThisNameIsPastTheCharacterLimit";
            ContactTest.validateLastName(lastNameTooLong);
        });
    }


    /**
     * Asserts that attempting to update a Contact with a valid address does not throw an exception.
     */
    @Test
    void validateValidAddressDoesNotThrowException() {
        assertDoesNotThrow(() -> {
            Contact validContact = createContact();
            String addressValidLength = "123 Willow Way";

            validContact.validateAddress(addressValidLength);

            assertEquals(addressValidLength, validContact.getAddress());
        }, "This message indicates an unexpected Exception was thrown");
    }

    /**
     * Asserts that attempting to update a Contact with an address that is null throws an exception.
     */
    @Test
    void validateAddressNullThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {
            Contact ContactTest = createContact();
            ContactTest.validateAddress(null);
        });
    }

    /**
     * Asserts that attempting to update a Contact with an address that is too long throws an exception.
     */
    @Test
    void validateAddressTooLongThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {
            Contact ContactTest = createContact();
            String addressTooLong = "ThisAddressIsPastTheCharacterLimit";
            ContactTest.validateAddress(addressTooLong);
        });
    }
}