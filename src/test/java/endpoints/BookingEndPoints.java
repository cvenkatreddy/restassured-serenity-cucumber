package endpoints;

import org.json.JSONException;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.Booking;
import model.BookingDetail;
import steps.World;
import utils.Constants;

public class BookingEndPoints extends BaseEndPoints {
	private final String BOOKING_ENDPOINT_PATH = "booking";

	public String getPath() {
		return BOOKING_ENDPOINT_PATH;
	}

	public Response addBooking(World world) throws JSONException {
		world.setRequest(getCommonSpec());
		Response response = addBooking(world.getRequest());
		world.setResponse(response);
		return world.getResponse();
	}

	public Response addBooking(RequestSpecification request) throws JSONException {
		Booking booking = new Booking();
		return addBooking(request, booking);
	}
	
	public Response addBooking(RequestSpecification rSpec, Booking booking) throws JSONException {
		rSpec = getCommonSpec().basePath(getPath());
		
		return sendRequest(rSpec, Constants.RequestType.POST_REQUEST, booking);
	}
	
	public String getBookingIdFromResponse(Response response) {
		BookingDetail bd = response.getBody().as(BookingDetail.class);
		return String.valueOf(bd.getBookingid());
	}

	public Response deleteBooking(String bookingId, RequestSpecification rSpec) {
		rSpec = getCommonSpec().cookie("token", getAuthorizationToken()).basePath(getBasePath(bookingId));
		
		return sendRequest(rSpec, Constants.RequestType.DELETE_REQUEST, null);
	}

	public Response updateBooking(String bookingId, Booking booking, RequestSpecification rSpec) {
		rSpec = getCommonSpec().cookie("token", getAuthorizationToken()).basePath(getBasePath(bookingId));
		
		return sendRequest(rSpec, Constants.RequestType.PUT_REQUEST, booking);
	}

	public Response getBookingById(String bookingId, RequestSpecification rSpec) {
		rSpec = getCommonSpec().cookie("token", getAuthorizationToken()).basePath(getBasePath(bookingId));

		return sendRequest(rSpec, Constants.RequestType.GET_REQUEST, null);
	}

	public boolean verifyBookingValuesAreAsExpected(Response response, Booking booking) {
		return booking.equals(response.getBody().as(Booking.class));
	}
	
	private String getBasePath(String bookingId) {
		return String.format("%s/%s", getPath(), bookingId);
	}
}
