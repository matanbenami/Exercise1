package com.example.matanbex.chatmyself;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private static final String LIST = "list";

    private ArrayList<String> messagesList = new ArrayList<String>();;
    private RecyclerView rv;
    private RVAdapter adapter;
    private EditText message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null){
            messagesList = savedInstanceState.getStringArrayList(LIST);
        }
        message = (EditText) findViewById(R.id.editText);
        rv = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new RVAdapter(MainActivity.this, messagesList);
        RecyclerView.LayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);
        message.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND){
                    String str = message.getText().toString();
                    message.setText(null);
                    if (str.equals("")){
                        Toast.makeText(getApplicationContext(), "Can't send an empty message.", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        messagesList.add(str);
                    }

                }
                return false;
            }

        });

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList(LIST, messagesList);
    }



}
