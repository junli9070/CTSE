package DVDRecordSystem;

import java.util.*;

public class ShowItem extends Command {
	Originator listO; 
	private Stack<Memento> undoList;
	private Stack<Memento> redoList;
    public ShowItem() {
    	listO = new ListOriginator();
		undoList = new Stack<Memento>();
		redoList = new Stack<Memento>();
    }
    
    public ShowItem(Originator o, Stack<Memento> u, Stack<Memento> r){
    	this.listO = o;
    	this.undoList = u;
    	this.redoList = r;
    }
    
    public void execute() throws Exception{
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Enter ID (a to show all):");
    	if(scanner.hasNextInt()){
        	int intInput = scanner.nextInt(); 
    		showItem(intInput);
    	}    	
    	else{
    		String strInput = scanner.nextLine();  
    		showItem(strInput);
    	}
        	
    }
    
    public void showItem(String id){
    	System.out.println("DVD Record System\nID\t\tTitle\t\tLength(mins)\tNo. available\t\tOther Info");
    	for(int i = 0; i< ((ListOriginator)listO).getItems().size(); i++){
    		System.out.println(((ListOriginator)listO).getItems().get(i));
    	}    	
    }
    
    public void showItem(int id){    	
    	System.out.println("\nDVD Information");
    	for(int i = 0; i < ((ListOriginator)listO).getItems().size(); i++){
    		if(((ListOriginator)listO).getItems().get(i).getDvdID() == id){
    			System.out.println("ID: " + ((ListOriginator)listO).getItems().get(i).getDvdID());
    			System.out.println("Title: " + ((ListOriginator)listO).getItems().get(i).getTitle());
    			System.out.println("Length: " + ((ListOriginator)listO).getItems().get(i).getLength() + " mins");
    			System.out.println("Number of available copies: " + ((ListOriginator)listO).getItems().get(i).getNumAvailable());
    			if(((ListOriginator)listO).getItems().get(i) instanceof Movie)
    				System.out.println("Director: " + ((Movie)((ListOriginator)listO).getItems().get(i).getDirector()));
    			else if(((ListOriginator)listO).getItems().get(i) instanceof MV)
Z    				System.out.println("Singer: " + ((MV)((ListOriginator)listO).getItems().get(i).getSinger()));
    		}	
    	}
    }
    
    public void undo(){}
    public void undo(Command c, Vector<DVD> items, String a) throws Exception{
    }
}