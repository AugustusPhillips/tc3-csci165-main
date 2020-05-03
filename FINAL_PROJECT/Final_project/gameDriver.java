import java.util.ArrayList;

public class gameDriver {
    public static void main(String[] args) {
        ArrayList<Creature> creatureArray = new ArrayList<Creature>();
        Nazgul nazgul = new Nazgul(0, 0);
        //Nazgul nazgul2 = new Nazgul(1, 1);
        Hobbit hobbit = new Hobbit(2, 2);
        //Hobbit hobbit2 = new Hobbit(3, 3);
        Ranger ranger = new Ranger(4, 4);
        Troll troll = new Troll(5, 5);

        creatureArray.add(nazgul);
        //creatureArray.add(nazgul2);
        creatureArray.add(hobbit);
        //creatureArray.add(hobbit2);
        creatureArray.add(ranger);
        creatureArray.add(troll);

        HealingItem potion = new HealingItem("Magic Potion", 25, 2);
        for(Creature creature : creatureArray){

            System.out.println(creature);

            
            creature.attack(creature);
            creature.addToInv(potion);
            creature.chooseAction();
            creature.move();

            System.out.println(creature);
            System.out.println("~~~~~~~~~~~~~~~");
        }
        //System.out.println(nazgul);
    }
}