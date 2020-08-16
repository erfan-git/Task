package com.example.task.Repository;

import com.example.task.model.Task;

import java.util.List;
import java.util.UUID;

public interface IRepository<E> {
    List<E> getTask();
    E getTask(UUID uuid);
    void update(E e);
    void delete(E e);
    void add(E e);
    void insert(E e);
    void insertList(List<E> list);
    int getPosition(UUID uuid);
}