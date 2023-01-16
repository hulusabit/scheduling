package fixture;

public class AwayTeams {
	private final int awayteamId;
    private final String awayteamName;

    /**
     * Initalize new Timeslot
     * 
     * @param timeslotId The ID for this timeslot
     * @param timeslot The timeslot being initalized
     */
    public AwayTeams(int awayteamId, String awayteamName){
        this.awayteamId = awayteamId;
        this.awayteamName = awayteamName;
    }
    
    /**
     * Returns the timeslotId
     * 
     * @return timeslotId
     */
    public int getAwayteamId(){
        return this.awayteamId;
    }
    
    /**
     * Returns the timeslot
     * 
     * @return timeslot
     */
    public String getAwayteamName(){
        return this.awayteamName;
    }


}
