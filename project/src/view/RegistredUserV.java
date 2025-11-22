package view;

import java.util.Scanner; 
import controller.Controller;
import model.Message;
import model.User;


public class RegistredUserV {

	private Scanner sc;
	private Controller cont;
	private User user;
	
	public RegistredUserV( Controller cont, User user ) {
		this.cont = cont;
		this.user = user;
		this.sc = new Scanner(System.in);
	}
	
	public void userMenu() {
		while( true ) {
			System.out.println("---User Menu--- \n");
			System.out.println("1. Write and post Message");
			System.out.println("2. Delete message");
			System.out.println("3. View my messages");
			System.out.println("4. View all messages");
			System.out.println("5. Logout");
			System.out.println("SELECT OPTION: ");
			
			String option = sc.nextLine();
			
			if ( option.equals("1")) {
				
				System.out.println("Write a message: ");
				String text = sc.nextLine();
				
				cont.postMessage(user.getUsername(), text);
			}
			
			else if ( option.equals("2")) {
				System.out.println("Enter a message id: ");
				String textId = sc.nextLine();
				
				int id = Integer.parseInt(textId);
				
				boolean ja = cont.deleteMessage(user.getUsername(), id);
				if (ja) System.out.println("Message deleted!");
			}
			
			else if ( option.equals("3")) {
				Message[] my = cont.getMessageByUser(user.getUsername());
				System.out.println("Output: ");
				
				for ( Message m : my ) {
					System.out.println("Message " + m.getId() + " by " + m.getAuthor() + ", " + m.getText() );
				}
				
				System.out.println();
			}
			
			else if ( option.equals("4")) {
				Message[] all = cont.getAllMessages();
				System.out.println("Output: ");
				
				for ( Message m : all ) {
					System.out.println("Message " + m.getId() + " by " + m.getAuthor() + ", " + m.getText() );
				}
				System.out.println("");
			}
			
			else if ( option.equals("5")) {
				System.out.println("Logging out");
				break;
			}
			else {
			System.out.println("INVALID OPTION");
			}
		}
	}
}
