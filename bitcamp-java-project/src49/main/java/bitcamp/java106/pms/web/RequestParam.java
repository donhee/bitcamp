package bitcamp.java106.pms.web;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME) // 파라미터의 이름을 지정하는 애노테이션
public @interface RequestParam {
    String value() default "";
}
