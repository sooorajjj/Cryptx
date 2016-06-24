package online.klok.cryptx;


import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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

        registerForContextMenu(getListView());
        }

    @Override
    public void onListItemClick(ListView l , View v, int position, long id){
        super.onListItemClick(l, v, position, id);

        launchFileDetailActivity(MainActivity.FragmentToLaunch.VIEW, position);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.long_press_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int rowPosition = info.position;

        switch(item.getItemId()){

            case R.id.edit:

                launchFileDetailActivity(MainActivity.FragmentToLaunch.EDIT, rowPosition);
                Log.d("Menu Clicks", " We pressed edit");
                return true;
        }
        return super.onContextItemSelected(item);
    }



    private void launchFileDetailActivity(MainActivity.FragmentToLaunch ftl, int position){

        File file = (File) getListAdapter().getItem(position);
        Intent intent = new Intent(getActivity(), FileDetailActivity.class);
        intent.putExtra(MainActivity.FILE_TITLE_EXTRA, file.getTitle());
        intent.putExtra(MainActivity.FILE_MESSAGE_EXTRA, file.getMessage());
        intent.putExtra(MainActivity.FILE_CATEGORY_EXTRA, file.getCategory());
        intent.putExtra(MainActivity.FILE_ID_EXTRA, file.getId());

        switch(ftl){
            case VIEW:
                intent.putExtra(MainActivity.FILE_FRAGMENT_TOLOAD_EXTRA, MainActivity.FragmentToLaunch.VIEW);
                break;
            case EDIT:
                intent.putExtra(MainActivity.FILE_FRAGMENT_TOLOAD_EXTRA, MainActivity.FragmentToLaunch.EDIT);
                break;
        }
        startActivity(intent);
    }


}
