import java.util.ArrayList;
import java.util.Date;
/**
 * La clase Proyecto modela los proyectos que gestiona el estudio de
 * arquitectura.
 *
 * @author Esteban Calvete Iglesias
 * @version 1.0
 */
public class Proyecto
{
    // MARK - Campos
    private final String NUMERO_PROYECTO;
    private String nombre;
    private Date fechaSolicitud;
    private Date fechaEntregaProyecto;
    private int duracionPrevista;
    private double presupuesto;
    private double coste;
    private boolean estaContratado;
    private boolean estaFinalizado;
    private Date fechaInicioObra;
    private Date fechaEntregaObra;
    private Cliente cliente;
    private Arquitecto arquitecto;
    private Aparejador aparejador;
    private Contable contable;
    private String direccion;
    private ArrayList<Certificado> certificados;
    private boolean esComunitario;
    private boolean esResidencial;
    
    // MARK - Constructores
    /**
     * Constructor para objetos de clase Proyecto
     * 
     * @param nombre Nombre del proyecto
     * @param year Año de solicitud del proyecto
     * @param month Mes de solicitud del proyecto
     * @param day Día de solicitud del proyecto
     * @param direccion Dirección del proyecto
     * @param esComunitario Finalidad comunitaria del proyecto: "true" o "false"
     * @param esResidencial Finalidad residencial del proyecto: "true" o "false"
     */
    public Proyecto(String nombre, int year, int month, int day, String direccion,
                    boolean esComunitario, boolean esResidencial)
    {
        NUMERO_PROYECTO = GeneradorNumeros.generaNumeroProyecto();
        certificados = new ArrayList<Certificado>();
        this.nombre = nombre;
        this.direccion = direccion;
        fechaSolicitud = new Date(year, month, day);
        estaContratado = false;
        estaFinalizado = false;
        this.esComunitario = esComunitario;
        this.esResidencial = esResidencial;
    }
    
    // MARK - Métodos públicos
    
    /**
     * Getter del número de proyecto
     * 
     * @return String con el número de proyecto
     */
    public String getId()
    {
        return NUMERO_PROYECTO;
    }
    
    /**
     * Getter de esComunitario. Indica si el proyecto es comunitario
     * 
     * @retrun boolean de confirmación de si el proyecto es comunitario
     */
    public boolean getComunitario()
    {
        return esComunitario;
    }
    
    /**
     * Getter de esResidencial. Indica si el proyecto es residencial
     * 
     * @return boolean de confirmación de si el proyecto es residencial
     */
    public boolean getEsResidencial()
    {
        return esResidencial;
    }
    
    /**
     * Getter de fecha de entrega de obra
     * 
     * @return Date indicativo de la fecha de entrega de obra
     */
    public Date getFechaEntregaObra()
    {
        return fechaEntregaObra;
    }
    
    /**
     * Getter del nombre de proyecto
     * 
     * @return String con el nombre del proyecto
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * Getter de arquitecto
     * 
     * @return Objeto Arquitecto asociado al proyecto
     */
    public Arquitecto getArquitecto()
    {
        return arquitecto;
    }
    
    /**
     * Getter de aparejador
     * 
     * @return Objeto Aparejador asociado al proyecto
     */
    public Aparejador getAparejador()
    {
        return aparejador;
    }
    
    /**
     * Getter de contable
     * 
     * @return Objeto Contable asociado al proyecto
     */
    public Contable getContable()
    {
        return contable;
    }
    
    /**
     * Getter de cliente
     * 
     * @return Objeto Cliente asociado al proyecto
     */
    public Cliente getCliente()
    {
        return cliente;
    }
    
    /**
     * Getter de finalizado. Indica si el proyecto está finalizado
     * 
     * @return boolean de confirmación de si el proyecto se encuentra finalizado
     */
    public boolean getFinalizado()
    {
        return estaFinalizado;
    }
    
