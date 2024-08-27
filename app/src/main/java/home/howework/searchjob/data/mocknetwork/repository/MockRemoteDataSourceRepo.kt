package home.howework.searchjob.data.mocknetwork.repository

import android.util.Log
import home.howework.searchjob.data.mocknetwork.model.OffersWorkCompaniesDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MockRemoteDataSourceRepo {
    fun getOffersVacancies(callback: (OffersWorkCompaniesDto)->Unit) {
        NetworkClient.create().getOffersVacancies()
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

