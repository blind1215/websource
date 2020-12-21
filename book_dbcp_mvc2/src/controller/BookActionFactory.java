package controller;

import action.Action;
import action.BookInsertAction;
import action.BookListAction;

public class BookActionFactory {
	private static BookActionFactory factory;
	private BookActionFactory() {}
	
	public static BookActionFactory getInstance() {
		if(factory == null) {
			factory = new BookActionFactory();
		}
		return factory;
	}
	
	public Action action(String cmd) {
		Action action =null;
		
		if(cmd.equals("/list.do")) {
			action = new BookListAction("select.jsp");
		}else if (cmd.equals("/insert.do")) {
			action = new BookInsertAction("list.do");
			
		}
		
		return action;
	}
}
