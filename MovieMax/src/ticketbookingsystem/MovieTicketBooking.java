package ticketbookingsystem;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MovieTicketBooking implements TicketBookService{

	 private static final int PLATINUM_COST = 320;
	 private static final int GOLD_COST = 280;
	 private static final int SILVER_COST = 240;
	 private static final double SERVICE_TAX_RATE = 0.14;
	 private static final double SBC_RATE = 0.005;
	 private static final double KKC_RATE = 0.005;
	 
	 
	 private static final Map<Character, Integer>  rowPrices = new HashMap<>();
	 static {
	 rowPrices.put('A', PLATINUM_COST);
	 rowPrices.put('B', GOLD_COST);
	 rowPrices.put('C', SILVER_COST);
	 }
	 
	private static final Set<String> availableSeats = new HashSet<>();
	 
	
	static {
	 availableSeats.add("A1"); availableSeats.add("A2"); availableSeats.add("A3"); 
	 availableSeats.add("A4"); availableSeats.add("A5"); availableSeats.add("A6"); 
	 availableSeats.add("A7"); availableSeats.add("A8"); availableSeats.add("A9"); 
	 availableSeats.add("B1"); availableSeats.add("B2"); availableSeats.add("B3");
	 availableSeats.add("B4"); availableSeats.add("B5"); availableSeats.add("B6"); 
	 availableSeats.add("C2"); availableSeats.add("C3"); availableSeats.add("C4"); 
	 availableSeats.add("C5"); availableSeats.add("C6"); availableSeats.add("C7");
	 }
	
	public void ticketbookservice() {
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			
			int showNo = getShowNumber(scanner);
			
			 System.out.println("Entered Show no is: " + showNo);
			 System.out.println("Available seats:");
			 printAvailableSeats();
			 
			 
		ArrayList<String> inputList = new ArrayList<>();

		while (true) {
		   System.out.print("Enter seat numbers (or '.' to stop): ");
		   String input = scanner.nextLine();
		   if (input.equals(".")) {
		     break;
		    }
		   	inputList.add(input);
		 }

		 //System.out.println("Input values: " + inputList);
		 
		 String seat;
		 int price;
		 double serviceTax;
		 double sbc ;
		 double kkc;
		 double total;
		 double subtotal = 0;
		 int book = 0;
		 
		 for (int i = 0; i <= inputList.size()-1; i++) {
			 String number = inputList.get(i);
			   
			 seat = number;
			 
			 
			 if (availableSeats.contains(seat)) {
				 availableSeats.remove(seat);
			   price = getPrice(seat);
			   book = +1;
			   subtotal = subtotal + price;
			   }
			 
			 else {
				 System.out.println("Seat not available. Please try again.");
			 } 
			}
		  
		 if(book > 0) {
			 System.out.println("Successfully Booked - Show" + showNo);
		 }
		 
		 
		   DecimalFormat df = new DecimalFormat("##.##");
		 
		   serviceTax = subtotal * SERVICE_TAX_RATE;
		   sbc = subtotal * SBC_RATE;
		   kkc = subtotal * KKC_RATE;
		   total = subtotal + serviceTax + sbc + kkc;
		   
		   System.out.println("Subtotal: Rs." + df.format(subtotal));
		   System.out.println("Service Tax @14%: Rs." + df.format(serviceTax));
		   System.out.println("Swachh Bharat Cess @0.5%: Rs." + df.format(sbc));
		   System.out.println("Krishi Kalyan Cess @0.5%: Rs." + df.format(kkc));
		   System.out.println("Total: Rs." + df.format(total));
		 	
		 
		 	break;
		 	
		 }
		
	          
	}

	
			 private static int getShowNumber(Scanner scanner) {
			 int showNo;
			 do {
			 System.out.print("Enter show number (1-5): ");
			 showNo = scanner.nextInt();
			 scanner.nextLine(); // consume newline character
			 } while (showNo < 1 || showNo > 5);
			 return showNo;
			 }
			 
			 
			 private static void printAvailableSeats() {
				 for (char row = 'A'; row <= 'C'; row++) {
					 System.out.print(row + ": ");
					 
				for (int seatNo = 1; seatNo <= 9; seatNo++) {
					String seat = row + "" + seatNo;
					if (availableSeats.contains(seat)) {
						System.out.print(seat + " ");
					} else {
						System.out.print("  ");
					}
				}
				System.out.println();
				}
			 }
			 
			 private static int getPrice(String seat) {
				 char row = seat.charAt(0);
				 return rowPrices.get(row);
				 }
				

}
