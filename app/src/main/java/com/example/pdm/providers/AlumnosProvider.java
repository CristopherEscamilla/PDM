package com.example.pdm.providers;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;

public class AlumnosProvider {

    private static final String[] nombres = {"Juan", "María", "Pedro"};
    private static final int[] edades = {20, 22, 21};

    // Array de notas de alumnos (cada subarray representa las notas de un alumno)
    private static final ArrayList<ArrayList<Integer>> notas = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList(80, 85, 90)),
            new ArrayList<>(Arrays.asList(75, 80, 85)),
            new ArrayList<>(Arrays.asList(70, 75, 80))
    ));

    // Método para obtener la lista de nombres de alumnos
    public static ArrayList<String> getNombres() {
        return new ArrayList<>(Arrays.asList(nombres));
    }

    // Método para obtener la lista de edades de alumnos
    public static ArrayList<Integer> getEdades() {
        ArrayList<Integer> edadesList = new ArrayList<>();
        for (int edad : edades) {
            edadesList.add(edad);
        }
        return edadesList;
    }

    // Método para obtener la lista de notas de un alumno dado su índice
    public static ArrayList<Integer> getNotas(int indice) {
        return notas.get(indice);
    }
}
