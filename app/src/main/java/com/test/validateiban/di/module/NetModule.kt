package com.test.validateiban.di.module


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.test.validateiban.BASE_URL
import com.test.validateiban.TIMEOUT_REQUEST
import com.test.validateiban.api.BasicAuthInterceptor
import com.test.validateiban.api.NetworkServices
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetModule {

    private val interceptor = HttpLoggingInterceptor()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

//    val tmdbApiInterceptor: Interceptor by lazy {
//        Interceptor { chain ->
//
//            val original = chain.request()
//            val originalHttpUrl = original.url()
//
//            val url = originalHttpUrl.newBuilder()
//                .addQueryParameter("user", "106901")
//                .addQueryParameter("password", "MTYzYmZkNjZiZmJiMTg2M2IwNjU2Nzk5NzI5OTVjNGY")
//                .build()
//
//            val reqBuilder = original.newBuilder()
//                .url(url)
//            chain.proceed(reqBuilder.build())
//        }
//    }



    @Provides
    fun provideHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(BasicAuthInterceptor("106901", "MmU4MDlkYWRhYzc1ZTRhMzYxMTVjNDg4ODNiNzcxNWE="))
        .addInterceptor(interceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(TIMEOUT_REQUEST, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_REQUEST, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_REQUEST, TimeUnit.SECONDS)
            .build()

    @Provides
    fun provideRetrofit(client: OkHttpClient, gson: Gson) = Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(client)

    @Provides
    @Singleton
    fun provideRetrofitService(builder: Retrofit.Builder): NetworkServices = builder.baseUrl(BASE_URL).build().create(NetworkServices::class.java)

}