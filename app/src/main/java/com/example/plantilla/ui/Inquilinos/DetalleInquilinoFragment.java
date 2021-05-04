package com.example.plantilla.ui.Inquilinos;

import android.os.Bundle;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.plantilla.R;
import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.modelo.Inquilino;
import com.example.plantilla.ui.Perfil.PerfilViewModel;

import java.util.List;

public class DetalleInquilinoFragment extends Fragment {
    private DetalleInquilinoViewModel detallesVm;
    private TextView tvNombre;
    private TextView tvApellido;
    private TextView tvDni;
    private TextView tvEmail;
    private TextView tvTelefono;
    private TextView tvGarante;
    private TextView tvTelefonoGarante;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        detallesVm =  ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(DetalleInquilinoViewModel.class);
        View root = inflater.inflate(R.layout.item_inquilinos, container, false);
        inicializar(root);

        detallesVm.getListaMutable().observe(getActivity(), new Observer<Inquilino>() {
            @Override
            public void onChanged(Inquilino inquilino) {
                tvNombre.setText(inquilino.getNombre());
                tvApellido.setText(inquilino.getApellido());
                tvDni.setText(inquilino.getDNI().toString());
                tvTelefono.setText(inquilino.getTelefono());
                tvEmail.setText(inquilino.getEmail());
                tvGarante.setText(inquilino.getNombreGarante());
                tvTelefonoGarante.setText(inquilino.getTelefonoGarante());
            }
        });
        detallesVm.cargarInquilinos((getArguments()));
        return root;
    }

    public void inicializar(View view) {
        tvNombre = view.findViewById(R.id.tvNombre);
        tvApellido = view.findViewById(R.id.tvApellido);
        tvDni = view.findViewById(R.id.tvDNI);
        tvEmail = view.findViewById(R.id.tvEmail);
        tvTelefono = view.findViewById(R.id.tvTelefono);
        tvGarante = view.findViewById(R.id.tvGarante);
        tvTelefonoGarante = view.findViewById(R.id.tvTelefonoGrante);

    }

}



