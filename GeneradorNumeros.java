
/**
 * La clase GeneradorNumeros es una clase auxiliar que genera números únicos de:
 *      -Cliente
 *      -Empleado
 *      -Proyecto
 *      -Certificado
 * 
 * con el objetivo de organización y facilitación de búsquedas.
 *
 * @author Esteban Calvete Iglesias
 * @version 1.0
 */
public class GeneradorNumeros
{
    // MARK - Campos
    private static int totalClientes = 0;
    private static int totalEmpleados = 0;
    private static int totalProyectos = 0;
    private static int totalCertificados = 0;
    
    // MARK - Constructores
    /**
     * Constructor de objetos de clase GeneradorNumDoc
     */
    public GeneradorNumeros()
    {
    }
    
    // MARK - Métodos públicos
    /**
     * Función generadora de número de cliente
     *
     * @return Un número consecutivo de cliente
     */
    public static String generaNumeroCliente()
    {
        totalClientes++;
        return "CLI-" + totalClientes;
    }
    
    /**
     * Función generadora de número de empleado
     *
     * @return Un número consecutivo de empleado
     */
    public static String generaNumeroEmpleado()
    {
        totalEmpleados++;
        return "EMP-" + totalEmpleados;
    }
    
    /**
     * Función generadora de número de proyecto
     *
     * @return Un número consecutivo de proyecto
     */
    public static String generaNumeroProyecto()
    {
        totalProyectos++;
        return "PRO-" + totalProyectos;
    }
    
    /**
     * Función generadora de número de certificado
     *
     * @return Un número consecutivo de certificado
     */
    public static String generaNumeroCertificado()
    {
        totalCertificados++;
        return "CER-" + totalCertificados;
    }
}
