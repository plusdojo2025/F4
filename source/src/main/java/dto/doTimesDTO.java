package dto;

import java.io.Serializable;
import java.time.LocalDate;

public class doTimesDTO implements Serializable {

    private int do_time_id;        // 実施時間ID（主キー、自動採番）
    private int id;               // ユーザーID（Not null）
    private double exercise_do;   // 運動時間（Not null）
    private double study_do;      // 勉強時間（Not null）
    private double sleep_do;      // 睡眠時間（Not null）
    private LocalDate date;			  //日付

    public doTimesDTO(int id, double exercise_do, double study_do, double sleep_do) {
		this.do_time_id = 0;
        this.id = id;
		this.exercise_do = exercise_do; 	
		this.study_do = study_do;
		this.sleep_do = sleep_do;
		
	}

    //SELECT用DTO
    public doTimesDTO(int id, double exercise_do, double study_do, double sleep_do, LocalDate date) {
        this.do_time_id = 0;
        this.id = id;
        this.exercise_do = exercise_do;
        this.study_do = study_do;
        this.sleep_do = sleep_do;
        this.date = date;
    }

    
	public doTimesDTO() {
		this.do_time_id = 0; 
        this.id = 0;
		this.exercise_do = 0; 	
		this.study_do = 0;
		this.sleep_do = 0;
	}
	
	

    // Getter / Setter
    public int getDo_time_id() {
        return do_time_id;
    }

    public void setDo_time_id(int do_time_id) {
        this.do_time_id = do_time_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getExercise_do() {
        return exercise_do;
    }

    public void setExercise_do(double exercise_do) {
        this.exercise_do = exercise_do;
    }

    public double getStudy_do() {
        return study_do;
    }

    public void setStudy_do(double study_do) {
        this.study_do = study_do;
    }

    public double getSleep_do() {
        return sleep_do;
    }

    public void setSleep_do(double sleep_do) {
        this.sleep_do = sleep_do;
    }
    
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}