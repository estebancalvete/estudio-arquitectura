import java.util.Date;
/**
 * La clase Certificado modela los certificados que desarrolla el estudio de
 * arquitectura.
 *
 * @author Esteban Calvete Iglesias
 * @version 1.0
 */
public class Certificado
{
    // MARK - Campos
    private final String NUMERO_CERTIFICADO;
    private Date fechaSolicitud;
    private Date fechaEstimadaEntrega;
    private Date fechaEmision;
    private boolean entregado;
    private double coste;
    private Cliente cliente;
    private Arquitecto arquitecto;
    private Aparejador aparejador;
    private Contable contable;
    private Proyecto proyecto;
    private String tipo;
    
    // MARK - Constructores
    /**
     * Constructor para objetos de clase Certificado
     * 
     * @param year Año de solicitud
     * @param month Mes de solicitud
     * @param day Día de solicitud
     * @param proyecto Proyecto arquitectónico al que se aplica el certificado
     * @param tipo Tipo de proyecto
     */
    public Certificado(int year, int month, int day, Proyecto proyecto,
                       String tipo)
    {
        NUMERO_CERTIFICADO = GeneradorNumeros.generaNumeroCertificado();
        fechaSolicitud = new Date(year, month, day);
        this.proyecto = proyecto;
        entregado = false;
        this.tipo = tipo;
    }
    
    // MARK - Métodos públicos
    /**
     * Getter del número de certificado
     * 
     * @return String del número de certificado
     */
    public String getId()
    {
        return NUMERO_CERTIFICADO;
    }
    
    /**
     * Getter del tipo de certificado
     * 
     * @return String del tipo de certificado
     */
    public String getTipo()
    {
        return tipo;
    }
    
    /**
     * Getter del proyecto asociado al certificado
     * 
     * @return Objeto Proyecto asociado al certificado
     */
    public Proyecto getProyecto()
    {
        return proyecto;
    }
    
    /**
     * Getter de fecha de emisión de certificado
     * 
     * @return Objeto Date representativo de la fecha de emision del certificado
     */
    public Date getFechaEmision()
    {
        return fechaEmision;
    }
    
    /**
     * Getter de entregado. Indica si el certificado está expedido o aún está en
     * proceso de expedición
     * 
     * @return boolean indicativo de si el certificado ha sido expedido
     */
    public boolean getEntregado()
    {
        return entregado;
    }
    
    /**
     * Getter del cliente asociado al certificado
     * 
     * @return Objeto Cliente asociado al certificado
     */
    public Cliente getCliente()
    {
        return cliente;
    }
    
    /**
     * Getter de arquitecto
     * 
     * @return Objeto Arquitecto asociado al certificado
     */
    public Arquitecto getArquitecto()
    {
        return arquitecto;
    }
    
    /**
     * Getter de aparejador
     * 
     * @return Objeto Aparejador asociado al certificado
     */
    public Aparejador getAparejador()
    {
        return aparejador;
    }
    
    /**
     * Getter del contable asociado al certificado
     * 
     * @return Objeto Contable asociado al certificado
     */
    public Contable getContable()
    {
        return contable;
    }
    
    /**
     * Setter de empleados que realizarán el certificado. Se añade fecha prevista
     * de entrega.
     *
     * @param arquitecto Arquitecto que firmará el certificado
     * @param aparejador Aparejador que visitará el proyecto
     * @param contable Contable que gestionará las finanzas
     * @param year Año de entrega estimada del certificado
     * @param month Mes de entrega estimada del certificado
     * @param day Dia de entrega estimada del certificado
     */
    public void setEmpleadosCertificado(Arquitecto arquitecto,
                                        Aparejador aparejador,
                                        Contable contable,
                                        int year,
                                        int month,
                                        int day)
    {
        this.arquitecto = arquitecto;
        this.aparejador = aparejador;
        this.contable = contable;
        fechaEstimadaEntrega = new Date(year, month, day);
        printConfirmacionEmpleados();
    }
    
    /**
     * Función de emisión del certificado
     * 
     * @param  year Año de emisión del certificado
     * @param  month Mes de emisión del certificado
     * @param  day Dia de emisión del certificado
     */
    public void emitirCertificado(int year, int month, int day)
    {
        fechaEmision = new Date(year, month, day);
        entregado = true;
    }
    
    /**
     * Setter de cliente
     * 
     * @param cliente Cliente a asignar al certificado
     */
    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }
    
    /**
     * Setter de coste de certificado
     * 
     * @param coste Coste de expedición del certificado
     */
    public void setCoste(double coste)
    {
        this.coste = coste;
    }
    
    // MARK - Métodos privados
    /**
     * Método privado de impresión de mensaje de confirmación de adición de
     * empleados al proyecto y su fecha prevista de entrega
     */
    private void printConfirmacionEmpleados()
    {
        System.out.println("El certificado con número #" + NUMERO_CERTIFICADO);
        System.out.println("Ha sido asignado con los siguietes datos:");
        System.out.println("Arquitecto: " + arquitecto.getName());
        System.out.println("Aparejador: " + aparejador.getName());
        System.out.println("Contable: " + contable.getName());
        System.out.println("Fecha estimada de entrega:");
        System.out.println(fechaEstimadaEntrega.getDay() + "/" +
                           fechaEstimadaEntrega.getMonth() + "/" +
                           fechaEstimadaEntrega.getYear());
    }
}
