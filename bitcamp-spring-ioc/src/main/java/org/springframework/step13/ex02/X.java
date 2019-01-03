package org.springframework.step13.ex02;

import org.springframework.stereotype.Component;

@Component
public class X {
    public X() {
        System.out.println("X 객체 생성됨");
    }
    
    public void m() {
        System.out.println("X.m() 호출");
    }
}
