package com.example.practical17_admissionapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    PopupMenu popupMenu;
    EditText name,phoneno,email,percentage;
    String c_lass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        Button btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Admission Confirmation").setMessage("Are you sure you want to submit the form");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(MainActivity.this,Profile.class);
                        intent.putExtra("name",name.getText().toString());
                        intent.putExtra("phoneno",phoneno.getText().toString());
                        intent.putExtra("email",email.getText().toString());
                        intent.putExtra("percentage",percentage.getText().toString());
                        intent.putExtra("c_class",c_lass);
                        Toast.makeText(MainActivity.this, "Admission successful", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
        popupMenu=new PopupMenu(this,findViewById(R.id.admissiopopup));
        popupMenu.getMenuInflater().inflate(R.menu.popup,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.fe:
                        c_lass="FE";
                        return true;
                    case R.id.se:
                        c_lass="SE";
                        return true;
                    case R.id.te:
                        c_lass="TE";
                        return true;
                    case R.id.be:
                        c_lass="BE";
                        return true;
                    default:
                        return false;
                }
            }
        });

        Button button=findViewById(R.id.admissiopopup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu.show();
            }
        });
    }
    public void init(){
        name=findViewById(R.id.name);
        phoneno=findViewById(R.id.phoneno);
        email=findViewById(R.id.email);
        percentage=findViewById(R.id.percentage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu,menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.about:
                Intent intent=new Intent(MainActivity.this,About.class);
                startActivity(intent);
                break;
            case R.id.home:
                Intent intent1=new Intent(MainActivity.this,Home.class);
                startActivity(intent1);
                break;
            case R.id.register:
                Toast.makeText(this, "You are currently on registration page", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}