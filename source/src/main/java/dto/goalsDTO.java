package dto;

import java.io.Serializable;

public class goalsDTO implements Serializable {
	private int goals_id;           // 目標時間id
    private int id;                 // ユーザーid(外部キー)
	private double exercise_goal;    // 運動時間目標
	private double study_goal;       // 勉強時間目標
	private double sleep_goal;       // 睡眠時間目標
	

	public goalsDTO(int goals_id, int id, double exercise_goal, double study_goal, double sleep_goal) {
		this.goals_id = goals_id;
        this.id = id;
		this.exercise_goal = exercise_goal; 	
		this.study_goal = study_goal;
		this.sleep_goal = sleep_goal;
	}

	public goalsDTO() {
		this.goals_id = 0; 
        this.id = 0;
		this.exercise_goal = 0; 	
		this.study_goal = 0;
		this.sleep_goal = 0;
	}

    // goals_idのゲッター、セッター
	public int getGoals_id() {
		return goals_id;
	}
	public void setGoals_id(int goals_id) {
		this.goals_id = goals_id;
	}

    // idのゲッター、セッター
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

    // exercise_goalのゲッター、セッター
	public double getExercise_goal() {
		return exercise_goal;
	}
	public void setExercise_goal(double exercise_goal) {
		this.exercise_goal = exercise_goal;
	}
	
    // study_goalのゲッター、セッター
	public double getStudy_goal() {
		return study_goal;
	}
	public void setStudy_goal(double study_goal) {
		this.study_goal = study_goal;
	}

    // sleep_goalのゲッター、セッター	
	public double getSleep_goal() {
		return sleep_goal;
	}
	public void setSleep_goal(double sleep_goal) {
		this.sleep_goal = sleep_goal;
	}
}
