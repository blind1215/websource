package controller;



import action.Action;
import action.UserInsertAction;
import action.UserListAction;

public class UserActionFactory {
	private static UserActionFactory factory;
	private UserActionFactory() {}
	public static UserActionFactory getInstance() {
		if(factory == null) {
			factory = new UserActionFactory();
		}
		return factory;
	}
	


	public Action action(String cmd) {
		Action action = null;
		if (cmd.equals("/insert.do")) {
			action = new UserInsertAction("list.do");
		}else if(cmd.equals("/list.do")) {
			action = new UserListAction("list.jsp");
		}
		return action;
	}
}
