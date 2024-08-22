package appointmentService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class AppointmentServiceTest {

    private AppointmentService service;
    private Appointment appointment;

    @BeforeEach
    public void setUp() {
        service = new AppointmentService();
        appointment = new Appointment("1234567890", new Date(System.currentTimeMillis() + 100000), "Meeting");
    }

    @Test
    public void testAddAppointment() {
        service.addAppointment(appointment);
        assertEquals(appointment, service.getAppointment("1234567890"));
    }

    @Test
    public void testAddDuplicateAppointment() {
        service.addAppointment(appointment);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(new Appointment("1234567890", new Date(System.currentTimeMillis() + 200000), "Another Meeting"));
        });
    }

    @Test
    public void testDeleteAppointment() {
        service.addAppointment(appointment);
        service.deleteAppointment("1234567890");
        assertNull(service.getAppointment("1234567890"));
    }

    @Test
    public void testDeleteNonExistentAppointment() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("1234567890");
        });
    }
}
