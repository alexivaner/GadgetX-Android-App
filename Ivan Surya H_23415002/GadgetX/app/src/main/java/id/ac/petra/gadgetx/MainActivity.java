package id.ac.petra.gadgetx;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    SwipeRefreshLayout swipe;
    RecyclerView.LayoutManager mManager;
    RequestQueue mRequest;
    List<ModelList> mListItems;
    Toolbar toolbar;
    private AlertDialog.Builder alertDialogBuilder;
    private AlertDialog dialog;
    String ip= "192.168.43.17";
    private final String url_brand = "http://"+ip+"/load_data_search.php?memory=";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerTemp);
        mRequest = Volley.newRequestQueue(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showInputDialog();

            }
        });

         final String search = "";
         final String search2 ="";

        mListItems = new ArrayList<>();


        swipe = findViewById(R.id.swipe_refresh_layout);

        swipe.setOnRefreshListener(this);
        swipe.post(new Runnable() {
                       @Override
                       public void run() {
                           swipe.setRefreshing(true);
                           getSmartphone(search,search2);


                       }
                   }
        );
        mManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(mManager);
        mAdapter = new AdapterList(mListItems,MainActivity.this);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

    }


    public List<ModelList> getSmartphone(String searchTerm, String searchTerm2)    {
        JsonArrayRequest requestImage = new JsonArrayRequest(Request.Method.GET, url_brand+searchTerm2, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("JSONResponse",response.toString());
                        for(int i=0; i< response.length(); i++){
                            try {
                                JSONObject data = response.getJSONObject(i);
                                ModelList model = new ModelList();
                                model.setId(data.getString("ID"));
                                model.setName(data.getString("NAME"));
                                model.setStatus(data.getString("STATUS"));
                                model.setNetwork(data.getString("NETWORK"));
                                model.setImg(data.getString("IMAGE"));
                                model.setDim(data.getString("DIMENSION"));
                                model.setDisty(data.getString("DISPLAY_TYPE"));
                                model.setDisz(data.getString("DISPLAY_SIZE"));
                                model.setCpu(data.getString("CPU"));
                                model.setOs(data.getString("OS"));
                                model.setMemory(data.getString("MEMORY"));
                                model.setCamera(data.getString("CAMERA"));
                                model.setBattery(data.getString("BATTERY"));
                                model.setBrand(data.getString("BRAND"));

                                mListItems.add(model);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            mAdapter.notifyDataSetChanged();
                            swipe.setRefreshing(false);

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("ERRORRequest","Error:"+error.getMessage());
                    }
                });
        mRequest.add(requestImage);
        return mListItems;
    }



    @Override
    public void onRefresh() {
        new SendMsg().execute("User melakukan refresh");
        String search = "";
        String search2="";
        mListItems.clear();
        getSmartphone(search,search2);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.new_search) {
            showInputDialog();
            // return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void showInputDialog() {

        alertDialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.toolbar_layout, null);
        final EditText newSearchEdt = (EditText) view.findViewById(R.id.searchEdt);
        final EditText newSearchEdt2 = (EditText) view.findViewById(R.id.searchEdt2);
        Button submitButton = (Button) view.findViewById(R.id.submitButton);


        alertDialogBuilder.setView(view);
        dialog = alertDialogBuilder.create();
        dialog.show();
        final String[] search = new String[1];
        final String[] search2 = new String[1];
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!newSearchEdt.getText().toString().isEmpty()) {
                    search[0] = newSearchEdt.getText().toString();
                }
                if (!newSearchEdt2.getText().toString().isEmpty()) {
                    search2[0] = newSearchEdt2.getText().toString();
                }


                mListItems.clear();
                getSmartphone(search[0], search2[0]);
                new SendMsg().execute("User melakukan search dengan search value "+search2[0]+"GB");

                dialog.dismiss();


            }
        });
    }

    static class SendMsg extends AsyncTask<String,Void,Void> {

        @Override
        protected Void doInBackground(String... arg0) {
            UDPClient c = new UDPClient();
            c.sendPacket(arg0[0]);
            SystemClock.sleep(200);
            return null;
        }
    }

    class ReceiveMsg extends AsyncTask<String,Void,Void> {

        @Override
        protected Void doInBackground(String... arg0) {
            UDPClient d = new UDPClient();
            d.receivePacket(arg0[0]);
            SystemClock.sleep(200);
            return null;
        }
    }

}
