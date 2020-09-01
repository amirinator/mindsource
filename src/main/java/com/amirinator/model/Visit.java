package com.amirinator.model;

import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

/**
 * This is the model class for a page visit. It contains the
 * information for the product id, the user id and the timestamp
 * of the visit.
 */
@EqualsAndHashCode
public class Visit {

	private String productId;
	private String userId;
	private Timestamp visitTime;

	/**
	 * Class constructor required to initialize the values for a visit object
	 *
	 * @param pId   the product ID of the visit
	 * @param uId   the user ID of the visit
	 * @param vTime the timestamp of the visit
	 */
	public Visit(String pId, String uId, Timestamp vTime) {
		productId = pId;
		userId = uId;
		visitTime = vTime;
	}

	/**
	 * Returns the product ID of the visit
	 *
	 * @return Returns the product ID of the visit
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * Returns the user ID of the visit
	 *
	 * @return Returns the user ID of the visit
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Returns the timestamp of the visit
	 *
	 * @return Returns the timestamp of the visit
	 */
	public Timestamp getVisitTime() {
		return visitTime;
	}
}
