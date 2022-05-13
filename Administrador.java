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
     * @param name Nombre del administrador
     * @param telefono Teléfono de contacto del adminsitrador
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
     * @param estudio Estudio donde se dará el alta al adminstrador
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
     * @param cliente Cliente a dar de alta
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
     * @param empleado Empleado a dar de baja en el sistema
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
     * @param cliente Cliente a dar de baja en el sistema
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
     * @param persona Cliente o empleado al que se le modificará el nombre
     * @param name Nuevo nombre del usuario
     */
    public void modificaNombre(Persona persona, String name)
    {
        if(getEstudio() != null){
            persona.setName(name);
            printConfirmacionModificacion();
        } else {
            printAdminNoSistema();
        }
    }
    
    /**
     * Modificación de número de teléfono del usuario
     * 
     * @param persona Cliente o empleado al que se le modificará el teléfono
     * @param telefono Nuevo número de teléfono del usuario
     */
    public void modificaTelefono(Persona persona, int telefono)
    {
        if(getEstudio() != null){
            persona.setTelefono(telefono);
            printConfirmacionModificacion();
        } else {
            printAdminNoSistema();
        }
    }
    
    /**
     * Asignación de empleados a un proyecto, el proyecto se considera contratado
     * 
     * @param numProyecto Número del proyecto al que se asignan los empleados
     * @param arquitecto Arquitecto a añadir al proyecto
     * @param aparejador Aparejador a añadir al proyecto
     * @param contable Contable a añadir al proyecto
     */
    public void asignarEmpleadosProyecto(String numProyecto,
                                         Arquitecto arquitecto,
                                         Aparejador aparejador,
                                         Contable contable)
    {
        if(getEstudio() != null){
            Proyecto proyecto = getProyecto(numProyecto);
            if(proyecto != null){
                proyecto.setEmpleadosProyecto(arquitecto, aparejador, contable);
                printConfirmacionEmpleados();
            } else {
                printErrorProyecto();
            }
        } else {
            printAdminNoSistema();
        }
    }
    
    /**
     * Asignación de empleados a un certificado
     * 
     * @param numCertificado Número del certificado al que se asignan empleados
     * @param arquitecto Arquitecto a añadir al certificado
     * @param aparejador Aparejador a añadir al certificado
     * @param contable Contable a añadir al certificado
     */
    public void asignarEmpleadosCertificado(String numCertificado,
                                            Arquitecto arquitecto,
                                            Aparejador aparejador,
                                            Contable contable)
    {
        if(getEstudio() != null){
            Certificado certificado = getCertificado(numCertificado);
            if(certificado != null){
                certificado.setEmpleadosCertificado(arquitecto, aparejador,
                                                    contable);
                printConfirmacionEmpleados();
            } else {
                printErrorCertificado();
            }
        } else {
            printAdminNoSistema();
        }
    }
    
    /**
     * Visualización de datos de todas las personas registradas en el sistema
     */
    public void VisualizarPersonasRegistradas()
    {
        if(getEstudio() != null){
            System.out.println("Empleados:");
            System.out.println("-----------------------------------------------");
            for(int i=0; i<getEstudio().getEmpleados().size(); i++){
                printInfoEmpleado(getEstudio().getEmpleados().get(i));
            }
            System.out.println("Clientes:");
            System.out.println("-----------------------------------------------");
            for(int i=0; i<getEstudio().getClientes().size(); i++){
                printInfoCliente(getEstudio().getClientes().get(i));
            }
        } else {
            printAdminNoSistema();
        }
    }
    
    /**
     * Visualización de clientes por aquitecto asignado a su proyecto o
     * certificado
     * 
     * @param arquitecto Arquitecto asignado a proyecto o certificado del cliente
     */
    public void VisualizarClientesPorAqruitecto(Arquitecto arquitecto)
    {
        if(getEstudio() != null){
            System.out.println("Clientes asociados al arquitecto:");
            System.out.println(arquitecto.getNumeroEmpleado() + ", "
                               + arquitecto.getName());
            System.out.println("-----------------------------------------------");
            ArrayList<Cliente> clientes = getEstudio().getClientes();
            for(int i=0; i<clientes.size(); i++){
                ArrayList<Proyecto> proyectos = clientes.get(i).getProyectos();
                for(int j=0; j<proyectos.size(); j++){
                    if(proyectos.get(j).getArquitecto() == arquitecto){
                        printInfoCliente(clientes.get(i));
                    }
                }
                ArrayList<Certificado> certificados = clientes.get(i)
                                                          .getCertificados();
                for(int j=0; j<certificados.size(); j++){
                    if(certificados.get(j).getArquitecto() == arquitecto){
                        printInfoCliente(clientes.get(i));
                    }
                }
            }
        } else {
            printAdminNoSistema();
        }
    }
    
    /**
     * Visualización de clientes por aparejador asignado a su proyecto o
     * certificado
     * 
     * @param aparejador Aparejador asignado a proyecto o certificado del cliente
     */
    public void VisualizarClientesPorAparejador(Aparejador aparejador)
    {
        if(getEstudio() != null){
            System.out.println("Clientes asociados al aparejador:");
            System.out.println(aparejador.getNumeroEmpleado() + ", "
                               + aparejador.getName());
            System.out.println("-----------------------------------------------");
            ArrayList<Cliente> clientes = getEstudio().getClientes();
            for(int i=0; i<clientes.size(); i++){
                ArrayList<Proyecto> proyectos = clientes.get(i).getProyectos();
                for(int j=0; j<proyectos.size(); j++){
                    if(proyectos.get(j).getAparejador() == aparejador){
                        printInfoCliente(clientes.get(i));
                    }
                }
                ArrayList<Certificado> certificados = clientes.get(i)
                                                          .getCertificados();
                for(int j=0; j<certificados.size(); j++){
                    if(certificados.get(j).getAparejador() == aparejador){
                        printInfoCliente(clientes.get(i));
                    }
                }
            }
        } else {
            printAdminNoSistema();
        }
    }
    
    /**
     * Visualización de viviendas/edificios y las fechas de fin de obra
     */
    public void visualizarProyectosFechaFinObra()
    {
        if(getEstudio() != null){
            System.out.println("Proyectos del estudio y su fecha de fin de obra:");
            System.out.println("------------------------------------------------");
            ArrayList<Cliente> clientes = getEstudio().getClientes();
            for(int i=0; i<clientes.size(); i++){
                ArrayList<Proyecto> proyectos = clientes.get(i).getProyectos();
                for(int j=0; j<proyectos.size(); j++){
                    printProyectoFechaFinObra(proyectos.get(j));
                }
            }
        } else {
            printAdminNoSistema();
        }
    }
    
    /**
     * Visualización de viviendas/edificios y las fechas del último certificado
     * de habitabilidad emitido.
     */
    public void visualizarProyectosFechaUltimoCertificadoHabitabilidad()
    {
        if(getEstudio() != null){
            System.out.println("Proyectos residenciales del estudio y fecha de");
            System.out.println("su último certificado de habitabilidad:");
            System.out.println("----------------------------------------------");
            ArrayList<Cliente> clientes = getEstudio().getClientes();
            for(int i=0; i<clientes.size(); i++){
                ArrayList<Proyecto> proyectos = clientes.get(i).getProyectos();
                ArrayList<Proyecto> proyectosResidenciales = filterResidenciales(
                                                                 proyectos);
                for(int j=0; j<proyectosResidenciales.size(); j++){
                    Proyecto proyecto = proyectosResidenciales.get(j);
                    Certificado ultimoHabita = getUltimoHabitabilidad(proyecto);
                    if(ultimoHabita != null){
                        printProyectoFechaCertificado(ultimoHabita);
                    } else {
                        printProyectoNoTieneCertificado(proyecto);
                    }
                }
            }
        } else {
            printAdminNoSistema();
        }
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
     * Función auxiliar de obtención de proyecto a partir del número de proyecto
     * 
     * @param numero String de número de proyecto, por ejemplo "PRO-16"
     * 
     * @return Proyecto correspondiente al número introducido
     */
    private Proyecto getProyecto(String numero)
    {
        Proyecto proyecto = null;
        for(int i=0; i<getEstudio().getClientes().size(); i++){
            Cliente cliente = getEstudio().getClientes().get(i);
            for(int j=0; j<cliente.getProyectos().size(); j++){
                Proyecto proyectoAComparar = cliente.getProyectos().get(j);
                if(proyectoAComparar.getId() == numero){
                    proyecto = proyectoAComparar;
                }
            }
        }
        return proyecto;
    }
    
    /**
     * Función auxiliar de obtención de certificado a partir del número de
     * certificado
     * 
     * @param numero String de número de certificado, por ejemplo "CER-27"
     * 
     * @return Certificado correspondiente al número introducido
     */
    private Certificado getCertificado(String numero)
    {
        Certificado certificado = null;
        for(int i=0; i<getEstudio().getClientes().size(); i++){
            Cliente cliente = getEstudio().getClientes().get(i);
            for(int j=0; j<cliente.getCertificados().size(); j++){
                Certificado certificadoAComparar = cliente.getCertificados().get(j);
                if(certificadoAComparar.getId() == numero){
                    certificado = certificadoAComparar;
                }
            }
        }
        return certificado;
    }
    
    /**
     * Función auxiliar para el filtrado de proyectos residenciales a partir de
     * un ArrayList de proyectos
     * 
     * @param proyectos ArrayList de proyectos
     * 
     * @return ArrayList de proyectos residenciales
     */
    private ArrayList<Proyecto> filterResidenciales(ArrayList<Proyecto> proyectos)
    {
        ArrayList<Proyecto> residenciales = new ArrayList<Proyecto>();
        for(int i=0; i<proyectos.size(); i++){
            if(proyectos.get(i).getEsResidencial()){
                residenciales.add(proyectos.get(i));
            }
        }
        return residenciales;
    }
    
    /**
     * Función auxiliar obtiene el último certificado de habitabilidad a partir de
     * un proyecto residencial dado. Si el proyecto no tiene aún certificado
     * devuelve null.
     * 
     * @param proyecto Proyecto del que se obtienen certificados de habitabilidad
     * 
     * @return ArrayList de certificaods de habitabilidad
     */
    private Certificado getUltimoHabitabilidad(Proyecto proyecto)
    {
        ArrayList<Certificado> certificados = proyecto.getCertificados();
        ArrayList<Certificado> certs = new ArrayList<Certificado>();
        for(int i=0; i<certificados.size(); i++){
            if(certificados.get(i).getTipo() == "Habitabilidad"){
                certs.add(certificados.get(i));
            }
        }
        ArrayList<Certificado> expedidos = new ArrayList<Certificado>();
        for(int i=0; i<certs.size(); i++){
            if(certs.get(i).getEntregado()){
                expedidos.add(certs.get(i));
            }
        }
        if(certs.size() > 0){
            int lastIndex = certs.size() - 1;
            return certs.get(lastIndex);
        } else {
            return null;
        }
    }
    
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
     * @param empleado Empleado cuyos datos se visualizarán por pantalla
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
     * @param cliente Cliente cuyos datos se visualizarán por pantalla
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
     * @param proyecto Proyecto a imprimir con su fecha fin de obra
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
    
    /**
     * Método privado de impresión de información de proyecto residencial con la
     * fecha de su último certificado de habitabilidad.
     * 
     * @param certificado Último certificado de habitabilidad de un proyecto dado
     */
    private void printProyectoFechaCertificado(Certificado certificado){
        Cliente cliente = certificado.getCliente();
        Proyecto proyecto = certificado.getProyecto();
        Date fechaEmision = certificado.getFechaEmision();
        System.out.println("Número de cliente: " + cliente.getNumeroCliente());
        System.out.println("Nombre de cliente: " + cliente.getName());
        System.out.println("Teléfono de cliente: " + cliente.getTelefono());
        System.out.println("Número de proyecto: " + proyecto.getId());
        System.out.println("Nombre de proyecto: " + cliente.getName());
        System.out.println("Número de certificao: " + certificado.getId());
        System.out.println("Fecha de último certificado de habitabilidad:");
        System.out.println(fechaEmision.getDay() + "/" + fechaEmision.getMonth()
                           + "/" + fechaEmision.getYear());
        System.out.println("---------------------------------------------------");
    }
    
    /**
     * Método privado de impresión de información de proyecto residencial con la
     * fecha de su último certificado de habitabilidad.
     * 
     * @param certificado Último certificado de habitabilidad de un proyecto dado
     */
    private void printProyectoNoTieneCertificado(Proyecto proyecto){
        Cliente cliente = proyecto.getCliente();
        System.out.println("Número de cliente: " + cliente.getNumeroCliente());
        System.out.println("Nombre de cliente: " + cliente.getName());
        System.out.println("Teléfono de cliente: " + cliente.getTelefono());
        System.out.println("Número de proyecto: " + proyecto.getId());
        System.out.println("Nombre de proyecto: " + cliente.getName());
        System.out.println("ESTE PROYECTO RESIDENCIAL AÚN NO TIENE NINGÚN");
        System.out.println("CERTIFICADO DE HABITABILIDAD EXPEDIDO.");
        System.out.println("---------------------------------------------------");
    }
    
    /**
     * Printer de confirmación de empleados asignados con éxito
     */
    private void printConfirmacionEmpleados()
    {
        System.out.println("Los empleados se han asignado con éxito");
    }
    
    /**
     * Printer de error de proyecto no encontrado
     */
    private void printErrorProyecto()
    {
        System.out.println("No se ha encontrado proyecto con el número indicado");
    }
    
    /**
     * Printer de error de certificado no encontrado
     */
    private void printErrorCertificado()
    {
        System.out.println("No se ha encontrado certificado con el num. indicado");
    }
}
