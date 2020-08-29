package com.example.task.controller.fragments;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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

    public static TaskListFragment newInstance() {
        
        Bundle args = new Bundle();
        
        TaskListFragment fragment = new TaskListFragment();
        fragment.setArguments(args);
        return fragment;
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
        initUI();
        return view;
    }

    private void initUI() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }else{
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        }
        TaskRepository repository = TaskRepository.getInstance(getActivity());
        List<Task> tasks = repository.getList();
        TaskAdapter adapter = new TaskAdapter(tasks);
        mRecyclerView.setAdapter(adapter);
    }

    private void findViews(View view) {
        mRecyclerView = view.findViewById(R.id.recycle_view_tasks);
    }

    private class TaskHolder extends RecyclerView.ViewHolder {
        private TextView mTextViewTitle;
        private TextView mTextViewState;
private LinearLayout mLayout ;
        public TaskHolder(@NonNull View itemView) {
            super(itemView);

            mTextViewTitle = itemView.findViewById(R.id.list_row_task_title);
            mTextViewState = itemView.findViewById(R.id.list_row_task_state);
            mLayout = itemView.findViewById(R.id.list_row_task);
        }

        public void bindTask(Task task) {
            mTextViewTitle.setText(task.getTitle());
            mTextViewState.setText(task.getState().toString());

            if (getAdapterPosition() %2 != 0){
                mLayout.setBackgroundColor(getResources().getColor(R.color.color_row_green));
            }else {
                mLayout.setBackgroundColor(Color.WHITE);
            }
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

        @Override
        public int getItemCount() {
            return mTasks.size();
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
    }
}