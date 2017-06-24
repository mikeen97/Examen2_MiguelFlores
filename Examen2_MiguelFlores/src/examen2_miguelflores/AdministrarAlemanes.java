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
public class AdministrarAlemanes {

    private ArrayList<alemanes> listaAlemanes = new ArrayList();
    private File archivo = null;

    public AdministrarAlemanes(String Path) {
        archivo = new File(Path);
    }

    public AdministrarAlemanes() {
    }

    public ArrayList<alemanes> getListAlemanes() {
        return listaAlemanes;
    }

    public void setListaContacto(alemanes x) {
        listaAlemanes.add(x);
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void setAlemanes(alemanes p) {
        this.listaAlemanes.add(p);
    }

    public void CargarArchivo() {
        try {
            listaAlemanes = new ArrayList();
            alemanes temp;

            if (archivo.exists()) {
                FileInputStream entrada
                        = new FileInputStream(archivo);
                ObjectInputStream objeto
                        = new ObjectInputStream(entrada);
                try {
                    while ((temp = (alemanes) objeto.readObject()) != null) {
                        listaAlemanes.add(temp);
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
            for (alemanes t : listaAlemanes) {
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
