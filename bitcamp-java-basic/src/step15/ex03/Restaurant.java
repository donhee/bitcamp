// Build을 상속 받아 startEffect() 와 endEffect()를 구체화시킨다.
package step15.ex03;

public class Restaurant extends Building {
    @Override
    public void startEffect() {
        System.out.println("뚝딱..뚞딱..");
    }
    
    @Override
    public void endEffect() {
        System.out.println("완성..완성..");
    }
}
