package thachpham.hometest.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import thachpham.hometest.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fm.beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_container, new HotkeyFragment());
//        fragmentTransaction.commit();
    }
}
