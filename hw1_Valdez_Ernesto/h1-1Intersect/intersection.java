/**
 * NAME: Ernesto Valdez
 * DATE: 9-15-16
 * CLASS: JAVA
 *
 */
import java.util.Scanner;
public class intersection {
public static void main(String[] args) {
	Scanner in= new Scanner(System.in);
	// make an array for the inputs
	double [] x1=new double [2];
	double [] y1=new double [2];
	double [] x2=new double [2];
	double [] y2= new double [2];
	// Ask the user for input
	System.out.println("Please input the first point for the first line segment");
	x1[0]=in.nextDouble(); // x1
	x1[1]=in.nextDouble(); // y1
	System.out.println("Please input the seconds point for the first line segment");
	y1[0]=in.nextDouble(); //x2
	y1[1]=in.nextDouble();//y2
	System.out.println("Please input the first point for second line segment");
	x2[0]=in.nextDouble(); //x1
	x2[1]=in.nextDouble(); //y1
	System.out.println("Please input the second point for the second line segment");
	y2[0]=in.nextDouble(); //x2
	y2[1]=in.nextDouble();//y2
	
	
	// now that we have the data stored in variables we can use the points to
	// get the slope of each of the lines to determine if they intersect or not
	//************* SLOPE FORMULA m=(y2-y1)/(x2-x1)************
	double m1=(y1[1]-(x1[1]))/(y1[0]-(x1[0]));
	double m2=(y2[1]-(x2[1]))/(y2[0]-(x2[0]));
	//System.out.println("*****************Slopes*************");
	//////////////////////////////////////////////////////////////////
	// now that we have the slopes of each of the lines now we can find out
	// if they intersect or not by calculating the y intercept
	// then plugging everything into the following two formulas
	//y=ax+c ; y=bx+d
	// if they following equations are they same then they intercept
	//////////////////////////////////////////////////////////////////////
	//lets calculate the y intercepts c and d for the respective lines
	double c=x1[1]-(m1*x1[0]);
	double d=x2[1]-(m2*x2[0]);
	//System.out.println("****************Y intercepts(C and D)****************");
	double xx= (((d-c)/(m1-m2)));
	//System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	// now find the value of x in the formula
	// now all thats left to do it plug everything into the equations and check
	// if they are the same  :)
	// NOTE x=1
	double y1In=(m1*xx)+c;
	double y2In=(m2*xx)+d;
	//System.out.println("****************Lines**************");
	if(Double.isNaN(y1In))
	{
		y1In=0;
	}
	if(Double.isNaN(y2In))
	{
		y2In=0;
	}
	
	 // condiditons to check if they intersect or not
	if(y1In==y2In)
	{ 
		if(m1==m2)
		{
			if(c==d)
			{
				System.out.println("Intersection");
			}
			else
				System.out.println("No Intersection");
		}
		else if(c!=d)
		{ 
			if(m1==m2)
				System.out.println("No Intersection");
			else if(m2==c || m2==d)
			{
				if(x1[0]==x2[0])
					System.out.println("Intersection");
				else
					System.out.println("No Intersection");
			}
			else
				System.out.println("Intersection");
		 }
		 else
		 {
			 System.out.println("Intersection");
		 }
	 }
	  else if(c!=d)
	  {
		System.out.println("No Intersection");
	  }
   } 

}
