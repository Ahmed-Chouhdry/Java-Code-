import java.io.Reader;
import java.util.*;
import java.util.Scanner;

class tata {
	private  Scanner InputReader ;
	private InputReader reader; 
	private Responder responder;
	public tata()
	{
		Scanner reader = new Scanner(System.in); 
		reader = new InputReader();
		responder = new Responder();
	}
	public void start()
	{
		boolean finished = false;
		printWelcome();
		while(!finished) {
		String input = reader.getInput();
		if(input.startsWith("bye")) {
			finished = true;
		}
		else{
				String response = responder.generateResponse();
				System.out.println(response);
			}
		}
		printGoodbye();
	}
	private void printWelcome()
	{
		System.out.println(
		"Welcome to the DodgySoft Technical Support System.");
		System.out.println();
		System.out.println("Please tell us about your problem.");
		System.out.println("We will assist you with any problem you might have.");
		System.out.println("Please type 'bye' to exit our system.");
	}

	private void printGoodbye()
	{
		System.out.println("Nice talking to you. Bye...");
	}
}


