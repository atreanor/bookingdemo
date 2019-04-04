package alan.bookingdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {
    // private List<HotelBooking> bookings;
    // new reference to BookingRepository
    private BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
        // bookings = new ArrayList<>();
        // bookings.add(new HotelBooking("Marriot", 250.00, 3));
        // bookings.add(new HotelBooking("Ibis", 135.00, 4));
        // bookings.add(new HotelBooking("Novotel", 190.00, 1));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<HotelBooking> getAll() {
        //return bookings;
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/affordable/{price}",  method = RequestMethod.GET)
    public List<HotelBooking> getAffordable(@PathVariable double price) {
        // return bookings.stream().filter(x -> x.getPricePerNight() <= price).collect(Collectors.toList());
        return bookingRepository.findByPricePerNightLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking) {
        // bookings.add(hotelBooking);
        // return bookings;
        bookingRepository.save(hotelBooking);
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public List<HotelBooking> remove(@PathVariable long id) {
        bookingRepository.deleteById(id);

        return bookingRepository.findAll();
    }
}
