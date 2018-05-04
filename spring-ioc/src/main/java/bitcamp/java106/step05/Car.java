package bitcamp.java106.step05;

import java.util.Arrays;

public class Car {
    String model;
    String maker;
    int cc;
    Engine engine; // 엔진 추가
    Tire[] tires; // 타이어
    
    @Override
    public String toString() {
        return "Car [model=" + model + ", maker=" + maker + ", cc=" + cc + ", engine=" + engine + ", tires="
                + Arrays.toString(tires) + "]";
    }

    // 타이어 셋터 겟터 추가
    public Tire[] getTires() {
        return tires;
    }

    public void setTires(Tire[] tires) {
        this.tires = tires;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getMaker() {
        return maker;
    }
    public void setMaker(String maker) {
        this.maker = maker;
    }
    public int getCc() {
        return cc;
    }
    public void setCc(int i) {
        this.cc = i;
    }
    
    
    
    
}
