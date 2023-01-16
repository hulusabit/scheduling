package fixture;

public class Match {

		private final int matchId;
		private final int hometeamId;
		private final int stadiumId;
		private int refereeId;
		private int timeslotId;
		private int awayteamId;
	
		
		public Match(int matchId, int hometeamId, int stadiumId) {
			this.matchId = matchId;
			this.hometeamId = hometeamId;
			this.stadiumId = stadiumId;
		}
		
		public void addReferee(int refereeId) {
			this.refereeId = refereeId;
		}
		
		public void addAwayteam(int awayteamId) {
			this.awayteamId = awayteamId;
		}
		
		public void addTimeslot(int timeslotId) {
			this.timeslotId = timeslotId;
		}
		
		
		
		public int getMatchId() {
			return this.matchId;
			
		}
		
		public int getHometeamId() {
			return this.hometeamId;
		}
		
		public int getStadiumId() {
			return this.stadiumId;
		}
		
		public int getRefereeId() {
			return this.refereeId;
		}
		
		public int getTimesslotId() {
			return this.timeslotId;
		}
		public int getAwayteamId() {
			return this.awayteamId;
		}
	
		
	
		


}
