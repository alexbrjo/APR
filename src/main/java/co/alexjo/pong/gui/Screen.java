package co.alexjo.pong.gui;

import java.awt.Graphics;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Screen {
    
    public String title;
    private ArrayList<Input> inputs = new ArrayList<Input>();
    
    public void draw(Graphics g){
        for(int i = 0; inputs.size() > i; i++){
            inputs.get(i).draw(g);
        }
    } 
    
    public void exit(){
        
    }
    
    public Input getInputById(int id){
        return inputs.get(id);
    }
    
    public int getInputCount(int id){
        return inputs.size();
    } 
    
    public void addInput(Input i){
        inputs.add(i);
    }
    
    public void clearScreen(){
        inputs.clear();
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
}
