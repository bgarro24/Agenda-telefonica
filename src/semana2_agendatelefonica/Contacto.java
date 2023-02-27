/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana2_agendatelefonica;

import static semana2_agendatelefonica.Semana2_AgendaTelefonica.BaseDatos;

/**
 *
 * @author ferna
 */
public class Contacto {

    //Paso 1: Declarar los atributos o propiedades del contacto. 
    private int Id;
    private String Nombre;
    private String Apellidos;
    private String Telefono;

    //Paso 2: Creación de los métodos GET Y SET
    //Get: Obtiene datos de la lista.
    //Set: Asigna datos a la lista.
    //Iniciamos con los métodos get - uno por cada atributo.
    public int getId() {
        return Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getTelefono() {
        return Telefono;
    }

    //Iniciamos con los métodos set - uno por cada atributo.
    public void setId(int id) {
        this.Id = id;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.Apellidos = apellidos;
    }

    public void setTelefono(String telefono) {
        this.Telefono = telefono;
    }

    //Paso 3: Construcción de los constructores | Vacio | Id | Todos los atributos
    //Primer Constructor: Instancia plana y lo podemos utilizar en el orden que queramos. 
    public Contacto() {
    }

    //Segundo Constructor Id: Consultas a Id o identificadores.
    public Contacto(int id) {
        this.Id = id;
    }

    //Tercer Constructor todos los atributos: manejar los datos en orden
    public Contacto(int id, String nombre, String apellidos, String telefono) {
        this.Id = id;
        this.Nombre = nombre;
        this.Apellidos = apellidos;
        this.Telefono = telefono;
    }

    //Paso 4: Creación de métodos - Funcionalidad de la clase.
    //Método 1: Guardar Contacto
    public boolean Guardar() {
        //Vamos a crear una variable booleana que se llama guardado y funciona para guardar la información.
        boolean Guardado = false;
        this.setId(BaseDatos.size() + 1);//Incrementamos el id.
        Guardado = BaseDatos.add(this);//Guardamos la información de guardado en el arraylist BaseDatos.
        return Guardado;//Retornamos la variable limpia para utilizarla y guardar información nuevamente.
    }

    //Método 2: Modificar Contacto.
    public boolean Editar() {
        //Vamos crear una variable booleana que se llama editado y funciona para editar la información.
        boolean Editado = false;
        for (Contacto Fila : BaseDatos) {//Objeto Fila trae la info del arraylist BaseDatos.
            if (Fila.getId() == this.getId()) {//Validamos que los id sean iguales.
                //El fila.getId() trae el id de BaseDatos y lo iguala o compara al id que estamos ingresando.
                Fila.setNombre(this.getNombre());//Cambiamos al nombre ingresado.
                Fila.setApellidos(this.getApellidos());//Cambiamos a los apellidos ingresados.
                Fila.setTelefono(this.getTelefono());//Cambiamos al teléfono ingresado.
                Editado = true;//Si editado es igual a true se editaron los datos.
                break;//Detenemos el ciclo para que no siga editando el contacto.
            }

        }
        return Editado;//Retornamos la variable para poder modificar otro contacto.
    }

    //Método 3: Consultar Contacto.
    public Contacto Consultar() {
        //Vamos a crear un objeto que se llama consultado y funciona para obtener o consultar la información.
        Contacto Consultado = null;//Mi objeto consultado funciona para consultar la información.
        for (Contacto Fila : BaseDatos) {//El objeto Fila trae la info del arraylist BaseDatos.
            if (Fila.getId() == this.getId()) {//Validamos que los id sean iguales.
                //El fila.getId() trae el id de BaseDatos y lo iguala o compara al id que estamos ingresando. 
                //Si los id son iguales me van a mostrar la información consultada.
                Consultado = Fila;//Consultado va a ser igual a la información obtenida por Fila en BaseDatos.
                break;//Detenemos el ciclo para que no se siga consultando el mismo contacto.
            }
        }
        return Consultado;//Retornamos la variable para poder consultar otro contacto.
    }

    //Método 4: Listar Contacto.
    public String Listar() {
        String Contenido = "Lista de Contactos \n";//Declaramos la variable contenido con el titulo.
        for (Contacto Fila : BaseDatos) {//El objeto Fila trae la info del arraylist BaseDatos.
            Contenido += "Id:" + Fila.getId() + "\n"
                    + "Nombre:" + Fila.getNombre() + " " + Fila.getApellidos() + "\n" //Concatenamos el nombre y apellidos.
                    + "Teléfono:" + Fila.getTelefono() + "\n";
        }
        return Contenido;
    }
}
