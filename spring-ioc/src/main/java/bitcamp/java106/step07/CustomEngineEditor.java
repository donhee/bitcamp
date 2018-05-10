// 프로퍼티 에디터 만들기
package bitcamp.java106.step07;

import java.beans.PropertyEditorSupport;

public class CustomEngineEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] values = text.split(",");
        
        Engine engine = new Engine();
        engine.setMaker(values[0]); // 비트자동차
        engine.setValve(Integer.parseInt(values[1])); // 16
        engine.setCylinder(Integer.parseInt(values[2])); // 4
        
        this.setValue(engine);
    }
    
}
