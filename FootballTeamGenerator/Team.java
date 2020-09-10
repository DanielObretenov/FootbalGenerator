package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name ){
        setName(name);
        this.players = new ArrayList<>();
    }
    public  double getRating(){
        return this.players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0);
    }

    public String getName() {
        Validator.validateName(name);
        return name;
    }
    public void addPlayer(Player player){
        this.players.add(player);
    }
    public void removePlayer(String name){
        int oldSize = this.players.size();
        this.players.removeIf(p-> p.getName().equals(name));
        Validator.validatePlayer(oldSize,players.size(),name,this.name);
    }

    private void setName(String name) {
        this.name = name;
    }



}
