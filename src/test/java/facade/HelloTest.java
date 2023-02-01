package facade;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloTest {
    Hello hello;

    @BeforeEach
    void setUp() {
        hello = new Hello();
    }

    @AfterEach
    void tearDown() {
    }

    //REQUIREMENT 1
    //Write a method greet(name) that interpolates name in a simple greeting.
    //For example, when name is "Bob", the method should return a string "Hello, Bob.".
    @Test
    public void testHello() {
        System.out.println("Method to say hello");
        String actual = (String) hello.sayHello("Felicia");
        String expected = "Hello Felicia";
        assertEquals(expected, actual);
    }

    //REQUIREMENT 2
    //Handle nulls by introducing a stand-in.
    //For example, when name is null, then the method should return the string "Hello, my friend."
    @Test
    public void testNameNull() {
        System.out.println("Method to test if name is null");
        String actual = (String) hello.sayHello(null);
        String expected = "Hello, my friend";
        assertEquals(expected, actual);
    }

    //REQUIREMENT 3
    //Handle shouting. When name is all uppercase, then the method should shout back to the user.
    //For example, when name is "JERRY" then the method should return the string "HELLO JERRY!"
    @Test
    public void testNameIsUppercase() {
        System.out.println("Method to test if name is all uppercase");
        String actual = (String) hello.sayHello("FELICIA");
        String expected = "HELLO FELICIA!";
        assertEquals(expected, actual);
    }

    //REQUIREMENT 4
    //Handle two names of input. When name is an array of two names (or, in languages that support it, varargs or a splat), then both names should be printed.
    //For example, when name is ["Jill", "Jane"], then the method should return the string "Hello, Jill and Jane."
    @Test
    public void testTwoNamesOfInput() {
        System.out.println("Method to test two names of input");
        String[] names = new String[]{"Jill", "Jane"};
        String actual = (String) hello.sayHello(names);
        String expected = "Hello, Jill and Jane";
        assertEquals(expected, actual);
    }

//    //REQUIREMENT 5
//    //Handle an arbitrary number of names as input. When name represents more than two names, separate them with commas and close with an Oxford comma and "and". For example, when name is ["Amy", "Brian", "Charlotte"], then the method should return the string "Hello, Amy, Brian, and Charlotte."
//    @Test
//    public void testArtibraryNumberOfNames() {
//        System.out.println("Method to arbitrary number of names as input");
//        String[] names = new String[]{"Amy", "Brian", "Charlotte"};
//        String actual = (String) hello.sayHello(names);
//        String expected = "Hello, Amy, Brian, and Charlotte.";
//        assertEquals(expected, actual);
//    }


    //REQUIREMENT 6
    //Allow mixing of normal and shouted names by separating the response into two greetings. For example, when name is ["Amy", "BRIAN", "Charlotte"], then the method should return the string "Hello, Amy and Charlotte. AND HELLO BRIAN!"

    //REQUIREMENT 7
    //If any entries in name are a string containing a comma, split it as its own input. For example, when name is ["Bob", "Charlie, Dianne"], then the method should return the string "Hello, Bob, Charlie, and Dianne.".

    //REQUIREMENT 8
    //Allow the input to escape intentional commas introduced by Requirement 7. These can be escaped in the same manner that CSV is, with double quotes surrounding the entry. For example, when name is ["Bob", "\"Charlie, Dianne\""], then the method should return the string "Hello, Bob and Charlie, Dianne.".
}