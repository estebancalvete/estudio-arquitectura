
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
     * Visualización de datos clientes asignados
     */
    public void printClientesAsignados()
    {
        //
    }
}
