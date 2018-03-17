package com.idouble.loginactivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button  mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        mButton = (Button)findViewById (R.id.bt_login);

        MyListener();
    }

    public void  MyListener() {
         OnClick onClick = new OnClick();
         mButton.setOnClickListener (onClick);

    }

     class OnClick implements View.OnClickListener {
         @Override
         public void onClick(View v) {
             switch (v.getId ()){
                 case R.id.bt_login:
                     final AlertDialog.Builder builder = new AlertDialog.Builder (MainActivity.this);
                     LayoutInflater inflater = LayoutInflater.from (MainActivity.this);
                     final View view = inflater.inflate (R.layout.activity_login,null,false);
                     EditText username = (EditText)view.findViewById (R.id.et_username);
                     EditText password = (EditText)view.findViewById (R.id.et_password);
                     final Button Login = (Button)view.findViewById (R.id.ib_login);
                     Button Cancel = (Button)view.findViewById (R.id.ib_cancel);
                     Login.setOnClickListener (new View.OnClickListener () {
                         @Override
                         public void onClick(View v) {
                             Toast.makeText (MainActivity.this,"Login",Toast.LENGTH_SHORT).show ();
                         }
                     });
                     Cancel.setOnClickListener (new View.OnClickListener () {
                         @Override
                         public void onClick(View v) {
                             Toast.makeText (MainActivity.this,"Resgist",Toast.LENGTH_SHORT).show ();
                         }
                     });
                     builder.setTitle ("登录").setView (view).show ();
                     break;
             }
         }
     }
}
