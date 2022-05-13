
/**
 * La clase Aparejador modela los aparejadores del estudio de arquitectura y
 * hereda de la clase Empleado.
 *
 * @author Esteban Calvete Iglesias
 * @version 1.0
 */
public class Aparejador extends Empleado
{
    // MARK - Campos

    // MARK - Constructores
    /**
     * Constructor para objetos de clase Aparejador
     * 
     * @param  name nombre de la persona
     * @param  telefono Teléfono de contacto
     */
    public Aparejador(String name, int telefono)
    {
        super(name, telefono, "Aparejador");  
    }
    
    // MARK - Métodos públicos
    /**
     * Método de inicición de obra
     * 
     * @param proyecto Proyecto asociado al inicio de obra
     * @param year Año de inicio de obra
     * @param month Mes de inicio de obra
     * @param day Día de inicio de obra
     * @param duracion Duración prevista de obra
     */
    public void iniciarObra(Proyecto proyecto, int year, int month, int day,
                            int duracion)
    {
        if(getEstudio() != null) {
            if(proyecto.getAparejador() != this){
                printErrorAparejadorAsignado();
            } else {
                if(proyecto.getFechaEntregaProyecto() != null){
                    if(duracion > 0){
                        proyecto.setFechaInicioObra(year, month, day);
                        proyecto.setDuracionPrevista(duracion);
                        printConfirmacion();
                    } else {
                        printErrorDuracion();
                    }
                } else {
                    printErrorProyectoNoEntregado();
                }
            }
        } else {
            printAparejadorNoSistema();
        }
    }
    
    /**
     * Método de entrega de obra
     * 
     * @param proyecto Proyecto asociado a la obra
     * @param year Año de entrega de obra
     * @param month Mes de entrega de obra
     * @param day Día de entrega de obra
     */
    public void entregarObra(Proyecto proyecto, int year, int month, int day)
    {
        if(getEstudio() != null) {
            if(proyecto.getAparejador() == this){
                if(proyecto.getFechaInicioObra() != null){
                    proyecto.setFechaEntregaObra(year, month, day);
                    proyecto.setEstaFinalizado();
                    printConfirmacion();
                } else {
                    printErrorNoIniciado();
                }
            } else {
                printErrorAparejadorAsignado();
            }
        } else {
            printAparejadorNoSistema();
        }
    }
    
    // MARK - Métodos privados
    /**
     * Printer de mensaje de error "Aparejador no dado de alta en el sistema"
     */
    private void printAparejadorNoSistema()
    {
        System.out.println("No se ha podido realizar la gestión porque");
        System.out.println("usted no está dado de alta en el sistema.");
    }
    
    /**
     * Printer de error de aparejador no asignado
     */
    private void printErrorAparejadorAsignado()
    {
        System.out.println("No se ha podido realizar la gestión porque");
        System.out.println("usted no es el aparejador asignado.");
    }
    
    /**
     * Printer de error duracion errónea
     */
    private void printErrorDuracion()
    {
        System.out.println("No se ha podido realizar la gestión porque");
        System.out.println("la duración introducida no es válida.");
    }
    
    /**
     * Printer de mensaje de confirmación de gestión realizada
     */
    private void printConfirmacion()
    {
        System.out.println("La gestión solicitada se ha realizado con éxito");
    }
    
    /**
     * Printer de mensaje error proyecto no entregado
     */
    private void printErrorProyectoNoEntregado()
    {
        System.out.println("La obra no se puede iniciar porque el proyecto aún");
        System.out.println("no ha sido entregado por en arquitecto.");
    }
    
    /**
     * Printer de mensaje error proyecto no entregado
     */
    private void printErrorNoIniciado()
    {
        System.out.println("La obra no se puede entregar porque");
        System.out.println("aún no ha sido iniciada.");
    }
}
