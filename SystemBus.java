import java.util.Scanner;
import java.util.Random;
/**
 * Classe que simula um sistema de gerenciamento de mémoria.
 * 
 * @author (Jonathas Ruam) 
 * @version (0.1)
 */
public class SystemBus
{
    private Memory memory;
    private Processor processor[];
    private int qntProcessor;
    private int qntCores;
    
    public SystemBus(){
        
    }
    
    /**
     * Método que inicialia o sistema de gerenciamneto de memória.
     */
    public void startSystem(){
        Scanner in = new Scanner(System.in);
        Random gerador = new Random();
        int choice = 0;
        System.out.println("Numero de cores Do sistema:");
        choice = in.nextInt();
        while(choice%2 != 0){
            System.out.println("Numero de cores invalido!O sistema aceita apenas multiplos de 2.");
            System.out.println("Numero de cores Do sistema:");
            choice = in.nextInt();
        }
        this.qntCores = choice;
        this.qntProcessor = choice/2;
        this.processor = new Processor[qntProcessor];
        for(int i = 0;i<this.qntProcessor;i++){
            this.processor[i] = new Processor(i);
        }
        this.memory = new Memory(100);
        for(int i = 0;i<this.memory.getSize();i++){
            this.memory.setData(i,gerador.nextInt(1000));
        }
    }
    
    /**
     * Método que lista os componentes e seus respectivos valores atuais.
     */
    public void listarComponentes(){
        for(Processor p : processor){
            p.viewProcessor();
        }
        System.out.println("Memoria: ");
        this.memory.viewMemory();
    }
    
    /**
     * Método para realizar a leitura da memória principal.
     * Os parâmetros adress e coreId referem-se ao endereço da memoria principal que será escrito e o core que realizará 
     * a escrita.
     */
    public void read(int adress,int coreId){
        this.processor[(int) coreId/2].read(coreId,adress,this.memory);
        this.listarComponentes();
    }
    
    /**
     * Método para realizar a escrita da memória principal.
     * Os parâmetros adress e coreId referem-se ao endereço da memoria principal que será lido e o core que realizará 
     * a leitura.
     */
    public void write(int adress,int value,int coreId){
        this.processor[(int) coreId/2].write(value,coreId,adress,this.memory);
        UpdateSystem(adress,value);
        this.listarComponentes();
    }
    
    /**
     * Método que Realiza a chamada da atualização da hierarquia de memória.
     */
    public void UpdateSystem(int adress,int value){
        for(Processor p : processor){
            p.update(adress,value);
        }
    }
    
    
    /**
     * Método para iniciar um teste do sistema.
     * Simula um sistema com 4 cores.
     */
    public void TesteSystem(){
        this.qntCores = 4;
        this.qntProcessor = 4/2;
        this.processor = new Processor[qntProcessor];
        Random gerador = new Random();
        for(int i = 0;i<this.qntProcessor;i++){
            this.processor[i] = new Processor(i);
        }
        this.memory = new Memory(100);
        for(int i = 0;i<this.memory.getSize();i++){
            this.memory.setData(i,gerador.nextInt(1000));
        }
        
        this.listarComponentes();
    }
    
    /**
     * Método para simular Leitura.
     */
    public void testeRead(){
        this.read(0,0);
        this.read(5,1);
        this.read(17,2);
        this.read(35,3);
        this.read(64,0);
        this.read(99,1);
        this.listarComponentes();
    }
    
    /**
     * Método para simular escrita.
     */
    public void testeWriteReference(){
        this.write(0,362,0);//utilizando core que já contem
        this.write(5,24,2);//utilizando core que n contem o mapeamento
        this.write(99,47,3);
        this.listarComponentes();
    }
    
    /**
     * Método para simular leitura para teste write through.
     */
    public void testeWritethroughRead(){
        this.read(10,0);
        this.read(10,1);
        this.read(10,2);
        this.read(10,3);
        this.listarComponentes();
    }
    
    /**
     * Método para simular a escrita e ver o write-through.
     */
    public void testeWritethroughWrite(){
        this.write(10,444,0);
        this.listarComponentes();
    }
    
    /**
     * Método para simular o LRU.
     * é necessario realizar uma escrita após a chamada do método para ver a utilização do LSR.
     */
    public void testeLRU(){
        this.read(0,0);
        this.read(1,0);
        this.read(2,0);
        this.read(3,0);
        this.read(4,0);
        this.read(5,0);
        this.read(6,0);
        this.read(7,0);
        this.read(8,0);
        this.read(9,0);
        this.read(10,0);
        this.read(11,0);
        this.read(12,0);
        this.read(13,0);
        this.read(14,0);
    }
}
