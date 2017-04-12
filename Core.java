
/**
 * Implementa um Core.
 * 
 * @author (Jonathas Ruam) 
 * @version (0.1)
 */
public class Core
{
   //CPU cpu;
   private CacheMemory L1;
   private int ID;
    /**
     * Constrututor para obejetos Core.
     * O parâmetro id referencia o Processor ao qual o Core criado pertence.
     */
    public Core(int id)
    {
        this.ID = id;
        this.L1 = new CacheMemory(15);
    }
    
    /**
     * Método para retornar o ID do Core.
     */
    public int getId(){
        return this.ID;
    }
    
    /**
     *  Método para atribuir/modificar um valor na Cache L1.
     */
    public void setL1(int value,int adress){
        this.L1.setData(value,adress);
    }
    
    /**
     * Método para retornar o valor contido no endereço adress na Cache L1 do Core.
     */
    public int getValueL1(int adress){
        return this.L1.getData(adress);
    }
    
    /**
     * Método para retornar a Cache L1 do Core.  
     */
    public CacheMemory getL1(){
        return this.L1;
    }
    
    /*
    public boolean verify(int value,int adress){
        return false;
    }*/
    
    /**
     * Método para imprimir informações do Core.
     */
    public void viewCore(){
        System.out.print("CORE : " + this.ID + "    ");
        this.L1.viewCache();
    }
}
