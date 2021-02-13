package com.stud.awra.testtask4.dagger;

import android.content.Context;
import android.content.SharedPreferences;
import com.stud.awra.testtask4.network.NetworkService;
import com.stud.awra.testtask4.repository.Repository;
import com.stud.awra.testtask4.repository.RepositoryImpl;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module(includes = NetworkModule.class)
public class RepositoryModule {
  private final Context context;

  public RepositoryModule(Context context) {
    this.context = context;
  }

  @Singleton
  @Provides Repository getRepository(NetworkService service, SharedPreferences sp) {
    return new RepositoryImpl(service, sp);
  }

  @Provides SharedPreferences getSharedPreferences() {
    return context.getSharedPreferences(context.getPackageName() + "sp", Context.MODE_PRIVATE);
  }
}
