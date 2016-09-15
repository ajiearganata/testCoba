package id.telkomuniversity.tika.mymovie;

import android.os.Bundle;
import android.support.annotation.BinderThread;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import id.telkomuniversity.tika.mymovie.adapter.AdapterMovie;

public class MainActivity extends AppCompatActivity implements AdapterMovie.AdapterListener {

    @Bind(R.id.rec)
    RecyclerView rec;

    private LinearLayoutManager linearLayoutManager;
    private AdapterMovie adapterMovie;
    private List<String> mdata=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mdata.add("Meraih Mimpi");
        mdata.add("Natural");
        mdata.add("LDR");


        linearLayoutManager = new LinearLayoutManager(this);
        adapterMovie = new AdapterMovie(mdata,this);
        rec.setAdapter(adapterMovie);
        rec.setLayoutManager(linearLayoutManager);
        adapterMovie.notifyDataSetChanged();
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
    public void onClick(String item, int position) {

    }
}
