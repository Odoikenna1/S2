package phoneBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class phoneBookTests
{
    @BeforeEach
    void test_ThatSetFirstName_SetsFirstNameField()
    {
        MaintainContact newContact = new MaintainContact();
        assertEquals("Sam",sam.getFirstName());
    }



}