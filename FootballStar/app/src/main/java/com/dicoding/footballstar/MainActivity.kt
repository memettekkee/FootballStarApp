package com.dicoding.footballstar

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvFootballs: RecyclerView
    private val list = ArrayList<Football>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFootballs = findViewById(R.id.rv_football)
        rvFootballs.setHasFixedSize(true)

        list.addAll(getListFootballs())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListFootballs(): ArrayList<Football> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listFootball = ArrayList<Football>()
            for (i in dataName.indices) {
                val footballz = Football(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
                listFootball.add(footballz)
            }
            return listFootball


    }
    private fun showSelectedFootball(football: Football) {
        Toast.makeText(this, "Kamu memilih " + football.name, Toast.LENGTH_SHORT).show()

        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("football_name", football.name)
        intent.putExtra("football_img", football.photo)
        intent.putExtra("football_deskripsi", football.description)
        startActivity(intent)
    }

    private fun showRecyclerList() {
        rvFootballs.layoutManager = LinearLayoutManager(this)
        val listFootballAdapter = ListFootballAdapter(list)
        rvFootballs.adapter = listFootballAdapter

        listFootballAdapter.setOnItemClickCallback(object : ListFootballAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Football) {
                showSelectedFootball(data)
            }
        })
    }
}