package pl.kosinski.task;

import org.springframework.stereotype.Service;
import pl.kosinski.unit.UnitListDto;

import java.util.List;

@Service
public interface TaskCrudService {

    TaskInfoDto createTask(Long requestId);

    TaskInfoDto saveTask(TaskInfoDto taskInfoDto);

    void assignUnit(long taskId, UnitListDto unitListDto);

    void unassignunit(long taskId);

    TaskInfoDto findTaskById(Long id);

    void deleteTask(Long id);

    List<TaskInfoDto> findAllTasks();

}
