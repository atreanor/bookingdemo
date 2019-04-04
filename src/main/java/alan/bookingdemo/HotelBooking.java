package alan.bookingdemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HotelBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String hotelName;
    private double pricePerNight;
    private int numNights;

    public HotelBooking() {}

    public HotelBooking(String newName, double newPricePerNight, int newNumNights) {
        this.hotelName = newName;
        this.pricePerNight = newPricePerNight;
        this.numNights = newNumNights;
    }

    public String getHotelName() {
        return hotelName;
    }
    public double getPricePerNight() {
        return pricePerNight;
    }
    public int getNumNights() {
        return numNights;
    }
    public double getTotalPrice(){
        return pricePerNight * numNights;
    }

    public long getId() {
        return id;
    }
}
