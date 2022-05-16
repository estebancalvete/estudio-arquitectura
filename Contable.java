import java.util.ArrayList;
/**
 * La clase Contable modela los contables del estudio de arquitectura, hereda de la
 * clase Empleado.
 *
 * @author Esteban Calvete Iglesias
 * @version 1.0
 */
public class Contable extends Empleado
{
    // MARK - Campos

    // MARK - Constructores
    /**
     * Constructor para objetos de clase Contable
     * 
     * @param  name Nombre de la persona
     * @param  telefono Teléfono de contacto
     */
    public Contable(String name, int telefono)
    {
        super(name, telefono, "Contable");
    }
    
    // MARK - Métodos públicos
    /**
     * Función de asignación de presupuesto a un proyecto
     * 
     * @param numProyecto Número del proyecto a asignar el presupuesto
     * @param presupuesto Presupuesto del proyecto
     */
    public void asignarPresupuestoProyecto(String numProyecto, double presupuesto)
    {
        if(getEstudio() != null) {
            Proyecto proyecto = getProyecto(numProyecto);
            if(proyecto != null){
                if(proyecto.getContable() != this){
                    printErrorContableAsignado();
                } else {
                    if(presupuesto > 0){
                        proyecto.setPresupuesto(presupuesto);
                        printConfirmacion();
                    } else {
                        printErrorCantidad();
                    }
                }
            } else {
                printErrorProyecto();
            }
        } else {
            printContableNoSistema();
        }
        
    }
    
    /**
     * Función de asignación de coste a un proyecto
     * 
     * @param numProyecto Número del proyecto a asignar el coste
     * @param coste Coste del proyecto
     */
    public void asignarCosteProyecto(String numProyecto, double coste)
    {
        if(getEstudio() != null) {
            Proyecto proyecto = getProyecto(numProyecto);
            if(proyecto != null){
                if(proyecto.getContable() != this){
                    printErrorContableAsignado();
                } else {
                    if(coste > 0){
                        proyecto.setCoste(coste);
                        printConfirmacion();
                    } else {
                        printErrorCantidad();
                    }
                }
            } else {
                printErrorProyecto();
            }
        } else {
            printContableNoSistema();
        }
    }
    
    /**
     * Función de asignación de coste a un certificado
     * 
     * @param numCertificado Número del certificado a asignar el coste
     * @param coste Coste del certificado
     */
    public void asignarCosteCertificado(String numCertificado, double coste)
    {
        if(getEstudio() != null) {
            Certificado certificado = getCertificado(numCertificado);
            if(certificado != null){
                if(certificado.getContable() != this){
                    printErrorContableAsignado();
                } else {
                    if(coste > 0){
                        certificado.setCoste(coste);
                        printConfirmacion();
                    } else {
                        printErrorCantidad();
                    }
                }
            } else {
                printErrorCertificado();
            }
        } else {
            printContableNoSistema();
        }
    }
    
