package com.example.plantilla.ui.Inmuebles;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.plantilla.R;
import com.example.plantilla.modelo.Inmueble;

import java.io.Serializable;
import java.util.List;

public class DetalleInmuebleFragment extends Fragment {

    private DetalleInmuebleViewModel detalleInmuebleViewModel;
    private View root;
    private Inmueble inmueble;

    private TextView tvTitulo, tvId, tvAmbientes, tvDireccion, tvPrecio, tvUso, tvTipo;
    private CheckBox cbEstado;
    private ImageView ivImagenInmueble;

    public View onCreateView(@NonNull final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        inmueble = (Inmueble) getArguments().getSerializable("inmueble");

        detalleInmuebleViewModel = new ViewModelProvider(this).get(DetalleInmuebleViewModel.class);
        root = inflater.inflate(R.layout.detalle_inmueble, container, false);

        inicializarComponentes(root);

        detalleInmuebleViewModel.getInmueble().observe(getViewLifecycleOwner(), new Observer<Inmueble>() {
            @Override
            public void onChanged(Inmueble inmueble) {
                tvId.setText(inmueble.getIdInmueble()+"");
                tvAmbientes.setText(inmueble.getAmbientes()+"");
                tvDireccion.setText(inmueble.getDireccion());
                tvPrecio.setText("$"+inmueble.getPrecio());
                tvUso.setText(inmueble.getUso());
                tvTipo.setText(inmueble.getTipo());
                cbEstado.setChecked(inmueble.isEstado());
                Glide.with(getContext())
                        .load(inmueble.getImagen())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(ivImagenInmueble);
            }
        });

        detalleInmuebleViewModel.leerDetalle(inmueble);
        return root;
    }

    private void inicializarComponentes(View root) {
        tvTitulo=root.findViewById(R.id.tvTitulo);
        tvId=root.findViewById(R.id.tvId);
        tvAmbientes=root.findViewById(R.id.tvAmbientes);
        tvDireccion=root.findViewById(R.id.tvDireccion);
        tvPrecio=root.findViewById(R.id.tvPrecio);
        tvUso=root.findViewById(R.id.tvUso);
        tvTipo=root.findViewById(R.id.tvTipo);
        cbEstado=root.findViewById(R.id.cbEstado);
        ivImagenInmueble=root.findViewById(R.id.ivImagenInmueble);

        cbEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inmueble.setEstado(cbEstado.isChecked());

                detalleInmuebleViewModel.actualizarDetalle(inmueble);

                Toast.makeText(getContext(), "Inmueble actualizado con exito.", Toast.LENGTH_LONG).show();
            }
        });
    }
}