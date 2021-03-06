package bitcamp.java106.step06;

public class CarFactory {
    public static Car create(String model) { // 스태틱 메서드 호출하기
        Car c = new Car();
        switch (model) {
        case "티코" :
            c.setMaker("대우자동차");
            c.setModel("Tico");
            c.setCc(1980);
            return c;
        case "소나타" :
            c.setMaker("현대자동차");
            c.setModel("Sonata");
            c.setCc(1980);
            return c;
        case "SM5" :
            c.setMaker("르노삼성자동차");
            c.setModel("SM5");
            c.setCc(1599);
            return c;
        default:
            c.setMaker("비트자동차");
            c.setModel("자바휘웅");
            c.setCc(5000);
            return c;
        }
    }
}
