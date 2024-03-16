package com.spring.qualifiers;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class BarFormatter implements Formatter {

    public String format() {
        return "bar";
    }
}
