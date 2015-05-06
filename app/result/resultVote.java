package result;

/**
 * Created by patawat on 4/16/15 AD.
 */
public class resultVote {

    private String name;
    private int score;
    private int score2;
    private int score3;
    private int score4;
    private int score5;
    private int criteria;
    public resultVote(String name,int criteria){

        this.name = name;
        this.score = 0;
        this.score2 = 0;
        this.score3 = 0;
        this.score4 = 0;
        this.score5 = 0;
        this.criteria = criteria;
    }
// Come back to clean code
    public String getname(){
        return this.name;
    }
    public static double countNumberID(){
        double num = 0;
        int size = Vote.find.all().size();
                if(size==0)
                    return 1;
        for (int i=0;i<size;i++){
            num++;
        }

        return num;
    }
    public static double countNumVoteCri(){
        double num = 0;
        for (int i=0;i<Criteria.find.all().size();i++){
            num++;
        }
        return num;
    }
    public double getScore(){
        //if (countNumberID()==0)
        return this.score/countNumberID();
    }
    public double getScore2(){
        return this.score2/countNumberID();
    }
    public double getScore3(){
        return this.score3/countNumberID();
    }
    public double getScore4(){
        return this.score4/countNumberID();
    }
    public double getScore5(){
        return this.score5/countNumberID();
    }
    public double getCriteria(){
        if (criteria==0 || countNumVoteCri()==0)
            return 0.0;
        return this.criteria/countNumVoteCri();
    }
    public void setName(String name){
        this.name = name;
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
    public void setScore4(int newScore){
        this.score4 +=newScore;
    }
    public void setScore5(int newScore){
        this.score5 +=newScore;
    }
    public void setCriteria(int newScore){
        this.criteria +=newScore;
    }

}
