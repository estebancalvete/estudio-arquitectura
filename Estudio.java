import java.util.ArrayList;
/**
 * La clase Estudio modela el sistema integrado de gestión de un estudio de
 * arquitectura.
 *
 * @author Esteban Calvete Iglesias
 * @version 1.0
 */
public class Estudio
{
    // MARK - Campos
    private ArrayList<Cliente> clientes;
    private ArrayList<Empleado> empleados;
    
    // MARK - Constructores
    /**
     * Constructor para objetos de clase Estudio
     */
    public Estudio()
    {
        clientes = new ArrayList<Cliente>();
        empleados = new ArrayList<Empleado>();
        crearHistorico();
    }
    
    /**
     * Método principal main
     */
    public static void main(String[] args) {
        
    }
    
    // MARK - Métodos públicos
    /**
     * Getter del ArrayList de clientes
     * 
     * @return ArrayList the clientes dados de alta
     */
    public ArrayList<Cliente> getClientes()
    {
        return clientes;
    }
    
    /**
     * Getter del ArrayList de empleados
     * 
     * @return ArrayList de empleados dados de alta
     */
    public ArrayList<Empleado> getEmpleados()
    {
        return empleados;
    }
    
    /**
     * Método de obtención de cliente desde ArrayList de clientes.
     * 
     * @param numCliente Número de cliente
     * 
     * @return Objeto Cliente correspondiente a un número de cliente
     */
    public Cliente getCliente(String numCliente) {
        for(int i = 0; i<clientes.size(); i++){
            if(clientes.get(i).getNumeroCliente() == numCliente){
                return clientes.get(i);
            }
        }
        System.out.println("El cliente con el número #" + numCliente);
        System.out.println("no consta en la lista de clientes actual");
        return null;
    }
    
    /**
     * Método de obtención de empleado desde ArrayList de empleados.
     * 
     * @param numEmpleado Número de empleado
     * 
     * @return Objeto Empleado correspondiente a un número de empleado
     */
    public Empleado getEmpleado(String numEmpleado) {
        for(int i = 0; i<empleados.size(); i++){
            if(empleados.get(i).getNumeroEmpleado() == numEmpleado){
                return empleados.get(i);
            }
        }
        System.out.println("El empleado con el número #" + numEmpleado);
        System.out.println("no consta en la lista de empleados actual");
        return null;
    }
    
