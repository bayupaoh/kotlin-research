package me.bayupaoh.belajarkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)

        val userList = ArrayList<User>()

        userList.add(User("Bayu","Jl. Dipatiukur","http://images2.fanpop.com/images/photos/7900000/John-Doe-john-doe-7968986-291-291.jpg"))
        userList.add(User("Bayu","Jl. Dipatiukur","http://images2.fanpop.com/images/photos/7900000/John-Doe-john-doe-7968986-291-291.jpg"))
        userList.add(User("Bayu","Jl. Dipatiukur","http://images2.fanpop.com/images/photos/7900000/John-Doe-john-doe-7968986-291-291.jpg"))
        userList.add(User("Bayu","Jl. Dipatiukur","http://images2.fanpop.com/images/photos/7900000/John-Doe-john-doe-7968986-291-291.jpg"))
        userList.add(User("Bayu","Jl. Dipatiukur","http://images2.fanpop.com/images/photos/7900000/John-Doe-john-doe-7968986-291-291.jpg"))
        userList.add(User("Bayu","Jl. Dipatiukur","http://images2.fanpop.com/images/photos/7900000/John-Doe-john-doe-7968986-291-291.jpg"))

        val adapter = CustomAdapter(userList)
        recyclerView.adapter = adapter
    }
}
