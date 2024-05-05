package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Fail.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit test for HelloApp.
 * <p/>
 * A unit test aims to test all code and code paths of a specific class.
 * <p/>
 * This test uses PowerMock and Mockito to mock objects.
 */
@PrepareForTest({System.class, HelloApp.class})
public class HelloAppTest {

    @Test
    public void testMain() {
        String[] args = {"1"};
        HelloApp.main(args);
    }

    @Test
    public void testWrongArgument() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream errorStream = new PrintStream(outContent);

        HelloApp app = new HelloApp();
        String[] args = {"bicycle"};
        int exitCode = app.processArguments(args, errorStream);

        assertEquals(HelloApp.EXIT_STATUS_PARAMETER_NOT_UNDERSTOOD, exitCode);
    }


    @Test
    public void testHelloError() {
        Hello hello = new Hello();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        assertThrows(IllegalArgumentException.class, () -> {
            hello.setTimes(21);
            hello.sayHello(new PrintStream(outputStream));
        });}

    @Test
    public void testDefaultArgument() {
        // Passing no arguments should work.
        String[] args = {};
        HelloApp.main(args);
    }

    @Test
    public void classInstanceForCodeCoverageTest() {
        // Strictly speaking this test doesn't achieve anything, because HelloApp contains only a single static
        // method, but for purposes of full code coverage it is included. In general,
        // it is easier to aim for full code coverage and be done with it, than to remember why class X is stuck at
        // 95% code coverage.
        new HelloApp();
    }
}
