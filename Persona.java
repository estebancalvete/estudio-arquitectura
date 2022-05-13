
/**
 * La clase Persona modela los usuarios del sistema de gestión del estudio de
 * arquitectura. Clase abstracta ya que solo se utiliza como superclase.
 *
 * @author Esteban Calvete Iglesias
 * @version 1.0
 */
public class Persona
{
    // MARK - Campos
    private String name;
    private int telefono;
    private boolean activo;

    // MARK - Constructores
    /**
     * Constructor para objetos de clase Persona
     * 
     * @param nombre Nombre de la persona
     * @param telefono Teléfono de contacto de la persona
     */
    public Persona(String name, int telefono)
    {
        this.name = name;
        this.telefono = telefono;
        activo = false;
    }

    // MARK - Métodos públicos
    /**
     * Método que devuelve el nombre de la persona
     *
     * @return Nombre de la persona
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Método que devuelve el número de teléfono de la persona
     *
     * @return Número de teléfono de la persona
     */
    public int getTelefono()
    {
        return telefono;
    }
    
    /**
     * Método para saber si el usuario está dado de alta en el sistema
     * 
     * @return boolean de usuario activo en el sistema
     */
    public boolean getActivo()
    {
        return activo;
    }
    
    /**
     * Método setter de nombre de la persona
     * 
     * @param name Nuevo nombre de la persona
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Método setter de número de teléfono de la persona
     * 
     * @param teléfono Nuevo número de teléfono de la persona
     */
    public void setTelefono(int telefono)
    {
        this.telefono = telefono;
    }
    
    /**
     * Set persona activa en el sistema
     */
    public void setActivo()
    {
        activo = true;
    }
    
    /**
     * Set persona inactiva en el sistema
     */
    public void setInactivo()
    {
        activo = false;
    }
}
