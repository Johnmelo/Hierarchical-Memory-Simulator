
/**
 * Classe que implementa uma memória cache.
 * 
 * @author (Jonathas Ruam) 
 * @version (0.1)
 */
public class CacheMemory
{
    private Info data[];
    private int size;
    private Lista LSR;
    private int qnt;
    private boolean cheia;
    private boolean ocupado[];
    
    /**
     * Cria uma CacheMemory.
     */
    public CacheMemory(int size)
    {
        this.size = size;
        this.data = new Info[size];
        this.ocupado = new boolean[size];
        for(int i = 0;i< size;i++){
            this.data[i] = new Info();
            this.ocupado[i] = false;
        }
        this.LSR = new Lista();
        this.cheia = false;
        this.qnt = 0;    
    }
    
    /**
     * Método que verifica se a cache está cheia.
     */
    public boolean cheia(){
        return this.qnt>=this.size;
    }
    
    /**
     * Método para atribuir/modificar o atributo data da CacheMemory.
     * O parâmetro value e o adress representam o valor contido e endereço da memória principal respectivamente.
     */
    public void setData(int value,int adress){
        int aux = mapeamentoDireto(adress);
        if(!this.cheia()){
            this.data[aux].setTag(adress);
            this.data[aux].setData(value);
            if(!ocupado[aux]){
                this.qnt++;
                ocupado[aux] = true;
                this.LSR.push_back(aux);
            }else{
                this.LSR.remove(aux);
                this.LSR.push_back(aux);
            }
        }
        else{
            int x = this.LSR.front();
            this.data[x].setTag(adress);
            this.data[x].setData(value);
            this.LSR.pop_front();
            this.LSR.push_back(x);
        }
    }
    
    /**
     * Método que retorna uma Info da CacheMemory.
     * Retorna o valor DATA do objeto Info Armazenado na CacheMemory no endereço definido pelo parâmetro adress.
     */
    public int getData(int adress){ 
        if(isValidate(adress))
            return this.data[adress].getData();
        else
            return -1;
    }
    
    /**
     * Método que retorna a TAG contida na CacheMemory.
     * Retorna a TAG contida no endereço da CacheMemory definido pelo parâmetro adress.
     */
    public int getTag(int adress){
        return this.data[adress].getTag();
    }
    
    /**
     * Método que verifica se o endereço de armazenamento é válido para a CacheMemory.
     * Verifica se o parâmetro adress está dentro do range da CacheMemory, Retornando true caso esteja ou false se não for válido. 
     */
    public boolean isValidate(int adress){
        return adress>=0 && adress< this.size;
    }
    
    /**
     * Método que verifica se endereço da memória principal já foi mapeado.
     * Retorna true em caso afirmativo,caso contrário false.
     */
    public boolean isLoaded(int value,int adress){
        int aux = mapeamentoDireto(adress);
        return (this.data[aux].getTag() == adress);
    }
    
    /**
     * Método que realiza o mapeamento direto.
     * Retorna a posição da cache em que o endereço definido pelo parâmetro adress será mapeado.
     */
    public int mapeamentoDireto(int adress){
        return adress%this.size;
    }
    
    /**
     * Método para imprimir informações da CacheMemory.
     */
    public void viewCache(){
        for(int i = 0;i<this.size;i++){
            this.data[i].print();
        }
        System.out.println(" ");
    }

}
