package view;

import java.util.Scanner;
import controller.Controller;
import model.Message;

public class GuestV {
	private Controller cont;
	private Scanner sc;
	
	public GuestV( Controller cont ) {
		this.cont = cont;
		this.sc = new Scanner(System.in);
	}
	
	public void guestMenu() {
		
		while( true ) {
			System.out.println("---Guest Menu--- \n");
			System.out.println("1. View all Messages");
			System.out.println("2. Get back");
			System.out.println("SELECT OPTION: ");
			String option = sc.nextLine();
			
			if ( option.equals("1")) {
				Message[] all = cont.getAllMessages();
				System.out.println("Output: ");
				System.out.println();
				
				for ( Message m : all ) {
					System.out.println("Message:" + m.getId() + "by " + m.getAuthor() + ", " + m.getText() );

				}
				
				System.out.println();
			}
			
			else if ( option.equals("2")) {
				break;
			}
			
			else {
				System.out.println("INVALID OPTION");
			}
		}
	}
}
