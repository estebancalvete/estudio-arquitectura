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
     * @param proyecto Proyecto a asignar el presupuesto
     * @param presupuesto Presupuesto del proyecto
     */
    public void asignarPresupuestoProyecto(Proyecto proyecto, double presupuesto)
    {
        if(getEstudio() != null) {
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
            printContableNoSistema();
        }
        
    }
    
    /**
     * Función de asignación de coste a un proyecto
     * 
     * @param proyecto Proyecto a asignar el coste
     * @param coste Coste del proyecto
     */
    public void asignarCosteProyecto(Proyecto proyecto, double coste)
    {
        if(getEstudio() != null) {
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
            printContableNoSistema();
        }
    }
    
    /**
     * Función de asignación de coste a un certificado
     * 
     * @param certificado Certificado a asignar el coste
     * @param coste Coste del certificado
     */
    public void asignarCosteCertificado(Certificado certificado, double coste)
    {
        if(getEstudio() != null) {
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
}
