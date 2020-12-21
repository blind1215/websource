package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response);
	//실행해라 (request,response)를 이용해서 
	//execute를 실행시키는 참조변수에 request,response를 둠 

}
