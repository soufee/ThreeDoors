public class Doors {
    private int A;
    private int B;
    private int C;

    private Doors() {
        int thePrizzeDoor = (int) Math.round(Math.random()*3);
        A = 0;
        B = 0;
        C = 0;
        if (thePrizzeDoor == 0) A = 1;
        else if (thePrizzeDoor == 1) B = 1;
        else C = 1;
    }

    public static Doors getDoors() {
        return new Doors();
    }

    public int getA() {
        return A;
    }

    public int getB() {
        return B;
    }

    public int getC() {
        return C;
    }

    @Override
    public Doors clone() throws CloneNotSupportedException {
        Doors copy = new Doors();
        copy.A = this.A;
        copy.B = this.B;
        copy.C = this.C;
        return copy;
    }

    public void openWrongDoor(int choice) {
        if (choice == 0) {
            if (B == 1) {
                C = -1;
            } else if (C == 1) {
                B = -1;
            } else {
                int ind = getRandomDoor();
                if (ind == 1) B = -1;
                else C = -1;
            }
        } else if (choice == 1) {
            if (A == 1) {
                C = -1;
            } else if (C == 1) {
                A = -1;
            } else {
                int ind = getRandomDoor();
                if (ind == 1) A = -1;
                else C = -1;
            }
        } else{
            if (A == 1) {
                B = -1;
            } else if (B == 1) {
                A = -1;
            } else {
                int ind = getRandomDoor();
                if (ind == 1) A = -1;
                else B = -1;
            }
        }
    }


    public int secondChoise(Player p, int firstChoice){
       if (p.getStrategy().equals(Strategies.NOTCHANGER)){
           return firstChoice;
       } else {
           if (A!=-1 && 0!=firstChoice) return 0;
           else if (B!=-1 && 1!=firstChoice) return 1;
           else return 2;
       }
    }

    public boolean isWon(Player p, int firstChoise){
        openWrongDoor(firstChoise);
        int i = secondChoise(p, firstChoise);
        if (i==0){
            return A==1;
        } else if (i==1){
            return B==1;
        } else{
            return C==1;
        }
    }
    private int getRandomDoor(){
        return (int) (Math.round(Math.random()*2)+1);
    }
    @Override
    public String toString() {
        return "Doors{" +
                "A=" + A +
                ", B=" + B +
                ", C=" + C +
                '}';
    }
}
