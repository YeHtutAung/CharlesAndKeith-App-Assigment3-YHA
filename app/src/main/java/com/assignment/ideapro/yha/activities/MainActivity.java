package com.assignment.ideapro.yha.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.assignment.ideapro.yha.R;
import com.assignment.ideapro.yha.adapters.NewProductAdapter;
import com.assignment.ideapro.yha.data.vos.NewProductVO;
import com.assignment.ideapro.yha.delegates.INewProductDelegate;

public class MainActivity extends AppCompatActivity implements INewProductDelegate{

    private NewProductAdapter mNewProductAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvNewProduct = findViewById(R.id.rv_new_product);
        mNewProductAdapter = new NewProductAdapter(this);
        rvNewProduct.setAdapter(mNewProductAdapter);
        rvNewProduct.setLayoutManager(new GridLayoutManager(this, 2));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTapImage(NewProductVO talk) {
        Intent intent = new Intent(getApplicationContext(), NewProductDetailsActivity.class);
        startActivity(intent);
    }
}
