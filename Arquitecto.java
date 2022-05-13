
/**
 * La clase Arquitecto modela los arquitectos del estudio de arquitectura y hereda
 * de la clase Empleado.
 *
 * @author Esteban Calvete Iglesias
 * @version 1.0
 */
public class Arquitecto extends Empleado
{
    // MARK - Campos
    
    // MARK - Constructores
    /**
     * Constructor para objetos de clase Arquitecto
     * 
     * @param  name nombre de la persona
     * @param  telefono Teléfono de contacto
     */
    public Arquitecto(String name, int telefono)
    {
        super(name, telefono, "Arquitecto");
    }

    // MARK - Métodos públicos
    /**
     * Método de entrega de proyecto
     * 
     * @param proyecto Proyecto a entregar
     * @param year Año de entrega del proyecto
     * @param month Mes de entrega del proyecto
     * @param day Día de entrega del proyecto
     */
    public void entregarProyecto(Proyecto proyecto, int year, int month, int day)
    {
        if(getEstudio() != null) {
            if(proyecto.getArquitecto() != this){
                printErrorArquitectoAsignado();
            } else {
                proyecto.setFechaEntregaProyecto(year, month, day);
                printConfirmacion();
            }
        } else {
            printArquitectoNoSistema();
        }
    }
    
    /**
     * Visualización de datos clientes asignados
     */
    public void printClientesAsignados()
    {
        //
    }
    
    // MARK - Métodos privados
    /**
     * Printer de mensaje de error "Arquitecto no dado de alta en el sistema"
     */
    private void printArquitectoNoSistema()
    {
        System.out.println("No se ha podido realizar la gestión porque");
        System.out.println("usted no está dado de alta en el sistema.");
    }
    
    /**
     * Printer de error de arquitecto no asignado
     */
    private void printErrorArquitectoAsignado()
    {
        System.out.println("No se ha podido realizar la gestión porque");
        System.out.println("usted no es el arquitecto asignado.");
    }
    
    /**
     * Printer de mensaje de confirmación de gestión realizada
     */
    private void printConfirmacion()
    {
        System.out.println("La gestión solicitada se ha realizado con éxito");
    }
}
