/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author Michał
 */
public class StateManager {
    private ArrayList<State> states;
    
    private int currentState;
    
    public static final int MENUSTATE = 0;
    public static final int GAMESTATE = 1;
    
    public StateManager(Graphics2D g2d) {
        states = new ArrayList<State>();
        states.add(new Game(this));
        
        states.get(currentState).update(g2d);
    }
    
    public void update(Graphics2D g2d) {
        states.get(currentState).update(g2d);
    }
    
    public void draw(Graphics2D g2d) {
        states.get(currentState).draw(g2d);
    }
    
    public void keyPressed(int key) {
        states.get(currentState).keyPressed(key);
    }
    
    public void keyReleased(int key) {
        states.get(currentState).keyReleased(key);
    }
    
    public void setState(int state) {
        currentState = state;
        states.get(state).init();
    }
    
    public int getCurrentState() {
        return currentState;
    }
}
