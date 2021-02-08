package com.cifpfbmoll.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private LinkedList<String> mobileArray;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        mobileArray = new LinkedList<>();
        String[] mobiles = getResources().getStringArray(R.array.mobiles);
        for (int i = 0; i <mobiles.length ; i++) {
            mobileArray.add(mobiles[i]);
        }
        this.adapter = new RecycleAdapter(this, mobileArray);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void addToList(View v){
        mobileArray.add("Position: "+adapter.getItemCount());
        recyclerView.smoothScrollToPosition(adapter.getItemCount());
        adapter.notifyDataSetChanged();
    }
}
