/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1.guessing.game;

/**
 *
 * @author TOSHIBA
 */
public class Guess {
    private int a;
    private int b;
    private int c;
    private boolean followsRules;

    public Guess(int a, int b, int c, boolean followsRules) {
        //parameterized constructor
        this.a = a;
        this.b = b;
        this.c = c;
        this.followsRules = followsRules;
    }

    @Override
    public String toString() {
        return "[" + a + " " + b + " " + c + " " + followsRules + ']';
    }
    
    
    
    
}
