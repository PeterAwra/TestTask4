package com.stud.awra.testtask4.screens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import com.stud.awra.testtask4.databinding.Screen3Binding;
import com.stud.awra.testtask4.model.Person;

public class ThirdScreen extends Fragment {
  private Screen3Binding binding;
  private Person person;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    person = ThirdScreenArgs.fromBundle(getArguments()).getPerson();
  }

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    binding = Screen3Binding.inflate(inflater, container, false);
    return binding.getRoot();
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    binding.setPerson(person);
    binding.btBack.setOnClickListener(v -> Navigation.findNavController(view).popBackStack());
  }
}
