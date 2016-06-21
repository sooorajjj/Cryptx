package online.klok.filemanager;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FileViewFragment extends Fragment {


    public FileViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentLayout = inflater.inflate(R.layout.fragment_file_view, container, false);

        TextView title = (TextView) fragmentLayout.findViewById(R.id.viewFileTitle);
        TextView message = (TextView) fragmentLayout.findViewById(R.id.viewFileMessage);
        ImageView icon = (ImageView) fragmentLayout.findViewById(R.id.viewFileIcon);

        Intent intent = getActivity().getIntent();

        title.setText(intent.getExtras().getString(MainActivity.FILE_TITLE_EXTRA));
        message.setText(intent.getExtras().getString(MainActivity.FILE_MESSAGE_EXTRA));

        File.Category filecat = (File.Category) intent.getSerializableExtra(MainActivity.FILE_CATEGORY_EXTRA);
        icon.setImageResource(File.categoryToDrawable(filecat));



        return fragmentLayout;
    }

}


