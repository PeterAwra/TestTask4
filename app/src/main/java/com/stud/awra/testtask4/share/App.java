package com.stud.awra.testtask4.share;

import android.app.Application;
import com.stud.awra.testtask4.dagger.DaggerAppComponent;
import com.stud.awra.testtask4.dagger.RepositoryModule;
import com.stud.awra.testtask4.repository.Repository;

public class App extends Application {
  public static Repository repository;

  @Override public void onCreate() {
    super.onCreate();
    repository = DaggerAppComponent.builder()
        .repositoryModule(new RepositoryModule(this.getApplicationContext()))
        .build()
        .getRepository();
  }
}
