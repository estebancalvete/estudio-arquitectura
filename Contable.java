
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
     * @param  name nombre de la persona
     * @param  telefono Teléfono de contacto
     */
    public Contable(String name, int telefono)
    {
        super(name, telefono, "Contable");
    }
    
    // MARK - Métodos públicos
}
