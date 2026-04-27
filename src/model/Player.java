package model;

public class Player {
    private String nickname;
    private int ranking;

    public Player(String nickname, int ranking){
        this.nickname = nickname;
        this.ranking = ranking;
    }

    public String getNickname(){
        return nickname;
    }

    public void setNickname (String novoNickname){
        if (novoNickname != null && !novoNickname.isEmpty()){
            this.nickname = novoNickname;
        }
    }

    public int getRanking(){
        return ranking;
    }

    public void setRanking (int novoRanking){
        this.ranking = novoRanking;
    }

    public String toString(){
        return "Jogador{Nick:'" + nickname + "', ranking=" + ranking + "}";
    }

}
