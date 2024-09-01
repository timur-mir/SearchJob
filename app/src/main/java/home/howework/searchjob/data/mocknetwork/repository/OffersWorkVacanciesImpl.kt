package home.howework.searchjob.data.mocknetwork.repository

import android.util.Log
import home.howework.searchjob.data.mocknetwork.model.OffersWorkCompaniesDto
import home.howework.searchjob.domain.OffersWorkCompaniesRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OffersWorkVacanciesImpl: OffersWorkCompaniesRepository {
 //   private val mockRemoteDateSourceRepo= MockRemoteDataSourceRepo()
   val networkServiceClient=NetworkServiceClient()
    override suspend fun getOffersVacancies(callback: (OffersWorkCompaniesDto)->Unit){
      // mockRemoteDateSourceRepo.getOffersVacancies(){it->callback(it)
     networkServiceClient.getMockRemoteDataSourceRepo().getOffersVacancies()
         .enqueue(object : Callback<OffersWorkCompaniesDto> {
             override fun onResponse(
                 call: Call<OffersWorkCompaniesDto>,
                 response: Response<OffersWorkCompaniesDto>
             ) {
                 callback(response.body()!!)
             }

             override fun onFailure(call: Call<OffersWorkCompaniesDto>, t: Throwable) {
                 Log.e("Server", "execute request error = ${t.message}", t)
             }

         })
        }
    }

