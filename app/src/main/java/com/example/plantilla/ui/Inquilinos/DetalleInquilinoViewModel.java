package com.example.plantilla.ui.Inquilinos;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.modelo.Inquilino;
import com.example.plantilla.request.ApiClient;

public class DetalleInquilinoViewModel extends ViewModel {

    private MutableLiveData<Inquilino> listaMutable;

    public LiveData<Inquilino> getListaMutable(){
        if(listaMutable==null){
            listaMutable= new MutableLiveData<>();
        }
        return listaMutable;
    }



    public void cargarInquilinos(Bundle bundle) {
        Inquilino inquilino = (Inquilino) bundle.getSerializable("inquilino");
        this.listaMutable .setValue(inquilino);
    }





}
