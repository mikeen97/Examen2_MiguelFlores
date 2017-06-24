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
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Edwin Mejia
 */
public class AdministrarRusos implements Serializable {
    
    private ArrayList<rusos> listaRusos = new ArrayList();
    private File archivo = null;

    public AdministrarRusos(String Path) {
        archivo = new File(Path);
    }

    public AdministrarRusos() {
    }

    public ArrayList<rusos> getListRusos() {
        return listaRusos;
    }

    public void setListaContacto(rusos x) {
        listaRusos.add(x);
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void setRusos(rusos p) {
        this.listaRusos.add(p);
    }

    public void CargarArchivo() {
        try {
            listaRusos = new ArrayList();
            rusos temp;

            if (archivo.exists()) {
                FileInputStream entrada
                        = new FileInputStream(archivo);
                ObjectInputStream objeto
                        = new ObjectInputStream(entrada);
                try {
                    while ((temp = (rusos) objeto.readObject()) != null) {
                        listaRusos.add(temp);
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
            for (rusos t : listaRusos) {
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