    /**
     * Método de adición de cliente
     * 
     * @param cliente Cliente a añadir al ArrayList de clientes
     */
    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    
    /**
     * Método de adición de empleado
     * 
     * @param empleado Empleado a añadir al ArrayList de empleados
     */
    public void addEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }
    
    
    /**
     * Método de eliminación de cliente
     * 
     * @param cliente Cliente a eliminar del ArrayList de clientes
     */
    public void removeCliente(Cliente cliente) {
        clientes.remove(cliente);
    }
    
    /**
     * Método de eliminación de empleado
     * 
     * @param empleado Empleado a eliminar del ArrayList de empleados
     */
    public void removeEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }
    
    // MARK - Métodos públicos
    /**
     * Método de creación de ejemplo de histórico de clientes, empleados,
     * proyectos y certificados de ejemplo para ayudar a en la corrección
     * de la práctica.
     */
    private void crearHistorico()
    {
        Administrador admin1 = new Administrador("Andrea Administradora", 680215487);
        Arquitecto arq1 = new Arquitecto("Juan Arquitecto", 690146355);
        Aparejador apa1 = new Aparejador("Marta Aparejadora", 670258741);
        Contable cont1 = new Contable("Manuel Contable", 647412478);
        Cliente cli1 = new Cliente("Roberta Clienta", 693486957);
        Cliente cli2 = new Cliente("Pedro Cliente", 630252590);
        Cliente cli3 = new Cliente("Raul Cliente", 682596230);
        admin1.altaAdmin(this);
        admin1.altaEmpleado(arq1);
        admin1.altaEmpleado(apa1);
        admin1.altaEmpleado(cont1);
        admin1.altaCliente(cli1);
        admin1.altaCliente(cli2);
        admin1.altaCliente(cli3);
        cli1.solicitarProyectoResidencial("Edificio Plaza", 2020, 8, 23,
                                "C/Real 45", 1500, 1300, 4, 25, 10, true);
        cli1.solicitarProyectoNoResidencial("Almacén Tejidos", 2021, 10, 2,
                                "C/Castor SN", 2000, 2000, "Empresarial", false);
        cli2.solicitarProyectoResidencial("Edificio Puerto", 1990, 7, 29,
                                "C/Principal 13", 1100, 1000, 8, 40, 22, true);
        cli2.solicitarProyectoResidencial("Casa Florinda", 2021, 2, 12,
                                "C/Rosalía 4", 300, 250, 1, 3, 2, false);
        cli3.solicitarProyectoResidencial("Edificio Tower", 1950, 2, 16,
                                "C/Bilbao 35", 2100, 1700, 80, 250, 60, true);
        cli3.solicitarProyectoNoResidencial("Hospital Central", 1990, 12, 10,
                                "C/Puerto 12", 3500, 3200, "Sanitario", true);
        cli3.solicitarProyectoRehabilitacion("Casa Vieja", 2003, 3, 15,
                                "C/Mayor 68", 400, false);
        cli3.solicitarProyectoRehabilitacion("Cancha Tenis", 2006, 1, 12,
                                "C/Bailen", 150, true);
        admin1.asignarEmpleadosProyecto("PRO-1", "EMP-2", "EMP-3", "EMP-4");
        admin1.asignarEmpleadosProyecto("PRO-2", "EMP-2", "EMP-3", "EMP-4");
        admin1.asignarEmpleadosProyecto("PRO-3", "EMP-2", "EMP-3", "EMP-4");
        admin1.asignarEmpleadosProyecto("PRO-4", "EMP-2", "EMP-3", "EMP-4");
        admin1.asignarEmpleadosProyecto("PRO-5", "EMP-2", "EMP-3", "EMP-4");
        admin1.asignarEmpleadosProyecto("PRO-6", "EMP-2", "EMP-3", "EMP-4");
        admin1.asignarEmpleadosProyecto("PRO-7", "EMP-2", "EMP-3", "EMP-4");
        admin1.asignarEmpleadosProyecto("PRO-8", "EMP-2", "EMP-3", "EMP-4");
        cont1.asignarPresupuestoProyecto("PRO-1", 230000.00);
        cont1.asignarPresupuestoProyecto("PRO-2", 380000.00);
        cont1.asignarPresupuestoProyecto("PRO-3", 120000.00);
        cont1.asignarPresupuestoProyecto("PRO-4", 290000.00);
        cont1.asignarPresupuestoProyecto("PRO-5", 880000.50);
        cont1.asignarPresupuestoProyecto("PRO-6", 950000.00);
        cont1.asignarPresupuestoProyecto("PRO-7", 20000.00);
        cont1.asignarPresupuestoProyecto("PRO-8", 130000.00);
        cont1.asignarCosteProyecto("PRO-1", 230000.99);
        cont1.asignarCosteProyecto("PRO-2", 410000.35);
        cont1.asignarCosteProyecto("PRO-3", 135000.00);
        cont1.asignarCosteProyecto("PRO-4", 310000.90);
        cont1.asignarCosteProyecto("PRO-5", 860000.00);
        cont1.asignarCosteProyecto("PRO-6", 960000.25);
        cont1.asignarCosteProyecto("PRO-7", 21000.50);
        cont1.asignarCosteProyecto("PRO-8", 140000.99);
        arq1.entregarProyecto("PRO-1", 2020, 9, 23);
        arq1.entregarProyecto("PRO-2", 2021, 11, 2);
        arq1.entregarProyecto("PRO-3", 1990, 9, 29);
        arq1.entregarProyecto("PRO-4", 2021, 3, 12);
        arq1.entregarProyecto("PRO-5", 1950, 3, 16);
        arq1.entregarProyecto("PRO-6", 1991, 1, 10);
        arq1.entregarProyecto("PRO-7", 2003, 4, 15);
        arq1.entregarProyecto("PRO-8", 2006, 2, 12);
        apa1.iniciarObra("PRO-1", 2020, 9, 24, 10);
        apa1.entregarObra("PRO-1", 2021, 07, 25);
        apa1.iniciarObra("PRO-3", 1990, 9, 30, 9);
        apa1.entregarObra("PRO-3", 1991, 8, 2);
        apa1.iniciarObra("PRO-5", 1950, 3, 20, 10);
        apa1.entregarObra("PRO-5", 1950, 12, 30);
        apa1.iniciarObra("PRO-8", 2022, 5, 10, 6);
        cli3.solicitarCertificadoInspeccionTecnica(1995, 10, 9, "PRO-5");
        admin1.asignarEmpleadosCertificado("CER-1", "EMP-2", "EMP-3", "EMP-4");
        cont1.asignarCosteCertificado("CER-1", 300.00);
        apa1.registrarVisitaParaCertificado("CER-1", 1995, 11, 10); 
        arq1.emitirCetificadoNoEficiencia("CER-1", 1995, 12, 3);
        cli1.solicitarCertificadoHabitabilidad(2020, 8, 25, "PRO-1");
        admin1.asignarEmpleadosCertificado("CER-2", "EMP-2", "EMP-3", "EMP-4");
        cont1.asignarCosteCertificado("CER-2", 220.00);
        apa1.registrarVisitaParaCertificado("CER-2", 2020, 8, 30); 
        arq1.emitirCetificadoNoEficiencia("CER-1", 2020, 9, 15);
    }
}
