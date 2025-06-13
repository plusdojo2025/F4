package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.goalsDAO;
import dao.resultsDAO;
import dto.goalsDTO;
import model.calc;

@WebServlet("/feedback")
public class feedbackServlet extends HttpServlet {
    double goalexcersize;
    double goalstudy;
    double goalsleep;
    double doexcersize;
    double dostudy;
    double dosleep;
    double dayLevel;
    String yourFeed;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();//セッション取得
        Integer userId = (Integer) session.getAttribute("user_id");//ログイン時にキーとペアでsession.setAttribute()した時のキーを使う

        //sessionにIdがある場合
        if (userId != null) {
            doexcersize = Double.parseDouble(request.getParameter("doex"));
            dostudy = Double.parseDouble(request.getParameter("dost"));
            dosleep = Double.parseDouble(request.getParameter("dosl"));


           
            goalsDAO goalsdao = new goalsDAO();
            resultsDAO resultsdao = new resultsDAO();

            goalsDTO goalsdto = goalsdao.selectGoal(userId);//userIdでで各goal値を取得するメソッド 戻り値はgoalsDTO型をもとにインスタンス作成＆宣言
            goalexcersize = goalsdto.getExercise_goal();
            goalstudy = goalsdto.getStudy_goal();
            goalsleep = goalsdto.getSleep_goal();

            calc cc = new calc();
            dayLevel = cc.dayLevelCheck(doexcersize, dostudy, dosleep, goalexcersize, goalstudy, goalsleep);//達成度をmodelで算出して格納
            yourFeed = cc.buildDayFeedback(dayLevel);

            request.setAttribute("level",dayLevel);//値をリクエストスコープに格納
            request.setAttribute("feedback",yourFeed);

            resultsdao.setResults(userId, dayLevel, yourFeed);//resultsDAOのメソッドでデータベースに進捗率、フィードバックをインサート

        }
        //forwardで値をセットしたまま画面遷移
        RequestDispatcher dispatcher = request.getRequestDispatcher("feedback.jsp");
        dispatcher.forward(request, response);
    }
}
