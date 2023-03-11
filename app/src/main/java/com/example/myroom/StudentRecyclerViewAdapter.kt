package com.example.myroom

import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myroom.DB.Student

class StudentRecyclerViewAdapter(
    private val clickListener: (Student)->Unit
):RecyclerView.Adapter<StudentViewHolder>() {
    private val studentList = ArrayList<Student>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item,parent,false)
        return StudentViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(studentList[position],clickListener)
    }

    fun setList(student: List<Student>){
        studentList.clear()
        studentList.addAll(student)
    }

}
class StudentViewHolder(private val view: View):RecyclerView.ViewHolder(view){
    fun bind(student: Student, clickListener: (Student)->Unit){
        val nameText  = view.findViewById<TextView>(R.id.tvName)
        val emailText  = view.findViewById<TextView>(R.id.tvEmail)

        nameText.text = student.name
        emailText.text = student.email

        view.setOnClickListener {
                clickListener(student)
        }
    }
}