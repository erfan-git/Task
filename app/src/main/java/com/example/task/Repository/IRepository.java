package com.example.task.Repository;

import com.example.task.model.Task;

import java.util.List;
import java.util.UUID;

public interface IRepository<E> {
    List<E> getList();
    E get(UUID uuid);
    void update(E e);
    void delete(E e);
    void insert(E e);
    void insertList(List<E> list);
    int getPosition(UUID uuid);
}
