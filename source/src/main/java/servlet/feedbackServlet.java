package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

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
                	boolean deleted = deleteTables.delete(userId);
                	if(deleted) {
                		request.setAttribute("message", "7日が経過しました。");
        		    	request.setAttribute("message2", "新しい目標を決めましょう！");
        		    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registGoal.jsp");
        			    dispatcher.forward(request, response);
                	}
                	
                	/*
                    double doExercise = Double.parseDouble(request.getParameter("doex"));
                    double doStudy = Double.parseDouble(request.getParameter("dost"));
                    double doSleep = Double.parseDouble(request.getParameter("dosl"));
                    */
                	goalsDAO goalsdao = new goalsDAO();
                    resultsDAO resultsdao = new resultsDAO();
                	doTimesDAO dtdao = new doTimesDAO();
                	calc cc = new calc();
                	boolean check = dtdao.doCheck(userId);
                	
                	if (check) {
                		List<Double> timesList = dtdao.getTwoRecords(userId);
                		double extime = timesList.get(0);   // 運動時間
                        double sttime = timesList.get(1);   // 勉強時間
                        double sltime = timesList.get(2);   // 睡眠時間
                        double extime2 = timesList.get(3);   // 運動時間
                        double sttime2 = timesList.get(4);   // 勉強時間
                        double sltime2 = timesList.get(5);   // 睡眠時間
                        double level;
                        String yourFeed;
                      
                		if (extime == extime2 && sttime == sttime2 && sltime == sltime2) {
                			level = resultsdao.getLevel(userId);
                			yourFeed = resultsdao.getFeedback(userId);
                		}
                		else {
                			goalsDTO goalsdto = goalsdao.selectGoal(userId);//sessionで取得したIDでユーザに応じたゴールDTOを作る
                            double goalExercise = goalsdto.getExercise_goal();
                            double goalStudy = goalsdto.getStudy_goal();
                            double goalSleep = goalsdto.getSleep_goal();

                            
                            List<Double> dayLevelList = cc.dayLevelCheck(
                                extime, sttime, sltime,
                                goalExercise, goalStudy, goalSleep
                            );
                            String sleepfeed = cc.sleepCheck(sltime);
                            System.out.println(dayLevelList);
                            yourFeed = cc.buildDayFeedback(dayLevelList, sleepfeed);
                            
                            level = dayLevelList.get(0);
                           
                            resultsdao.setResults(userId, dayLevelList.get(0), yourFeed);
                			
                		}
                		HttpSession session2 = request.getSession();
                        session2.setAttribute("extime", extime);
                        session2.setAttribute("sttime", sttime);
                        session2.setAttribute("sltime", sltime);
                        session.setAttribute("level", level);//進捗率取得して　リクエストスコープにセット
                        session.setAttribute("feedback", yourFeed);
                	}
                	else {
                		request.getRequestDispatcher("/WEB-INF/jsp/resultDefault.jsp").forward(request, response);
                	}
       
                    //分岐処理変更
                    
        		    LocalDate firstdate = dtdao.getFirstDate(userId);
        		    if(firstdate != null) {
        		    	LocalDate lastdate = dtdao.getLastTimes(userId);
            		    LocalDate nowdate = LocalDate.now();
                        int count = dtdao.countDotimes(userId);//ここのダオ処理を変える
                        long date = cc.judgeDate(firstdate, nowdate);//最初の登録と今の時刻を比較
                        long lastinsert = cc.judgeDate(lastdate, nowdate);//最後の実施登録が今日か
                        
                        System.out.println(count+"ですよ"); 
                        System.out.println(date+"ですよ");
                        if (date >= 6 && lastinsert == 0) {
                        	response.sendRedirect(request.getContextPath() + "/weekFeedback");
                        }
                        else
                        {
                        	request.getRequestDispatcher("/WEB-INF/jsp/resultDay.jsp").forward(request, response);
                        }
        		    }
                    else
                    {
                        	request.getRequestDispatcher("/WEB-INF/jsp/resultDefault.jsp").forward(request, response);
                    }
                } catch (NumberFormatException e) {
                    request.setAttribute("error", "入力された値が不正です。");
                }catch(Exception e) {
                    System.out.println(e.getMessage());

                }
            } else {
            	response.sendRedirect(request.getContextPath() + "/login");
                return;
            }
        } else {
        	response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        //request.getRequestDispatcher("/WEB-INF/jsp/resultDay.jsp").forward(request, response);
    }
}
