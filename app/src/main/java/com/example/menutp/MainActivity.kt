package com.example.menutp

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.menutp.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener, TimePickerDialog.OnTimeSetListener,
    DatePickerDialog.OnDateSetListener {
    /*------*/
    //COMPOSANTS GRAPHIQUES
    /*------*/
    lateinit var binding: ActivityMainBinding

    val ALERT_DIALOG: Int = 25;
    val TIME_PICKER: Int = 26;
    val DATE_PICKER: Int = 27;

    var calendar = Calendar.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Chargement de l'interface graphique
        binding = ActivityMainBinding.inflate(layoutInflater)

        //Affichage
        setContentView(binding.root)
    }

    /*------*/
    //START
    /*------*/

    override fun onStart() {
        super.onStart()
    }

    /*------*/
    //DESTROY
    /*------*/

    override fun onDestroy() {
        super.onDestroy()
    }

    /*------*/
    //CLICK
    /*------*/

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    /*--------------------------------*/
    // MENU
    /*--------------------------------*/

    /*------*/
    //CREATION
    /*------*/

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(0, ALERT_DIALOG, 0, "Alert dialog")
        menu?.add(0, TIME_PICKER, 0, "Time picker")
        menu?.add(0, DATE_PICKER, 0, "Date picker")
        return super.onCreateOptionsMenu(menu)
    }

    /*------*/
    //MANAGER D'ITEM
    /*------*/
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            ALERT_DIALOG -> alertDialogBuilder().create().show()
            TIME_PICKER -> TimePickerDialog(this, this, 22, 33, true).show()

            DATE_PICKER -> DatePickerDialog(
                this, this,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        return super.onOptionsItemSelected(item)
    }

    /*--------------------------------*/
    // CALLBACK PICKER
    /*--------------------------------*/


    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        Toast.makeText(this, "$p1 h $p2 m", Toast.LENGTH_SHORT).show();
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        Toast.makeText(this, "$p1/$p2/$p3", Toast.LENGTH_SHORT).show();

    }

     fun alertDialogBuilder(): AlertDialog.Builder {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setMessage("Create Toast").setTitle("Mon Titre")
            .setIcon(R.mipmap.ic_launcher)
        alertDialogBuilder.setPositiveButton("ok") { dialog, which ->
            Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
        }
        return alertDialogBuilder
    }

}