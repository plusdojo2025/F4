package servlet;

import java.time.LocalDate;

import dao.doTimesDAO;
import dao.goalsDAO;
import dao.resultsDAO;
import model.calc;

public class deleteTables {
    public static boolean delete(int userId) {
        doTimesDAO dtdao = new doTimesDAO();
        goalsDAO gdao = new goalsDAO();
        resultsDAO rdao = new resultsDAO();

        LocalDate firstdate = dtdao.getFirstDate(userId);
        LocalDate nowdate = LocalDate.now();

        if (firstdate != null) {
            calc cc = new calc();
            long judge = cc.judgeDate(firstdate, nowdate);
            if (judge >= 7) {
                dtdao.delete(userId);
                gdao.deleteGoal(userId);
                rdao.deleteAllResult(userId);
                return true; // 削除が行われた
            }
        }

        return false; // 削除されなかった
    }
}

