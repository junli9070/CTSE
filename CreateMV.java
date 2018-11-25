package DVDRecordSystem;

import java.util.*;

public class CreateMV extends Command {
	Originator listO; //Vector<DVD> items;
	Stack<Memento> undoList;
	Stack<Memento> redoList;
    public CreateMV() {
    	listO = new ListOriginator();//items = new Vector<DVD>();
		undoList = new Stack<Memento>();
		redoList = new Stack<Memento>();
    }
    
    public CreateMV(Originator o, Stack<Memento> u, Stack<Memento> r){
    	this.listO = o;//this.items = i;
    	this.undoList = u;
    	this.redoList = r;
    }
    
    public void execute() throws Exception{
    	String input;
    	String[] strDetail;
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Enter id, title, length, number of available copies, singer:");
    	input = scanner.nextLine();
	    strDetail = input.split(", "); 
	    int [] intDetail = {Integer.parseInt(strDetail[0]), Integer.parseInt(strDetail[2]), Integer.parseInt(strDetail[3])};
	    DVD dvd = null;
	    for(int i = 0; i < ((ListOriginator)listO).getItems().size(); i++){
    		if(((ListOriginator)listO).getItems().get(i).getDvdID() == intDetail[0]){ 
    			dvd = ((ListOriginator)listO).getItems().get(i);
    		}
		}
		
		if(dvd == null){
		    DVD mv = new MV(intDetail[0], strDetail[1], intDetail[1], intDetail[2], strDetail[4]);
		    Command cm = new CreateMV(listO, undoList, redoList);	  
		    String action = "Create " + intDetail[0] + " " + strDetail[1];  
		    Originator lo = new ListOriginator(((ListOriginator)listO).getItems());
		    Memento undo = new ListMemento(cm, (Originator)lo, action);
		    undoList.push(undo);
		    //ListOriginator lo = new ListOriginator(items);
		    //Memento undo = new Memento(cm, lo, action);
		    //undoList.push(undo);	       
		    //items.add(mv);
		    System.out.println("DVD record created"); 
		    System.out.println("DVD Record System\nID\t\tTitle\t\tLength(mins)\tNo. available\t\tOther Info");
	    	for(int i = 0; i < ((ListOriginator)listO).getItems().size(); i++){
	    		System.out.println(((ListOriginator)listO).getItems().get(i));
	    	}  
		    ((ListOriginator)listO).addItem(movie);
		    System.out.println("DVD Record System\nID\t\tTitle\t\tLength(mins)\tNo. available\t\tOther Info");
	    	for(int i = 0; i < ((ListOriginator)listO).getItems().size(); i++){
	    		System.out.println(((ListOriginator)listO).getItems().get(i));
	    }
		else{
			System.out.println("ID has been exist");
		}
    }
    
    public void undo(){}
    
    public void undo(Command c, Vector<DVD> i, String a) throws Exception{ 
    	Originator lo = new ListOriginator(((ListOriginator)listO).getItems());
    	Memento redo = new ListMemento(c, (Originator)lo, a);
    	redoList.push(redo);
    	System.out.println("DVD Record System\nID\t\tTitle\t\tLength(mins)\tNo. available\t\tOther Info");
    	for(int j = 0; j < i.size(); j++){
    		System.out.println(i.get(j));
    	}  
    	((ListOriginator)listO).setItems(i);
    }    
}
