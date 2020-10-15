package targetinterview.barrenlandanalysis;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for Barren Land Algo.
 */
public class BarrenLandAnalysisAlgoTest {
	
	@Test
    public void testFindFertileLand1() {
        String[] barrenCoordinates = {"0 292 399 307"};
        int length 	= 400;
        int breadth = 600;
        String expectedResponse = "116800 116800 ";
        Farm farm = new Farm(length, breadth);
        farm.setBarrenCoordinates(barrenCoordinates);
        farm.startCalculation();
        assertEquals(expectedResponse, farm.getReponse());
    }
	
	@Test
    public void testFindFertileLand2() {
        String[] barrenCoordinates = {"48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275 547"};
        int length 	= 400;
        int breadth = 600;
        String expectedResponse = "22816 192608 ";
        Farm farm = new Farm(length, breadth);
        farm.setBarrenCoordinates(barrenCoordinates);
        farm.startCalculation();
        assertEquals(expectedResponse, farm.getReponse());
    }
	
	@Test
    public void testFindFertileLand3() {
        String[] barrenCoordinates = {"0 0 0 599"};
        int length 	= 400;
        int breadth = 600;
        String expectedResponse = "239400 ";
        Farm farm = new Farm(length, breadth);
        farm.setBarrenCoordinates(barrenCoordinates);
        farm.startCalculation();
        assertEquals(expectedResponse, farm.getReponse());

    }
	
	@Test
    public void testFindFertileLand4() {
        String[] barrenCoordinates = {"0 0 399 599"};
        int length 	= 400;
        int breadth = 600;
        String expectedResponse = "No Fertile Land Found";
        Farm farm = new Farm(length, breadth);
        farm.setBarrenCoordinates(barrenCoordinates);
        farm.startCalculation();
        assertEquals(expectedResponse, farm.getReponse());
    }
	
	@Test
    public void testFindFertileLand5() {
        String[] barrenCoordinates = {"0 2 4 7", "5 0 9 7", "4 7 7 9"};
        int length 	= 10;
        int breadth = 10;
        String expectedResponse = "4 8 10 ";
        Farm farm = new Farm(length, breadth);
        farm.setBarrenCoordinates(barrenCoordinates);
        farm.startCalculation();
        farm.printLand();
        assertEquals(expectedResponse, farm.getReponse());
    }
	
	@Test
    public void testInvalidCoordinates() {
        String[] barrenCoordinates = {" 2 4 7", "5 0 9 7", "4 7 7 9"};
        int length 	= 10;
        int breadth = 10;
        String expectedResponse = "Process skipped, CoOrdinates invalid";
        Farm farm = new Farm(length, breadth);
        farm.setBarrenCoordinates(barrenCoordinates);
        farm.startCalculation();
        assertEquals(expectedResponse, farm.getReponse());
    }
	
	@Test
    public void testOutOfBoundsBarrenCoordinates() {
        String[] barrenCoordinates = {"11 2 4 7", "5 0 9 7", "4 7 7 9"};
        int length 	= 10;
        int breadth = 10;
        String expectedResponse = "Process skipped, BarrenLand not in the specified area";
        Farm farm = new Farm(length, breadth);
        farm.setBarrenCoordinates(barrenCoordinates);
        farm.startCalculation();
        assertEquals(expectedResponse, farm.getReponse());
    }


}
