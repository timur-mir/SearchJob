package home.howework.data.mocknetwork.repository

import android.util.Log
import home.howework.data.mapToOffersWorkCompaniesDto
import home.howework.data.mocknetwork.model.OffersWorkCompaniesResponse
import home.howework.data.mocknetwork.network.NetworkServiceClient
import home.howework.domain.OffersWorkCompaniesRepository
import home.howework.domain.entities.OffersWorkCompaniesDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class OffersWorkVacanciesImpl @Inject constructor(private val networkServiceClient: NetworkServiceClient): OffersWorkCompaniesRepository {

    override suspend fun getOffersVacancies(callback: (OffersWorkCompaniesDto)->Unit){
     networkServiceClient.getMockRemoteDataSourceRepo().getOffersVacancies()
         .enqueue(object : Callback<OffersWorkCompaniesResponse> {
             override fun onResponse(
                 call: Call<OffersWorkCompaniesResponse>,
                 response: Response<OffersWorkCompaniesResponse>
             ) {
                 callback(response.body()!!.mapToOffersWorkCompaniesDto())
             }

             override fun onFailure(call: Call<OffersWorkCompaniesResponse>, t: Throwable) {
                 Log.e("Server", "execute request error = ${t.message}", t)
             }

         })
        }
    }

