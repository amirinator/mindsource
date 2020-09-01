package com.amirinator.service;

import com.amirinator.model.Visit;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface VisitorService {

	/**
	 * Time format for visit records
	 */
	SimpleDateFormat timeFormatter = new SimpleDateFormat("yyyy-MM-dd hh");

	/**
	 * @param visits the collection of visit records
	 * @return map of products with each collection of corresponding visits
	 */
	Map<String, List<Visit>> apply(Collection<Visit> visits);

	/**
	 * return a count of the records whose visit.timestamp value falls within the parameters time range exclusive
	 * of the timeStart and timeEnd values.
	 *
	 * @param startTime - the timestamp value of the start time
	 * @param endTime   - the timestamp value of the end time
	 * @return the count of visits between the parameter time range
	 */
	Long getCountOfVisitsForTimeRange(Timestamp startTime, Timestamp endTime, List<Visit> visits);

	/**
	 * Lead Visit objects from resources file for running the application
	 *
	 * @return a list of Visit objects
	 */
	List<Visit> loadVisits(String fileName);

	/**
	 * return a map of of product id that has a count of distinct visits per user. The key is the product id and
	 * the value is the count of distinct visits per user.
	 *
	 * @return the distinct count of the users that have visited a specific product
	 */
	Map<String, Map<String, List<Visit>>> distinctVisitCountByProduct(List<Visit> visits);
}
