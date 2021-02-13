package com.stud.awra.testtask4.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.stud.awra.testtask4.model.Person;
import com.stud.awra.testtask4.repository.Repository;
import com.stud.awra.testtask4.share.App;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;

public class Screen2ViewModel extends ViewModel {
  private final Repository repository = App.repository;
  private final MutableLiveData<List<Person>> personalsLiveData =
      new MutableLiveData<>(new ArrayList<>());
  private final MutableLiveData<Boolean> loadingLiveDate = new MutableLiveData<>(false);
  private final MutableLiveData<Throwable> errorLiveDate = new MutableLiveData<>(null);
  private Disposable disposable;

  public void refreshData() {
    if (!loadingLiveDate.getValue()) {
      loadingLiveDate.setValue(true);
      disposable =
          repository.getPersonal().subscribe(personalsLiveData::setValue,
              throwable -> {
                errorLiveDate.setValue(throwable);
                loadingLiveDate.setValue(false);
              },
              () -> {
                loadingLiveDate.setValue(false);
                errorLiveDate.postValue(null);
              });
    }
  }

  public LiveData<Boolean> getLoading() {
    return loadingLiveDate;
  }

  public LiveData<List<Person>> getPersonals() {
    return personalsLiveData;
  }

  public LiveData<Throwable> getError() {
    return errorLiveDate;
  }

  public void init() {
    if (personalsLiveData.getValue().isEmpty() && errorLiveDate.getValue() == null) {
      refreshData();
    }
  }

  @Override protected void onCleared() {
    if (!disposable.isDisposed()) disposable.dispose();
  }
}
