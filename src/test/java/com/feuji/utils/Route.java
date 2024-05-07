package com.feuji.utils;

/**
 * The Route class contains constants representing different endpoints of the
 * RESTful Booker API.
 */
public class Route {

	/**
	 * Base URL of the RESTful Booker API.
	 */
	public static final String BASE_URL = "https://restful-booker.herokuapp.com";
	/**
	 * Endpoint for authentication.
	 */
	public static final String AUTH_END_POINT = "/auth";
	/**
	 * Endpoint for creating a new booking.
	 */
	public static final String POST_END_POINT = "/booking";
	/**
	 * Endpoint for getting all bookings. This endpoint is the same as the
	 * POST_END_POINT for this API.
	 */
	public static final String GET_ALL_END_POINT = POST_END_POINT;
	/**
	 * Endpoint for getting a booking by its ID. This endpoint uses a placeholder
	 * {bookingid} for the actual booking ID.
	 */
	public static final String GET_BY_ID_END_POINT = "/booking/{bookingid}";
	/**
	 * Endpoint for updating an existing booking. This endpoint also uses the
	 * GET_BY_ID_END_POINT with a booking ID parameter.
	 */
	public static final String UPDATE_END_POINT = GET_BY_ID_END_POINT;
	/**
	 * Endpoint for deleting a booking. This endpoint also uses the
	 * GET_BY_ID_END_POINT with a booking ID parameter.
	 */
	public static final String DELETE_END_POINT = GET_BY_ID_END_POINT;

}
