//Nathan Blue
//Exercise 14.5
import java.security.SecureRandom;

public class E14_5
{
	public static void main(String[] args)
	{
		SecureRandom random = new SecureRandom();

		String[] article = {"the", "a", "one", "some", "any"};
		String[] noun = {"boy", "girl", "dog", "town", "car"};
		String[] verb = {"drove", "jumped", "ran", "walked", "skipped"};
		String[] preposition = {"to", "from", "over", "under", "on"};

		String sentence = "";

		for(int i = 0; i < 20; i++)
		{
			sentence = article[random.nextInt(5)] + " " +
					   noun[random.nextInt(5)] + " " +
					   verb[random.nextInt(5)] + " " +
					   preposition[random.nextInt(5)] + ".";

			sentence = sentence.substring(0, 1).toUpperCase() + sentence.substring(1);
			System.out.println((i + 1) + " - " + sentence);
			sentence = "";
		}
	}
}

/*
Example Output:

1 - Any boy walked on.
2 - A car jumped to.
3 - Any car drove from.
4 - The dog walked to.
5 - Any town walked on.
6 - The town skipped to.
7 - Some car jumped from.
8 - Some dog jumped under.
9 - Some dog drove over.
10 - Any car walked over.
11 - One boy jumped from.
12 - The town skipped on.
13 - One girl skipped on.
14 - Any dog skipped under.
15 - Any dog drove to.
16 - Some girl jumped under.
17 - Some girl skipped from.
18 - Some town skipped over.
19 - One boy drove to.
20 - One car jumped from.
*/