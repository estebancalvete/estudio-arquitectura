
/**
 * La clase NoResidencial modela los proyectos no residenciales como naves
 * industriales, museos u otros, hereda de la clase Proyecto.
 *
 * @author Esteban Calvete Iglesias
 * @version 1.0
 */
public class NoResidencial extends Proyecto
{
    // MARK - Campos
    private int supTerreno;
    private int supEdificio;
    private String finalidad;
    
    // MARK - Constructores
    /**
     * Constructor para objetos de clase NoResidencial
     * 
     * @param nombre Nombre del proyecto
     * @param year Año de solicitud del proyecto
     * @param month Mes de solicitud del proyecto
     * @param day Día de solicitud del proyecto
     * @param direccion Dirección de la edificación
     * @param supTerreno Superficie del terreno
     * @param supEdificio Superficie de la edificación
     * @param finalidad Finalidad de la edificación
     * @param esComunitario Finalidad comunitaria del proyecto: "true" o "false"
     */
    public NoResidencial(String nombre, int year, int month, int day,
                         String direccion, int supTerreno, int supEdificio,
                         String finalidad, boolean esComunitario)
    {
        super(nombre, year, month, day, direccion, esComunitario, false);
        this.supTerreno = supTerreno;
        this.supEdificio = supEdificio;
        this.finalidad = finalidad;
    }
    
    // MARK - Métodos públicos
}
