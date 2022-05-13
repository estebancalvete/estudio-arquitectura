
/**
 * La clase Rehabilitación modela los proyectos de reforma de construcciones
 * ya finalizadas y hereda de la clase Proyecto.
 *
 * @author Esteban Calvete Iglesias
 * @version 1.0
 */
public class Rehabilitacion extends Proyecto
{
    // MARK - Campos
    private int supReformar;
    
    // MARK - Constructores
    /**
     * Constructor de objetos de la clase Rehabilitacion
     * 
     * @param nombre Nombre del proyecto
     * @param year Año de solicitud del proyecto
     * @param month Mes de solicitud del proyecto
     * @param day Día de solicitud del proyecto
     * @param direccion Direccion de realización del proyecto
     * @param supReformar Superficie a reformar
     * @param esComunitario Finalidad comunitaria del proyecto: "true" o "false"
     */
    public Rehabilitacion(String nombre, int year, int month, int day,
                          String direccion, int supReformar, boolean esComunitario)
    {
        super(nombre, year, month, day, direccion, esComunitario, false);
        this.supReformar = supReformar;
    }
    
    // MARK - Métodos públicos
}
