package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.doTimesDAO;
import dao.goalsDAO;
import dao.resultsDAO;
import dto.goalsDTO;
import dto.usersDTO;
import model.calc;

@WebServlet("/feedback")
public class feedbackServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false); // falseで既存セッションのみ取得

        
        System.out.println("白下");
        
        if (session != null) {
            usersDTO user = (usersDTO) session.getAttribute("userinfo");
            if (user != null) {
                int userId = user.getId();

                try {
                	/*
                    double doExercise = Double.parseDouble(request.getParameter("doex"));
                    double doStudy = Double.parseDouble(request.getParameter("dost"));
                    double doSleep = Double.parseDouble(request.getParameter("dosl"));
                    */
                	doTimesDAO dtdao = new doTimesDAO();
                	
                    List<Double> timesList = dtdao.getTimes(userId);
                    double extime = timesList.get(0);   // 運動時間
                    double sttime = timesList.get(1);   // 勉強時間
                    double sltime = timesList.get(2);   // 睡眠時間

                    goalsDAO goalsdao = new goalsDAO();
                    resultsDAO resultsdao = new resultsDAO();

                    goalsDTO goalsdto = goalsdao.selectGoal(userId);//sessionで取得したIDでユーザに応じたゴールDTOを作る
                    double goalExercise = goalsdto.getExercise_goal();
                    double goalStudy = goalsdto.getStudy_goal();
                    double goalSleep = goalsdto.getSleep_goal();

                    calc cc = new calc();
                    List<Double> dayLevelList = cc.dayLevelCheck(
                        extime, sttime, sltime,
                        goalExercise, goalStudy, goalSleep
                    );
                    String sleepfeed = cc.sleepCheck(sltime);
                    System.out.println(dayLevelList);
                    String yourFeed = cc.buildDayFeedback(dayLevelList, sleepfeed);
                    
                    HttpSession session2 = request.getSession();
                    session2.setAttribute("extime", extime);
                    session2.setAttribute("sttime", sttime);
                    session2.setAttribute("sltime", sltime);
                    
                    session.setAttribute("level", dayLevelList.get(0));//進捗率取得して　リクエストスコープにセット
                    session.setAttribute("feedback", yourFeed);

                    resultsdao.setResults(userId, dayLevelList.get(0), yourFeed);
         
                    int count = dtdao.countDotimes(userId);
                    System.out.println(count+"ですよ");                    
                    if (count == 0) {
                    	request.getRequestDispatcher("/WEB-INF/jsp/resultDefault.jsp").forward(request, response);
                    }
                    else if (count <= 6) {
                    	request.getRequestDispatcher("/WEB-INF/jsp/resultDay.jsp").forward(request, response);
                    }
                    else {
                    	request.getRequestDispatcher("/WEB-INF/jsp/resultWeek.jsp").forward(request, response);
                    }
             
                } catch (NumberFormatException e) {
                    request.setAttribute("error", "入力された値が不正です。");
                }catch(Exception e) {
                    System.out.println(e.getMessage());

                }
            } else {
                response.sendRedirect("login.jsp");
                return;
            }
        } else {
            response.sendRedirect("login.jsp");
            return;
        }
        //request.getRequestDispatcher("/WEB-INF/jsp/resultDay.jsp").forward(request, response);
    }
}
