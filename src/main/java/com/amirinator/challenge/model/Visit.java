package com.amirinator.challenge.model;

import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

/**
 * This is the model class for a page visit. It contains the
 * information for the product id, the user id and the timestamp
 * of the visit.
 */
@EqualsAndHashCode
public class Visit {

    private Integer productId;
    private Integer userId;
    private Timestamp visitTime;

    public Visit(Integer pId, Integer uId, Timestamp vTime) {
        productId = pId;
        userId = uId;
        visitTime = vTime;
    }

    /**
     * Returns the product ID of the visit
     * @return Returns the product ID of the visit
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * Returns the user ID of the visit
     * @return Returns the user ID of the visit
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Returns the timestamp of the visit
     * @return Returns the timestamp of the visit
     */
    public Timestamp getVisitTime() {
        return visitTime;
    }
}
