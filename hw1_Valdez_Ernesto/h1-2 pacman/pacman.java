import java.util.*;
public class pacman {

	public static void main(String[] args) throws InterruptedException
	{
		Scanner in=new Scanner(System.in);
		// TODO Auto-generated method stub
		// START THE GAME BY ASKING THE USER FOR THE SIZE OF THE GAME
		System.out.println("enter the legth of the game");
		int rows=in.nextInt();
		System.out.println("Enter the width of the game");
		int cols=in.nextInt();
		char[][] gameBoard = new char[rows][cols];
		// DETERMINE THE ACTUAL SIZE OF THE GAME SINCE THE OUTISDE LAYER IS NOT ACTUALLY
		// PLAYABLE AND WILL BE USED AS THE BOUNDARIES FOR THE "PACMAN"
		int actualSize=(rows-2)*(cols-2);
		// CREATE THE BOARD OR THE SPACE USING THE USERS NUMBERS
		for(int i = 0; i < rows; i++)
		{
			for(int x = 0; x < cols; x++)
			{
				gameBoard[i][x] ='*';
			}
		}
		
		// CREATE THE POSITION WHERE THE PACMAN WILL START
		// FOR SIMPLICITY WE WILL MAKE IT SO IT ENTERS IN THE 
		// SAME PLACE EVERTIME 
		int pos1 = 1;
		int pos2 = 1;
		gameBoard[pos1][pos2] = '@';
		int exit = 0;
		while(true)
		{
			for(int i = 1; i < rows-1; i++)
			{
				for(int j = 1; j < cols-1; j++)
				{
					if(gameBoard[i][j] == ' ' || gameBoard[i][j] == '@')
					{
						exit++;
					}
				}
			}
			//PRINTING THE SCREEEN OVER AND OVER AGAIN TO MAKE IT LOOK
			//LIKE EVERYTHING IS MOVING IN REAL TIME
			for(int i = 0; i < rows; i++)
			{
				for(int x = 0; x < cols; x++)
				{
					System.out.print(gameBoard[i][x]);
				}
				System.out.println();
			}
			System.out.println();
			Thread.sleep(1000);
			//MAKES THE PACMAN MOVE RANDOMLY ACROSS THE GAMEBOARD
			// WITHOUT LETTING THE PACMAN GET OUT OF BOUNDS
			// USING THE RANDOM NUMBER GENERATOR AND A COUPLE OF IF STATEMENTS
			// WE ARE ABLE TO SIMULATE THE PACMAN MOVING IN DIFFRENT DIRRECTIONS 
			gameBoard[pos1][pos2] = ' ';
			int path = (int)(Math.random()*5);
			if(path == 0 && pos1 < rows-2)
			{
				pos1 = pos1 + 1;
			}
			else if(path == 1 && pos2 < cols-2 )
			{
				pos2 = pos2 + 1;
			}
			else if(path == 2 && pos1 > 1)
			{
				pos1 = pos1 - 1;
			}
			else if(path == 3 && pos2 > 1)
			{
				pos2 = pos2 - 1;
			}
			else if(path==4 && pos1 <rows-2 &&pos2<cols-2)
			{
				pos1=pos1+1;
			}
			gameBoard[pos1][pos2] = '@';
			//exit condition that checks if the actual space (rows-2)(cols-2)
			// is empty if so exit out
			if(exit == actualSize)
			{
				break;
			}
			exit = 0;
			
		}
		// exit message to player :p
		System.out.println("GAME OVER :) HOPE YOU HAD FUN!!!");
	}

}


