package com.stud.awra.testtask4.screens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import com.stud.awra.testtask4.R;

public class FirstScreen extends Fragment {

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.screen_1, container, false);
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    getView().findViewById(R.id.screen1_bt_resume)
        .setOnClickListener(v -> Navigation.findNavController(getView())
            .navigate(FirstScreenDirections.actionFirstScreenToSecondScreen()));
  }
}
