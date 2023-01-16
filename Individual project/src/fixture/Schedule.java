package fixture;

import java.util.HashMap;



public class Schedule {
	private final HashMap<Integer, Referee> referees;
    private final HashMap<Integer, AwayTeams> awayteams;
	private final HashMap<Integer, Timeslot> timeslots;
	private final HashMap<Integer, HomeTeams> hometeams;
	private final HashMap<Integer, Stadium> stadium;
    private Match matches[];

	private int numMatches = 0;

	/**
	 * Initialize new Timetable
	 */
	public Schedule() {
	
		this.referees = new HashMap<Integer, Referee>();
	    this.hometeams = new HashMap<Integer, HomeTeams>();
	    this.awayteams = new HashMap<Integer, AwayTeams>();
	    this.timeslots = new HashMap<Integer, Timeslot>();
	    this.stadium = new HashMap<Integer, Stadium>();

		
		
		
	}

	/**
	 * "Clone" a timetable. We use this before evaluating a timetable so we have
	 * a unique container for each set of classes created by "createClasses".
	 * Truthfully, that's not entirely necessary (no big deal if we wipe out and
	 * reuse the .classes property here), but Chapter 6 discusses
	 * multi-threading for fitness calculations, and in order to do that we need
	 * separate objects so that one thread doesn't step on another thread's
	 * toes. So this constructor isn't _entirely_ necessary for Chapter 5, but
	 * you'll see it in action in Chapter 6.
	 * 
	 * @param cloneable
	 */
	public Schedule(Schedule cloneable) {
	
		this.referees = cloneable.getReferees();
	    this.hometeams = cloneable.getHomeTeams();
	    this.stadium = cloneable.getStadium();
	    this.awayteams = cloneable.getAwayTeams();
		this.timeslots = cloneable.getTimeslots();
	
		

	}

	private HashMap<Integer, Stadium> getStadium() {
		
		return this.stadium;
	}

	private HashMap<Integer, HomeTeams> getHomeTeams() {
		return this.hometeams;
	}
	private HashMap<Integer, AwayTeams> getAwayTeams() {
		return this.awayteams;
	}

	private HashMap<Integer, Timeslot> getTimeslots() {
		return this.timeslots;
	}

	private HashMap<Integer, Referee> getReferees() {
		return this.referees;
	}
	
	
	

	/**
	 * Add new room
	 * 
	 * @param roomId
	 * @param roomName
	 * @param capacity
	 */
	

	/**
	 * Add new professor
	 * 
	 * @param professorId
	 * @param professorName
	 */
	public void addReferee(int refereeId, String refereeName) {
		this.referees.put(refereeId, new Referee(refereeId, refereeName));
	}
	
	public void addHomeTeams(int hometeamId, String hometeamName, int stadiumIds[]) {
		this.hometeams.put(hometeamId, new HomeTeams(hometeamId, hometeamName, stadiumIds));
		this.numMatches = 0;
		
	}
	


	
	

	/**
	 * Add new group
	 * 
	 * @param groupId
	 * @param groupSize
	 * @param moduleIds
	 */
	public void addStadium(int stadiumId,String stadiumName) {
		this.stadium.put(stadiumId, new Stadium(stadiumId, stadiumName
				));
		this.numMatches = 0;
	}

	/**
	 * Add new timeslot
	 * 
	 * @param timeslotId
	 * @param timeslot
	 */
	public void addTimeslot(int timeslotId, String timeslot) {
		this.timeslots.put(timeslotId, new Timeslot(timeslotId, timeslot));
	}
	
	public void addAwayTeams(int awayteamId, String awayteamName) {
		this.awayteams.put(awayteamId, new AwayTeams(awayteamId, awayteamName));
	}
	

	/**
	 * Create classes using individual's chromosome
	 * 
	 * One of the two important methods in this class; given a chromosome,
	 * unpack it and turn it into an array of Class (with a capital C) objects.
	 * These Class objects will later be evaluated by the calcClashes method,
	 * which will loop through the Classes and calculate the number of
	 * conflicting timeslots, rooms, professors, etc.
	 * 
	 * While this method is important, it's not really difficult or confusing.
	 * Just loop through the chromosome and create Class objects and store them.
	 * 
	 * @param individual
	 */
	public void createMatches(Individual individual) {
		// Init classes
		Match matches[] = new Match[this.getNumMatches()];

		// Get individual's chromosome
		int chromosome[] = individual.getChromosome();
		int chromosomePos = 0;
		int classIndex = 0;

		for (HomeTeams hometeams : this.getHomeTeamsAsArray()) {
			int stadiumIds[] = hometeams.getStadiumIds();
			for (int stadiumId : stadiumIds) {
				matches[classIndex] = new Match(classIndex, hometeams.getHometeamId(), stadiumId);

				// Add timeslot
				matches[classIndex].addTimeslot(chromosome[chromosomePos]);
				chromosomePos++;
				
				//Add awayteams
				matches[classIndex].addAwayteam(chromosome[chromosomePos]);
				chromosomePos++;

				

				// Add professor
				matches[classIndex].addReferee(chromosome[chromosomePos]);
				chromosomePos++;

				classIndex++;
				 
				
				 }
			}
		

		this.matches = matches;
	}

	

