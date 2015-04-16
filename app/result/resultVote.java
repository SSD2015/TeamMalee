package result;

/**
 * Created by patawat on 4/16/15 AD.
 */
public class resultVote {
    private int name;
    private int score;
    private int score2;
    private int score3;
    public resultVote(int ProjectNum,int score,int score2,int score3){
        this.name = ProjectNum;
        this.score = score;
        this.score2 = score2;
        this.score3 = score3;
    }
    public int getname(){
        return this.name;
    }
    public int getScore(){
        return this.score;
    }
    public int getScore2(){
        return this.score2;
    }
    public int getScore3(){
        return this.score3;
    }
    public void setScore(int newScore){
        this.score +=newScore;
    }
    public void setScore2(int newScore){
        this.score2 +=newScore;
    }
    public void setScore3(int newScore){
        this.score3 +=newScore;
    }

}
