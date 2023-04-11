package ticketbookingsystem;

import java.util.Scanner;

public class MovieMax {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int choice=0;
		System.out.println("\n*************  Welcome to the MovieMax!  ****************\n");
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		
		while (true) {
			
			System.out.println("\n\tTicket Booking");
	      	  System.out.println("_____________________________________\n");
	          System.out.println("1. Book \t 2. QUIT\n");
	          System.out.println("************************************************\n");
	          
	          
	          System.out.print("Enter your choice: ");
	          choice = scanner.nextInt();
	          switch(choice)
	          {
	            
	            case 1: 
	            TicketBookService movService = new MovieTicketBooking();
	    		
	    		movService.ticketbookservice();
	    		break;
	    		
	            case 2: System.out.println("_______________________________________________________________________________________");
       		    System.out.println("\nMESSAGE:   Enjoy the show at MovieMax  ");
       		    System.out.println("_______________________________________________________________________________________");
       		    System.exit(0);
	            	    
	          }

			}
		}
	}

