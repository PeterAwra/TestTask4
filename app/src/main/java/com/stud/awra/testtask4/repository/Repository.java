package com.stud.awra.testtask4.repository;

import com.stud.awra.testtask4.model.Person;
import io.reactivex.Observable;
import java.util.List;

public interface Repository {
  Observable<List<Person>> getPersonal();
}
