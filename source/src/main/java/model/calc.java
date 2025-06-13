package model;

import java.util.List;
import java.util.Random;

import dto.stringBookDTO;

public class calc{//doexcersize dostudy dosleep｜ goalexcersize goalstudy goalsleep をサーブレットでもらう
    
    //一日の全項目に対する達成度を計算するメソッド
    public double dayLevelCheck(double doexcersize, double dostudy, double dosleep, double goalexcersize, double goalstudy, double goalsleep){
        double totalDayDo = doexcersize + dostudy + dosleep;
        double totalDayGoal = goalexcersize + goalstudy + goalsleep;
        if (totalDayDo == 0) return 0.0;

        double dayLevel = totalDayDo / totalDayGoal * 100;
        return Math.round(dayLevel * 10.0) / 10.0;
    }

    public String buildDayFeedback(double dayLevel){
        stringBookDTO book = new stringBookDTO();//テンプレート文DTOのインスタンス作成
        Random rand = new Random();
        
        if (dayLevel >= 90) {
            List<String> list = book.getBestfeed();
            String best = list.get(rand.nextInt(list.size()));
            return best;
        } else if (dayLevel >= 60) {
            List<String> list = book.getGoodfeed();
            String good = list.get(rand.nextInt(list.size()));
            return good;
        } else if (dayLevel >= 30) {
            List<String> list = book.getSosofeed();
            String soso = list.get(rand.nextInt(list.size()));
            return soso;
        } else {
           List<String> list = book.getNgfeed();
            String ng = list.get(rand.nextInt(list.size()));
            return ng;
        }
    } 

    public double weekLevelCheck(double doexcersize, double dostudy, double dosleep, double goalexcersize, double goalstudy, double goalsleep, List<Double> levelList){
        double totalWeekDo = doexcersize + dostudy + dosleep;
        double totalWeekGoal = goalexcersize + goalstudy + goalsleep;
        if (totalWeekDo == 0) return 0.0;

        double lastDayLevel = Math.round((totalWeekDo / totalWeekGoal * 100) * 10) / 10;

        for(int i = 0; i < levelList.size(); i++){
            lastDayLevel += levelList.get(i);
        }
        
        // 7日間の平均を計算し、小数1桁で返す
        double avgLevel = lastDayLevel / 7;
        
        return Math.round(avgLevel * 10.0) / 10.0;
    }

    public String buildWeekFeedback(double weekLevel){
        stringBookDTO book = new stringBookDTO();//テンプレート文DTOのインスタンス作成
        Random rand = new Random();
        
        if (weekLevel >= 90) {
            List<String> list = book.getBestfeed();
            String best = list.get(rand.nextInt(list.size()));
            return best;
        } else if (weekLevel >= 60) {
            List<String> list = book.getGoodfeed();
            String good = list.get(rand.nextInt(list.size()));
            return good;
        } else if (weekLevel >= 30) {
            List<String> list = book.getSosofeed();
            String soso = list.get(rand.nextInt(list.size()));
            return soso;
        } else {
           List<String> list = book.getNgfeed();
            String ng = list.get(rand.nextInt(list.size()));
            return ng;
        }
    } 

}