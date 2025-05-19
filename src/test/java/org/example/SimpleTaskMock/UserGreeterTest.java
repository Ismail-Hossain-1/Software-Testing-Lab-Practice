package org.example.SimpleTaskMock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static  org.mockito.Mockito.*;
import org.mockito.*;
import org.mockito.exceptions.base.MockitoException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class UserGreeterTest {

    @Mock
    TimeService mockTimeSimeService;

    @InjectMocks
    UserGreeter userGreeter;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testGenerateWelcomeMessage() {
       Mockito.when(mockTimeSimeService.getCurrentPeriod()).thenReturn("Morning");
       assertEquals("Good Morning Ismail! Welcome.", userGreeter.generateWelcomeMessage("Ismail"));
       verify(mockTimeSimeService).getCurrentPeriod();
    }


}