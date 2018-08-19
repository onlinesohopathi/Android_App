package com.example.awsaf.onlinesohopathi.Activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.awsaf.onlinesohopathi.Adapter.CustomAdapter;
import com.example.awsaf.onlinesohopathi.Model.Response;
import com.example.awsaf.onlinesohopathi.R;
import com.example.awsaf.onlinesohopathi.Rest.ApiClient;
import com.example.awsaf.onlinesohopathi.Rest.ApiInterface;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    MenuItem cameramenu;

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;


    public static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        askPermissions();

//        final TextView txt = findViewById(R.id.text_name);
//        txt.setText("");
        ///Bottom Navigation Bar Codes:
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


//        myOnClickListener = new MyOnClickListener(this);

        recyclerView = findViewById(R.id.my_recycler_view);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

//        removedItems = new ArrayList<Integer>();



        final ProgressDialog mprogressDialog;
        mprogressDialog = new ProgressDialog(MainActivity.this);
        mprogressDialog.setCancelable(false);
        mprogressDialog.setMessage("Loading...");
        mprogressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mprogressDialog.show();

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<List<Response>> call = apiService.getQuestions();
        call.enqueue(new Callback<List<Response>>() {

            @Override
            public void onResponse(Call<List<Response>> call, retrofit2.Response<List<Response>> response) {

                adapter = new CustomAdapter(response.body() , MainActivity.this);
                recyclerView.setAdapter(adapter);

//                Toast.makeText(MainActivity.this, "Posted request done", Toast.LENGTH_SHORT).show();

//                for(int j = 0 ; j < response.body().size() ; j++){
//                    List<Answer> answers = response.body().get(j).getAnswers();
//
//                    for (int i=0 ; i< answers.size() ; i++){
//                        txt.setText(txt.getText() +"\n--"+j+">---\n" + answers.get(i).getString());
//
//                    }
//                }

                if (mprogressDialog.isShowing())
                    mprogressDialog.dismiss();

            }

            @Override
            public void onFailure(Call<List<Response>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Could Not get Nearby Bikes", Toast.LENGTH_SHORT).show();
                if (mprogressDialog.isShowing())
                    mprogressDialog.dismiss();
            }

        });


    }

    void askPermissions(){
        Dexter.withActivity(this).withPermissions(
                Manifest.permission.INTERNET)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if(report.areAllPermissionsGranted()){
                            //Intent intent = new Intent(MapActivity2.this, MapActivity2.class);
                            //startActivity(intent);
                            //finish();

                        }
                        else{
                            Toast.makeText(MainActivity.this, "We need these permissions...", Toast.LENGTH_SHORT).show();
                            askPermissions();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.actionbar_buttons, menu);

        cameramenu = menu.findItem(R.id.button_camera);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        //noinspection SimplifiableIfStatement
        switch (item.getItemId())
        {
            case R.id.button_camera: {
                Intent intentCamera = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intentCamera);

                break;

            }



        }



        return super.onOptionsItemSelected(item);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //TODO: GO TO HOME ACTIVITY;
                    return true;
                case R.id.navigation_medication:
                    //TODO: GO TO QUESTION ACTIVITY;
//                    Intent medicineIntent = new Intent(MainActivity.this, QuestionActivity.class);
//                    startActivity(medicineIntent);
//                    finish();
                    return true;
                case R.id.navigation_profile:
                    //TODO: GO TO PROFILE ACTIVITY;
//                    Intent profileIntent = new Intent(MainActivity.this, ProfileActivity.class);
//                    startActivity(profileIntent);
//                    finish();
                    return true;
            }
            return false;
        }

    };

    private static class MyOnClickListener implements View.OnClickListener {

        private final Context context;

        private MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            removeItem(v);
        }

        private void removeItem(View v) {
            Toast.makeText(context, "Remove item called", Toast.LENGTH_SHORT).show();
//            int selectedItemPosition = recyclerView.getChildPosition(v);
//            RecyclerView.ViewHolder viewHolder
//                    = recyclerView.findViewHolderForPosition(selectedItemPosition);
//            TextView textViewName
//                    = (TextView) viewHolder.itemView.findViewById(R.id.textViewName);
//            String selectedName = (String) textViewName.getText();
//            int selectedItemId = -1;
//            for (int i = 0; i < MyData.nameArray.length; i++) {
//                if (selectedName.equals(MyData.nameArray[i])) {
//                    selectedItemId = MyData.id_[i];
//                }
//            }
//            removedItems.add(selectedItemId);
//            data.remove(selectedItemPosition);
//            adapter.notifyItemRemoved(selectedItemPosition);
        }
    }

}
