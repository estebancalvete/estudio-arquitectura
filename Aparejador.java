
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
}
