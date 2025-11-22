package controller;

import model.User;
import model.Message;


public class Controller {
	
	public User[] users;
	public Message[] messages;
	private int nextId = 3;
	
	public Controller() {
		users = new User[] {
				new User("John Nash", "jnash", "123", "User"),
				new User("Anna Kim", "akim", "789", "User")
	};
	
		messages = new Message[] {
				new Message(1, "jnash", "Hello iam new here!"),
				new Message(2, "akim", "hii whats up!")
		};
}
	public User login( String username, String password ) {
		for ( int i = 0; i < users.length; i++) {
			if ( users[i].getUsername().equals(username) && users[i].getPassword().equals(password)) {
				return users[i];
			}
		}
		return null;
	}
	
	public void postMessage( String author, String text ) {
		Message[] biggerA = new Message[messages.length + 1];
		for ( int i = 0; i < messages.length; i++) {
			biggerA[i] = messages[i];
		}
		
		biggerA[messages.length] = new Message(nextId, author, text);
		nextId++;
		messages = biggerA;
	}

	public boolean deleteMessage( String author, int id ) {
		boolean found = false;
		Message[] smallerA = new Message[messages.length - 1];
		int index = 0;
		
		for ( int i = 0; i < messages.length; i++) {
			if ( messages[i].getId() == id && messages[i].getAuthor().equals(author)) {
				found = true;
				continue;
			}
			if ( index < smallerA.length ) {
				smallerA[index] = messages[i];
				index++;
			}
		}
		
		if ( found ) {
			messages = smallerA;
		}
		return found;
	}
	public Message[] getAllMessages() {
		return messages;
	}
	
	public Message[] getMessageByUser( String author ) {
		int count = 0;
		for ( int i = 0; i < messages.length; i++) {
			if ( messages[i].getAuthor().equals(author)) {
				count++;
			}
		}
		Message[] userMessages = new Message[count];
		int index = 0;
		for ( int i = 0; i < messages.length; i++) {
			if ( messages[i].getAuthor().equals(author)) {
				userMessages[index] = messages[i];
				index++;
			}
		}
		return userMessages;
	}
}
