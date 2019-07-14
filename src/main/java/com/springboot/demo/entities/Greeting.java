package com.springboot.demo.entities;

import java.util.Objects;

public class Greeting {

    private String greeting;

    public Greeting() {}

    public Greeting(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Greeting greeting1 = (Greeting) o;
        return Objects.equals(greeting, greeting1.greeting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(greeting);
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "greeting='" + greeting + '\'' +
                '}';
    }
}
