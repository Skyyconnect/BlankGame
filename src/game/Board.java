package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Player player;
    private ArrayList<Wizard> wizard;
    private boolean ingame;
    private final int IPlayer_X = 40;
    private final int IPlayer_Y = 60;
    private final int B_WIDTH = 400;
    private final int B_HEIGHT = 300;
    private final int DELAY = 15;

    private final int[][] pos = {
        {2380, 29}, {2500, 59}, {1380, 89},
        {780, 109}, {580, 139}, {680, 239},
        {790, 259}, {760, 50}, {790, 150},
        {980, 209}, {560, 45}, {510, 70},
        {930, 159}, {590, 80}, {530, 60},
        {940, 59}, {990, 30}, {920, 200},
        {900, 259}, {660, 50}, {540, 90},
        {810, 220}, {860, 20}, {740, 180},
        {820, 128}, {490, 170}, {700, 30}
    };

    public Board() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        ingame = true;

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        player = new Player(IPlayer_X, IPlayer_Y);

      initWizard();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void initWizard() {
        wizard = new ArrayList<>();

        for (int[] p : pos) {
            wizard.add(new Wizard(p[0], p[1]));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (ingame) {

            drawObjects(g);

        } else {

            drawGameOver(g);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics g) {

        if (player.isVisible()) {
            g.drawImage(player.getImage(), player.getX(), player.getY(),
                    this);
        }

        ArrayList<Missile> ms = player.getMissiles();

        for (Missile m : ms) {
            if (m.isVisible()) {
                g.drawImage(m.getImage(), m.getX(), m.getY(), this);
            }
        }

        for (Wizard a : wizard) {
            if (a.isVisible()) {
                g.drawImage(a.getImage(), a.getX(), a.getY(), this);
            }
        }

        g.setColor(Color.WHITE);
        g.drawString("Wizards left: " + wizard.size(), 5, 15);
    }

    private void drawGameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2,
                B_HEIGHT / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        inGame();

       updatePlayer();
        updateMissiles();
        updateWizards();

        checkCollisions();

        repaint();
    }

    private void inGame() {
        
        if (!ingame) {
            timer.stop();
        }
    }

    private void updatePlayer() {

        if (player.isVisible()) {
            player.move();
        }
    }

    private void updateMissiles() {

        ArrayList<Missile> ms = player.getMissiles();

        for (int i = 0; i < ms.size(); i++) {

            Missile m = ms.get(i);

            if (m.isVisible()) {
                m.move();
            } else {
                ms.remove(i);
            }
        }
    }

    private void updateWizards() {

        if (wizard.isEmpty()) {

            ingame = false;
            return;
        }

        for (int i = 0; i < wizard.size(); i++) {

            Wizard a = wizard.get(i);
            if (a.isVisible()) {
                a.move();
            } else {
                wizard.remove(i);
            }
        }
    }

    public void checkCollisions() {

        Rectangle r3 = player.getBounds();

        for (Wizard wiz : wizard) {
            Rectangle r2 = wiz.getBounds();

            if (r3.intersects(r2)) {
                player.setVisible(false);
                wiz.setVisible(false);
                ingame = false;
            }
        }

        ArrayList<Missile> ms = player.getMissiles();

        for (Missile m : ms) {

            Rectangle r1 = m.getBounds();

            for (Wizard wiz2 : wizard) {

                Rectangle r2 = wiz2.getBounds();

                if (r1.intersects(r2)) {
                    m.setVisible(false);
                    wiz2.setVisible(false);
                }
            }
        }
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }
    }
}