package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.doTimesDAO;
import dto.doTimesDTO;
import dto.usersDTO;

@WebServlet("/registTime")
public class registTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession(false);
        
        usersDTO userdto = (usersDTO) session.getAttribute("userinfo");
        if(userdto != null) {
            int id = userdto.getId();
            if(id >=1) {
            	System.out.println("userId:"+id);
                
                double exercise_do = Double.parseDouble(request.getParameter("exercise"));
                double study_do = Double.parseDouble(request.getParameter("study"));
                double sleep_do = Double.parseDouble(request.getParameter("sleep"));
                System.out.println(exercise_do);
                System.out.println(study_do);
                System.out.println(sleep_do);
                System.out.println("がユーザから入力されました");

                doTimesDTO doTime = new doTimesDTO(id, exercise_do, study_do, sleep_do);

                doTimesDAO dtdao = new doTimesDAO();
                List<Double> list = dtdao.getTimes(id);//idを参照して最新の実施時間をそれぞれ取得
                double lastedo = list.get(0);
                double laststdo = list.get(1);
                double lastsldo = list.get(2);
                System.out.println(lastedo);
                System.out.println(laststdo);
                System.out.println(lastsldo);
                System.out.println("が現在インサートされている最新の実施時間です");
                
                
                //DBにある実施時間が今回入力されている実施時間を比較
                
                boolean check = (exercise_do == lastedo && study_do == laststdo && sleep_do == lastsldo);

                if (check) {
                	session.setAttribute("lastDoTime", new doTimesDTO(id, exercise_do, study_do, sleep_do));
                	System.out.println("sessionに格納されました");
                    System.out.println("全く同じ内容だったのでinsertは行いません");
                } else {
                	session.setAttribute("lastDoTime", new doTimesDTO(id, exercise_do, study_do, sleep_do));
                    dtdao.insert(doTime);
                    System.out.println("内容が変わったのでinsertされました sessionに格納されました");
                }
                
                
                
                
                
                //DBと比較して打ち込まれた値が一つでも変化している　または　一度も実施を登録してない場合
                
                
                
            }
            else {
            	response.sendRedirect(request.getContextPath() + "/login");
            }
        }else {
        	response.sendRedirect(request.getContextPath() + "/login");    
        }
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
	    usersDTO userdto = (usersDTO) session.getAttribute("userinfo");
	    int userId = userdto.getId();

	    boolean deleted = deleteTables.delete(userId);
	    if (deleted) {
	        System.out.println("古いデータを削除しました（userId: " + userId + "）");
	        request.setAttribute("message", "7日が経過しました。");
	    	request.setAttribute("message2", "新しい目標を決めましょう!");

	        // 削除された場合はゴール再登録画面へ
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registGoal.jsp");
	        dispatcher.forward(request, response);
	        return;
	    }

	    // 削除されなかった場合は実施時間登録画面へ
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registTime.jsp");
	    dispatcher.forward(request, response);
	}
	
}
