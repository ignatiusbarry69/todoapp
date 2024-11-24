package com.dicoding.todoapp.ui.detail

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dicoding.todoapp.R
import com.dicoding.todoapp.ui.ViewModelFactory
import com.dicoding.todoapp.ui.list.TaskActivity
import com.dicoding.todoapp.ui.list.TaskViewModel
import com.dicoding.todoapp.utils.TASK_ID

class DetailTaskActivity : AppCompatActivity() {
    private lateinit var detailTaskViewModel: DetailTaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)

        //TODO 11 : Show detail task and implement delete action
        val factory = ViewModelFactory.getInstance(this)
        detailTaskViewModel = ViewModelProvider(this, factory).get(DetailTaskViewModel::class.java)
        detailTaskViewModel.setTaskId(intent.getIntExtra(TASK_ID, 0))
        detailTaskViewModel.task.observe(this) { task ->
            if (task != null) {
                findViewById<TextView>(R.id.detail_ed_title).text = task.title
                findViewById<TextView>(R.id.detail_ed_description).text = task.description
            }
        }
        findViewById<Button>(R.id.btn_delete_task).setOnClickListener{
            detailTaskViewModel.deleteTask()
            val taskActivity = Intent(this, TaskActivity::class.java)
            startActivity(taskActivity)
        }
    }
}