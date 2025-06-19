package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dto.stringBookDTO;

public class calc{//doexcersize dostudy dosleep｜ goalexcersize goalstudy goalsleep をサーブレットでもらう
    
    //一日の全項目に対する達成度を計算するメソッド
    public List<Double> dayLevelCheck(double doexcersize, double dostudy, double dosleep, double goalexcersize, double goalstudy, double goalsleep){
        List<Double>list = new ArrayList<Double>();
        double totalDayDo = doexcersize + dostudy + dosleep;
        double totalDayGoal = goalexcersize + goalstudy + goalsleep;
        if (totalDayDo == 0) {
        	list.add(0.0);
        	list.add(0.0);
        	list.add(0.0);
        	 return list;
        }

        double excersizelevel = doexcersize / goalexcersize *100;
        double studylevel = dostudy / goalstudy *100;
        double dayLevel = totalDayDo / totalDayGoal * 100;

        list.add(Math.round(dayLevel * 10.0) / 10.0);
        list.add(excersizelevel);
        list.add(studylevel);
        

        return list;//リストを返す
    }
    
    public String sleepCheck(double dosleep){
        stringBookDTO book = new stringBookDTO();
        Random rand = new Random();
        List<String> slfeedlist;
        String slfeed;
        if(dosleep >= 9){
            slfeedlist = book.getLongSlfeed();
            slfeed = slfeedlist.get(rand.nextInt(slfeedlist.size()));
            return slfeed;
        }else if(dosleep < 6){
            slfeedlist = book.getShortSlfeed();
            slfeed = slfeedlist.get(rand.nextInt(slfeedlist.size()));
            return slfeed;
        }else if(dosleep >= 6.5 && dosleep <= 7){
            slfeedlist = book.getBestSlfeed();
            slfeed = slfeedlist.get(rand.nextInt(slfeedlist.size()));
            return slfeed;
        }else{
            slfeedlist = book.getSosoSlfeed();
            slfeed = slfeedlist.get(rand.nextInt(slfeedlist.size()));
            return slfeed;
        }
    }

    public String buildDayFeedback(List<Double> dayLevelList, String slfeed){
        stringBookDTO book = new stringBookDTO();//テンプレート文DTOのインスタンス作成
        List<String> efeed = new ArrayList<>();
        List<String> sfeed = new ArrayList<>();
        String efeedback= "";
        String sfeedback= "";
        String dayfeed;
        Random rand = new Random();

        for(int i = 1; i < dayLevelList.size(); i++){
            switch (i) {
                case 1:
                    if(dayLevelList.get(dayLevelList.size() - i) >=80){
                        efeed = book.getBestExfeed();
                        efeedback = efeed.get(rand.nextInt(efeed.size()));
                    }else if(dayLevelList.get(dayLevelList.size() - i) >= 60){
                        efeed = book.getGoodExfeed();
                        efeedback = efeed.get(rand.nextInt(efeed.size()));
                    }else if(dayLevelList.get(dayLevelList.size() - i) >= 40){
                        efeed = book.getSosoExfeed();
                        efeedback = efeed.get(rand.nextInt(efeed.size()));
                    }else{
                        efeed = book.getNgExfeed();
                        efeedback = efeed.get(rand.nextInt(efeed.size()));
                    }
                    break;
                case 2:
                    if(dayLevelList.get(dayLevelList.size() - i) >=80){
                        sfeed = book.getBestStfeed();
                        sfeedback = sfeed.get(rand.nextInt(sfeed.size()));
                    }else if(dayLevelList.get(dayLevelList.size() - i) >= 60){
                        sfeed = book.getGoodStfeed();
                        sfeedback = sfeed.get(rand.nextInt(sfeed.size()));
                    }else if(dayLevelList.get(dayLevelList.size() - i) >= 40){
                        sfeed = book.getSosoStfeed();
                        sfeedback = sfeed.get(rand.nextInt(sfeed.size()));
                    }else{
                        sfeed = book.getNgStfeed();
                        sfeedback = sfeed.get(rand.nextInt(sfeed.size()));
                    }
                    break;
                default:
                    break;
            }
            
        }
        dayfeed = efeedback + "そして" + sfeedback + "最後に" + slfeed;
        return dayfeed;
        
        
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
        
        if (weekLevel >= 80) {
            List<String> list = book.getBestWeekfeed();
            String best = list.get(rand.nextInt(list.size()));
            return best;
        } else if (weekLevel >= 60) {
            List<String> list = book.getGoodWeekfeed();
            String good = list.get(rand.nextInt(list.size()));
            return good;
        } else if (weekLevel >= 40) {
            List<String> list = book.getSosoWeekfeed();
            String soso = list.get(rand.nextInt(list.size()));
            return soso;
        } else {
           List<String> list = book.getNgWeekfeed();
            String ng = list.get(rand.nextInt(list.size()));
            return ng;
        }
    } 
    
    public long judgeDate(LocalDate firstdate, LocalDate nowdate) {
    	long judge = ChronoUnit.DAYS.between(firstdate, nowdate);
    	return judge;
    }

}