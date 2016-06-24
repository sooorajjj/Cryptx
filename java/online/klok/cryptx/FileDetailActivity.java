package online.klok.cryptx;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FileDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_detail);

        createAndFragment();
    }

    private void  createAndFragment(){

        Intent intent = getIntent();
        MainActivity.FragmentToLaunch fragmentToLaunch =
                (MainActivity.FragmentToLaunch) intent.getSerializableExtra(MainActivity.FILE_FRAGMENT_TOLOAD_EXTRA);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch(fragmentToLaunch){
            case EDIT:

                FileEditFragment fileEditFragment= new FileEditFragment();
                setTitle(R.string.edit_fragment_title);
                fragmentTransaction.add(R.id.file_container, fileEditFragment, "FILE_EDIT_FRAGMENT");

                break;
            case VIEW:
                FileViewFragment fileViewFragment = new FileViewFragment();
                setTitle(R.string.view_fragment_title);
                fragmentTransaction.add(R.id.file_container, fileViewFragment, "FILE_VIEW_FRAGMENT");
                break;
        }

        fragmentTransaction.commit();

    }
}
