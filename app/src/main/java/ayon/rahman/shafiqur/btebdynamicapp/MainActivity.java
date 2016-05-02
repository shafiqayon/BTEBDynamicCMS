package ayon.rahman.shafiqur.btebdynamicapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ayon.rahman.shafiqur.btebdynamicapp.fragment.modelfrag;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ayon.rahman.shafiqur.btebdynamicapp.fragment.modelfrag myfrag = new modelfrag();
        getFragmentManager().beginTransaction().add(R.id.myMainActivityFrameContainer, myfrag).commit();


    }
}
