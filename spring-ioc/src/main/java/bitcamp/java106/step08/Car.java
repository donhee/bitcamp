package bitcamp.java106.step08;

import java.sql.Date;

public class Car {
    String model;
    String maker;
    int cc;
    boolean auto; //primitive 타입 변환기 확인
    Date createdDate; // 제조일 추가
    Engine engine;
    
    public Car() {
        System.out.println("Car() 호출됨!");
    }
    
    @Override
    public String toString() {
        return "Car [model=" + model + ", maker=" + maker + ", cc=" + cc + ", auto=" + auto + ", createdDate="
                + createdDate + ", engine=" + engine + "]";
    }

    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        System.out.println("setEngine() 호출됨!");
        this.engine = engine;
    }
    public boolean isAuto() {
        return auto;
    }
    public void setAuto(boolean auto) {
        System.out.println("setAuto() 호출됨!");
        this.auto = auto;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        System.out.println("setCreatedDate() 호출됨!");
        this.createdDate = createdDate;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        System.out.println("setModel() 호출됨!");
        this.model = model;
    }
    public String getMaker() {
        return maker;
    }
    public void setMaker(String maker) {
        System.out.println("setMaker() 호출됨!");
        this.maker = maker;
    }
    public int getCc() {
        return cc;
    }
    public void setCc(int i) {
        System.out.println("setCc() 호출됨!");
        this.cc = i;
    }
    
    
    
    
}
