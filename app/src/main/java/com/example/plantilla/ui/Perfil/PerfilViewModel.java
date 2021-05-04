package com.example.plantilla.ui.Perfil;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantilla.modelo.Propietario;
import com.example.plantilla.request.ApiClient;

public class PerfilViewModel extends ViewModel {

    MutableLiveData<Propietario> perfilMutable;
    MutableLiveData<Propietario> cambios;

    public LiveData<Propietario> getPerfilMutable(){
        if(perfilMutable==null){
            perfilMutable= new MutableLiveData<>();
        }
        return perfilMutable;
    }



    public LiveData<Propietario> getCambios(){
        if(cambios==null){
            cambios= new MutableLiveData<>();
        }
        return cambios;
    }

    public void cargarDatos(){
        ApiClient api =ApiClient.getApi();
        Propietario propietario = api.obtenerUsuarioActual();
        perfilMutable.setValue(propietario);
    }

  public void guardarCambios(Propietario propietario){
        ApiClient apiClient=ApiClient.getApi();
        apiClient.actualizarPerfil(propietario);
        cambios.setValue(propietario);
  }






}
