package targetinterview.barrenlandanalysis;

public class ValidateFarmData {
	
	private static String Farm_Coordinates_OutOfBounds_Error_Message_Fmt = "Process skipped, BarrenLand not in the specified area";
	private static String Farm_Coordinates_Invalid_Error_Message_Fmt = "Process skipped, CoOrdinates invalid";
	
	
	private static String ValidateBarrenCoOrdinate(String x, String y, int length, int breadth) {
		String message = "";
		try {
			int xVal = Integer.parseInt(x);
			int yVal = Integer.parseInt(y);
			if (xVal >= length || 
					yVal >= breadth || 
					xVal < 0 || 
					yVal < 0) {
					message = Farm_Coordinates_OutOfBounds_Error_Message_Fmt;
				}	
		} catch (Exception ex){
			message = Farm_Coordinates_Invalid_Error_Message_Fmt;
		}
		
		return message;
	}
	
	public static String ValidateBarrenRaw(String[] coordinates, int length, int breadth) {
		String message = "";
		if (coordinates.length != 4) {
			message = Farm_Coordinates_Invalid_Error_Message_Fmt;
		} else {
			message = ValidateBarrenCoOrdinate(coordinates[0], coordinates[1], length, breadth);
			if (message.isBlank()) {
				message = ValidateBarrenCoOrdinate(coordinates[2], coordinates[3], length, breadth);	
			}
		}
		
		return message;
	}
}
