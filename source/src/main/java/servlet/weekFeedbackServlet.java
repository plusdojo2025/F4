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

import dao.goalsDAO;
import dao.resultsDAO;
import dto.goalsDTO;
import model.calc;

@WebServlet("/weekfeedback")
public class weekFeedbackServlet extends HttpServlet {
    double goalexcersize;
    double goalstudy;
    double goalsleep;
    double doexcersize;
    double dostudy;
    double dosleep;
    double weekLevel;
    String yourLastFeed;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();//セッション取得
        Integer userId = (Integer) session.getAttribute("user_id");//ログイン時にキーとペアでsession.setAttribute()した時のキーを使う

        if (userId != null) {
            doexcersize = Double.parseDouble(request.getParameter("doex"));
            dostudy = Double.parseDouble(request.getParameter("dost"));
            dosleep = Double.parseDouble(request.getParameter("dosl"));


           
            goalsDAO goalsdao = new goalsDAO();
            resultsDAO resultsdao = new resultsDAO();

            goalsDTO goalsdto = goalsdao.selectGoal(userId);//userIdで各goal値を取得するメソッド 戻り値はgoalsDTO型   をもとにインスタンス作成＆宣言
            goalexcersize = goalsdto.getExercise_goal();//引数で使う値を変数にセット
            goalstudy = goalsdto.getStudy_goal();
            goalsleep = goalsdto.getSleep_goal();
            List<Double> levelList = resultsdao.getAllLevel(userId);//userIdを引数に格納されている全ての日ごとの進捗率を取得　戻り値list<Double>

            calc cc = new calc();
            //達成度をmodelで算出して格納 リストも引数として追加　
            weekLevel = cc.weekLevelCheck(doexcersize, dostudy, dosleep, goalexcersize, goalstudy, goalsleep, levelList);
            yourLastFeed = cc.buildWeekFeedback(weekLevel);

            request.setAttribute("level",weekLevel);//値をリクエストスコープに格納
            request.setAttribute("feedback",yourLastFeed);

            //最後のフィードバックはインサート不要resultsdao.setResults(userId, dayLevel, yourFeed);//resultsDAOのメソッドでデータベースに進捗率、フィードバックをインサート

        }
        //forwardで値をセットしたまま画面遷移
        RequestDispatcher dispatcher = request.getRequestDispatcher("lastfeedback.jsp");
        dispatcher.forward(request, response);
    }
}

