package view;

import java.util.Scanner;
import controller.Controller;
import model.User;


public class LoginV {
	
	private Controller cont;
	
	public LoginV(Controller cont) {
		this.cont = cont;
	}
	
	public void start() {
		Scanner sc = new Scanner(System.in);
		
		while ( true ) {
		System.out.println("---ChatterBox--- \n");
		System.out.println("1. Login as an registred user");
		System.out.println("2. Continue as a guest");
		System.out.println("3. Exit");
		System.out.println("SELECT OPTION:");
		
		String option = sc.nextLine();
		
		if ( option.equals("1")) {
			System.out.println("Ënter username: ");
			String username = sc.nextLine();
			
			
			System.out.println("Enter password: ");
			String password = sc.nextLine();
			
			User u = cont.login(username, password);
		
			if ( u != null ) {
				System.out.println("Login successful \n");
				RegistredUserV ru = new RegistredUserV(cont, u);
				ru.userMenu();
			}
			
			else {
				System.out.println("FAILED \n");
			}
		}
			else if ( option.equals("2")) {
				System.out.println("Continuing as a guest");
				GuestV gv = new GuestV(cont);
				gv.guestMenu();
			}
		
			else if ( option.equals("3")) {
				System.out.println("Bye");
				break;
			}
			
			else {
				System.out.println("INVALID OPTION");
			}
		}
	}

	public static void main(String[] args) {
		Controller cont = new Controller();
		LoginV login = new LoginV(cont);
		login.start();

	}
}


