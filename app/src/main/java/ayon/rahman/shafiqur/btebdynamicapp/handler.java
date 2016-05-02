package ayon.rahman.shafiqur.btebdynamicapp;

import android.app.Activity;
import android.util.Log;

import ayon.rahman.shafiqur.btebdynamicapp.fragment.ListViewFrag;

/**
 * Created by Shafiqur on 1/30/2016.
 */
public class handler extends Activity {


    public static void thisis(String url) {

        if (url.equals("ListView")) {
            ListViewFrag nextfrag = new ListViewFrag();
            //getFragmentManager().beginTransaction().replace(R.id.myMainActivityFrameContainer,nextfrag).addToBackStack(null).commit();
            Log.e("Check", "List View");
        } else if (url.equals("SlideTab")) {
            System.out.print("Slide Tab");
            Log.e("Check", "Slide Tab");
        } else if (url.equals("StaticPage")) {
            System.out.print("Static Page");
            Log.e("Check", "Static Page");
        } else {
            System.out.print("Nothing Found");
            Log.e("Check", "Nothing Found");
        }
    }
}
