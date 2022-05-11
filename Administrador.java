import java.util.ArrayList;
import java.util.Date;
/**
 * La clase Administrador modela los administradores del estudio de arquitectura y
 * hereda de la clase Empleado.
 *
 * @author Esteban Calvete Iglesias
 * @version 1.0
 */

public class Administrador extends Empleado
{
    // MARK - Campos
    
    // MARK - Constructores
    /**
     * Constructor para objetos de clase Administrador
     * 
     * @param  name Nombre del administrador
     * @param  telefono Teléfono de contacto del adminsitrador
     * 
     */
    public Administrador(String name, int telefono)
    {
        super(name, telefono, "Administrador");
    }
    
    // MARK - Métodos públicos
    /**
     * Alta propia del administrador del sistema en el estudio de arquitectura
     * 
     * @param  estudio Estudio donde se dará el alta al adminstrador
     */
    public void altaAdmin(Estudio estudio)
    {
        if(this.getEstudio() != null){
            printUsuarioYaSistema();
        } else {
            setActivo();
            setEstudio(estudio);
            getEstudio().addEmpleado(this);
            printConfirmacionAlta();
        }
    }
    
    /**
     * Alta de un empleado en el sistema
     * 
     * @param empleado Empleado a dar de alta
     */
    public void altaEmpleado(Empleado empleado)
    {
        if(getEstudio() != null){
            if(getEstudio().getEmpleados().contains(empleado)){
                printUsuarioYaSistema();
            } else {
                empleado.setEstudio(getEstudio());
                empleado.setActivo();
                getEstudio().addEmpleado(empleado);
                printConfirmacionAlta();
            }
        } else {
            printAdminNoSistema();
        }
    }
    
    /**
     * Alta de un cliente en el sistema
     * 
     * @param  cliente Cliente a dar de alta
     */
    public void altaCliente(Cliente cliente)
    {
        if(getEstudio() != null){
            if(getEstudio().getClientes().contains(cliente)){
                printUsuarioYaSistema();
            } else {
                getEstudio().addCliente(cliente);
                cliente.setActivo();
                printConfirmacionAlta();
            }
        } else {
            printAdminNoSistema();
        }
    }
    
    /**
     * Baja de un empleado en el sistema
     * 
     * @param  empleado Empleado a dar de baja en el sistema
     */
    public void bajaEmpleado(Empleado empleado)
    {
        if(getEstudio() != null){
            if(getEstudio().getEmpleados().contains(empleado)){
                empleado.removeEstudio();
                empleado.setInactivo();
                getEstudio().removeEmpleado(empleado);
                printConfirmacionBaja();
            } else {
                printUsuarioNoSistema();
            }
        } else {
            printAdminNoSistema();
        }
    }
    
    /**
     * Baja de un cliente en el sistema
     * 
     * @param  cliente Cliente a dar de baja en el sistema
     */
    public void bajaCliente(Cliente cliente)
    {
        if(getEstudio() != null){
            if(getEstudio().getClientes().contains(cliente)){
                cliente.setInactivo();
                getEstudio().removeCliente(cliente);
                printConfirmacionBaja();
            } else {
                printUsuarioNoSistema();
            }
        } else {
            printAdminNoSistema();
        }
    }
    
    /**
     * Modificación de nombre del usuario
     * 
     * @param  persona Cliente o empleado al que se le modificará el nombre
     * @param  name Nuevo nombre del usuario
     */
    public void modificaNombre(Persona persona, String name)
    {
        persona.setNombre(name);
        printConfirmacionModificacion();
    }
    
    /**
     * Modificación de número de teléfono del usuario
     * 
     * @param  persona Cliente o empleado al que se le modificará el teléfono
     * @param  telefono Nuevo número de teléfono del usuario
     */
    public void modificaTelefono(Persona persona, int telefono)
    {
        persona.setTelefono(telefono);
        printConfirmacionModificacion();
    }
    
