package dudewheresarecar.bobthekettleapp

import android.arch.lifecycle.ViewModel
import okhttp3.*
import java.io.IOException

class NetworkViewModel : ViewModel() {
    private val client = OkHttpClient()

    fun postToServer(url: String, json: String): String {
        val JSON: MediaType = MediaType.get("application/json; charset=utf-8")
        val body: RequestBody = RequestBody.create(JSON, json)
        val request = Request.Builder()
                .url(url)
                .post(body)
                .build()
        var response: Response? = null
        try {
            response = client.newCall(request).execute()
        } catch (e: IOException) {

        }
        return response?.body()!!.string()
    }

    fun getFromServer(url: String): String {
        val request = Request.Builder()
                .url(url)
                .build()
        var response: Response? = null
        try {
            response = client.newCall(request).execute()
        } catch (e: IOException) {

        }
        return response?.body()!!.string()
    }
}

