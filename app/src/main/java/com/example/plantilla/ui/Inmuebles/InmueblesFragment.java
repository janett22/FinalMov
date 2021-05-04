package com.example.plantilla.ui.Inmuebles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.plantilla.R;
import com.example.plantilla.modelo.Inmueble;

import java.util.ArrayList;
import java.util.List;

public class InmueblesFragment extends Fragment {

    private InmueblesViewModel vm;
    private ListView listaInmuebles;
    private List<Inmueble> lista;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vm = new ViewModelProvider(this).get(InmueblesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_inmuebles, container, false);

        inicializarVista(root);
        vm.getlistaMutable().observe(getViewLifecycleOwner(), new Observer<List<Inmueble>>() {

            @Override
            public void onChanged(List<Inmueble> inmuebles) {
                lista = inmuebles;
                ArrayAdapter<Inmueble> adapter = new ListaAdapter(getContext(), R.layout.item_inmuebles, lista, getLayoutInflater());
                listaInmuebles.setAdapter(adapter);
            }
        });
        vm.leerInmuebles();
        return root;
    }

    private void inicializarVista(View root) {
        listaInmuebles = root.findViewById(R.id.listaInmuebles);
    }
}