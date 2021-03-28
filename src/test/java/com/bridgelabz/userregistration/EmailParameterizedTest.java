package com.bridgelabz.userregistration;


import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.Before;

import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class EmailParameterizedTest {

    private final String emailTest;
    private final boolean expectedResult;



    public EmailParameterizedTest(String emailTest, boolean expectedResult) {
        super();
        this.emailTest = emailTest;
        this.expectedResult = expectedResult;
    }

    @Before
    public void initialize() {
        UserValidationProcess userValidationProcess = new UserValidationProcess();
    }

    @Parameterized.Parameters
    public static Collection <Object[]> input() {
        return Arrays.asList(new Object[][] {
                {"abc@yahoo.com", true},
                {"abc-10@yahoo.com", true},
                {"abc.1010@yahoo.com", true},
                {"abc222@abccom", true},
                {"abc.100@abc.com.au", true},
                {"abc@1.com", true},
                {"abc123@gamil.a", false},
                {"abc123@.com", false},
                {"abc@gmail.com.1a", false},
                {"abc..4004@gamil.com", false},
                {"abc-100@abc.net", true}
        });
    }

    @Test
    public  void givenEmailShouldReturnAsPerParameterizedTest() {
        UserValidationProcess userValidationProcess = new UserValidationProcess();
        System.out.println("valid email result " + expectedResult);
        boolean result = userValidationProcess.validEmail(emailTest);
        assertEquals(expectedResult, result);
    }
}
