public class Hero {
    private String name;

    private int hitPoints;

    public Hero(String name) {
        this.name = name;
        this.hitPoints = 100;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public String toString(){
        return "Hero{name=\'" + name + "\', hitPoints=" + hitPoints + "}";
    }

    public void attack(Hero opponent){
        double value = Math.random();
        if (value < 0.5) {
            opponent.hitPoints -= 10;
        } else {
            hitPoints -= 10;
        }
    }

    public void senzuBean(){
        this.hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent) {
        while ((opponent.hitPoints > 0) && (hitPoints > 0)) {
            attack(opponent);
        }
    }

    public String fightUntilTheDeath(Hero opponent) {
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return name + ": " + hitPoints + opponent.name +  ": " + opponent.hitPoints;
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n) {
        int heroW = 0;
        int opponentW = 0;
        int a[] = new int[2];
        for(int i=0;i<n;i++){
            senzuBean();
            opponent.senzuBean();
            fightUntilTheDeathHelper(opponent);
            if(hitPoints == 0){
                opponentW++;
            }else heroW++;
        }
        a[0] = heroW;
        a[1] = opponentW;
        return a;
    }

    public String nFightsToTheDeath(Hero opponent, int n){
        String answer = "";
        int a[] = new int[2];
        a = nFightsToTheDeathHelper(opponent, n);
        answer = name + ": " + a[0] + " wins\n" + opponent.name + ": " + a[1] + " wins\n";
        if(a[0] == a[1]){
            answer += "OMG! It was actually a draw!";
        }else if(a[0] > a[1]){
            answer += name + " wins!";
        }else{
            answer += opponent.name + " wins!";
        }
        return answer;
    }

    public void dramaticFightToTheDeath(Hero opponent){
        try {
            senzuBean();
            opponent.senzuBean();
            while(opponent.hitPoints > 0 && hitPoints > 0){
                attack(opponent);
                Thread.sleep(1000);
                System.out.println(name + ": " + hitPoints + "\t" + opponent.name + ": " + opponent.hitPoints);
            }
            if (hitPoints > 0) {
                System.out.println(name + " wins!");
            } else {
                System.out.println(opponent.name + " wins!");
            }
        }
        catch(InterruptedException e){
            System.out.println("error");
        }
    }
}



