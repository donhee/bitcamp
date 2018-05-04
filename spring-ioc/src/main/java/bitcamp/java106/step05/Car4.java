package bitcamp.java106.step05;

import java.util.Properties;

public class Car4 {
    String model;
    String maker;
    int cc;
    Properties options; // Properties 쓰는 경우도 있다.
    

    @Override
    public String toString() {
        return "Car4 [model=" + model + ", maker=" + maker + ", cc=" + cc + ", options=" + options + "]";
    }
    public Properties getOptions() {
        return options;
    }
    public void setOptions(Properties options) {
        this.options = options;
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
