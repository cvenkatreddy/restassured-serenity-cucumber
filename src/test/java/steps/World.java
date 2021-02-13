package steps;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.Booking;

public class World {
	private Response response;
	private RequestSpecification request;
	private Booking booking;

	public void setResponse(Response response) {
		this.response = response;
	}

	public Response getResponse() {
		return this.response;
	}

	public void setRequest(RequestSpecification request) {
		this.request = request;
	}

	public RequestSpecification getRequest() {
		return this.request;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

}
