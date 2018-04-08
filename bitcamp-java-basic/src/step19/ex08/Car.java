package step19.ex08;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class Car {
    Engine engine;
    
    public Car() {
        System.out.println("=====> Car()");
        this.engine = new Engine();
    }
    
    public void move() {
        this.engine.run();
    }
}
