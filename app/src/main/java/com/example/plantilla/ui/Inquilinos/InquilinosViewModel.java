package com.example.plantilla.ui.Inquilinos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.modelo.Inquilino;
import com.example.plantilla.request.ApiClient;
import com.google.android.gms.common.api.Api;

import java.util.ArrayList;
import java.util.List;

public class InquilinosViewModel extends ViewModel {


private MutableLiveData<List<Inmueble>> inmueblesAlquilados;


    public LiveData<List<Inmueble>> getInmueblesAlquilados(){
        if(inmueblesAlquilados==null){
           inmueblesAlquilados= new MutableLiveData<>();
        }
        return inmueblesAlquilados;
    }


public void cargarAlquileres(){
        ApiClient apiClient = ApiClient.getApi();
        List<Inmueble> listaAlquilados = apiClient.obtenerPropiedadesAlquiladas();
        inmueblesAlquilados.setValue(listaAlquilados);
}
}
