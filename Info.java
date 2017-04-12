
/**
 * Classe que implementa dados de uma memória cache no formato TAG e DATA.
 * 
 * @author (Jonathas Ruam) 
 * @version (0.1)
 */
public class Info
{
    private int TAG;
    private int DATA;
    
    /**
     * Cria um objeto Info.
     */
    public Info(){
        this.TAG = -1;
        this.DATA = -1;
    }
    
    
    /**
     * Método para Modificar/atribuir a TAG do objeto Info.
     * O parâmetro tag será setado como a TAG do obejeto Info. 
     */
    public void setTag(int tag){
        this.TAG = tag;
    }
    
    /**
     * Método que Retorna o valor da TAG do objeto Info. 
     */
    public int getTag(){
        return this.TAG;
    }
    
    /**
     * Método para Modificar/atribuir o atributo DATA do objeto Info.
     * O parâmetro tag será setado como DATA do obejeto Info. 
     */
    public void setData(int data){
        this.DATA = data;
    }
    
    
    /**
     * Método que retorna o valor de DATA do objeto Info.
     */
    public int getData(){
        return this.DATA;
    }
    
    /**
     * Método para imprimir as informações do objet Info.
     */
    public void print(){
        System.out.print("("+this.TAG +"|"+this.DATA+") ");
    }
}
