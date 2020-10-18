package targetinterview.barrenlandanalysis;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class BarrenLandAnalysisAlgo 
{
    private static final int LENGTH = 400;
    private static final int BREADTH = 600;
    
    public static void main( String[] args )
    {
//    	{"0 292 399 307"}
//    	{"48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275 547"}
//    	String[] barrenCoordinates = {"0 292 399 307"};
    	Farm farm = new Farm(LENGTH, BREADTH);
		System.out.println("Barren Coordinates are set of 4 co-ordinates saperated by ','");
		System.out.println("Example: 48 192 351 207, 48 392 351 407 , 120 52 135 547 , 260 52 275 547");
		Scanner myIP = new Scanner(System.in);
    	while (true) {
    		System.out.println("Enter Barren Coordinates: ");
    		String barrenCoordinatesStr = myIP.nextLine();
    		if (barrenCoordinatesStr.equals("X")) {
    			System.out.println("Process exiting..");
    			break;
    		} else {
        		String[] barrenCoordinates = barrenCoordinatesStr.trim().split(","); 
            	farm.setBarrenCoordinates(barrenCoordinates);
            	System.out.println(farm.getFertileLandAreas());
        		System.out.println("Type X to exit..");
        		System.out.println("");
    		}
    	}

    }
}
