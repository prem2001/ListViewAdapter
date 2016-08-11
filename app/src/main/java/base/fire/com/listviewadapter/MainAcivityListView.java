package base.fire.com.listviewadapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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
    List<ModelItem> rowItems;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rowItems = new ArrayList<ModelItem>();
        for (int i = 0; i < titles.length; i++) {
            ModelItem item = new ModelItem(images[i], titles[i], descriptions[i]);
            rowItems.add(item);
        }

        listView = (ListView) findViewById(R.id.list);
        CustomBaseAdapter adapter = new CustomBaseAdapter(this, rowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        String titleId = ((ModelItem) parent.getItemAtPosition(position)).getTitle();

        Toast toast = Toast.makeText(getApplicationContext(),
                "Item " + (position + 1) + ": " + rowItems.get(position),
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
}
