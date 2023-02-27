/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semana2_agendatelefonica;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ferna
 */
public class Semana2_AgendaTelefonica {

    //Un arraylist es una clase que permite almacenar datos o información en la memoria.
    //Vamos a guardar temporalmente los contactos en BaseDatos que es el arraylist.
    public static ArrayList<Contacto> BaseDatos = new ArrayList<>();

    public static void main(String[] args) {
        //Vamos a crear una variable menu que va a contener la interfaz del menu principal.
        String Menu = "*** Bienvenido a la agenda teléfonica ***\n"//Titulo.
                + "1. Guardar Contacto. \n"
                + "2. Editar Contacto. \n"
                + "3. Consultar Contacto. \n"
                + "4. Listar Contactos. \n"
                + "5. Salir.";
        //Creamos una variable opcion para ingresar las opciones del menu.
        int Opcion;
        do {
            Opcion = Integer.parseInt(JOptionPane.showInputDialog(Menu));
            //Vamos a crear un objeto vacio que nos va a permitir ingresar a la clase contacto.
            Contacto myContacto = null;
            //Vamos a crear las variables vacias con las que vamos a pedir la información.
            int id = 0;
            String nombre;
            String apellidos;
            String telefono;
            //Creamos el switch que contiene las opciones del menu 
            switch (Opcion) {
                case 1://Guardar Contacto
                    nombre = JOptionPane.showInputDialog("Ingrese el nombre del contacto.");
                    apellidos = JOptionPane.showInputDialog("Ingrese los apellidos del contacto.");
                    telefono = JOptionPane.showInputDialog("Ingrese el número de teléfono del contacto.");
                    //Pasos para guardar el contacto.
                    //Paso 1: Llamar al constructor y asignarlo al objeto myContacto.
                    myContacto = new Contacto(id, nombre, apellidos, telefono);
                    //Paso 2: Creamos una variable booleana llamada guardado.
                    boolean Guardado = myContacto.Guardar();//Aqui guardamos el contacto.
                    if (Guardado) {//Validamos si se guardo o no se guardo el contacto.
                        JOptionPane.showMessageDialog(null, "Contacto agregado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "El contacto no se guardo, intentelo nuevamente.");
                    }
                    break;
                case 2: //Editar Contacto
                    id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del contacto"));
                    //Llamamos al constructor del id y lo asignamos al objeto myContacto.
                    myContacto = new Contacto(id);
                    //Por medio del objeto myContacto vamos a buscar o consultar el contacto.
                    myContacto = myContacto.Consultar();//Consultar el contacto.
                    if (myContacto != null) {//Si es diferente de null vamos a proceder a editar el contacto
                        //Vamos a pedir los nuevos datos para editar el contacto.
                        nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre.");
                        apellidos = JOptionPane.showInputDialog("Ingrese los nuevos apellidos.");
                        telefono = JOptionPane.showInputDialog("Ingrese el nuevo teléfono.");
                        //Llamamos al constructor y se lo asignamos a myContacto.
                        myContacto = new Contacto(id, nombre, apellidos, telefono);
                        //Creamos una variable editado para verificar si se edita o no el contacto.
                        boolean Editado = myContacto.Editar();//Aqui se edita el contacto.
                        if (Editado) {//Validamos si se edito o no el contacto.
                            JOptionPane.showMessageDialog(null, "Contacto editado exitosamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "El contacto no se edito, intentelo nuevamente.");
                        }
                    }
                    break;
                case 3: //Consultar Contacto.
                    id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del contacto"));
                    //Llamamos al constructor del id y lo asignamos al objeto myContacto.
                    myContacto = new Contacto(id);
                    //Por medio del objeto myContacto vamos a buscar o consultar el contacto.
                    myContacto = myContacto.Consultar();//Consultar el contacto.
                    if (myContacto != null) {//Si es diferente de null vamos a proceder a consultar el contacto
                        String Contenido = "Id:" + myContacto.getId() + "\n"
                                + "Nombre:" + myContacto.getNombre() + " " + myContacto.getApellidos() + "\n" //Concatenamos el nombre y apellidos.
                                + "Teléfono:" + myContacto.getTelefono();
                        JOptionPane.showMessageDialog(null, Contenido);//Mostramos la variable contenido.
                    } else {
                        JOptionPane.showMessageDialog(null, "El contacto no existe.");
                    }
                    break;
                case 4: //Listar Contactos.
                    //Instanciamos al constructor vacio.
                    myContacto = new Contacto();
                    //Asignamos la variable contactos al metodo listar.
                    String Contactos = myContacto.Listar();
                    //Mostramos todos los contactos existentes.
                    JOptionPane.showMessageDialog(null, Contactos);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "La opción ingresada no existe, intentelo nuevamente.");
            }
        } while (Opcion < 5);
    }

}
