package Main;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


import wIn.Window;

public class WorkClass {

	
		//Instance Variables 
	    private Window _w;
	    ArrayList<String> studentsNames = new ArrayList<String>();
	 	 
	    //Buttons 
	    private static final String[] OPTIONS = { "Add", "Remove", "Swap", "Move", "Exit" };
	   
	    
	   
	      
	    //This method introduces the player and declares that the seat positions begin at 0
	    public WorkClass() {
	   	 _w = new Window();	 
	   	 _w.msg("Seat positions begin at 0.");
	   	 defaultStringStudents();
	   	 check();
	    }
	    
	    //This method creates some default character placements to fill the arrayList
	    public void defaultStringStudents() {
	    	studentsNames.add("Matteo C");
	    	studentsNames.add("John C");
	    	studentsNames.add("Chris G");
	    	studentsNames.add("Gabriel G");
	    	studentsNames.add("Eddie L");
	    	studentsNames.add("Pablo L");
	    	studentsNames.add("Brandon M");
	    	studentsNames.add("Mario P" );
	    	studentsNames.add("Jordan R");
	    	studentsNames.add("empty"); 
	    	studentsNames.add("empty"); 
	    	studentsNames.add("empty"); 
	    }
	    
	    //This method displays the Classroom default set up and gives options to the player
	    //The method covers all the possible options when it comes to adding a new student to the List or swapping positions or moving a student to an empty spot or removing a student entirely
	    public void check() {
	    	
	   	 int selection = _w.option(OPTIONS, "STUDENT SEATING CHART \r\n \r\n " + studentsNames);
	   	 if (selection == 0) { //ADD
	   	
	   		 String inputAddStudent = _w.in("You selected: ADD \r\n Type in a name to add a student, first name and last intial please. \r\n " + studentsNames);	   		
	   		 if(inputAddStudent!=null)
	   		 studentsNames.add(inputAddStudent);
	   		 check();
	   	 }
	   	 else if(selection == 1) { //REMOVE
	   		 String inputRemoveStudent = _w.in("You selected: REMOVE \r\n Type the name of the student you would like to remove. \r\n " + studentsNames);
	   		 studentsNames.remove(inputRemoveStudent);
	   		 check();
	   	 }
	   	 else if(selection == 2) { //SWAP
	   		 int inputSwapStudent = Integer.parseInt(JOptionPane.showInputDialog("You selected: SWAP \r\n Type the first student index you would like to swap. \r\n " + studentsNames));
	   		 String SwapStudent = "";
	   		 for(int i = 0; i < studentsNames.size();i++) {
	   			if(inputSwapStudent== i) {
	   				SwapStudent = studentsNames.get(i);
	   				
	   			}
	   		 }
	   		 int inputSwapStudent2=  Integer.parseInt(JOptionPane.showInputDialog("You selected: " + SwapStudent + "\r\n Type in another student index." + studentsNames));
	   		 String SwapStudent2 = "";
	   		 for(int i = 0; i < studentsNames.size();i++) {
	   			if(inputSwapStudent2 == i) {
	   				SwapStudent2 = studentsNames.get(i);
	   				
	   			}   			
	   			else if(studentsNames.get(inputSwapStudent2) == "empty") {
		   			 _w.msg("This seat is empty, if you would like to move this student to an empty seat please select the move action.");
		   			 check();
	   			}
	   		 }
	   		 for(int i = 0; i < studentsNames.size();i++) {
		   			if(inputSwapStudent == i) {
		   			
		   				studentsNames.set(i,SwapStudent2);
		   			}
		   			else if(inputSwapStudent2 == i) {
		   				studentsNames.set(i,SwapStudent);
		   			}
	   		 }		
	   		 check();
	   		 
	   	 }
	   	 else if(selection == 3) { //MOVE
	   		int inputMoveStudent = Integer.parseInt(JOptionPane.showInputDialog("You selected: MOVE \r\n Type in the student index you want to move. \r\n " + studentsNames));
	   		String MoveStudent ="";
	   		for(int i =0; i< studentsNames.size();i++) {
	   			if(inputMoveStudent == i) {
	   				MoveStudent = studentsNames.get(i);
	   				studentsNames.remove(i);
	   				studentsNames.add(i,"empty");
	   				
	   			}
	   		}
	   		int newStudentSeat = Integer.parseInt(JOptionPane.showInputDialog("You selected: MOVE \r\n Type in the empty index, and to move the student to that seat \r\n " + studentsNames));
	   		studentsNames.set(newStudentSeat, MoveStudent);
	   		check();	   		 
	   	 }
	   	 else { //EXIT
	   		 System.exit(0);
	   	 }
	    }
}

	

	

