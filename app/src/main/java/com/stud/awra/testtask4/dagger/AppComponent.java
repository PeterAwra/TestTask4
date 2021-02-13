package com.stud.awra.testtask4.dagger;

import com.stud.awra.testtask4.repository.Repository;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = RepositoryModule.class)
public interface AppComponent {
  Repository getRepository();
}