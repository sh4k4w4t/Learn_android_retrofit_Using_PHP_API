package com.alivepython.mobilebankingappusingphpapi.interfaces;

import okhttp3.ResponseBody;
import retrofit2.http.POST;

public interface WebService {
    @POST("")
    ResponseBody loginNow();
}
