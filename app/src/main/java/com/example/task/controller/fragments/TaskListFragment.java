package com.example.task.controller.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.task.R;
import com.example.task.Repository.TaskRepository;
import com.example.task.model.Task;

import java.util.List;


public class TaskListFragment extends Fragment {
    private RecyclerView mRecyclerView;

    public TaskListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);
        findViews(view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        initUI();

        return view;
    }

    private void initUI() {
        TaskRepository repository = TaskRepository.getInstance();
        List<Task> tasks = repository.getTasks();
        TaskAdapter adapter = new TaskAdapter(tasks);
        mRecyclerView.setAdapter(adapter);
    }

    private void findViews(View view) {
        mRecyclerView = view.findViewById(R.id.recycle_view_tasks);
    }

    private class TaskHolder extends RecyclerView.ViewHolder {
        private TextView mTextViewTitle;
        private TextView mTextViewState;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);

            mTextViewTitle = itemView.findViewById(R.id.list_row_task_title);
            mTextViewState = itemView.findViewById(R.id.list_row_task_state);
        }

        public void bindTask(Task task) {
            mTextViewTitle.setText(task.getName());
            mTextViewTitle.setText(task.getState().toString());
        }
    }

    private class TaskAdapter extends RecyclerView.Adapter<TaskHolder> {
        private List<Task> mTasks;

        public TaskAdapter(List<Task> tasks) {
            mTasks = tasks;
        }

        public List<Task> getTasks() {
            return mTasks;
        }

        public void setTasks(List<Task> tasks) {
            mTasks = tasks;
        }

        @NonNull
        @Override
        public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.list_row_task, parent, false);
            TaskHolder taskHolder = new TaskHolder(view);
            return taskHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
            Task task = mTasks.get(position);
            holder.bindTask(task);
        }

        @Override
        public int getItemCount() {
            return mTasks.size();
        }
    }
}