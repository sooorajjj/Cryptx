package online.klok.cryptx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by klok on 17/6/16.
 */
public class FileAdapter extends ArrayAdapter<File>{

    public static class ViewHolder{
        TextView title;
        TextView file;
        ImageView fileIcon;
    }

    public FileAdapter(Context context, ArrayList<File> files){

        super(context, 0, files);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        File file = getItem(position);

        ViewHolder viewHolder;


        if (convertView == null) {

            viewHolder = new ViewHolder();

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);

            viewHolder.title = (TextView) convertView.findViewById(R.id.listItemFileName);
            viewHolder.file = (TextView) convertView.findViewById(R.id.listItemFileDetails);
            viewHolder.fileIcon = (ImageView) convertView.findViewById(R.id.listItemFileIcon);

            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.title.setText(file.getTitle());
        viewHolder.file.setText(file.getMessage());
        viewHolder.fileIcon.setImageResource(file.getAssociatedDrawable());

        return convertView;


    }

}
