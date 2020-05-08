package io.dolphin.common.annotation;

import java.lang.annotation.*;

/**
 * @author Eric
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

	String value() default "";
}
