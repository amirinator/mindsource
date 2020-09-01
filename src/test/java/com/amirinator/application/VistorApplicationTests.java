package com.amirinator.application;

import com.amirinator.model.Visit;
import com.amirinator.service.VisitorService;
import com.amirinator.service.impl.VisitorServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class VistorApplicationTests {

	VisitorService service;
	List<Visit> visits;

	/*
	 * Clean up resources after each test
	 */
	@AfterEach
	public void teardown() {
		service = null;
		visits = null;
	}

	/*
	 * Set up resources for each test
	 */
	@BeforeEach
	public void setup() {
		service = new VisitorServiceImpl();
		visits = service.loadVisits("/UsersVisitsSeedFile.txt");
	}

	/*
	 * Verify a collection of visit records is inflated from the resources file
	 */
	@Test
	@DisplayName("Verify the creation of 'visit' records from a resources file is correct")
	public void testGetVisits() {
		assert (!visits.isEmpty());
	}

	/*
	 * Verify the count of unqiue users per product.  For product "p1" the count is 3
	 */
	@Test
	@DisplayName("Verify the known unique visit count for a product is correct")
	public void testUniqueUserCountPerProduct() {
		Integer count = service.distinctVisitCountByProduct(visits).get("p1").size();
		assert (count.equals(3));
	}

	/*
	 * Verify the correct count of visits for a time range.
	 */
	@Test
	@DisplayName("Verify the collection of visits for a given time range is correct")
	public void testGetVisitsForTimeRange() {
		Long count = null;
		try {
			Timestamp startTime = new Timestamp(service.timeFormatter.parse("2019-01-01 04").getTime());
			Timestamp endTime = new Timestamp(service.timeFormatter.parse("2019-01-03 14").getTime());
			//count = service.getCountOfVisitsForTimeRange(startTime, endTime, visits);
			assert (service.getCountOfVisitsForTimeRange(startTime, endTime, visits) == 9);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//assert (count == 9);
	}

	/*
	 * Verify the correct count of visits for a time range
	 */
	@Test
	@DisplayName("Verify that the start date is not after the end date")
	public void testDateRangeVerification() {
		try {
			Timestamp startTime =
					new Timestamp(service.timeFormatter.parse("2019-01-05 04").getTime());
			Timestamp endTime = new Timestamp(service.timeFormatter.parse("2019-01-03 14").getTime());
			Exception exception = assertThrows(RuntimeException.class, () ->
					service.getCountOfVisitsForTimeRange(startTime, endTime, visits)
			);
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("The start time has to be before the end time"));
		}
	}
}
