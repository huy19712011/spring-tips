package dev.cat;

import dev.cat.utils.DateTimeParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    @Test
    void shouldFindOverlap() {

        Task task = new Task(
                "Make lunch",
                "2025-02-01 12:00", "2025-02-01 12:30");

        LocalDateTime newStart = DateTimeParser.parseToLocalDateTime("2025-02-01 11:00");
        LocalDateTime newEnd = DateTimeParser.parseToLocalDateTime("2025-02-01 12:15");

        assertTrue(taskService.isOverlap(newStart, newEnd, task));

    }


    @Test
    void shouldSaveTask() {
        Task task = new Task(
                "Make lunch",
                "2025-02-01 12:00", "2025-02-01 12:30");

        int val = taskService.createTask(task);
        assertEquals(1, val);

    }

    @Test
    void shouldNotSaveTaskIfOverlap() {

        Task task = new Task(
                "Make lunch",
                "2025-02-01 13:00", "2025-02-01 14:30");

        int val = taskService.createTask(task);
        assertEquals(-1, val);

    }

    @Test
    public void testThatDoesNothing() {

        // Create a mock object
        TaskService mockService = mock(TaskService.class);

        // Set up a method to do nothing when called
        doNothing().when(mockService).deleteTask(1L);

        // Call the method
        mockService.deleteTask(1L);

        // Verify that the method was called
        verify(mockService.deleteTask(1L));
    }

}