    /**
     * Asignación de empleados a un proyecto. Se añadirá también la fecha estimada
     * de entrega del proyecto y el proyecto se considerará contratado
     * 
     * @param  proyecto Proyecto al que se asignan los empleados
     * @param  arquitecto Arquitecto a añadir al proyecto
     * @param  aparejador Aparejador a añadir al proyecto
     * @param  contable Contable a añadir al proyecto
     * @param  year Año de entrega estimada del proyecto
     * @param  month Mes de entrega estimada del proyecto
     * @param  day Día de entrega estimada del proyecto
     */
    public void asignarEmpleadosProyecto(Proyecto proyecto,
                                         Arquitecto arquitecto,
                                         Aparejador aparejador,
                                         Contable contable,
                                         int year,
                                         int month,
                                         int day)
    {
        proyecto.setEmpleadosProyecto(arquitecto, aparejador, contable,
                                      year, month, day);
    }
    
    /**
     * Asignación de empleados a un certificado. Se añadirá la fecha estimada de
     * entrega del certificado
     * 
     * @param  certificado Certificado al que se asignan los empleados
     * @param  arquitecto Arquitecto a añadir al certificado
     * @param  aparejador Aparejador a añadir al certificado
     * @param  contable Contable a añadir al certificado
     * @param  year Año de entrega estimada del certificado
     * @param  month Mes de entrega estimada del certificado
     * @param  day Día de entrega estimada del certificado
     */
    public void asignarEmpleadosCertificado(Certificado certificado,
                                            Arquitecto arquitecto,
                                            Aparejador aparejador,
                                            Contable contable,
                                            int year,
                                            int month,
                                            int day)
    {
        certificado.setEmpleadosCertificado(arquitecto, aparejador, contable,
                                            year, month, day);
    }
    
    /**
     * Visualización de datos de todas las personas registradas en el sistema
     */
    public void VisualizarPersonasRegistradas()
    {
        System.out.println("Empleados:");
        System.out.println("---------------------------------------------------");
        for(int i=0; i<getEstudio().getEmpleados().size(); i++){
            printInfoEmpleado(getEstudio().getEmpleados().get(i));
        }
        System.out.println("Clientes:");
        System.out.println("---------------------------------------------------");
        for(int i=0; i<getEstudio().getClientes().size(); i++){
            printInfoCliente(getEstudio().getClientes().get(i));
        }
    }
    
    /**
     * Visualización de clientes por aquitecto asignado a su proyecto o
     * certificado
     * 
     * @param  arquitecto Arquitecto asignado a proyecto o certificado del cliente
     */
    public void VisualizarClientesPorAqruitecto(Arquitecto arquitecto)
    {
        System.out.println("Clientes asociados al arquitecto:");
        System.out.println(arquitecto.getNumeroEmpleado() + ", "
                           + arquitecto.getName());
        System.out.println("---------------------------------------------------");
        ArrayList<Cliente> clientes = getEstudio().getClientes();
        for(int i=0; i<clientes.size(); i++){
            ArrayList<Proyecto> proyectos = clientes.get(i).getProyectos();
            for(int j=0; j<proyectos.size(); j++){
                if(proyectos.get(j).getArquitecto() == arquitecto){
                    printInfoCliente(clientes.get(i));
                }
            }
            ArrayList<Certificado> certificados = clientes.get(i).getCertificados();
            for(int j=0; j<certificados.size(); j++){
                if(certificados.get(j).getArquitecto() == arquitecto){
                    printInfoCliente(clientes.get(i));
                }
            }
        }
    }
    
    /**
     * Visualización de clientes por aparejador asignado a su proyecto o
     * certificado
     * 
     * @param  aparejador Aparejador asignado a proyecto o certificado del cliente
     */
    public void VisualizarClientesPorAparejador(Aparejador aparejador)
    {
        System.out.println("Clientes asociados al aparejador:");
        System.out.println(aparejador.getNumeroEmpleado() + ", "
                           + aparejador.getName());
        System.out.println("---------------------------------------------------");
        ArrayList<Cliente> clientes = getEstudio().getClientes();
        for(int i=0; i<clientes.size(); i++){
            ArrayList<Proyecto> proyectos = clientes.get(i).getProyectos();
            for(int j=0; j<proyectos.size(); j++){
                if(proyectos.get(j).getAparejador() == aparejador){
                    printInfoCliente(clientes.get(i));
                }
            }
            ArrayList<Certificado> certificados = clientes.get(i).getCertificados();
            for(int j=0; j<certificados.size(); j++){
                if(certificados.get(j).getAparejador() == aparejador){
                    printInfoCliente(clientes.get(i));
                }
            }
        }
    }
    
