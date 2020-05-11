import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

//import java.util.Timer;
import javax.swing.Timer;

class gameDrawer extends JPanel implements ActionListener {
    private final int GRID_SIZE = 16;
    static Map gameMap = new Map();
    private static final long serialVersionUID = 1L;
    private JFrame window = new JFrame();
    Timer timer = new Timer(1000000, this);

    public gameDrawer() {
        timer.start();// Start the timer here.
        initUI();
    }

    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == timer) {
            repaint();
        }
    }

    private void initUI() {
        window.add(this);
        window.setTitle("Nazgul vs Hobbit");
        window.setSize(Map.getMapSize() * GRID_SIZE + 2, (Map.getMapSize() + 1) * GRID_SIZE + 20);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        /*
         * for(Creature creature : creatureList(arraylistofcreature)){
         * creature.chooseAction }
         */

        Graphics2D g2d = (Graphics2D) g;
        

        for(int index = 50; index > 0; index--){
            for (Creature c : gameMap.getCreatureList()) {
            
                g2d.setColor(c.color());
                g2d.fillRect(c.getPositionX() * GRID_SIZE, c.getPositionY() * GRID_SIZE, GRID_SIZE, GRID_SIZE);
    
            }
            
            
            
            //System.out.println(hobbit);//
        }
            //g2d.drawLine(0, GRID_SIZE*gameMap.getMapSize(), GRID_SIZE*gameMap.getMapSize(), GRID_SIZE*gameMap.getMapSize());
        
        for (Item i : gameMap.getItemList()) {
            g2d.setColor(Color.BLUE);
            g2d.fillOval(i.getPositionX() * GRID_SIZE, i.getPositionY() * GRID_SIZE, GRID_SIZE, GRID_SIZE);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            gameDrawer drawer = new gameDrawer();
            drawer.setVisible(true);
        });
/*
        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
*/      Nazgul nazgul = new Nazgul(2, 2);
        Nazgul nazgul2 = new Nazgul(7, 6);
        Hobbit hobbit = new Hobbit(4, 3);
        Hobbit hobbit2 = new Hobbit(12, 15);
        Ranger ranger = new Ranger(10, 10);
        Troll troll = new Troll(5, 5);
        Blade blade = new Blade(150, 5);
        HealingItem potion = new HealingItem("Magic Potion", 25, 2);
        potion.setPosiiton(12, 12);

        blade.setPosiiton(5, 9);
        gameMap.addCreature(nazgul2);
        gameMap.addCreature(hobbit);
        gameMap.addCreature(ranger);
        gameMap.addCreature(hobbit2);
        gameMap.addCreature(troll);
        gameMap.addCreature(nazgul);
        gameMap.addItem(potion);
        for(Creature c : gameMap.getCreatureList()){
            c.chooseAction(gameMap);
            if(c.getHealth() == 0){
                gameMap.removeCreature(c);
            }
        }
//System.out.println(hobbit);

    } // end main
} // end class
