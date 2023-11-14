package com.atees.listroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

   private EditText Name, Email, Type;
   private Button button;
   private  AddViewModel addViewModel;
   private  boolean editMode;

   private  int mID;

   public  static  final  String EXTRA_ID="com.atees.listroom.extraid";
    public  static  final  String EXTRA_NAME="com.atees.listroom.name";
    public  static  final  String EXTRA_EMAil="com.atees.listroom.email";
    public  static  final  String EXTRA_TYPE="com.atees.listroom.type";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Name=findViewById(R.id.editTextName);
        Email=findViewById(R.id.editTextEmail);
        Type=findViewById(R.id.editTextType);
        button=findViewById(R.id.button);

        Intent intent= getIntent();
        if(intent.hasExtra(EXTRA_ID)){
            setTitle("edit_list");
            editMode =true;
            mID =intent.getIntExtra(EXTRA_ID,-1);

        }else {
            setTitle("Add_edit_list");
            editMode =false;
        }

        addViewModel = ViewModelProviders.of(this).get(AddViewModel.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Savedata();
                
            }
        });


    }

    private void Savedata() {

        String name=Name.getText().toString().trim();
        String email=Email.getText().toString().trim();
        String type=Type.getText().toString().trim();

        Words wordobject =new Words(name,email,type);

        if (name.isEmpty()||email.isEmpty()||type.isEmpty()){
            Toast.makeText(this, "please text the fields", Toast.LENGTH_SHORT).show();
            return;
        }
         if (editMode) {
             wordobject.setId(mID);
             addViewModel.update(wordobject);

         }else {
             addViewModel.insert(wordobject);

         }

        finish();
    }
}