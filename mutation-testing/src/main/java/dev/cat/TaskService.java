package dev.cat;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TaskService {


    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public boolean isOverlap(LocalDateTime newStart,
                             LocalDateTime newEnd, Task task) {

        return !(newEnd.isBefore(task.getStart())
                || newStart.isAfter(task.getEnd()));

    }

    protected boolean isFreeSlot(LocalDateTime newStart, LocalDateTime newEnd) {
        return taskRepository.findAll()
                .stream()
                .noneMatch(t -> isOverlap(newStart, newEnd, t));
    }


    public int createTask(Task newTask) {
        if (newTask.getStart().isBefore(newTask.getEnd())
                && isFreeSlot(newTask.getStart(), newTask.getEnd())) {
            taskRepository.save(newTask);
            return 1;
        }
        return -1;
    }

    public boolean deleteTask(long id) {
        taskRepository.deleteById(id);
        if (taskRepository.findById(id).isEmpty()) {
            return true;
        }
        return false;
    }

}
