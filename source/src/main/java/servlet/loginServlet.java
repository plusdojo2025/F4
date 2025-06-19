package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.doTimesDAO;
import dao.goalsDAO;
import dao.resultsDAO;
import dao.usersDAO;
import dto.goalsDTO;
import dto.usersDTO;
import model.calc;
// ?
//mport dto.LoginUser;
//import dto.Result;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// リクエストパラメータを取得する 
		request.setCharacterEncoding("UTF-8");
		String mail = request.getParameter("mail");
		String pw = request.getParameter("pw");

		usersDAO udao = new usersDAO();
		usersDTO udto = udao.login(mail, pw);
		
		resultsDAO rdao = new resultsDAO();

		goalsDAO gdao = new goalsDAO();
		if (udto != null) {
			// ユーザーID
			int userid = udto.getId();
			//現在の時間と最初に登録した時間の差を求める
			doTimesDAO dtdao = new doTimesDAO();
		    LocalDate firstdate = dtdao.getFirstDate(userid);
		    LocalDate nowdate = LocalDate.now();
		    calc cc = new calc();
		    
		    if (firstdate != null) {
		    	long judge = cc.judgeDate(firstdate, nowdate);
		    	//差が7以上なら実施時間・目標時間・評価を削除
			    if(judge >= 7) {
			    	request.setAttribute("message", "7日が経過しました。");
			    	request.setAttribute("message2", "新しい目標を決めましょう❣");
			    	dtdao.delete(userid);
			    	gdao.deleteGoal(userid);
			    	rdao.deleteAllResult(userid);
			    }
		    }
		    
		    
		    //目標時間を取得
		    goalsDTO gdto = gdao.selectGoal(udto.getId());
		   
		    HttpSession session = request.getSession();
		    session.setAttribute("userinfo", udto);
		    
		    if (gdto != null) {//テスト必須
		        response.sendRedirect(request.getContextPath() + "/home");
		        
		    } else {
		        response.sendRedirect(request.getContextPath() + "/registGoal");
		    }
		} else {
		    request.setAttribute("errorMessage", "メールアドレスまたはパスワードが間違っています。");
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		    dispatcher.forward(request, response);
		}
	}




}