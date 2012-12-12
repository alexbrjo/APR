package co.alexjo.pong;

import java.util.HashMap;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener{
    
    public static boolean A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;
    private static boolean down = true;
    private static boolean up = false;
    private static boolean initKeys;
    private HashMap<Character, Boolean> keyBoard = new HashMap<Character, Boolean>();
    
    public KeyBoard(){
        if (!initKeys) {
            for (int i = 10; i < 36; i++) {
                keyBoard.put(Character.forDigit(i, 36), Boolean.FALSE);
            }
            initKeys = true;
            update();
        }
    }
    
    public void update() {
        A = keyBoard.get('a');
        B = keyBoard.get('b');
        C = keyBoard.get('c');
        D = keyBoard.get('d');
        E = keyBoard.get('e');
        F = keyBoard.get('f');
        G = keyBoard.get('g');
        H = keyBoard.get('h');
        I = keyBoard.get('i');
        J = keyBoard.get('j');
        K = keyBoard.get('k');
        L = keyBoard.get('l');
        M = keyBoard.get('m');
        N = keyBoard.get('n');
        O = keyBoard.get('o');
        P = keyBoard.get('p');
        Q = keyBoard.get('q');
        R = keyBoard.get('r');
        S = keyBoard.get('s');
        T = keyBoard.get('t');
        U = keyBoard.get('u');
        V = keyBoard.get('v');
        W = keyBoard.get('w');
        X = keyBoard.get('x');
        Y = keyBoard.get('y');
        Z = keyBoard.get('z');
    }

    public void keyTyped(KeyEvent ke) {
       
    }

    public void keyPressed(KeyEvent ke) {
        keyBoard.put(ke.getKeyChar(), down);
        update();
    }

    public void keyReleased(KeyEvent ke) {
        keyBoard.put(ke.getKeyChar(), up);
        update();
    }
}
