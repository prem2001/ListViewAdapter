package base.fire.com.listviewadapter.activity;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import base.fire.com.listviewadapter.R;
import base.fire.com.listviewadapter.adapter.CustomBaseAdapter;
import base.fire.com.listviewadapter.database.DatabaseManager;
import base.fire.com.listviewadapter.model.ModelItem;

public class MainAcivityListView extends Activity implements
        AdapterView.OnItemClickListener {

    public static final String[] titles = new String[]{"Strawberry",
            "Banana", "Orange", "Mixed"};

    public static final String[] descriptions = new String[]{
            "It is an aggregate accessory fruit",
            "It is the largest herbaceous flowering plant", "Citrus Fruit",
            "Mixed Fruits"};

    public static final Integer[] images = {
            R.drawable.straw,
            R.drawable.straw,
            R.drawable.straw,
            R.drawable.straw};

    ListView listView;
    ArrayList<ModelItem> modelItemArrayList;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modelItemArrayList = new ArrayList<ModelItem>();
        for (int i = 0; i < titles.length; i++) {
            ModelItem item = new ModelItem(images[i], titles[i], descriptions[i]);
            modelItemArrayList.add(item);
        }

        listView = (ListView) findViewById(R.id.list);
        CustomBaseAdapter adapter = new CustomBaseAdapter(this, modelItemArrayList);
        listView.setAdapter(adapter);

//        loadingDataBase();

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        String titleId = ((ModelItem) parent.getItemAtPosition(position)).getTitle();

        Toast toast = Toast.makeText(getApplicationContext(),
                "Item " + (position + 1) + ": " + modelItemArrayList.get(position),
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

    private void loadingDataBase() {
        DatabaseManager dbManager = new DatabaseManager(this);
        dbManager.open();
        dbManager.insertDataToSqliteDB("PREM", "NATH");
        Cursor history = dbManager.getFirstRowData();

        String data = dbManager.getAllData();
        Log.e("PREM",data);
//        ChatCursorAdapter viewAdapter = new ChatCursorAdapter(MainAcivityListView.this, history, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
//        viewAdapter.notifyDataSetChanged();
//        listView.setAdapter(viewAdapter);
        dbManager.close();


    }
}
