package com.example.matheuscatossi.loggiboxcd.webservice;


import com.example.matheuscatossi.loggiboxcd.model.Package;
import com.example.matheuscatossi.loggiboxcd.model.ResultPackage;
import com.example.matheuscatossi.loggiboxcd.utils.Constants;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET(Constants.PACKAGE)
    Call<ResultPackage> getAllPackages();

}