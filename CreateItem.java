/**
 * @(#)CreateItem.java
 *
 *
 * @author 
 * @version 1.00 2018/11/3
 */
package DVDRecordSystem;
 
import java.util.*;

public class CreateItem extends Command {
	private Map<String, String> dvdType = new HashMap<String, String>();
	Originator listO; 
	Stack<Memento> undoList; 
	Stack<Memento> redoList; 
    public CreateItem() {
    	dvdType.put("mo", "CreateMovie");
    	dvdType.put("mv", "CreateMV");
    	listO = new ListOriginator();
		undoList = new Stack<Memento>();
		redoList = new Stack<Memento>();
    }
    
    public CreateItem(Originator o, Stack<Memento> u, Stack<Memento> r){
    	dvdType.put("mo", "CreateMovie");
    	dvdType.put("mv", "CreateMV");
    	this.listO = o;
    	this.undoList = u;
    	this.redoList = r;
    }
    
    public void execute() throws Exception{
    	String input;
    	Scanner scanner = new Scanner(System.in);
    	Class[] cArg = new Class[3]; 
		cArg[0] = Originator.class; 
		cArg[1] = Stack.class; 
		cArg[2] = Stack.class;
    	System.out.println("Enter DVD type (mo=movie/mv=MV):");
	    input = scanner.next();
	    System.out.println(dvdType.get(input));
	    Command ci = (Command)Class.forName("DVDRecordSystem." + dvdType.get(input)).getDeclaredConstructor(cArg).newInstance(listO, undoList, redoList);
	    ci.execute();	  
    }
    
    public void undo(){}
    public void undo(Command c, Vector<DVD> items, String action) throws Exception{
    }
}