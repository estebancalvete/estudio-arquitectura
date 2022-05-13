import java.util.Date;
/**
 * La clase InspeccionTecnica modela los certificados renovables de inspeccion
 * técnica de edificios comunitarios desde los 45 años de antigüedad, hereda
 * de la clase Certificado.
 *
 * @author Esteban Calvete Iglesias
 * @version 1.0
 */
public class InspeccionTecnica extends Certificado
{
    // MARK - Campos
    private Date fechaVisitaAparejador;
    
    // MARK - Constructores
    /**
     * Constructor para objetos de clase InspeccionTecnica
     * 
     * @param year Año de solicitud
     * @param month Mes de solicitud
     * @param day Día de solicitud
     * @param proyecto Proyecto comunitario al que se aplica el certificado
     */
    public InspeccionTecnica(int year, int month, int day, Proyecto proyecto)
    {
        super(year, month, day, proyecto, "Inspección Técnica");
    }
    
    // MARK - Métodos públicos
    /**
     * Setter de fecha de visita del aparejador
     * 
     * @param year Año de visita del aparejador
     * @param month Mes de visita del aparejador
     * @param day Día de visita del aparejador
     */
    public void setFechaVisitaAparejador(int year, int month, int day)
    {
        fechaVisitaAparejador = new Date(year, month, day);
    }
}
