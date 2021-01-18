//Contestant ID: 01-0024-0045
import java.util.InputMismatchException;
import java.util.Scanner;

public class Movies {

	public static void main(String[] args) {
		Scanner numInput = new Scanner(System.in);
		try {
			//ask for the number of movies being rated
			System.out.println("How many movies are you rating?");
			int numMovies = numInput.nextInt();
			System.out.println();
			if(numMovies < 0) {
				throw new InputMismatchException("Incorrect data has been entered");
			}
			
			for(int i = 0; i < numMovies; i++) {
				//ask for the three website ratings, and calculate the average
				System.out.println("Please enter ratings from the movie review website for movie #" + (i + 1));
				int webRatingOne = numInput.nextInt();
				if(webRatingOne <= 0 || webRatingOne > 100) throw new InputMismatchException("Incorrect data has been entered");
				
				int webRatingTwo = numInput.nextInt();
				if(webRatingTwo <= 0 || webRatingTwo > 100) throw new InputMismatchException("Incorrect data has been entered");
				
				int webRatingThree = numInput.nextInt();
				if(webRatingThree <= 0 || webRatingThree > 100) throw new InputMismatchException("Incorrect data has been entered");
				
				double webRatingAvg = Math.round(((webRatingOne + webRatingTwo + webRatingThree) / 3.0) * 100.0) / 100.0;
				System.out.println();
				
				//ask for the two focus group ratings, and calculate the average
				System.out.println("Please enter ratings from the focus group for movie #" + (i + 1));
				double focusGroupRatOne = numInput.nextDouble();
				if(focusGroupRatOne <= 0 || focusGroupRatOne > 100) throw new InputMismatchException("Incorrect data has been entered");
				
				double focusGroupRatTwo = numInput.nextDouble();
				if(focusGroupRatTwo <= 0 || focusGroupRatTwo > 100) throw new InputMismatchException("Incorrect data has been entered");
				
				double focusGroupRatAvg = Math.round(((focusGroupRatOne + focusGroupRatTwo) / 2.0) * 100.0) / 100.0;
				System.out.println();
				
				//generate a random double for the movie critic rating from [1, 100]
				double movieCritRating = Math.round((Math.random() * 99 + 1) * 100.0) / 100.0;
				double overallMovieRat = Math.round(((webRatingAvg * .2) + (focusGroupRatAvg * .3) + (movieCritRating * .5)) * 100.0) / 100.0;
				
				//print out all of the rating/review information
				System.out.println("Ratings for movie #" + (i + 1));
				System.out.println("Average website rating: " + webRatingAvg);
				System.out.println("Average focus group rating: " + focusGroupRatAvg);
				System.out.println("Average movie critic rating: " + movieCritRating);
				System.out.println("Overall movie rating: " + overallMovieRat);
				System.out.println("Press c, then ENTER to continue");
				numInput.next();
			}
			
		}
		catch(InputMismatchException e) {
			System.err.println("Incorrect data has been entered");
			System.out.println("Press c, then ENTER to close");
			numInput.next();
		}
	}
}
