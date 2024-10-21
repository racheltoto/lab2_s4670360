package com.example.lab2_s4670360.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab2_s4670360.data.RequestLogin
import com.example.lab2_s4670360.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel

class LoginVM @Inject constructor(

    private val apiService: ApiService,

    @ApplicationContext private val appContext: Context

) : ViewModel(){
    fun login(username: String, password: String, onSuccess: (String) -> Unit, onError: (String) -> Unit){

        viewModelScope.launch {
            try {

                val ResponseLogin = apiService.login(RequestLogin(username, password))
                val keypass = ResponseLogin.keypass

                val sharedPreferences =
                    appContext.getSharedPreferences("APP_PREFS", Context.MODE_PRIVATE)
                sharedPreferences.edit().putString("keypass", keypass).apply()

                Log.d("LoginVM", "Received keypass: ${ResponseLogin.keypass}")

                onSuccess(ResponseLogin.keypass)

            }
            catch (e: HttpException){
                Log.e("LoginVM", "Login failed: ${e.message()}")
                onError("Login failed:${e.message}")

            }catch (e: IOException){
                onError("Network error: ${e.message}")

            }catch (e:Exception){
                onError("An error occurred: ${e.message}")
            }

        }
    }
}

