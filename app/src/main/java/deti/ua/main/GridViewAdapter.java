package deti.ua.main;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridViewAdapter extends ArrayAdapter<ImageItem> {

    private Context context;
    private int layoutResourceId;
    private ArrayList<ImageItem> data = new ArrayList<>();

    public GridViewAdapter(Context context, int layoutResourceId, ArrayList<ImageItem> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    public void setData(ArrayList<ImageItem> data) {
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.imageTitle = (TextView) row.findViewById(R.id.text);
            holder.imageUser = (TextView) row.findViewById(R.id.subtext);
            holder.imageViews = (TextView) row.findViewById(R.id.views);
            holder.image = (ImageView) row.findViewById(R.id.image);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }


        ImageItem item = data.get(position);
        holder.imageTitle.setText(item.getTitle());
        holder.imageUser.setText(item.getUser());
        holder.imageViews.setText(item.getViews());
        holder.image.setImageBitmap(item.getImage());
        return row;
    }

    static class ViewHolder {
        TextView imageUser;
        TextView imageTitle;
        TextView imageViews;
        ImageView image;
    }
}