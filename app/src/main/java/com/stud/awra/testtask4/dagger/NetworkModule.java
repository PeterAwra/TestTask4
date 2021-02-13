package com.stud.awra.testtask4.dagger;

import com.google.gson.GsonBuilder;
import com.stud.awra.testtask4.network.NetworkService;
import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
  @Provides Retrofit getRetrofit(OkHttpClient client,
      Converter.Factory converterFactory,
      CallAdapter.Factory callFactory) {
    return new Retrofit.Builder()
        .baseUrl("https://google.com")
        .client(client)
        .addConverterFactory(converterFactory)
        .addCallAdapterFactory(callFactory)
        .build();
  }

  @Provides NetworkService getNetworkService(Retrofit retrofit) {
    return retrofit.create(NetworkService.class);
  }

  @Provides OkHttpClient getClient(Interceptor interceptor) {
    return new OkHttpClient.Builder().addInterceptor(interceptor).build();
  }

  @Provides Converter.Factory getConverterFactory() {
    return GsonConverterFactory.create(new GsonBuilder().setLenient().create());
  }

  @Provides CallAdapter.Factory getCallFactory() {
    return RxJava2CallAdapterFactory.create();
  }

  @Provides Interceptor getInterceptor() {
    return chain -> {
      Response response = chain.proceed(chain.request());
      return response.newBuilder()
          .body(ResponseBody.create(" {\n"
                  + "     \"personal\" : [\n"
                  + "              {\"name\":\"Ivan\",\"surname\":\"Ivanov\",\"age\":\"25\",\"sex\":\"male\",\"occupation\":\"CEO\"},\n"
                  + "              {\"name\":\"Petr\",\"surname\":\"Sidorov\",\"age\":\"20\",\"sex\": \"male\",\"occupation\":\"Developer\"},\n"
                  + "              {\"name\":\"Andrey\",\"surname\":\"Zaripov\",\"age\":\"23\",\"sex\": \"male\",\"occupation\":\"Supply manager\"},\n"
                  + "              {\"name\":\"Sergey\",\"surname\":\"Petrov-Vodkin\",\"age\":\"33\",\"sex\": \"male\",\"occupation\":\"Account manager\"},\n"
                  + "              {\"name\":\"Konstantin\",\"surname\":\"Paustovskiy\",\"age\":\"35\",\"sex\": \"male\",\"occupation\":\"Driver\"},\n"
                  + "              {\"name\":\"Olga\",\"surname\":\"Stepanova\",\"age\":\"26\",\"sex\": \"female\",\"occupation\":\"Manager\"},\n"
                  + "              {\"name\":\"Iryna\",\"surname\":\"Sviridova\",\"age\":\"35\",\"sex\": \"female\",\"occupation\":\"CEO\"},\n"
                  + "              {\"name\":\"Valentyna\",\"surname\":\"Stepanova\",\"age\":\"33\",\"sex\": \"female\",\"occupation\":\"Manager\"},\n"
                  + "              {\"name\":\"Olga\",\"surname\":\"Paustovskiy\",\"age\":\"35\",\"sex\": \"female\",\"occupation\":\"Manager\"},\n"
                  + "              {\"name\":\"Anna\",\"surname\":\"Grigorishina\",\"age\":\"40\",\"sex\": \"female\",\"occupation\":\"Key account manager\"},\n"
                  + "              {\"name\":\"Stepan\",\"surname\":\"Andreev\",\"age\":\"27\",\"sex\": \"male\",\"occupation\":\"Driver\"}\n"
                  + "                 ]\n"
                  + "    }",
              MediaType.get("application/json; charset=utf-8")))
          .build();
    };
  }
}
