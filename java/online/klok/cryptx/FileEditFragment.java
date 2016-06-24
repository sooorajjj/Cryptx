package online.klok.cryptx;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class FileEditFragment extends Fragment {


    public FileEditFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentLayout = inflater.inflate(R.layout.fragment_file_edit, container, false);

        EditText title = (EditText) fragmentLayout.findViewById(R.id.editFileTitle);
        EditText message = (EditText) fragmentLayout.findViewById(R.id.editFileMessage);
        ImageButton fileCatButton = (ImageButton) fragmentLayout.findViewById(R.id.editFileButton);

        Intent intent = getActivity().getIntent();
        title.setText(intent.getExtras().getString(MainActivity.FILE_TITLE_EXTRA));
        message.setText(intent.getExtras().getString(MainActivity.FILE_MESSAGE_EXTRA));

        File.Category fileCat = (File.Category) intent.getSerializableExtra(MainActivity.FILE_CATEGORY_EXTRA);
        fileCatButton.setImageResource(File.categoryToDrawable(fileCat));

        return fragmentLayout;
    }

}
