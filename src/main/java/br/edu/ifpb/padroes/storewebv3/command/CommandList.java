package br.edu.ifpb.padroes.storewebv3.command;

import java.util.Stack;

public class CommandList {
	 private Stack<Command> history = new Stack<>();

	    public void push(Command c) {
	        history.push(c);
	    }

	    public Command pop() {
	        return history.pop();
	    }

	    public boolean isEmpty() { return history.isEmpty(); }
}
