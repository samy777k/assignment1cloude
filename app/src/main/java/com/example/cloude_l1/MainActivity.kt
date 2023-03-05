package com.example.cloude_l1

import android.app.ProgressDialog
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    val db = Firebase.firestore


    //  //    companion object {
//        lateinit var data: ArrayList<person>
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // val progres: ProgressDialog


        btnSave.setOnClickListener {
//            progress = ProgressBar(this)
//            progress.setMessage("Loading..................")
//            progresDialog.setCancelable(false)
            progressBar.visibility = View.VISIBLE

            var name = name.text.toString()
            var id = id.text.toString()
            var address = address.text.toString()

            val person = hashMapOf(
                "name" to name,
                "id" to id,
                "address" to address
            )
// Add a new document with a generated ID
            db.collection("persons2")
                .add(person)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(applicationContext , "success" , Toast.LENGTH_SHORT).show()
                    progressBar.visibility = View.GONE
//                Log.e("samy", "DocumentSnapshot added with ID: ${documentReference.id}")

                }
                .addOnFailureListener { e ->
                    Toast.makeText(applicationContext, "Error  ${e}", Toast.LENGTH_SHORT).show();
//                    progresDialog.dismiss()

                }
        }
//        data = ArrayList<person>()
//        data.add(person(1,"samy" , "alremal"))
//        data.add(person(1,"samy" , "alremal"))
//        data.add(person(1,"samy" , "alremal"))
//        data.add(person(1,"samy" , "alremal"))
//        getUser()


        show.setOnClickListener {
            var intent = Intent(this, PersonList::class.java)
            startActivity(intent)
        }
    }


}