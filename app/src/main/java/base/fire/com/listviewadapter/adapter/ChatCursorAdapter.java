package base.fire.com.listviewadapter.adapter;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import base.fire.com.listviewadapter.R;
import base.fire.com.listviewadapter.database.DatabaseField;

/**
 * Created by prem on 11/8/16.
 */
public class ChatCursorAdapter extends CursorAdapter {
    private TextView tvBody;
    private TextView tvPriority;

    public ChatCursorAdapter(Context context, Cursor cursor, int flags) {
        super(context, cursor, flags);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {


        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder holder = (ViewHolder) view.getTag();
        // Find fields to populate in inflated template
        if (holder == null) {
            holder = new ViewHolder();
            holder.tvBody = (TextView) view.findViewById(R.id.title);
            view.setTag(holder);
        }
        // Populate fields with extracted properties
        holder.tvBody.setText(cursor.getString(DatabaseField.ChatMessages.INDEX_FIRST));
    }

    static class ViewHolder {
        TextView tvBody;
    }
}