    /**
     * Getter de fecha de entrega del proyecto
     * 
     * @return Objeto Date de fecha de entrega del proyecto
     */
    public Date getFechaEntregaProyecto()
    {
        return fechaEntregaProyecto;
    }
    
    /**
     * Getter de fecha de inicio de obra
     * 
     * @return Objeto Date de fecha de inicio de obra
     */
    public Date getFechaInicioObra()
    {
        return fechaInicioObra;
    }
    
    /**
     * Getter del ArrayList de certificados asociados al proyecto
     * 
     * @return ArrayList de certificados asociados al proyecto
     */
    public ArrayList<Certificado> getCertificados()
    {
        return certificados;
    }
    
    /**
     * Setter de empleados que realizarán el proyecto
     * El proyecto se considera contratado
     *
     * @param arquitecto Arquitecto que realizará el proyecto
     * @param aparejador Aparejador que desarrollará el proyecto
     * @param contable Contable que gestionará las finanzas
     */
    public void setEmpleadosProyecto(Arquitecto arquitecto,
                                     Aparejador aparejador,
                                     Contable contable)
    {
        this.arquitecto = arquitecto;
        this.aparejador = aparejador;
        this.contable = contable;
        estaContratado = true;
        printConfirmacionEmpleados();
    }
    
    /**
     * Setter de cliente asociado al proyecto
     * 
     * @param cliente Cliente asociado al proyecto
     */
    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }
    
    /**
     * Setter de presupuesto de obra
     * 
     * @param presupuesto Presupuesto para el desarrollo del proyecto
     */
    public void setPresupuesto(double presupuesto)
    {
        this.presupuesto = presupuesto;
    }
    
    /**
     * Setter de coste de obra
     * 
     * @param coste Coste de desarrollo del proyecto
     */
    public void setCoste(double coste)
    {
        this.coste = coste;
    }
    
    /**
     * Setter de duración prevista de obra
     * 
     * @param duracionPrevista Duración prevista de obra en días
     */
    public void setDuracionPrevista(int duracionPrevista)
    {
        this.duracionPrevista = duracionPrevista;
    }
    
    /**
     * Setter de fecha de entrega de proyecto
     * 
     * @param year Año de inicio de obra
     * @param month Mes de inicio de obra
     * @param day Día de inicio de obra
     */
    public void setFechaEntregaProyecto(int year, int month, int day)
    {
        fechaEntregaProyecto = new Date(year, month, day);
    }
    
    /**
     * Setter de fecha de inicio de obra
     * 
     * @param year Año de inicio de obra
     * @param month Mes de inicio de obra
     * @param day Día de inicio de obra
     */
    public void setFechaInicioObra(int year, int month, int day)
    {
        fechaInicioObra = new Date(year, month, day);
    }
    
    /**
     * Setter de fecha de entrega de obra
     * 
     * @param year Año de entrega de obra
     * @param month Mes de entrega de obra
     * @param day Día de entrega de obra
     */
    public void setFechaEntregaObra(int year, int month, int day)
    {
        fechaEntregaObra = new Date(year, month, day);
    }
    
    /**
     * Setter de obra finalizada
     */
    public void setEstaFinalizado()
    {
        estaFinalizado = true;
    }
    
    /**
     * Método de adición de certificado al histórico del proyecto
     * 
     * @param certificado Certificado a asociar al proyecto
     */
    public void addCertificado(Certificado certificado) {
        certificados.add(certificado);
    }
    
    // MARK - Métodos privados
    /**
     * Método privado de impresión de mensaje de confirmación de adición de
     * empleados al proyecto
     */
    private void printConfirmacionEmpleados()
    {
        System.out.println("El proyecto número #" + NUMERO_PROYECTO);
        System.out.println("Se ha contratado correctamente con los siguientes");
        System.out.println("empleados asignados:");
        System.out.println("Arquitecto: " + arquitecto.getName());
        System.out.println("Aparejador: " + aparejador.getName());
        System.out.println("Contable: " + contable.getName());
    }
}
