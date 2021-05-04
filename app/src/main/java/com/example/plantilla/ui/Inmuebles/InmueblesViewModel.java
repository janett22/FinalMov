package com.example.plantilla.ui.Inmuebles;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.request.ApiClient;

import java.util.List;

public class InmueblesViewModel extends ViewModel {

    private MutableLiveData<List<Inmueble>> listaMutable;

    public LiveData<List<Inmueble>> getlistaMutable(){
        if(listaMutable==null){
            listaMutable= new MutableLiveData<>();
        }
        return listaMutable;
    }
    public void leerInmuebles(){
        ApiClient api = ApiClient.getApi();
        List<Inmueble>lista=api.obtnerPropiedades();
        listaMutable.setValue(lista);
    }
}