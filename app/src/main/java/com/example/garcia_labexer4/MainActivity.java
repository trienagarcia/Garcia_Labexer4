package com.example.garcia_labexer4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    String[] oName, oCountry, oIndustry, oCeo, oMess;
    int[] logo = {R.drawable.icbc, R.drawable.jpmorgan, R.drawable.chinacons, R.drawable.agricultural, R.drawable.bankofamer, R.drawable.apple, R.drawable.pingan, R.drawable.bankofchina, R.drawable.shell, R.drawable.wells, R.drawable.exxon, R.drawable.att, R.drawable.samsung, R.drawable.citi};
    ArrayList<AndroidVersions> versions = new ArrayList<>();
    ListView lstVersions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("TOP GLOBAL COMPANIES");

        oName = getResources().getStringArray(R.array.cName);
        oCountry = getResources().getStringArray(R.array.cCountry);
        oIndustry = getResources().getStringArray(R.array.cIndustry);
        oCeo = getResources().getStringArray(R.array.cCeo);
        oMess = getResources().getStringArray(R.array.cMess);

        for (int i = 0; i < oName.length; i++) {
            versions.add(new AndroidVersions(logo[i], oName[i], oCountry[i], oIndustry[i], oCeo[i]));
        }

        AndroidAdapter adapter = new AndroidAdapter(this, R.layout.item, versions);
        lstVersions = findViewById(R.id.lv);
        lstVersions.setAdapter(adapter);
        lstVersions.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int i, long id) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setIcon(logo[i]);
        dialog.setTitle(oName[i]);
        dialog.setMessage(oMess[i]);
        dialog.setNeutralButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.create().show();
    }
}
