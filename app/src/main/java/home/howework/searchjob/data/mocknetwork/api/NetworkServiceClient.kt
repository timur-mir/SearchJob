package home.howework.searchjob.data.mocknetwork.repository

import home.howework.searchjob.data.mocknetwork.model.OffersWorkCompaniesDto
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("jobs")
    fun getOffersVacancies() : Call<OffersWorkCompaniesDto>
}

object NetworkClient {
    fun create() : ApiService {
        return Retrofit.Builder()
            .client(OkHttpClient.Builder().addInterceptor(MockInterceptor()).build())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://www.mocky.io/v2/")
            .build().create(ApiService::class.java)
    }
}