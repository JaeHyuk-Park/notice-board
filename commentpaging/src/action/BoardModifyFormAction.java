package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardModifyFormAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 	ActionForward forward = new ActionForward();
			int board_num=Integer.parseInt(request.getParameter("board_num"));
			String page = request.getParameter("page");
			BoardDetailService boardDetailService
			= new BoardDetailService();
			BoardBean article = boardDetailService.getArticle(board_num);
		   	
		   	request.setAttribute("page", page);
		   	request.setAttribute("article", article);
	   		forward.setPath("/qna_board_modify.jsp");
	   		return forward;
	   		
	 }
	 
}