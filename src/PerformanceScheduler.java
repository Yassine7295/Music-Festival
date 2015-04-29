/**
*Yassine Khaliqui
*109050245
*Homework Assignment Number 1
*CSE 214 Recitation Section 06
*Recitation TA: Kevin Flyangolts 
*Grading TA: Zheyuan (Jeffrey) Gao;
*@author Yassine
*/
import java.util.Scanner;

//import javax.swing.text.Position;

public class PerformanceScheduler {
	
	public static void main(String[] args){
		
		String menu = "Main Menu: \n\n"
				+ "A) Add a new performance to the list? \n"
				+ "I) Insert a new performance after current node? \n"
				+ "R) Remove the current node from the list? \n"
				+ "C) Display the current node? \n"
				+ "D) Display all nodes? \n"
				+ "F) Move cursor forward? \n"
				+ "B) Move cursor backward? \n"
				+ "J) Jump to a given position? \n"
				+ "Q) Exit the program? \n\n"
				+ "What would you like to do: ";
		Scanner s = new Scanner(System.in);
		PerformanceList list = new PerformanceList();
		PerformanceNode node;
		String name;
		String leadPerformer;
		int attendance;
		int startTime;
		int duration;
		int position;
		
		System.out.print(menu);
		String input = s.nextLine();
		while(!(input.equalsIgnoreCase("Q"))){
			if(input.equalsIgnoreCase("A")){
				System.out.println();
				System.out.print("What is the name? ");
				name = s.nextLine();
				System.out.print("Who is the lead performer? ");
				leadPerformer = s.nextLine();
				System.out.print("How many are attending? ");
				attendance = s.nextInt();
				System.out.print("What is the duration of this performance? ");
				duration = s.nextInt();
				node = new PerformanceNode(name, leadPerformer, attendance, duration);
				list.addToEnd(node);
				System.out.println();
				System.out.println("The performance " + node.getName() + " has been added to the end of the performance list.");
				System.out.println();
				System.out.print(menu);
			}
			else if(input.equalsIgnoreCase("I")){
				System.out.println();
				System.out.print("What is the name? ");
				name = s.nextLine();
				System.out.print("Who is the lead performer? ");
				leadPerformer = s.nextLine();
				System.out.print("How many are attending? ");
				attendance = s.nextInt();
				System.out.print("When does the event start? ");
				startTime = s.nextInt();
				node = new PerformanceNode(name, leadPerformer, attendance, startTime);
				list.addAfterCurrent(node);
				list.updateStartTime();
				System.out.println();
				System.out.println("The performance " + node.getName() + " has been added after the current node in the performance list.");
				System.out.println();
				System.out.print(menu);
			}
			else if(input.equalsIgnoreCase("R")){
				System.out.println();
				try{
					list.removeCurrentNode();
					list.updateStartTime();
					System.out.println("The current performance has been removed form the performance list.");
				}catch(EmptyListException ex){
					ex.getMessage();
				}
				System.out.println();
				System.out.print(menu);
			}
			else if(input.equalsIgnoreCase("C")){
				System.out.println();
				try{
					System.out.println("Current No. Performance Name           Lead Performer Name      Participants Duration Start Time\n"
							+ "------------------------------------------------------------------------------------------------");
					System.out.print("      *   " + 1 + " ");
					list.displayCurrentPerformance();
				}catch(EmptyListException ex){
					ex.getMessage();
				}
				System.out.println();
				System.out.print(menu);
			}
			else if(input.equalsIgnoreCase("D")){
				System.out.println();
				System.out.println(list.toString());
				System.out.print(menu);
			}
			else if(input.equalsIgnoreCase("F")){
				System.out.println();
				try{
					list.moveCursorForward();
					System.out.println("The cursor has move one node forward. ");
				}catch(EmptyListException ex){
					ex.getMessage();
				}
				catch(NullPointerException ex){
					System.out.println("You are already at the end of the list.");
				}
				System.out.println();
				System.out.print(menu);
			}
			else if(input.equalsIgnoreCase("B")){
				System.out.println();
				try{
					list.moveCursorBackward();
					System.out.println("The cursor has move one node backward. ");
				}catch(EmptyListException ex){
					ex.getMessage();
				}
				catch(NullPointerException ex){
					System.out.println("You are already at the beginning of the list.");
				}
				System.out.println();
				System.out.print(menu);
			}
			else if(input.equalsIgnoreCase("J")){
				System.out.println();
				System.out.print("Enter the new position for the cursor: ");
				position = s.nextInt();
				try{
					list.jumpToPosition(position);
					System.out.println();
					System.out.println("The cursor has jumped to position " + position + ".");
				}catch(NullPointerException ex){
					System.out.println("You have entered an invalid position value.");
				}
				System.out.println();
				System.out.print(menu);
			}
			input = s.nextLine();
		}
		System.out.println();
		System.out.println("Program terminating normally...");
		
	}
}
