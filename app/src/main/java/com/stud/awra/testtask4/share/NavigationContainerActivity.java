package com.stud.awra.testtask4.share;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.google.android.material.snackbar.Snackbar;
import com.stud.awra.testtask4.R;

public class NavigationContainerActivity extends AppCompatActivity {
  private NavController navController;
  private Toast toast;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.navigation_container);
  }

  @Override protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    navController = Navigation.findNavController(this, R.id.nav_host_fragment);
  }

  @Override public void onBackPressed() {
    if (!navController.navigateUp()) {
      Snackbar
          .make(findViewById(R.id.nav_host_fragment), R.string.msg_do_you_want_to_exit,
              Snackbar.LENGTH_SHORT)
          .setAction(android.R.string.yes, v -> finish())
          .show();
    }
  }
}