package org.springframework.step06;

public class CarFactory2 {
    public static Car create(String model) {
        Car c = new Car();
        switch (model) {
        case "티코":
            c.setMaker("대우자동차");
            c.setModel("Tico");
            c.setCc(1000);
            return c;
        case "소나타":
            c.setMaker("현대자동차");
            c.setModel("Sonata");
            c.setCc(2000);
            return c;
        case "SM6":
            c.setMaker("르노삼성자동차");
            c.setModel("SM6");
            c.setCc(3000);
            return c;
        default:
            c.setMaker("비트자동차");
            c.setModel("비트카");
            c.setCc(100);
            return c;
        }
    }
}
