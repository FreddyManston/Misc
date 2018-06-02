class voteRecorder
{
	private static String nameCandidatePresident1;
	private static String nameCandidatePresident2;
	private static String nameCandidateVicePresident1;
	private static String nameCandidateVicePresident2;
	public static int votesCandidatePresident1;
	public static int votesCandidatePresident2;
	public static int votesCandidateVicePresident1;
	public static int votesCandidateVicePresident2;
	public int myVoteForPresident; //individual's vote for a president (0 for no choice, 1 for first candidate, and 2 for the second candidate)
	public int myVoteForVicePresident; //individual's vote for a vice president (0 for nothing, 1 for first candidate, 2 for the second candidate)

	public voteRecorder()		// Default constructor.
	{
		nameCandidatePresident1 = "No name yet.";
		nameCandidatePresident2 = "No name yet.";
		nameCandidateVicePresident1 = "No name yet.";
		nameCandidateVicePresident2 = "No name yet.";
	}
	
	public voteRecorder(String name1, String name2, String name3, String name4)	// Constructor for the names of the four candidates.
	{
		nameCandidatePresident1 = name1;
		nameCandidatePresident2 = name2;
		nameCandidateVicePresident1 = name3;
		nameCandidateVicePresident2 = name4;	
	}
	
	public static void setPresidentCandidates(String name1, String name2)
	{
		nameCandidatePresident1 = name1;
		nameCandidatePresident2 = name2;
	}
	
	public static void setVicePresidentCandidates(String name1, String name2)
	{
		nameCandidateVicePresident1 = name1;
		nameCandidateVicePresident2 = name2;
	}
	
	public static void resetVotes()
	{
		votesCandidatePresident1 = 0;
		votesCandidatePresident2 = 0;
	}
	
	public static String getCurrentVotePresident()
	{
		String votesForEach = nameCandidatePresident1 + " - " + votesCandidatePresident1 + "\n" + nameCandidatePresident2 + " - " +  votesCandidatePresident2;
		return (votesForEach);
	}
	
	public static String getCurrentVoteVicePresident()
	{
		String votesForEach = nameCandidateVicePresident1 + " - " + votesCandidateVicePresident1 + "\n" + nameCandidateVicePresident2 + " - " +  votesCandidateVicePresident2;
		return (votesForEach);
	}
	
	public void getAndConfirmVote1(int vote)
	{
		if (vote < 0 || vote > 2)
		{
			System.out.println("Invalid input. This vote will not be recorded.");
			return;
		}
		else
		{
			switch(vote)
			{
				case 1:
				votesCandidatePresident1 ++;
				break;
				
				case 2:
				votesCandidatePresident2 ++;
				break;	
			}
		}
		
	}
	
	public void getAndConfirmVote2(int vote)
	{
		if (vote < 0 || vote > 2)
		{
			System.out.println("Invalid input. This vote will not be recorded.");
			return;
		}
		else
		{
			switch(vote)
			{
				case 1:
				votesCandidateVicePresident1 ++;
				break;
				
				case 2:
				votesCandidateVicePresident2 ++;
				break;	
			}
		}
		
	}
	
	private recordVotes(vote);
}


