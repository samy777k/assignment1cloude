package com.example.cloude_l1

import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_person_list.*

class PersonList : AppCompatActivity() {
    val db = Firebase.firestore
    lateinit var adapter : PersonAdapter
    lateinit var data: ArrayList<person>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_list)

        data = ArrayList<person> ()
//        Toast.makeText(this , "{${data[0]}}" , Toast.LENGTH_SHORT).show()
        getUser()


        adapter = PersonAdapter(this, data)
//        data.add(person("1","samy","dsds"))
        list.adapter = adapter
//        adapter.notifyDataSetChanged()

Toast.makeText(this , "{${data.toString()}}" , Toast.LENGTH_SHORT).show()
    }
    fun getUser() {

        db.collection("persons2")
            .get()
            .addOnSuccessListener(OnSuccessListener { documentSnapshots ->

                if (documentSnapshots.isEmpty) {
                   Toast.makeText(this , "empty" , Toast.LENGTH_SHORT).show()
                    return@OnSuccessListener
                } else {

                    for (documentSnapshot in documentSnapshots) {
                        if (documentSnapshot.exists()) {

                            data.add(person(documentSnapshot.getString("id").toString() ,
                                documentSnapshot.getString("name").toString(),
                                documentSnapshot.getString("address").toString()

                            ))

                            adapter.notifyDataSetChanged()
//                            Toast.makeText(this , data.toString() , Toast.LENGTH_SHORT).show()
//                            adapter.notifyDataSetChanged()
                        }
                    }
                }
            }).addOnFailureListener { Toast.makeText(this , "erorr" , Toast.LENGTH_SHORT).show() }
    }
}