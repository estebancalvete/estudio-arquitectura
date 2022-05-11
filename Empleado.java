
/**
 * La clase Empleado modela los empleados del estudio de arquitectura y hereda
 * de la clase Persona.
 *
 * @author Esteban Calvete Iglesias
 * @version 1.0
 */
public class Empleado extends Persona
{
    // MARK - Campos
    private final String NUMERO_EMPLEADO;
    private String tipoEmpleado;
    private Estudio estudio;

    // MARK - Constructores
    /**
     * Constructor para objetos de clase Empleado
     * 
     * @param  name Nombre del empleado
     * @param  telefono Teléfono del empleado
     * @param  tipoEmpleado Tipo de empleado
     */
    public Empleado(String name, int telefono, String tipoEmpleado)
    {
        super(name, telefono);
        this.tipoEmpleado = tipoEmpleado;
        NUMERO_EMPLEADO = GeneradorNumeros.generaNumeroEmpleado();
    }
    
    // MARK - Métodos públicos
    /**
     * Getter de número de empleado
     */
    public String getNumeroEmpleado()
    {
        return NUMERO_EMPLEADO;
    }
    
    /**
     * Getter de estudio asignado
     */
    public Estudio getEstudio()
    {
        return estudio;
    }
    
    /**
     * Getter de tipo de empleado
     */
    public String getTipoEmpleado()
    {
        return tipoEmpleado;
    }
    
    /**
     * Método de asignación de estudio al empleado
     */
    public void setEstudio(Estudio estudio)
    {
        this.estudio = estudio;
    }
    
    /**
     * Método de eliminación de estudio asignado
     */
    public void removeEstudio()
    {
        estudio = null;
    }
}