    /**
     * Visualización de viviendas/edificios y las fechas de fin de obra
     */
    public void VisualizarProyectosFechaFinObra()
    {
        ArrayList<Cliente> clientes = getEstudio().getClientes();
        System.out.println("Proyectos del estudio y su fecha de fin de obra:");
        System.out.println("---------------------------------------------------");
        for(int i=0; i<clientes.size(); i++){
            ArrayList<Proyecto> proyectos = clientes.get(i).getProyectos();
            for(int j=0; j<proyectos.size(); j++){
                printProyectoFechaFinObra(proyectos.get(j));
            }
        }
    }
    
    /**
     * Visualización de viviendas/edificios y las fechas del último certificado
     * de habitabilidad emitido.
     */
    public void printViviendaFUC()
    {
        //
    }
    
    /**
     * Visualización de proyectos y certificados por vivienda
     */
    public void printProyectosCertificadosPorVivienda()
    {
        //
    }
    
    /**
     * Visualización de la planificación de ejecución de obras, a partir de los
     * proyectos contratados en un momento determinado
     */
    public void printPlanificacionObras()
    {
        //
    }
    
    // MARK - Métodos privados
    /**
     * Método privado de impresión de mensaje de error "Administrador no dado de
     * alta en el sistema"
     */
    private void printAdminNoSistema()
    {
        System.out.println("No se ha podido realizar la gestión porque");
        System.out.println("usted no está dado de alta en el sistema.");
        System.out.println("Por favor utilice el método altaAdmin()");
    }
    
    /**
     * Método privado de impresión de mensaje de error de usuario ya dado de
     * alta en el sistema
     */
    private void printUsuarioYaSistema()
    {
        System.out.println("El usuario ya estaba dado de alta en el sistema.");
    }
    
    /**
     * Método privado de impresión de mensaje de error de usuario no dado de
     * alta en el sistema
     */
    private void printUsuarioNoSistema()
    {
        System.out.println("El usuario no estaba dado de alta en el sistema.");
    }
    
    /**
     * Método privado de impresión de mensaje de confirmación de usuario dado de
     * alta en el sistema
     */
    private void printConfirmacionAlta()
    {
        System.out.println("El usuario se ha dado de alta correctamente.");
    }
    
    /**
     * Método privado de impresión de mensaje de confirmación de usuario dado de
     * baja en el sistema
     */
    private void printConfirmacionBaja()
    {
        System.out.println("El usuario se ha dado de baja correctamente.");
    }
    
    /**
     * Método privado de impresión de mensaje de confirmación de modificación de
     * datos de usuario
     */
    private void printConfirmacionModificacion()
    {
        System.out.println("Los datos se han modificado correctamente.");
    }
    
    /**
     * Método privado de impresión de información de empleados
     * 
     * @param  empleado Empleado cuyos datos se visualizarán por pantalla
     */
    private void printInfoEmpleado(Empleado empleado){
        System.out.println("Cargo: " + empleado.getTipoEmpleado());
        System.out.println("Número de empleado: " + empleado.getNumeroEmpleado());
        System.out.println("Nombre: " + empleado.getName());
        System.out.println("Número de teléfono: " + empleado.getTelefono());
        System.out.println("---------------------------------------------------");
    }
    
    /**
     * Método privado de impresión de información de cliente
     * 
     * @param  cliente Cliente cuyos datos se visualizarán por pantalla
     */
    private void printInfoCliente(Cliente cliente){
        System.out.println("Número de cliente: " + cliente.getNumeroCliente());
        System.out.println("Nombre: " + cliente.getName());
        System.out.println("Número de teléfono: " + cliente.getTelefono());
        System.out.println("---------------------------------------------------");
    }
    
    /**
     * Método privado de impresión de proyectos y su fecha fin de obra
     * 
     * @param  proyecto Proyecto a imprimir con su fecha fin de obra
     */
    private void printProyectoFechaFinObra(Proyecto proyecto){
        System.out.println("Número de proyecto: " + proyecto.getId());
        System.out.println("Nombre de proyecto: " + proyecto.getNombre());
        if(proyecto.getFechaEntregaObra() != null){
            Date fecha = proyecto.getFechaEntregaObra();
            System.out.println("Fecha de entrega de obra: "
                               + fecha.getDay() + "/" + fecha.getMonth() + "/"
                               + fecha.getYear());
        } else {
            System.out.println("Fecha de entrega de obra aún no asignada");
        }
        System.out.println("---------------------------------------------------");
    }
}
