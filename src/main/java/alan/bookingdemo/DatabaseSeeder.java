package alan.bookingdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    // add reference to bookingRepository
    private BookingRepository bookingRepository;

    @Autowired
    public DatabaseSeeder(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        List<HotelBooking> bookings = new ArrayList<>();

        bookings.add(new HotelBooking("Four Seasons", 155.00, 5));
        bookings.add(new HotelBooking("Jurys", 247.00, 4));
        bookings.add(new HotelBooking("Clayton", 215.00, 7));

        // saves bookings to database
        bookingRepository.saveAll(bookings);
    }
}