	/**
	 * Get room from roomId
	 * 
	 * @param roomId
	 * @return room
	 */
	
	/**
	 * Get random room
	 * deleted add if needed
	 * 
	 * @return room
	 */

	

	/**
	 * Get professor from professorId
	 * 
	 * @param professorId
	 * @return professor
	 */
	public Referee getReferee(int refereeId) {
		return (Referee) this.referees.get(refereeId);
	}
	
	public Stadium getStadium(int stadiumId) {
		return (Stadium) this.stadium.get(stadiumId);
	}
	
	

	/**
	 * Get module from moduleId
	 * 
	 * @param moduleId
	 * @return module
	 */
	public HomeTeams getHomeTeams(int hometeamId) {
		return(HomeTeams) this.hometeams.get(hometeamId);
	}
	
	

	/**
	 * Get moduleIds of student group
	 * 
	 * @param groupId
	 * @return moduleId array
	 */
	

	/**
	 * Get group from groupId
	 * 
	 * @param groupId
	 * @return group
	 */
	public AwayTeams getAwayTeam(int awayteamId) {
		return (AwayTeams) this.awayteams.get(awayteamId);
	}
	
	public HomeTeams[] getHomeTeamsAsArray() {
		return(HomeTeams[]) this.hometeams.values().toArray(new HomeTeams[this.hometeams.size()]);
	}
	

	/**
	 * Get all student groups
	 * 
	 * @return array of groups
	 */
	
	

	/**
	 * Get timeslot by timeslotId
	 * 
	 * @param timeslotId
	 * @return timeslot
	 */
	public Timeslot getTimeslot(int timeslotId) {
		return (Timeslot) this.timeslots.get(timeslotId);
	}

	/**
	 * Get random timeslotId
	 * 
	 * @return timeslot
	 */
	public Timeslot getRandomTimeslot() {
		Object[] timeslotArray = this.timeslots.values().toArray();
		Timeslot timeslot = (Timeslot) timeslotArray[(int) (timeslotArray.length * Math.random())];
		return timeslot;
	}
	
	
	public AwayTeams getRandomAwayTeams() {
		Object[] awayteamArray = this.awayteams.values().toArray();
		AwayTeams awayteam = (AwayTeams) awayteamArray[(int) (awayteamArray.length * Math.random())];
		return awayteam;
	}
	
	
	public Referee getRandomReferee() {
		Object[] refereeArray = this.referees.values().toArray();
		Referee referee = (Referee) refereeArray[(int) (refereeArray.length * Math.random())];
		return referee;
	}
	

	/**
	 * Get classes
	 * 
	 * @return classes
	 */
	public Match[] getMatches() {
		return this.matches;
	}
	

	/**
	 * Get number of classes that need scheduling
	 * 
	 * @return numClasses
	 */
	public int getNumMatches() {
		if (this.numMatches > 0) {
			return this.numMatches;
		}
		

		int numMatches = 0
				;
		
		HomeTeams hometeams[] = (HomeTeams[]) this.hometeams.values().toArray(new HomeTeams[this.hometeams.size()]);
		for (HomeTeams hometeam : hometeams) {
			numMatches += hometeam.getStadiumIds().length;

		}
		this.numMatches = numMatches;

		return this.numMatches;
	}

	/**
	 * Calculate the number of clashes between Classes generated by a
	 * chromosome.
	 * 
	 * The most important method in this class; look at a candidate timetable
	 * and figure out how many constraints are violated.
	 * 
	 * Running this method requires that createClasses has been run first (in
	 * order to populate this.classes). The return value of this method is
	 * simply the number of constraint violations (conflicting professors,
	 * timeslots, or rooms), and that return value is used by the
	 * GeneticAlgorithm.calcFitness method.
	 * 
	 * There's nothing too difficult here either -- loop through this.classes,
	 * and check constraints against the rest of the this.classes.
	 * 
	 * The two inner `for` loops can be combined here as an optimization, but
	 * kept separate for clarity. For small values of this.classes.length it
	 * doesn't make a difference, but for larger values it certainly does.
	 * 
	 * @return numClashes
	 */
	public int calcClashes() {
		int clashes = 0;
		
		for (Match teamA : this.matches) {
			for (Match teamB: this.matches) {
			
			if(teamA.getHometeamId() == teamB.getAwayteamId()) {
				clashes++;
				break;
				
			}
		}
		}
		

		

		return clashes;
	}


}


