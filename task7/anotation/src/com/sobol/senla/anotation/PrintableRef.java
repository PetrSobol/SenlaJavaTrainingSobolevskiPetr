package com.sobol.senla.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface PrintableRef {
String name();
boolean isDetailedView()default true;
boolean isRecursiv() default false;
int order();
}