    /**
     * Función de visualización por pantalla de los datos de los clientes
     * asociados
     */
    public void visualizarDatosClientesAsociados()
    {
        if(getEstudio() != null) {
            ArrayList<Proyecto> proyectosAsignados = new ArrayList<Proyecto>();
            ArrayList<Certificado> certificadosAsignados = new
                                                        ArrayList<Certificado>();
            ArrayList<Cliente> clientes = getEstudio().getClientes();
            if(clientes.size() == 0){
                System.out.println("Usted aún no tiene ningún cliente asociado");
            }
            for(int i=0; i<clientes.size(); i++){
                ArrayList<Proyecto> proyectos = getEstudio().getClientes()
                                                        .get(i).getProyectos();
                proyectosAsignados = getProyectosAsignados(proyectos);
                ArrayList<Certificado> certificados = getEstudio().getClientes()
                                                        .get(i).getCertificados();
                certificadosAsignados = getCertificadosAsignados(certificados);
                printDatosProyectoAsignado(proyectosAsignados);
                printDatosCertificadoAsignado(certificadosAsignados);
            }
        } else {
            printContableNoSistema();
        }
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
                if(proyectoAComparar.getId().equals(numero)){
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
                if(certificadoAComparar.getId().equals(numero)){
                    certificado = certificadoAComparar;
                }
            }
        }
        return certificado;
    }
    
    /**
     * Función auxiliar de retorno de ArrayList de proyectos asignados a partir
     * de un ArrayList de proyectos
     * 
     * @param proyectos ArrayList de proyectos
     * 
     * @return ArrayList de proyectos asignados
     */
    private ArrayList<Proyecto> getProyectosAsignados(ArrayList<Proyecto>
                                                                        proyectos)
    {
        ArrayList<Proyecto> asignados = new ArrayList<Proyecto>();
        for(int i=0; i<proyectos.size(); i++){
            Proyecto proyecto = proyectos.get(i);
            if(proyecto.getContable() == this){
                asignados.add(proyecto);
            }
        }
        return asignados;
    }
    
    /**
     * Función auxiliar de retorno de ArrayList de certificados asignados a partir
     * de un ArrayList de certificados
     * 
     * @param certificados ArrayList de certificados
     * 
     * @return ArrayList de certificados asignados
     */
    private ArrayList<Certificado> getCertificadosAsignados(ArrayList<Certificado>
                                                                     certificados)
    {
        ArrayList<Certificado> asignados = new ArrayList<Certificado>();
        for(int i=0; i<certificados.size(); i++){
            Certificado certificado = certificados.get(i);
            if(certificado.getContable() == this){
                asignados.add(certificado);
            }
        }
        return asignados;
    }
    
    /**
     * Printer de error de contable no asignado
     */
    private void printErrorContableAsignado()
    {
        System.out.println("No se ha podido realizar la gestión porque");
        System.out.println("usted no es el contable asignado.");
    }
    
    /**
     * Printer de error cantidad errónea
     */
    private void printErrorCantidad()
    {
        System.out.println("No se ha podido realizar la gestión porque");
        System.out.println("el importe introducido no es válido.");
    }
    
    /**
     * Printer de datos de clientes con proyecto asignado
     */
    private void printDatosProyectoAsignado(ArrayList<Proyecto> proyectos)
    {
        System.out.println("Proyectos asignados:");
        System.out.println("-----------------------------------------------");
        for(int i=0; i<proyectos.size(); i++){
            Proyecto proyecto = proyectos.get(i);
            Cliente cliente = proyecto.getCliente();
            if(proyecto.getFinalizado()){
                System.out.println("Proyecto ya finalizado:");
            } else {
                System.out.println("Proyecto aún en ejecución:");
            }
            System.out.println("Número Proyecto: " + proyecto.getId());
            System.out.println("Nombre Proyecto: " + proyecto.getNombre());
            System.out.println("Número Cliente: " + cliente.getNumeroCliente());
            System.out.println("Nombre Cliente: " + cliente.getName());
            System.out.println("-----------------------------------------------");
        }
    }
    
    /**
     * Printer de datos de clientes con certificado asignado
     */
    private void printDatosCertificadoAsignado(ArrayList<Certificado> certificados)
    {
        System.out.println("Certificados asignados:");
        System.out.println("-----------------------------------------------");
        for(int i=0; i<certificados.size(); i++){
            Certificado certificado = certificados.get(i);
            Cliente cliente = certificado.getCliente();
            Proyecto proyecto = certificado.getProyecto();
            System.out.println("Número Certificado: " + certificado.getId());
            System.out.println("Tipo Certificado: " + certificado.getTipo());
            System.out.println("Número Proyecto: " + proyecto.getId());
            System.out.println("Nombre Proyecto: " + proyecto.getNombre());
            System.out.println("Número Cliente: " + cliente.getNumeroCliente());
            System.out.println("Nombre Cliente: " + cliente.getName());
            System.out.println("-----------------------------------------------");
        }
    }
    
    /**
     * Printer de mensaje de error "Contable no dado de alta en el sistema"
     */
    private void printContableNoSistema()
    {
        System.out.println("No se ha podido realizar la gestión porque");
        System.out.println("usted no está dado de alta en el sistema.");
    }
    
    /**
     * Printer de mensaje de confirmación de gestión realizada
     */
    private void printConfirmacion()
    {
        System.out.println("La gestión solicitada se ha realizado con éxito");
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
