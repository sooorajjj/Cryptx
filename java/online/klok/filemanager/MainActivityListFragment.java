package online.klok.filemanager;


import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityListFragment extends ListFragment {

    private ArrayList<File> files;
    private FileAdapter fileAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        /*
        String[] values = new String[]{ "SlimRoms" , "VANIRaosp", "AOKP",
                "CyanogenMod", "FLEXOS", "Mokee Open Source", "TeslaOS",
                "TipsyOS", "AOSPA" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, values );

        setListAdapter(adapter);
        */
        files = new ArrayList<File>();
        files.add(new File("This is the new file title" , "This is the body of our file!",
                File.Category.PERSONAL));
        files.add(new File("New File Hey Hey Hey Lets see how large we can make this thing let's see hos much large", "something wrong?",File.Category.FINANCE));
        files.add(new File("This is working very well", "I'cant speak English",File.Category.QUOTE));
        files.add(new File("Uncle ben?", "With big powers come big responsibility",File.Category.PERSONAL));
        files.add(new File("Good Stuff", "Happy new year? LOL",File.Category.TECHNICAL));
        files.add(new File("This is a new File Title", "This is the Body of our File",File.Category.QUOTE));
        files.add(new File("Whats up", "Google knows everything",File.Category.TECHNICAL));
        files.add(new File("Moneyyyyy", "Yeah baby",File.Category.FINANCE));
        files.add(new File("Thanks BABY ", "This is the way",File.Category.FINANCE));

        fileAdapter = new FileAdapter(getActivity(), files);

        setListAdapter(fileAdapter);

        /* Divider between the list of Files */
        getListView().setDivider(ContextCompat.getDrawable(getActivity(), android.R.color.holo_blue_light));
        getListView().setDividerHeight(1);

        }

    @Override
    public void onListItemClick(ListView l , View v, int position, long id){
        super.onListItemClick(l, v, position, id);

        launchNoteDetailActivity(position);

    }

    private void launchNoteDetailActivity(int position){

        File file = (File) getListAdapter().getItem(position);
        Intent intent = new Intent(getActivity(), FileDetailActivity.class);
        intent.putExtra(MainActivity.FILE_TITLE_EXTRA, file.getTitle());
        intent.putExtra(MainActivity.FILE_MESSAGE_EXTRA, file.getMessage());
        intent.putExtra(MainActivity.FILE_CATEGORY_EXTRA, file.getCategory());
        intent.putExtra(MainActivity.FILE_ID_EXTRA, file.getId());


        startActivity(intent);

    }


}
