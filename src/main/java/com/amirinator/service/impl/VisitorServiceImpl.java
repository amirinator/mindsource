package com.amirinator.service.impl;

import com.amirinator.model.Visit;
import com.amirinator.service.VisitorService;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Functional interface class used to return a Map of products grouped by all of the visits
 * for each specific product key
 */
public class VisitorServiceImpl implements VisitorService {

	@Override
	public Map<String, List<Visit>> apply(Collection visits) {

		return (Map<String, List<Visit>>) visits.stream()
				.collect(Collectors
						.groupingBy(
								Visit::getProductId, Collectors.groupingBy(Visit::getUserId)));

	}

	@Override
	public Long getCountOfVisitsForTimeRange(Timestamp timeStart, Timestamp timeEnd, List<Visit> visits) {

		//verify the start time is before the end time
		if (timeStart.after(timeEnd)) {
			throw new RuntimeException("The start time has to be before the end time");
		}
		return visits.stream()
				.filter(visit -> visit.getVisitTime().after(timeStart) && visit.getVisitTime().before(timeEnd))
				.count();
	}

	@Override
	public List<Visit> loadVisits(String fileName) {

		List<Visit> visits = new ArrayList<>();
		try (InputStream inputStream = getClass().getResourceAsStream(fileName);
			 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

			visits = bufferedReader
					.lines()
					.skip(1)
					.map(line -> {
						Visit visit = null;
						try {
							String[] row = line.split("\t", -1);
							String productId = row[0];
							String userId = row[1];
							Timestamp visitedTime = new Timestamp(timeFormatter.parse(row[2]).getTime());
							visit = new Visit(productId, userId, visitedTime);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						return visit;
					}).collect(Collectors.toList());

		} catch (Exception e) {
			System.out.println("Exception:" + e);
		}
		return visits;
	}

	@Override
	public Map<String, Map<String, List<Visit>>> distinctVisitCountByProduct(List<Visit> visits) {

		return visits.stream()
				.collect(Collectors
						.groupingBy(
								Visit::getProductId, Collectors.groupingBy(Visit::getUserId)));

		//NOTE: This can also be done using a funcational interface
		//Function srvc = new VisitorService();
		//Map<String,List<Visit>> results = (Map<String, List<Visit>>) srvc.apply(visits);
		//return  results
	}
}
