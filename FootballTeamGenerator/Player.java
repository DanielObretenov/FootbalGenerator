package FootballTeamGenerator;

public class Player {

    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting){
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    public double overallSkillLevel(){
        return (this.endurance+ this.sprint + this.dribble + this.passing + this.shooting)/5.00;
    }
    public String getName() {
        return name;
    }

    private void setName(String name) {
        Validator.validateName(name);
        this.name = name;
    }

    private void setEndurance(int endurance) {
        Validator.ValidateStats(endurance,"Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        Validator.ValidateStats(sprint,"Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        Validator.ValidateStats(dribble,"Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        Validator.ValidateStats(passing,"Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        Validator.ValidateStats(shooting,"Shooting");
        this.shooting = shooting;
    }
}
