package fixture;



public class ScheduleGA {
	
	public static void main(String[] args) {
		
		// Get a Timetable object with all the available information.
	    Schedule schedule = initializeSchedule();
	    
	    // Initialize GA
	    GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.01, 0.9, 2, 5);
	    
	    // Initialize population
	    Population population = ga.initPopulation(schedule);
	    
	    // Evaluate population
	    ga.evalPopulation(population, schedule);
	    
	    // Keep track of current generation
	    int generation = 1;
	    
	    // Start evolution loop
	    while (ga.isTerminationConditionMet(generation, 1000) == false
	        && ga.isTerminationConditionMet(population) == false) {
	        // Print fitness
	        System.out.println("G" + generation + " Best fitness: " + population.getFittest(0).getFitness());

	        // Apply crossover
	        population = ga.crossoverPopulation(population);

	        // Apply mutation
	        population = ga.mutatePopulation(population, schedule);

	        // Evaluate population
	        ga.evalPopulation(population, schedule);

	        // Increment the current generation
	        generation++;
	    }

	    // Print fitness
	    schedule.createMatches(population.getFittest(0));
	    System.out.println();
	    System.out.println("Solution found in " + generation + " generations");
	    System.out.println("Final solution fitness: " + population.getFittest(0).getFitness());
	    System.out.println("Clashes: " + schedule.calcClashes());

