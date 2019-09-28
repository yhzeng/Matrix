package com.laioffer.matrix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.util.Log;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements EventFragment.OnItemSelectListener, CommentFragment.OnItemSelectListener {
    private EventFragment listFragment;
    private CommentFragment gridFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get ListView object from xml.
        // ListView eventListView = (ListView) findViewById(R.id.event_list);
        // Show different fragments based on screen size.
//        if (findViewById(R.id.fragment_container) != null) {
//            Fragment fragment = isTablet() ? new  CommentFragment() : new EventFragment();
//            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
//        }
        //add list view
        if(getSupportFragmentManager().findFragmentById(R.id.event_container)==null){
            listFragment=new EventFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.event_container, listFragment).commit();
        } else {
            listFragment = (EventFragment) getSupportFragmentManager().findFragmentById(R.id.event_container);
        }

        //add Grid view
        if(getSupportFragmentManager().findFragmentById(R.id.comment_container)==null && isTablet()){
            gridFragment = new CommentFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.comment_container, gridFragment).commit();
        } else {
            gridFragment = (CommentFragment) getSupportFragmentManager().findFragmentById(R.id.comment_container);
        }
    }

    private boolean isTablet() {
        return (getApplicationContext().getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_LARGE;

    }

    @Override
    public void onItemSelected(int position) {
        if (!isTablet()) {
            Intent intent = new Intent(this, EventGridActivity.class);
            intent.putExtra("position", position);
            startActivity(intent);
        } else {
            gridFragment.onItemSelected(position);
        }

    }

    @Override
    public void onCommentSelected(int position) {
        listFragment.onItemSelected(position);
    }


    // Initialize an adapter.
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this,
//                R.layout.event_item,
//                R.id.event_name,
//                getEventNames());

        // Assign adapter to ListView.
//        EventAdapter adapter = new EventAdapter(this);
//        eventListView.setAdapter(adapter);



//    /**
//     * A dummy function to get fake event names.
//     */
//    private String[] getEventNames() {
//        String[] names = {
//                "Event1", "Event2", "Event3",
//                "Event4", "Event5", "Event6",
//                "Event7", "Event8", "Event9",
//                "Event10", "Event11", "Event12"};
//        return names;
//    }


//    @Override
//    protected void onStart(){
//        super.onStart();
//        Log.e("Life cycle test", "We are at onStart()");
//    }
//
//    @Override
//    protected void onResume(){
//        super.onResume();
//        Log.e("Life cycle test", "We are at ONResume()");
//    }
//
//    @Override
//    protected void onPause(){
//        super.onPause();
//        Log.e("Life cyclte test", "We are at onPause()");
//    }
//
//    @Override
//    protected void onStop(){
//        super.onStop();
//        Log.e("Life cycle test", "We are at onStop");
//    }
//
//    @Override
//    protected void onDestroy(){
//        super.onDestroy();
//        Log.e("Life cycle test", "We are at onDestroy");
//    }
}


