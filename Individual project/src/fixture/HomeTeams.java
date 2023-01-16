package fixture;

public class HomeTeams {
	 private final int hometeamId;
	 private final String hometeamName;
	 private final int stadiumIds[];

	    

	    /**
	     * Initialize Group
	     * 
	     * @param groupId
	     * @param groupSize
	     * @param moduleIds
	     */
	    public HomeTeams(int hometeamId,String hometeamName, int stadiumIds[]){
	        this.hometeamId = hometeamId;
	        this.hometeamName = hometeamName;
	        this.stadiumIds = stadiumIds;
	      
	       
	    }
	    
	    /**
	     * Get groupId
	     * 
	     * @return groupId
	     */
	    public int getHometeamId(){
	        return this.hometeamId;
	    }
	    
	    /**
	     * Get groupSize
	     * 
	     * @return groupSize
	     */
	   
	    /**
	     * Get array of group's moduleIds
	     * 
	     * @return moduleIds
	     */

	    
	    public String getHometeamName() {
	    	return this.hometeamName;
	    	
	    }
	    public int[] getStadiumIds() {
	    	return this.stadiumIds;
	    }


}
