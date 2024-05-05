package TASK5.service;

import TASK5.entity.Todo;
import TASK5.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> create(Todo todo){
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> list(){
        Sort sort = Sort.by(Sort.Direction.DESC, "prioridade")
                .and(Sort.by(Sort.Direction.ASC, "id"));
        return todoRepository.findAll(sort);
    }

    public List<Todo> update(Todo todo){
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> delete(Long id){
        todoRepository.deleteById(id);
        return list();
    }
 }
