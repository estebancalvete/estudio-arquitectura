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
    }
    
    /**
     * Método principal main.
     */
    public static void main(String[] args) {
        
    }
    
    // MARK - Métodos públicos
    /**
     * Getter del ArrayList de clientes.
     */
    public ArrayList<Cliente> getClientes()
    {
        return clientes;
    }
    
    /**
     * Getter del ArrayList de empleados.
     */
    public ArrayList<Empleado> getEmpleados()
    {
        return empleados;
    }
    
    /**
     * Método de obtención de cliente desde ArrayList de clientes.
     * 
     * @param  numCliente Número de cliente
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
     * @param  numEmpleado Número de empleado
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
     * Método de adición de cliente.
     */
    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    
    /**
     * Método de adición de empleado.
     */
    public void addEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }
    
    /**
     * Método de eliminación de cliente.
     */
    public void removeCliente(Cliente cliente) {
        clientes.remove(cliente);
    }
    
    /**
     * Método de eliminación de empleado.
     */
    public void removeEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }
}
