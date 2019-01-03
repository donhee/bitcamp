package org.springframework.step13.ex02;

import org.springframework.stereotype.Component;

@Component
public class Z {
    public Z() {
        System.out.println("Z 객체 생성됨");
    }
    public void m() {
        System.out.println("Z.m() 호출");
    }
}
