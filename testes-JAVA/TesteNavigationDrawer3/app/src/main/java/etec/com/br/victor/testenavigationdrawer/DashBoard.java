package etec.com.br.victor.testenavigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class DashBoard extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        getSupportActionBar().hide();
        drawerLayout = findViewById(R.id.drawer_layout);

    }

    public void ClickMenu(View v){

        MainActivity.openDrawer(drawerLayout);

    }

    public void ClickLogo(View v){

        MainActivity.closeDrawer(drawerLayout);

    }

    public void ClickHome(View v){

        MainActivity.redirectActivity(this,MainActivity.class);

    }

    public void ClickDashboard(View v){

        recreate();

    }

    public void ClickAboutUs(View v){

        MainActivity.redirectActivity(this,AboutUs.class);

    }

    public void ClickLogout(View v){

        MainActivity.logout(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(drawerLayout);
    }
}