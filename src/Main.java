import javafx.print.Collation;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<Doors> doors1 = new ArrayList<>();
        List<Doors> doors2 = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Doors door = Doors.getDoors();
            doors1.add(door);
            doors2.add(door.clone());
           // System.out.println(door);
        }
        Player p1 = new Player("p1", Strategies.CHANGER);
        List<Boolean> firstPlayer = new ArrayList<>();
        Player p2 = new Player("p2", Strategies.NOTCHANGER);
        List<Boolean> secondPlayer = new ArrayList<>();
        for (int i = 0; i < doors1.size(); i++) {
           int choice = (int) Math.round(Math.random()*2);
            System.out.println("до выбора 1"+doors1.get(i));
            System.out.println("p1 выбирает " + choice);
            firstPlayer.add(doors1.get(i).isWon(p1, choice));
            secondPlayer.add(doors2.get(i).isWon(p2, choice));

            System.out.println("после выбора 1"+doors1.get(i) + ". "+firstPlayer.get(firstPlayer.size()-1));
            System.out.println("после выбора 2"+doors2.get(i) + ". "+secondPlayer.get(secondPlayer.size()-1));

        }

        System.out.println("Ченджер "+firstPlayer.stream().filter(s-> s).count());
        System.out.println("Не ченджер "+secondPlayer.stream().filter(s-> s).count());
    }
}
