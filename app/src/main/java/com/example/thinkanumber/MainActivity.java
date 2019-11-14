package com.example.thinkanumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random rand;
    private TextView tipp;
    private ImageView elet1,elet2,elet3,elet4,elet5;
    private AlertDialog alertDialog;
    private AlertDialog.Builder alertDialogBuilder;
    private Button plusz,minusz,kuld;
    private int randomSzam, tippeltSzam, elet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        plusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pluszGomb();
            }
        });

        minusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minuszGomb();
            }
        });

        kuld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kuldesGomb();
            }
        });
    }
    private void kuldesGomb() {
        if (tippeltSzam==randomSzam){
            kuld.setEnabled(false);
            plusz.setEnabled(false);
            minusz.setEnabled(false);
            alertDialogBuilder.setTitle("Gratulálok Nyertél!!");
            alertDialogBuilder.setMessage("Újra akarod kezdeni a játékot?");
            alertDialogBuilder.setPositiveButton("igen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    reStart();
                    eletek();
                }
            });
            alertDialogBuilder.setNegativeButton("nem", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alertDialogBuilder.setCancelable(false);
            alertDialog=alertDialogBuilder.create();
            alertDialog.show();
        }else if(tippeltSzam>randomSzam){
            if(elet>=1){
                elet--;
                eletek();
                Toast.makeText(MainActivity.this, "kisebb", Toast.LENGTH_SHORT).show();
            }else{
                alertDialogBuilder.setTitle("Vesztettél");
                alertDialogBuilder.setMessage("Újra akarod kezdeni a játékot?");
                alertDialogBuilder.setPositiveButton("igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        reStart();
                        eletek();
                    }
                });
                alertDialogBuilder.setNegativeButton("nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                alertDialogBuilder.setCancelable(false);
                alertDialog=alertDialogBuilder.create();
                alertDialog.show();
            }
        }else if(tippeltSzam<randomSzam){
            if(elet>=1){
                elet--;
                eletek();
                Toast.makeText(MainActivity.this, "nagyobb", Toast.LENGTH_SHORT).show();
            }else{
                alertDialogBuilder.setTitle("Vesztettél");
                alertDialogBuilder.setMessage("Újra akarod kezdeni a játékot?");
                alertDialogBuilder.setPositiveButton("igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        reStart();
                        eletek();
                    }
                });
                alertDialogBuilder.setNegativeButton("nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                alertDialogBuilder.setCancelable(false);
                alertDialog=alertDialogBuilder.create();
                alertDialog.show();
            }

        }
    }

    private void minuszGomb(){
        if (tippeltSzam>0){
            tippeltSzam--;
            tipp.setText(tippeltSzam+"");}
        else{
            Toast.makeText(MainActivity.this, "Elérted a minimumot", Toast.LENGTH_SHORT).show();
        }
    }
    private  void pluszGomb(){
        if (tippeltSzam<10){
            tippeltSzam++;
            tipp.setText(tippeltSzam+"");
        }
        else{
            Toast.makeText(MainActivity.this, "Elérted a maximumot", Toast.LENGTH_SHORT).show();
        }
    }
    private  void reStart(){
        randomSzam= rand.nextInt(10);
        elet=5;
        tippeltSzam=0;
        tipp.setText("0");
        kuld.setEnabled(true);
        plusz.setEnabled(true);
        minusz.setEnabled(true);
    }
    private  void  eletek(){
        switch (elet){
            case 5: elet1.setImageResource(R.drawable.heart2);
                elet2.setImageResource(R.drawable.heart2);
                elet3.setImageResource(R.drawable.heart2);
                elet4.setImageResource(R.drawable.heart2);
                elet5.setImageResource(R.drawable.heart2);
                break;
            case 4: elet1.setImageResource(R.drawable.heart1);
                elet2.setImageResource(R.drawable.heart2);
                elet3.setImageResource(R.drawable.heart2);
                elet4.setImageResource(R.drawable.heart2);
                elet5.setImageResource(R.drawable.heart2);
                break;
            case 3: elet1.setImageResource(R.drawable.heart1);
                elet2.setImageResource(R.drawable.heart1);
                elet3.setImageResource(R.drawable.heart2);
                elet4.setImageResource(R.drawable.heart2);
                elet5.setImageResource(R.drawable.heart2);
                break;
            case 2: elet1.setImageResource(R.drawable.heart1);
                elet2.setImageResource(R.drawable.heart1);
                elet3.setImageResource(R.drawable.heart1);
                elet4.setImageResource(R.drawable.heart2);
                elet5.setImageResource(R.drawable.heart2);
                break;
            case 1: elet1.setImageResource(R.drawable.heart1);
                elet2.setImageResource(R.drawable.heart1);
                elet3.setImageResource(R.drawable.heart1);
                elet4.setImageResource(R.drawable.heart1);
                elet5.setImageResource(R.drawable.heart2);
                break;
            case 0: elet1.setImageResource(R.drawable.heart1);
                elet2.setImageResource(R.drawable.heart1);
                elet3.setImageResource(R.drawable.heart1);
                elet4.setImageResource(R.drawable.heart1);
                elet5.setImageResource(R.drawable.heart1);
                break;

        }
    }
    private void init(){
        plusz= findViewById(R.id.plusz);
        minusz= findViewById(R.id.miusz);
        kuld= findViewById(R.id.kuldes);
        rand= new Random();
        elet1= findViewById(R.id.elet1);
        elet2= findViewById(R.id.elet2);
        elet3= findViewById(R.id.elet3);
        elet4= findViewById(R.id.elet4);
        elet5= findViewById(R.id.elet5);
        tipp= findViewById(R.id.megelenit);
        randomSzam= rand.nextInt(10);
        tippeltSzam=0;
        elet=5;
        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

    }
}
