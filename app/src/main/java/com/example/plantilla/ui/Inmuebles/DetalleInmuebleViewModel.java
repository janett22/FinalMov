package com.example.plantilla.ui.Inmuebles;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.request.ApiClient;

public class DetalleInmuebleViewModel extends ViewModel {

    private MutableLiveData<Inmueble> detalleInmuebleMutable;

    public LiveData<Inmueble> getInmueble(){
        if ( detalleInmuebleMutable == null ) {
            detalleInmuebleMutable = new MutableLiveData<>();
        }
        return detalleInmuebleMutable;
    }

    public void leerDetalle(Inmueble inmueble) {
        detalleInmuebleMutable.setValue(inmueble);
    }

    public void actualizarDetalle(Inmueble inmueble) {
        ApiClient apiClient = ApiClient.getApi();
        apiClient.actualizarInmueble(inmueble);
        detalleInmuebleMutable.setValue(inmueble);
    }
}