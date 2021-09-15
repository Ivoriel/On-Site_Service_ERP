package pl.kosinski.task;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskCrudService {

    TaskInfoDto saveTask(TaskInfoDto taskInfoDto);

    TaskInfoDto findTaskById(Long id);

    void deleteTask(Long id);

    List<TaskInfoDto> findAllTasks();
}
