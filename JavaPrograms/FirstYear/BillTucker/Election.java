import java.util.Scanner;

public class Election
{
	public static void main (String[] args)
	{
		Scanner RedStreak = new Scanner (System.in);
		voteRecorder newVoter = new voteRecorder();
		
		boolean bool_voteAgain = true;
		while (bool_voteAgain)
		{
			newVoter = new voteRecorder("Annie", "Bob", "John", "Susan");
			System.out.println("Which president are you voting for? \n0 - No vote\n1 - Annie P. Delcarme\n2 - Bobelinso B. Boycott");
			int president_vote = RedStreak.nextInt();
			newVoter.getAndConfirmVote1(president_vote);
			System.out.println("Which vice president are you voting for? \n0 - No vote\n1 - Johnny Knox\n2 - Susanna Francis");
			int vice_president_vote = RedStreak.nextInt();
			newVoter.getAndConfirmVote2(vice_president_vote);
			
			System.out.println("Would you like to vote again? Y/N");
			String string_voteAgain = RedStreak.next();
			if (string_voteAgain.equalsIgnoreCase("N"))
				bool_voteAgain = false;
		}
		
		System.out.println("The outcome of the votes are as follows:");
		System.out.println(newVoter.getCurrentVotePresident());
		System.out.println(newVoter.getCurrentVoteVicePresident());
	}
}

