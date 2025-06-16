package dto;

import java.util.ArrayList;
import java.util.List;

public class stringBookDTO{//これはデータベースとは関係ない　データ保持用
    private List<String> bestweekfeed;
    private List<String> goodweekfeed;
    private List<String> sosoweekfeed;
    private List<String> ngweekfeed;
    //ーーーーーーーーーーーーーーーーーーーーーーーーー
    private List<String> bestexfeed;
    private List<String> goodexfeed;
    private List<String> sosoexfeed;
    private List<String> ngexfeed;
    //ーーーーーーーーーーーーーーーーーーーーーーーーー
    private List<String> beststfeed;
    private List<String> goodstfeed;
    private List<String> sosostfeed;
    private List<String> ngstfeed;
    //ーーーーーーーーーーーーーーーーーーーーーーーーー
    private List<String> bestslfeed;
    private List<String> sososlfeed;
    private List<String> longslfeed;
    private List<String> shortslfeed;

    public stringBookDTO(){
        bestweekfeed = new ArrayList<String>();
        bestweekfeed.add("高い達成率を維持し、充実した成果を上げることができました。今後も同じ意欲で頑張ってください!");
        bestweekfeed.add("毎日の取り組みが着実に結果へとつながり、理想的な一週間になりました。この調子で継続しましょう!");
        bestweekfeed.add("目標に対して強い意志を持ち、完璧な成果を出しました。この調子で今後も成長を続けていきましょう!");
        goodweekfeed = new ArrayList<String>();
        goodweekfeed.add("ほぼ目標を達成できており、成果が出ていることが分かります。次はもっと上を目指しましょう!");
        goodweekfeed.add("目標達成に近づいており、良い流れができています。引き続き集中して取り組みましょう!");
        goodweekfeed.add("順調に目標に近づいており、着実な成長が見られます。今後も努力を続けていきましょう!");
        sosoweekfeed = new ArrayList<String>();
        sosoweekfeed.add("まだ課題はありますが、一歩ずつ改善が進んでいます。あきらめずに取り組み続けてください！");
        sosoweekfeed.add("結果は十分とは言えませんが、挑戦する姿勢は評価できます。継続して努力してください！");
        sosoweekfeed.add("目標からは離れていますが、前向きな取り組みが見られます。焦らず少しずつ前進しましょう！");
        ngweekfeed = new ArrayList<String>();
        ngweekfeed.add("目標達成にはまだ遠い状況ですが、あきらめずに努力を続けることが大切です。次回に期待します!");
        ngweekfeed.add("現状は厳しいですが、続けることで必ず成長できます。気持ちを切らさずに挑戦し続けてください!");
        ngweekfeed.add("目標からは大きく離れていますが、今は基礎固めの時期です。焦らず一歩ずつ進んでください!");
        // ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
        bestexfeed = new ArrayList<String>();
        bestexfeed.add("計画的な運動を心がけていますね！");
        bestexfeed.add("運動量バッチリです！");
        bestexfeed.add("運動に意欲を感じます！");
        goodexfeed = new ArrayList<String>();
        goodexfeed.add("運動習慣がついてきています！");
        goodexfeed.add("安定した運動ができています！");
        goodexfeed.add("あと一歩で運動完璧です！");
        sosoexfeed = new ArrayList<String>();
        sosoexfeed.add("少しずつ運動時間を増やしましょう！");
        sosoexfeed.add("目標を意識しながら運動しましょう！");
        sosoexfeed.add("諦めずに運動を継続しましょう！");
        ngexfeed = new ArrayList<String>();
        ngexfeed.add("運動があまりできていないようですね");
        ngexfeed.add("切り替えて運動しましょう");
        ngexfeed.add("運動時間を確保できていないようです");
        //ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
        beststfeed = new ArrayList<String>();
        beststfeed.add("計画的な学習を心がけていますね！");
        beststfeed.add("学習が捗っているようですね！");
        beststfeed.add("学習の意欲が非常に高いですね！");
        goodstfeed = new ArrayList<String>();
        goodstfeed.add("学習の習慣がついてきていますね！");
        goodstfeed.add("学習が少しづつ習慣化されています！");
        goodstfeed.add("あと少しで学習目標を達成できます！");
        sosostfeed = new ArrayList<String>();
        sosostfeed.add("少しづつ学習時間を増やしていきましょう！");
        sosostfeed.add("学習の時間をきちんと確保しましょう！");
        sosostfeed.add("諦めずに学習を取り組みましょう！");
        ngstfeed = new ArrayList<String>();
        ngstfeed.add("学習ができていないようです");
        ngstfeed.add("切り替えて学習をしていきましょう");
        ngstfeed.add("学習時間が取れていないようです");
        //ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
        bestslfeed = new ArrayList<String>();
        bestslfeed.add("完璧な睡眠時間をとれていますね！");
        bestslfeed.add("睡眠時間の調節が完璧です！");
        sososlfeed = new ArrayList<String>();
        sososlfeed.add("かなり睡眠取れてますね！");
        sososlfeed.add("いい感じに睡眠を取れています！");
        longslfeed = new ArrayList<String>();
        longslfeed.add("長すぎる睡眠は逆効果です！");
        longslfeed.add("寝すぎは体に毒ですよ！");
        shortslfeed = new ArrayList<String>();
        shortslfeed.add("睡眠不足は万病のもとです");
        shortslfeed.add("睡眠時間はしっかり確保しましょう");
    }

    public List<String> getBestExfeed(){
        return bestexfeed;
    }
    public List<String> getGoodExfeed(){
        return goodexfeed;
    }
    public List<String> getSosoExfeed(){
        return sosoexfeed;
    }
    public List<String> getNgExfeed(){
        return ngexfeed;
    }
    public List<String> getBestStfeed(){
        return beststfeed;
    }
    public List<String> getGoodStfeed(){
        return goodstfeed;
    }
    public List<String> getSosoStfeed(){
        return sosostfeed;
    }
    public List<String> getNgStfeed(){
        return ngstfeed;
    }
    public List<String> getBestSlfeed(){
        return bestslfeed;
    }
    public List<String> getLongSlfeed(){
        return longslfeed;
    }
    public List<String> getSosoSlfeed(){
        return sososlfeed;
    }
    public List<String> getShortSlfeed(){
        return shortslfeed;
    }
    public List<String> getBestWeekfeed(){
        return bestweekfeed;
    }
    public List<String> getGoodWeekfeed(){
        return goodweekfeed;
    }
    public List<String> getSosoWeekfeed(){
        return sosoweekfeed;
    }
    public List<String> getNgWeekfeed(){
        return ngweekfeed;
    }
}