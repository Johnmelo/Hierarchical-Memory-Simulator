
/**
 * Classe que Implementa uma Memória.
 * 
 * @author (Jonathas Ruam) 
 * @version (0.1)
 */
public class Memory
{
    private int size;
    private int adress[];
    
    /**
     * Construtor para  Memory.
     * O tamanho da Memory definido pelo parâmetro size.
     */
    public Memory(int size){
        this.size = size;
        this.adress = new int[size];
    }
    
    /**
     * Método para atribuir/modificar valor na Memory.
     */
    public void setData(int adress,int value){
        if(validate(adress))
            this.adress[adress] = value;
        else
            System.out.println("ENDEREÇO INVALIDO!");
    }
    
    /**
     * Método que retorna um valor na Memory.
     * Retorna o valor armazenado na Memory no endereço definido pelo parâmetro.
     */
    public int getData(int adress){
        if(validate(adress))
            return this.adress[adress];
        else
            return -1;   
    }
    
    /**
     * Método que retorna o Tamanho da Memory.
     */
    public int getSize(){
        return this.size;
    }
    
    /**
     * Método para válida o endereço na Memory.
     */
    public boolean validate(int adress){
        return adress>=0 && adress<this.size; 
    }
    
    /**
     * Método para imprimir informações da Memory.
     */
    public void viewMemory(){
        int c = 0;
        for(int value : adress){
            c++;
            System.out.print(value + " ");
            if(c%10 == 0)
                System.out.println();
        }
        System.out.println(" ");
    }
}
