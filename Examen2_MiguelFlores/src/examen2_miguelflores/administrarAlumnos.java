/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2_miguelflores;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Edwin Mejia
 */
public class administrarAlumnos {

    private ArrayList<alumnos> listaAlumnos = new ArrayList();
    private File archivo = null;

    public administrarAlumnos(String Path) {
        archivo = new File(Path);
    }

    public administrarAlumnos() {
    }

    public ArrayList<alumnos> getListRusos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(alumnos x) {
        listaAlumnos.add(x);
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void setAlumnos(alumnos p) {
        this.listaAlumnos.add(p);
    }

    public void CargarArchivo() {
        try {
            listaAlumnos = new ArrayList();
            alumnos temp;
            if (archivo.exists()) {
                FileInputStream entrada
                        = new FileInputStream(archivo);
                ObjectInputStream objeto
                        = new ObjectInputStream(entrada);
                try {
                    while ((temp = (alumnos) objeto.readObject()) != null) {
                        listaAlumnos.add(temp);
                    }
                } catch (EOFException e) {
                    //Encontro el final del archivo
                }
                objeto.close();
                entrada.close();

            }
        } catch (Exception e) {
        }
    }

    public void escribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            for (alumnos t : listaAlumnos) {
                bw.writeObject(t);
            }
            bw.flush();
        } catch (Exception e) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception e) {
            }
        }

    }
}
