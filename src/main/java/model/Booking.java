package model;

import java.util.Objects;
import java.time.LocalDate;
import com.github.javafaker.Faker;


/**
 * POJO for Booking API Response
 *
 * 
 */
public class Booking {
	private String firstname;
	private String lastname;
	private int totalprice;
	private BookingDates bookingdates;
	private boolean depositpaid;
	private String additionalneeds;
	Faker faker = new Faker();

	public Booking() {
		this.firstname = faker.name().firstName();
		this.lastname = faker.name().firstName();
		this.totalprice = faker.number().numberBetween(10, 10000);
		this.bookingdates = new BookingDates(LocalDate.now().toString(), LocalDate.now().plusDays(7).toString());
		this.depositpaid = true;
		this.additionalneeds = faker.food().spice();
	}

	public Booking(String firstname, String lastname, int totalprice, boolean depositpaid, BookingDates bookingdates,
			String additionalneeds) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.totalprice = totalprice;
		this.depositpaid = depositpaid;
		this.bookingdates = bookingdates == null ? new BookingDates(LocalDate.now().toString(), LocalDate.now().plusDays(7).toString()) : bookingdates;
		this.additionalneeds = additionalneeds;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public BookingDates getBookingdates() {
		return bookingdates;
	}

	public void setBookingdates(BookingDates bookingdates) {
		this.bookingdates = bookingdates;
	}

	public boolean isDepositpaid() {
		return depositpaid;
	}

	public void setDepositpaid(boolean depositpaid) {
		this.depositpaid = depositpaid;
	}

	public String getAdditionalneeds() {
		return additionalneeds;
	}

	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Booking booking = (Booking) o;
		return totalprice == booking.totalprice && depositpaid == booking.depositpaid
				&& Objects.equals(firstname, booking.firstname) && Objects.equals(lastname, booking.lastname)
				&& Objects.equals(bookingdates, booking.bookingdates)
				&& Objects.equals(additionalneeds, booking.additionalneeds);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstname, lastname, totalprice, bookingdates, depositpaid, additionalneeds);
	}
}
