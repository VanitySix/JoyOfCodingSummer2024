package edu.pdx.cs.joy.louis8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBIllTest {
    private PhoneBill phoneBill;
    private PhoneCall call1;
    private PhoneCall call2;

    @BeforeEach
    void setUp() {
        // Initialize PhoneBill and PhoneCalls
        phoneBill = new PhoneBill("John Doe");
        call1 = new PhoneCall("John Doe", "123-456-7890", "987-654-3210",
                LocalDateTime.of(2024, 8, 15, 10, 0),
                LocalDateTime.of(2024, 8, 15, 11, 0));
        call2 = new PhoneCall("John Doe", "123-456-7890", "555-555-5555",
                LocalDateTime.of(2024, 8, 16, 12, 0),
                LocalDateTime.of(2024, 8, 16, 13, 0));
    }
    @Test
    void testDateTime() {
        // Setup
        PhoneCall call1 = new PhoneCall("John Doe", "123-456-7890", "987-654-3210",
                LocalDateTime.of(2024, 8, 15, 10, 30),
                LocalDateTime.of(2024, 8, 15, 11,   30));
        // Print out date and time
        System.out.println("Begin DateTime: " + call1.getBeginTimeString());
        System.out.println("End DateTime: " + call1.getEndTimeString());
        System.out.println("PhoneCall Details: " + call1);
    }
    @Test
    void testAddPhoneCall() {
        phoneBill.addPhoneCall(call1);
        phoneBill.addPhoneCall(call2);
        Collection<PhoneCall> calls = phoneBill.getPhoneCalls();

        assertNotNull(calls, "Phone calls collection not null");
        assertEquals(2, calls.size(), "Phone calls size should be 2");
        assertTrue(calls.contains(call1), "Phone calls should contain call1");
        assertTrue(calls.contains(call2), "Phone calls should contain call2");
    }


    @Test
    void testGetCustomer() {
        assertEquals("John Doe", phoneBill.getCustomer());
    }
}
