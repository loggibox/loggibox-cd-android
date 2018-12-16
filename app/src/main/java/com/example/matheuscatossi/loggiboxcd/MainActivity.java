package com.example.matheuscatossi.loggiboxcd;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.matheuscatossi.loggiboxcd.adapter.PackageCustomAdapter;
import com.example.matheuscatossi.loggiboxcd.model.Package;
import com.example.matheuscatossi.loggiboxcd.model.ResultPackage;
import com.example.matheuscatossi.loggiboxcd.webservice.APIClient;
import com.example.matheuscatossi.loggiboxcd.webservice.APIInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Package> listPackage;
    private RecyclerView recyclerView;

    private ArrayList<Package> packages;
    private APIInterface apiService;

    private Call<ResultPackage> callPackage;

    private ProgressDialog progress;

    private void updateList() {
        apiService = APIClient.getService().create(APIInterface.class);
        progress = ProgressDialog.show(MainActivity.this, "Carregando", "Buscando informações...", true);
        callPackage = apiService.getAllPackages();

        Log.i("Request in API", "" + callPackage.request().url().toString());

        recyclerView = (RecyclerView) findViewById(R.id.list_package);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);

        listPackage = new ArrayList<>();

        callPackage.enqueue(new Callback<ResultPackage>() {
            public void onResponse(Call<ResultPackage> call, Response<ResultPackage> response) {
                if (response.raw().code() == 200) {

                    Log.i("Return Request", "Success");

                    ArrayList<Package> listPackage = response.body().getResult();

                    Log.i("Size", "" + listPackage.size());

                    for (Package packageObject : listPackage) {
                        listPackage.add(
                                new Package(
                                        packageObject.getId(),
                                        packageObject.getWeight(),
                                        packageObject.getDeadline(),
                                        packageObject.getDeadline_days(),
                                        packageObject.getDelivery_address(),
                                        packageObject.getDocument_deliveryman(),
                                        packageObject.getName_deliveryman(),
                                        packageObject.getId_user(),
                                        packageObject.getUser(),
                                        packageObject.getRoute_start(),
                                        packageObject.getRoute_end(),
                                        packageObject.isDelivered(),
                                        packageObject.isDelivering(),
                                        packageObject.isDistribution_center()));
                    }


                    PackageCustomAdapter rankingCustomAdapter;
                    rankingCustomAdapter = new PackageCustomAdapter(MainActivity.this, listPackage);

                    recyclerView.setAdapter(rankingCustomAdapter);


                    progress.dismiss();
                }
            }

            public void onFailure(Call<ResultPackage> call, Throwable t) {
                Log.e("ERROR in GetAllBidding", t.toString());
                progress.dismiss();
            }
        });
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                addPackage();
            }
        });


        updateList();

        Button btn_update = findViewById(R.id.btn_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateList();
            }
        });


//        listPackage.add(new Package("2kg", "2 dias", "Rua Fernandezz Palero", "Rua Fernandezz Palero", "1", "45084552802", "Matheus Catossi,"));
//        listPackage.add(new Package("3kg", "3 dias", "Rua Joao Juapira", "Rua Cesario Lange", "2","45084552802", "Matheus Catossi"));
//        listPackage.add(new Package("4.5kg", "4 dias", "Rua Cesario Lange", "Rua Ronaldo Cristiano", "3","45084552802", "Matheus Catossi"));
//        listPackage.add(new Package("3kg", "1 dia", "Av. Joao Do Carmo", "Av. Joao Do Carmo", "4","45084552802", "Matheus Catossi"));
//        listPackage.add(new Package("2.7kg", "3 dias", "Rua Joaquim Campos", "Rua Messi", "5","45084552802", "Matheus Catossi"));


    }

    public void addPackage(){
        Dialog dialog = new Dialog(this, R.style.AppTheme);
        dialog.setContentView(R.layout.popup);
        dialog.show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

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
}