	    // Print classes
	    System.out.println();
	    Match matches[] = schedule.getMatches();
	    int classIndex = 1;
	    for (Match bestClass : matches) {
	        System.out.println("Week " + classIndex + ":");
	        
	        System.out.println("Home: " + 
	                schedule.getHomeTeams(bestClass.getHometeamId()).getHometeamName());
	        System.out.println("Away: " + 
	                schedule.getAwayTeam(bestClass.getAwayteamId()).getAwayteamName
	                ());

	        System.out.println("Stadium: " + 
	                schedule.getStadium(bestClass.getStadiumId()).getStadiumName
	                ());
	       
	        System.out.println("Referee: " + 
	                schedule.getReferee(bestClass.getRefereeId()). getRefereeName(
	                		));
	        
	        System.out.println("Time: " + 
	                schedule.getTimeslot(bestClass.getTimesslotId()).getTimeslot());
	        
	        System.out.println("-----");
	        classIndex++;
	    }
	}

	/**
	 * Creates a Timetable with all the necessary course information.
	 * 
	 * Normally you'd get this info from a database.
	 * 
	 * @return
	 */
	private static Schedule initializeSchedule() {
		// Create timetable
		Schedule schedule = new Schedule();

		// Set up rooms
		

		// Set up timeslots
		schedule.addTimeslot(1, "Mon 9:00 - 11:00");
		schedule.addTimeslot(2, "Mon 11:00 - 13:00");
		schedule.addTimeslot(3, "Mon 13:00 - 15:00");
		schedule.addTimeslot(4, "Tue 9:00 - 11:00");
		schedule.addTimeslot(5, "Tue 11:00 - 13:00");
		schedule.addTimeslot(6, "Tue 13:00 - 15:00");
		schedule.addTimeslot(7, "Wed 9:00 - 11:00");
		schedule.addTimeslot(8, "Wed 11:00 - 13:00");
		schedule.addTimeslot(9, "Wed 13:00 - 15:00");
		schedule.addTimeslot(10, "Thu 9:00 - 11:00");
		schedule.addTimeslot(11, "Thu 11:00 - 13:00");
		schedule.addTimeslot(12, "Thu 13:00 - 15:00");
		schedule.addTimeslot(13, "Fri 9:00 - 11:00");
		schedule.addTimeslot(14, "Fri 11:00 - 13:00");
		schedule.addTimeslot(15, "Fri 13:00 - 15:00");
		schedule.addTimeslot(16, "Mon 9:00 - 11:00");
		schedule.addTimeslot(17, "Mon 11:00 - 13:00");
		schedule.addTimeslot(18, "Mon 13:00 - 15:00");
		schedule.addTimeslot(19, "Tue 9:00 - 11:00");
		schedule.addTimeslot(20, "Tue 11:00 - 13:00");

		// Set up professors
		schedule.addReferee(1, "Micheal Oliver");
		schedule.addReferee(2, "Paul Tierney");
		schedule.addReferee(3, "Anthony Taylor");
		schedule.addReferee(4, "Simon Hooper");
		schedule.addReferee(5, "Stuart Attwell");
		schedule.addReferee(6, "Andy Madley");
		schedule.addReferee(7, "Robert Jones");
		schedule.addReferee(8, "Craig Pawson");
		schedule.addReferee(9, "David Coote");
		schedule.addReferee(10, "Jarred Gillet");
		schedule.addReferee(11, "John Brooks");
		schedule.addReferee(12, "Darren England");
		schedule.addReferee(13, "Peter Bankes");
		schedule.addReferee(14, "Michael Salisbury");
		schedule.addReferee(15, "Andre Marriner");
		schedule.addReferee(16, "Tony Harrington");
		schedule.addReferee(17, "Chris Kavanagh");
		schedule.addReferee(18, "Graham Scott");
		schedule.addReferee(19, "Thomas Bramall");
		schedule.addReferee(20, "Robert Madley");
		
		
		

		// Set up modules and define the professors that teach them
		schedule.addHomeTeams(1,  "Liverpool", new int[] { 1 });
		schedule.addHomeTeams(2,  "Brentford", new int[] { 2 });
		schedule.addHomeTeams(3, "Fulham", new int[] { 3 });
		schedule.addHomeTeams(4,  "Leeds United", new int[] {  4 });
		schedule.addHomeTeams(5,  "Brighton & Hove Albion", new int[] { 5 });
		schedule.addHomeTeams(6,  "Everton FC", new int[] {  6 });
		schedule.addHomeTeams(7,  "Leicester City FC", new int[] { 7 });
		schedule.addHomeTeams(8,  "West Ham United", new int[] { 8 });
		schedule.addHomeTeams(9, "Wolverhampton Wanderers", new int[] { 9 });
		schedule.addHomeTeams(10,  "Manchester United FC", new int[] {  10 });
		schedule.addHomeTeams(11,  "Crystal Palace FC", new int[] { 11 });
		schedule.addHomeTeams(12,  "Newcastle United FC", new int[] {  12 });
		schedule.addHomeTeams(13,  "Southampton FC", new int[] { 12 });
		schedule.addHomeTeams(14, "Chelsea FC", new int[] { 14 });
		schedule.addHomeTeams(15,  "Nottingham Forest", new int[] {  15 });
		schedule.addHomeTeams(16,  "Arsenal FC", new int[] { 16 });
		schedule.addHomeTeams(17,  "Manchester City FC", new int[] {  17 });
		schedule.addHomeTeams(18,  "Tottenham Hotspur", new int[] {  18 });
		schedule.addHomeTeams(19,  "Aston Villa FC", new int[] { 19 });
		schedule.addHomeTeams(20,  "AFC Bournemouth", new int[] {  20 });
		
		
		// Set up AwayTeams
		schedule.addAwayTeams(1,  "Liverpool");
		schedule.addAwayTeams(2,  "Brentford");
		schedule.addAwayTeams(3, "Fulham");
		schedule.addAwayTeams(4,  "Leeds United");
		schedule.addAwayTeams(5,  "Brighton & Hove Albion");
		schedule.addAwayTeams(6,  "Everton FC");
		schedule.addAwayTeams(7,  "Leicester City FC");
		schedule.addAwayTeams(8,  "West Ham United");
		schedule.addAwayTeams(9, "Wolverhampton Wanderers");
		schedule.addAwayTeams(10,  "Manchester United FC");
		schedule.addAwayTeams(11,  "Crystal Palace FC");
		schedule.addAwayTeams(12,  "Newcastle United FC");
		schedule.addAwayTeams(13,  "Southampton FC");
		schedule.addAwayTeams(14, "Chelsea FC");
		schedule.addAwayTeams(15,  "Nottingham Forest");
		schedule.addAwayTeams(16,  "Arsenal FC");
		schedule.addAwayTeams(17,  "Manchester City FC");
		schedule.addAwayTeams(18,  "Tottenham Hotspur");
		schedule.addAwayTeams(19,  "Aston Villa FC");
		schedule.addAwayTeams(20,  "AFC Bournemouth");
		
		
		

		// Set up student groups and the modules they take.
		schedule.addStadium(1,"Anfield" );
		schedule.addStadium(2, "Community Stadium");
		schedule.addStadium(3,  "Craven Cottage");
		schedule.addStadium(4, "Elland Road");
		schedule.addStadium(5, "Falmer Stadium");
		schedule.addStadium(6, "Goddison Park");
		schedule.addStadium(7,  "King Power Stadium");
		schedule.addStadium(8,  "London Stadium");
		schedule.addStadium(9, "Molineux");
		schedule.addStadium(10,  "Old Trafford");
		schedule.addStadium(11,"Selhurst Park" );
		schedule.addStadium(12, "St James Park");
		schedule.addStadium(13,  "St Mary's");
		schedule.addStadium(14, "Stamford Bridge");
		schedule.addStadium(15, "The City Ground");
		schedule.addStadium(16, "The Emirates");
		schedule.addStadium(17,  "The Etihad");
		schedule.addStadium(18,  "Tottenham Hotspur Stadium");
		schedule.addStadium(19, "Villa Park");
		schedule.addStadium(20,  "Vitality Stadium");
		return schedule;
	}

}
