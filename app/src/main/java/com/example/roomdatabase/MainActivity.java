package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText name,age;
    TextView textView;
    RoomDatabase roomDatabase;
    Humandatabase hd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.edit1);
        age=findViewById(R.id.edit2);
        textView=findViewById(R.id.text1);
        hd= Room.databaseBuilder(this,Humandatabase.class,"mydb").allowMainThreadQueries().build();
    }

    public void save(View view) {
        String n=name.getText().toString();
        int a=Integer.parseInt(age.getText().toString());
        Human human=new Human(n,a);
        hd.humanDao().insert(human);
        Toast.makeText(this, "insertion succesfull", Toast.LENGTH_SHORT).show();
    }

    public void retrive(View view) {
        List<Human> list=hd.humanDao().getAll();
        textView.setText("");
        for (int i=0;i<list.size();i++){
            textView.append("Id"+list.get(i).getPersonid()+"\n");
            textView.append("NAme:"+list.get(i).getName()+"\n");
            textView.append("NAme:"+list.get(i).getAge()+"\n");
        }
    }
}