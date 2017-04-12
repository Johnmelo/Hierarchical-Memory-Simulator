import java.lang.Math;
/**
 * Classe que Implementa um Processor.
 * 
 * @author (Jonathas Ruam) 
 * @version (0.1)
 */
public class Processor
{
    Core A;
    Core B;
    CacheMemory L2;
    int ID;
    /**
     * Cria um processor.
     * O parâmetro id referece ao identificador do processor no sistema.
     */
    public Processor(int id)
    {
        this.A = new Core(2*id);
        this.B = new Core(2*id + 1);
        this.L2 = new CacheMemory(15);
        this.ID = id;
    
    }
    
    /**
     * Métódo para selecionar o core.
     * Utilizado para a seleção do core para realização de leitura/escrita.
     */
    public Core selectCore(int id){
        if (this.A.getId() == id)
            return this.A;
        else 
            return this.B;
    }
    
    /**
     * Método para realizar a leitura de dados da memória principal.
     */
    public void read(int ID,int adress,Memory memory){
        Core aux = selectCore(ID);
        if(!verifyLoaded(aux.getL1(),memory.getData(adress),adress)){
            aux.setL1(memory.getData(adress),adress);
            if(!verifyLoaded(this.L2,memory.getData(adress),adress)){
                this.L2.setData(memory.getData(adress),adress);
            }
        }else{
            System.out.println("DADO JÁ ARMAZENADO");
        }
    }
    
    /**
     * Método para realizar a escrita na memória principal.
     */
    public void write(int value,int ID,int adress,Memory memory){
        Core aux = selectCore(ID);
        aux.setL1(value,adress);
        this.L2.setData(value,adress);
        memory.setData(adress,value);
    }
    
    /**
     * Método para verificar se um determinado endereço já esta mapeado.
     */
    public boolean verifyLoaded(CacheMemory cache,int value,int adress){
       return cache.isLoaded(value,adress);
    }
    
    /**
     * Método que retorna o Id do processor.
     */
    public int getId(){
        return this.ID;
    }
    
    /**
     * Método para imprimir as informações do Processor.
     */
    public void viewProcessor(){
        System.out.println("PROCESSOR : "+this.getId());
        this.A.viewCore();
        this.B.viewCore();
        System.out.print("L2 : ");
        this.L2.viewCache();
        System.out.println(" ");
    }

    /**
     * Método para verificar a necessidade de atualização de nivéis de hierarquia.
     */
    public void update(int adress,int value){
        boolean flag = false;
        
        if(this.verifyLoaded(this.A.getL1(),value,adress)){
            this.writeUpdate(value,this.A,adress);
            flag = true;
        }
        
        if(this.verifyLoaded(this.B.getL1(),value,adress)){
            this.writeUpdate(value,this.B,adress);
            flag = true;
        }
        
        if(flag){
            this.L2.setData(value,adress);
        }
    }
    
    /**
     * Método para realizar a atualização de níveis de hierarquia.
     */
    public void writeUpdate(int value,Core core,int adress){
        core.setL1(value,adress);
    }
}
