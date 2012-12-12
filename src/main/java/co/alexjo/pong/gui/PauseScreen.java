package co.alexjo.pong.gui;

public class PauseScreen extends Screen {
    public PauseScreen(){
        initGUI();
    }
    public void initGUI(){
        clearScreen();
        addInput(new Input());
    }
}
