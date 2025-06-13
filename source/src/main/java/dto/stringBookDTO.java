package dto;

import java.util.ArrayList;
import java.util.List;

public class stringBookDTO{//これはデータベースとは関係ない　データ保持用

    private List<String> bestfeed;
    private List<String> goodfeed;
    private List<String> sosofeed;
    private List<String> ngfeed;

    public stringBookDTO(){
        bestfeed = new ArrayList<String>();
        bestfeed.add("素晴らしい結果ですね！");
        bestfeed.add("めちゃくちゃいい感じです！");
        bestfeed.add("有言実行とはこのことですね！");
        goodfeed = new ArrayList<String>();
        goodfeed.add("いい感じです！");
        goodfeed.add("努力が伝わります！");
        goodfeed.add("この調子です！");
        sosofeed = new ArrayList<String>();
        sosofeed.add("もう少し頑張れます！");
        sosofeed.add("悪くないですよ！");
        sosofeed.add("少しずつ時間を増やしていきましょう！");
        ngfeed = new ArrayList<String>();
        ngfeed.add("さぼりましたよね？");
        ngfeed.add("これがほんきですか？");
        ngfeed.add("目標が高すぎましたか？");
    }

    public List<String> getBestfeed(){
        return bestfeed;
    }
    public List<String> getGoodfeed(){
        return goodfeed;
    }
    public List<String> getSosofeed(){
        return sosofeed;
    }
    public List<String> getNgfeed(){
        return ngfeed;
    }
}
