package model;

/**
 * POJO for Booking Detail
 *
 * 
 */
public class BookingDetail {
    private int bookingid;
    private Booking booking;

    public BookingDetail() {
        this.bookingid = 10;
        this.booking = new Booking();
    }

    public BookingDetail(int bookingid, Booking booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

}
