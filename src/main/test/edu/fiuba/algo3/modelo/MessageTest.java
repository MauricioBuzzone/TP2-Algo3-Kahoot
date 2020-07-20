package edu.fiuba.algo3.modelo;
import static org.mockito.Mockito.*;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest {
    @Test
    public void messageGreeting() {
        Message message = new Message("Hello world!");

        assertEquals("Hello world!", message.greet());
    }
    @Test
    public void jejeje() {
        // mock creation
        List mockedList = mock(List.class);

        // using mock object - it does not tmvnhrow any "unexpected interaction" exception
        mockedList.add("one");
        mockedList.clear();

        // selective, explicit, highly readable verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }
}