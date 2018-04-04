// Build을 상속 받아 템플릿 메서드인 startEffect()와 endEffect를 구체화시킨다.
package step15.ex03;

public class Farm extends Building {
    @Override
    public void startEffect() {
        System.out.println("땅을 고른다..");
    }
    
    @Override
    public void endEffect() {
        System.out.println("씨앗을 뿌린다..");
    }
}
