package com.example.pdm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.pdm.R;
import com.example.pdm.classes.Alumno;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Alumno> list;

    public MyAdapter(Context context, ArrayList<Alumno> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_alumno, parent, false);
            holder = new ViewHolder();
            holder.textViewNombre = convertView.findViewById(R.id.txt_view_nombre);
            holder.textViewEdad = convertView.findViewById(R.id.txt_view_cuenta);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Alumno alumno = list.get(position);
        holder.textViewNombre.setText(alumno.getNombre());
        holder.textViewEdad.setText(String.valueOf(alumno.getNoCuenta()));

        return convertView;
    }

    private static class ViewHolder {
        TextView textViewNombre;
        TextView textViewEdad;
    }

}
