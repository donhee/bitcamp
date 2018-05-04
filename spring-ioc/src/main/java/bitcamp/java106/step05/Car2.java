package bitcamp.java106.step05;

import java.util.List;

public class Car2 {
    String model;
    String maker;
    int cc;
    Engine engine; // 엔진 추가
    List<Tire> tires; // 배열이 아니라 리스트 인터페이스
    

    @Override
    public String toString() {
        return "Car2 [model=" + model + ", maker=" + maker + ", cc=" + cc + ", engine=" + engine + ", tires=" + tires
                + "]";
    }

    public List<Tire> getTires() {
        return tires;
    }

    public void setTires(List<Tire> tires) {
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
