package appointmentService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class AppointmentTest {

    @Test
    public void testValidAppointmentCreation() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("1234567890", futureDate, "Meeting");
        assertEquals("1234567890", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Meeting", appointment.getDescription());
    }

    @Test
    public void testAppointmentIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", new Date(), "Description");
        });
    }

    @Test
    public void testAppointmentDateInThePast() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", new Date(System.currentTimeMillis() - 100000), "Description");
        });
    }

    @Test
    public void testDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", new Date(), "A".repeat(51));
        });
    }
}

