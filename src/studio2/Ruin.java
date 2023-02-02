package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Start Amount: ");
		int startAmount = in.nextInt();
		System.out.println("Enter Win Probability: ");
		double winChance = in.nextDouble();
		System.out.println("Enter Win Limit: ");
		int winLimit = in.nextInt();
		int currentAmount = startAmount;
		int simulationNumber = 0;
		int plays = 0;
		int totalWins = 0;
		int totalLosses = 0;
		System.out.println("Enter Days You Want to Play: ");
		int totalSimulations = in.nextInt();
		for(int i = 1; i <= totalSimulations; i++)
		{
			currentAmount = startAmount;
			simulationNumber++;
			plays = 0;
			while(currentAmount<winLimit && currentAmount>0)
			{
				plays++;
				double diceRoll = Math.random();
				if(diceRoll<winChance)
				{
					currentAmount++;
					//				System.out.println("Simulation " + totalSimulations + ": You win 1 dollar!");
					//				System.out.println("Current Balance: " + startAmount);
					//				System.out.println();

				}
				else
				{
					currentAmount--;
					//				System.out.println("Simulation " + totalSimulations + ": You lose 1 dollar :(");
					//				System.out.println("Current Balance: " + startAmount);
					//				System.out.println();

				}


			}
			if(currentAmount==winLimit)
			{
				System.out.println("Simulation " + simulationNumber + ": " + plays + " Win");
				totalWins++;
			}
			else
			{
				System.out.println("Simulation " + simulationNumber + ": " + plays + " Lose");
				totalLosses++;
			}
		}
		
		System.out.println();
		System.out.println("Losses: " + totalLosses + " Simulations: " + totalSimulations);
		double expectedRuin = 0;
		double ruinRate = (totalLosses * 1.0)/ totalSimulations;
		if(winChance==0.5)
		{
			expectedRuin = 1.0 - ((1.0 * startAmount) / winLimit);
		}
		else
		{
			double alpha = (1 - winChance) / winChance;
			expectedRuin = (Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit)) / (1 - Math.pow(alpha,  winLimit));
			
		}
		
		System.out.println("Ruin rate from simulations: " + ruinRate + " Expected ruin rate: " + expectedRuin);
	}
	

}
