package com.example.petapp;

import java.util.ArrayList;
import java.util.List;

public class DadosCompartilhados {

    public static String usuarioLogado = "";
    public static List<Pet> lista = new ArrayList<Pet>();
    private static Integer idPet = 0;

    public static Integer getProximoId(){
        idPet = idPet + 1;
        return idPet;
    }
}
