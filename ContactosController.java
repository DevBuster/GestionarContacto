package controlador;

import java.util.ArrayList;
import modelo.Contacto;

/**
 *
 * @author DevBuster
 */
public class ContactosController {

    public static ArrayList<Contacto> listaContacto;
    private int secuenciaID = 0;

    public ContactosController() {
        listaContacto = new ArrayList<>();
        listaContacto.add(new Contacto(secuenciaID, "Dev", "Buster", 123456789));
        secuenciaID++;
    }

    public Object[][] listarContactos() {
        Object tabla[][] = new Object[listaContacto.size()][4];
        int j = 0;

        for (Contacto i : listaContacto) {
            tabla[j][0] = i.getId();
            tabla[j][1] = i.getNombre();
            tabla[j][2] = i.getApellido();
            tabla[j][3] = i.getTelefono();
            j++;
        }
        return tabla;
    }

    public void agregarContacto(String nombre, String apellido, int telefono) {
        Contacto contacto = new Contacto(secuenciaID, nombre, apellido, telefono);
        listaContacto.add(contacto);
        secuenciaID++;
    }

    public String modificarContacto(int id, String nombre, String apellido, int telefono) {

        String info = "";
        for (Contacto i : listaContacto) {

            if (i.getId() == id) {
                i.setNombre(nombre);
                i.setApellido(apellido);
                i.setTelefono(telefono);
                info = "Modificado con exito";
                break;
            } else {
                info = "No se encontro el contacto a modificar";
            }
        }
        return info;
    }

    public String eliminarContacto(int id) {
        String Info = "";
        for (int i = 0; i < listaContacto.size(); i++) {
            if (listaContacto.get(i).getId() == id) {

                listaContacto.remove(id);
                Info = "ELiminado con exito";
                break;

            } else {
                Info = "No se encontro el contacto a eliminar";
            }
        }
        return Info;
    }

    public Object[][] obtenerPorId(int id) {
        Object tabla[][] = new Object[1][5];

        for (Contacto i : listaContacto) {
            if (i.getId() == id) {
                tabla[0][0] = i.getId();
                tabla[0][1] = i.getNombre();
                tabla[0][2] = i.getApellido();
                tabla[0][3] = i.getTelefono();
            }
        }
        return tabla;
    }
}
