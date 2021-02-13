package com.stud.awra.testtask4.repository;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.stud.awra.testtask4.model.Person;
import com.stud.awra.testtask4.model.Respond;
import com.stud.awra.testtask4.network.NetworkService;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RepositoryImpl implements Repository {

  private final NetworkService service;
  private final SharedPreferences sp;

  @Override public Observable<List<Person>> getPersonal() {
    return service.getPersonal()
        .subscribeOn(Schedulers.io())
        .doOnNext(
            personal -> sp.edit()
                .putString("RESPOND_JSON", new Gson().toJson(personal))
                .apply())
        .delay(5, TimeUnit.SECONDS)
        .map(Respond::getPerson)
        .map(personal -> {
          Collections.sort(personal,
              (o1, o2) -> -o1.getSurname().compareToIgnoreCase(o2.getSurname()));
          return personal;
        })
        .observeOn(AndroidSchedulers.mainThread());
  }

  public RepositoryImpl(NetworkService service, SharedPreferences sp) {
    this.service = service;
    this.sp = sp;
  }
}
