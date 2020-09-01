package com.amirinator.application;

import com.amirinator.model.Visit;
import com.amirinator.service.VisitorService;
import com.amirinator.service.impl.VisitorServiceImpl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class VisitorApplication {

	public static void main(String[] args) {

		VisitorService service = new VisitorServiceImpl();
		List<Visit> visits = service.loadVisits("/UsersVisitsSeedFile.txt");
		String serviceRequest = args[0];

		if (serviceRequest.equalsIgnoreCase("range")) {
			//verify the correct amount of input parameters are received
			if (args.length < 3) {
				throw new RuntimeException("For a date range search you must specify the start time and end time");
			}
			System.out.println("visits count is <" + visits.size() + ">");
			String start = args[1];
			String end = args[2];
			try {
				Timestamp startTime = new Timestamp(service.timeFormatter.parse(start).getTime());
				Timestamp endTime = new Timestamp(service.timeFormatter.parse(end).getTime());
				Long count = service.getCountOfVisitsForTimeRange(startTime, endTime, visits);
				System.out.println("The visit count for the time range between <" + startTime + "> and " +
						"<" + endTime + "> is <" + count + ">");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			//display the user counts per product
			Map<String, Map<String, List<Visit>>> visitsByUser = service.distinctVisitCountByProduct(visits);
			visitsByUser.forEach((productId, userVisits) ->
					System.out.println("For product <" + productId + "> the unique visitor count is <" + userVisits.size() + ">")
			);
		}
	}
}
