import java.util.Date;
/**
 * La clase Eficiencia modela los certificados de eficiencia energética
 * desarrollados por el estudio de arquitectura, hereda de la clase Proyecto.
 *
 * @author Esteban Calvete Iglesias
 * @version 1.0
 */
public class Eficiencia extends Certificado
{
    // MARK - Campos
    private Character categoria;
    private Date fechaVisitaAparejador;
    
    // MARK - Constructores
    /**
     * Constructor para objetos de clase Eficiencia
     * 
     * @param  year Año de solicitud
     * @param  month Mes de solicitud
     * @param  day Día de solicitud
     * @param  proyecto Proyecto arquitectónico al que se aplica el certificado
     */
    public Eficiencia(int year, int month, int day, Proyecto proyecto)
    {
        super(year, month, day, proyecto);
    }
    
    // MARK - Métodos públicos
    /**
     * Setter de categoría del certificado
     * 
     * @param  categoria Categoría del certificado (A, B, C, D, E, F, G)
     */
    public void setCategoria(Character categoria)
    {
        this.categoria = categoria;
    }
}
