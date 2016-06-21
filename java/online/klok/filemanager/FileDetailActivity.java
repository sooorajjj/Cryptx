package online.klok.filemanager;

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

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        FileViewFragment fileViewFragment = new FileViewFragment();
        setTitle(R.string.viewFragmentTitle);
        fragmentTransaction.add(R.id.file_container, fileViewFragment, "NOTE_VIEW_FRAGMENT");

        fragmentTransaction.commit();

    }
}
