package com.stud.awra.testtask4.network;

import com.stud.awra.testtask4.model.Respond;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NetworkService {
  @GET("/")
  Observable<Respond> getPersonal();
}
