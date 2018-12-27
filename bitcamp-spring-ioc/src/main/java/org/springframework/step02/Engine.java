package org.springframework.step02;

public class Engine {
    String maker;
    int value;
    int cylinder;
    
    public String getMaker() {
        return maker;
    }
    public void setMaker(String maker) {
        this.maker = maker;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public int getCylinder() {
        return cylinder;
    }
    public void setCylinder(int cylinder) {
        this.cylinder = cylinder;
    }
    
    @Override
    public String toString() {
        return "Engine [maker=" + maker + ", value=" + value + ", cylinder=" + cylinder + "]";
    }
    
}
