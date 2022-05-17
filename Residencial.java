
/**
 * La clase Residencial modela los proyectos residenciales de edificios y
 * viviendas unifamiliares y hereda de la clase Proyecto.
 *
 * @author Esteban Calvete Iglesias
 * @version 1.0
 */
public class Residencial extends Proyecto
{
    // MARK - Campos
    private int supTerreno;
    private int supEdificio;
    private int noPlantas;
    private int noHabitaciones;
    private int noBanos;
    
    // MARK - Constructores
    /**
     * Constructor para objetos de clase Residencial
     * 
     * @param nombre Nombre del proyecto
     * @param year Año de solicitud del proyecto
     * @param month Mes de solicitud del proyecto
     * @param day Día de solicitud del proyecto
     * @param direccion Dirección de la obra
     * @param supTerreno Superficie del terreno en m2
     * @param supEdificio Superficie del edificio en m2
     * @param noPlantas Número de plantas del edificio
     * @param noHabitaciones Número de habitaciones
     * @param noBanos Número de banos
     * @param esComunitario Finalidad comunitaria del proyecto: "true" o "false"
     */
    public Residencial(String nombre, int year, int month, int day,
                       String direccion, int supTerreno, int supEdificio,
                       int noPlantas, int noHabitaciones, int noBanos,
                       boolean esComunitario)
    {
        super(nombre, year, month, day, direccion, esComunitario, true);
        this.supTerreno = supTerreno;
        this.supEdificio = supEdificio;
        this.noPlantas = noPlantas;
        this.noHabitaciones = noHabitaciones;
        this.noBanos = noBanos;
    }
}
