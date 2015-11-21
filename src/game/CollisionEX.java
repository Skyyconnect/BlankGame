package game;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class CollisionEX extends JFrame {

    public CollisionEX() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Board());
        
        setResizable(false);
        pack();
        
        setTitle("Collision");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CollisionEX ex = new CollisionEX();
                ex.setVisible(true);
            }
        });
    }
}