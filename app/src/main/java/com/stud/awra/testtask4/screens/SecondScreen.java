package com.stud.awra.testtask4.screens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.stud.awra.testtask4.R;
import com.stud.awra.testtask4.adapters.PersonalAdapter;
import com.stud.awra.testtask4.viewmodels.Screen2ViewModel;

public class SecondScreen extends Fragment {

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.screen_2, container, false);
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    RecyclerView rvPersonals = view.findViewById(R.id.screen2_rv_personal);
    SwipeRefreshLayout swl = view.findViewById(R.id.screen2_srl);
    PersonalAdapter adapterPersonals =
        new PersonalAdapter(personal ->
            Navigation.findNavController(getView())
                .navigate(SecondScreenDirections.actionSecondScreenToThirdScreen(personal)));
    Screen2ViewModel model = new ViewModelProvider(requireActivity()).get(Screen2ViewModel.class);
    rvPersonals.setAdapter(adapterPersonals);
    swl.setOnRefreshListener(model::refreshData);
    model.getLoading().observe(getViewLifecycleOwner(), swl::setRefreshing);
    model.getPersonals().observe(getViewLifecycleOwner(), adapterPersonals::setItems);
    model.getError().observe(getViewLifecycleOwner(), this::showMsgError);
    model.init();
  }

  private void showMsgError(Throwable throwable) {
    if (throwable != null) {
      Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_LONG).show();
    }
  }
}
