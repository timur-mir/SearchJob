package home.howework.searchjob.data.mocknetwork.repository

import home.howework.searchjob.data.mocknetwork.model.OffersWorkCompaniesDto
import home.howework.searchjob.data.mocknetwork.network.MockInterceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Inject

class NetworkServiceClient @Inject constructor(){

    interface ApiService {
        @GET("jobs")
        fun getOffersVacancies(): Call<OffersWorkCompaniesDto>
    }
        fun getMockRemoteDataSourceRepo():ApiService{
            return Retrofit.Builder()
                .client(OkHttpClient.Builder().addInterceptor(MockInterceptor()).build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.mocky.io/v2/")
                .build().create(ApiService::class.java)

        }

}