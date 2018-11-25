/**
 * @(#)CreateMV.java
 *
 *
 * @author 
 * @version 1.00 2018/11/3
 */
package DVDRecordSystem;

import java.util.*;

public class CreateMV extends Command {
	Vector<DVD> items;
	Stack<Memento> undoList;
	Stack<Memento> redoList;
    public CreateMV() {
    	items = new Vector<DVD>();
		undoList = new Stack<Memento>();
		redoList = new Stack<Memento>();
    }
    
    public CreateMV(Vector<DVD> i, Stack<Memento> u, Stack<Memento> r){
    	this.items = i;
    	this.undoList = u;
    	this.redoList = r;
    }
    
    public void execute() throws Exception{
    	String input;
    	String[] strDetail;
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Enter id, title, length, number of available copies, director:");
    	input = scanner.nextLine();
	    strDetail = input.split(", "); 
	    int [] intDetail = {Integer.parseInt(strDetail[0]), Integer.parseInt(strDetail[2]), Integer.parseInt(strDetail[3])};
	    DVD dvd = null;
	    for(int i = 0; i < items.size(); i++){
    		if(items.get(i).getDvdID() == intDetail[0]){ 
    			dvd = items.get(i);
    		}
		}
		if(dvd == null){
		    DVD mv = new MV(intDetail[0], strDetail[1], intDetail[1], intDetail[2], strDetail[4]);
		    Command cm = new CreateMV(items, undoList, redoList);	  
		    String action = "Create " + intDetail[0] + " " + strDetail[1];  
		    ListOriginator lo = new ListOriginator(items);
		    Memento undo = new Memento(cm, lo, action);
		    undoList.push(undo);	       
		    items.add(mv);
	    }
		else{
			System.out.println("ID has been exist");
		}
    }
    
    public void undo(){}
        
    public void undo(Command c, Vector<DVD> i, String a) throws Exception{ 	
    	ListOriginator lo = new ListOriginator(items);  
    	Memento redo = new Memento(c, lo, a);
    	redoList.push(redo);
    	items = i;
    }
}