package pl.kosinski.task;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kosinski.request.RequestRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskCrudAdapter implements TaskCrudService{

    TaskRepository taskRepository;
    RequestRepository requestRepository;

    @Override
    public TaskInfoDto createTask(Long requestId) {
        TaskInfoDto taskInfoDto = new TaskInfoDto();
        taskInfoDto.setRequest(requestRepository.getById(requestId));
        return taskInfoDto;
    }

    @Override
    public TaskInfoDto saveTask(TaskInfoDto taskInfoDto) {
        Task task = new Task();
        if (taskInfoDto.getId() != null) {
            task = getById(taskInfoDto.getId());
            task.setTaskInfo(taskInfoDto.getRequest(), taskInfoDto.getUnit(),taskInfoDto.getStatus(), taskInfoDto.getDescription());
            taskRepository.save(task);
        } else {
            task.setTaskInfo(taskInfoDto.getRequest(), taskInfoDto.getUnit(), taskInfoDto.getStatus(), taskInfoDto.getDescription());
            taskRepository.save(task);
        }
        taskInfoDto.setId(task.getId());
        return taskInfoDto;
    }

    private Task getById(long id) {
        return taskRepository.getById(id);
    }

    @Override
    public TaskInfoDto findTaskById(Long id) {
        return translateToDto(getById(id));
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<TaskInfoDto> findAllTasks() {
        List<TaskInfoDto> infoDtoList = new ArrayList<>();
        List<Task> taskList = taskRepository.findAll();
        for (Task t : taskList) {
            infoDtoList.add(translateToDto(t));
        }
        return infoDtoList;
    }

    private TaskInfoDto translateToDto(Task task) {
        TaskInfoDto infoDto = new TaskInfoDto();
        infoDto.setId(task.getId());
        infoDto.setRequest(task.getRequest());
        infoDto.setUnit(task.getUnit());
        infoDto.setStatus(task.getStatus());
        infoDto.setDescription(task.getDescription());
        return infoDto;
    }

}
