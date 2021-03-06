package com.alivepython.mobilebankingappusingphpapi;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;

import com.alivepython.mobilebankingappusingphpapi.main_Apps_mobileBanking.model.DataController;
import com.alivepython.mobilebankingappusingphpapi.main_Apps_mobileBanking.model.UserModel;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.alivepython.mobilebankingappusingphpapi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    ConstraintLayout layoutConstrain;
    TextView userName,userPhone,userBalance;
    UserModel user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarMain.toolbar);
        initializedUI();

        navigationBarInfoChange();

        user= DataController.getInstance().getCurrentUser();
        if (user!=null){
            userName.setText(user.getUserName());
            userBalance.setText(user.getUserBalance()+" BDT");
            userPhone.setText(user.getUserPhone());
        }

        binding.appBarMain.fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,R.id.nav_allService)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    private void navigationBarInfoChange() {
        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);

        TextView navUsername = headerView.findViewById(R.id.navigation_userName);
        navUsername.setText("Unknown Person");

        TextView navEmail= headerView.findViewById(R.id.navigation_userEmail);
        navEmail.setText("Unknown@unkown.com");

    }

    private void initializedUI() {
        layoutConstrain= findViewById(R.id.toolbarConstrainLayoutID);
        userName = layoutConstrain.findViewById(R.id.userNameId);
        userPhone = layoutConstrain.findViewById(R.id.userPhoneNumberId);
        userBalance = layoutConstrain.findViewById(R.id.userBalanceId);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}