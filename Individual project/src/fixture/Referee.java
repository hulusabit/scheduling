package fixture;

public class Referee {
	private final int refereeId;
    private final String refereeName;

    /**
     * Initalize new Professor
     * 
     * @param professorId The ID for this professor
     * @param professorName The name of this professor
     */
    public Referee(int refereeId, String refereeName){
        this.refereeId = refereeId;
        this.refereeName = refereeName;
    }
    
    /**
     * Get professorId
     * 
     * @return professorId
     */
    public int getRefereeId(){
        return this.refereeId;
    }
    
    /**
     * Get professor's name
     * 
     * @return professorName
     */
    public String getRefereeName(){
        return this.refereeName;
    }

}
