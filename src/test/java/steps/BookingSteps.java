package steps;

import endpoints.BookingEndPoints;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Booking;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class BookingSteps {
	World world = new World();
	Booking booking = new Booking();
	String bookingId;
	List<Response> responseList = new ArrayList<>();
	BookingEndPoints bookingEndPoints = new BookingEndPoints();

	@When("I POST a create booking")
	public void iCreateNewBooking() {
		world.setBooking(booking);
		bookingEndPoints.addBooking(world);
	}

	@Then("I see response has {int} status code")
	public void iSeeResponseStatusCode(int code) {
		bookingEndPoints.verifyResponseStatusCode(world.getResponse(), code);
	}

	@Then("I verify booking request response as per booking model")
	public void iVerifyBookingResonseModel() {
		if (ContentType.JSON.toString().contains(world.getResponse().contentType())
				|| world.getResponse().contentType().contains(ContentType.XML.toString())) {
			Assert.assertTrue(
					bookingEndPoints.verifyBookingValuesAreAsExpected(world.getResponse(), world.getBooking()));
		}
	}

	@Then("the response has following response code")
	public void theResponseHasFollowingResponseCode(DataTable dt) {
		List<List<String>> rows = dt.asLists(String.class);
		for (int i = 1; i < dt.cells().size(); i++) {
			List<String> columns = rows.get(i);
			bookingEndPoints.verifyResponseStatusCode(responseList.get(i - 1), Integer.parseInt(columns.get(0)));
		}
	}

	@When("I POST a create booking API for multiple users")
	public void iAddABookingInTheAPIWithMultipleUsers(DataTable dt) {
		List<List<String>> rows = dt.asLists(String.class);
		for (int i = 1; i < dt.cells().size(); i++) {
			List<String> columns = rows.get(i);
			Booking bo = new Booking(columns.get(0), columns.get(1), Integer.parseInt(columns.get(2)),
					Boolean.parseBoolean(columns.get(3)), null, columns.get(4));
			responseList.add(bookingEndPoints.addBooking(null, bo));
		}
	}

	@When("I DELETE a booking")
	public void iDeleteABooking() {
		Response response = bookingEndPoints.addBooking(world);
		bookingId = bookingEndPoints.getBookingIdFromResponse(response);
		world.setResponse(bookingEndPoints.deleteBooking(bookingId, null));
	}

	@When("getting the same booking with Id")
	public void gettingTheSameBookingWithId() {
		world.setResponse(bookingEndPoints.getBookingById(bookingId, null));
	}

	@When("I UPDATE a booking")
	public void iUpdateBooking(List<String> boList) {
		Response response = bookingEndPoints.addBooking(world);
		bookingId = bookingEndPoints.getBookingIdFromResponse(response);
		Booking updatedBooking = new Booking(boList.get(0), boList.get(1), Integer.parseInt(boList.get(2)),
				Boolean.parseBoolean(boList.get(3)), null, boList.get(4));
		world.setResponse(bookingEndPoints.updateBooking(bookingId, updatedBooking, null));
	}
}
