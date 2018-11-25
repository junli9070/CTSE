/**
 * @(#)ExitSystem.java
 *
 *
 * @author 
 * @version 1.00 2018/11/9
 */
package DVDRecordSystem;

import java.util.*;

public class ExitSystem extends Command {
	Originator Ori;//Vector<DVD> items;
	Stack<Memento> undoList;
	Stack<Memento> redoList;
    public ExitSystem() {
    	Ori = new ListOriginator();//items = new Vector<DVD>();
		undoList = new Stack<Memento>();
		redoList = new Stack<Memento>();
    }
    
    public ExitSystem(Originator o, Stack<Memento> u, Stack<Memento> r){
    	this.Ori = o;//this.items = i;
    	this.undoList = u;
    	this.redoList = r;
    }
    
    public void execute() throws Exception{
	    System.out.println("\nExiting System...");
	    System.exit(0);
    }
    
    public void undo(){}
    public void undo(Command c, Vector<DVD> items, String action) throws Exception{
    }
}