import java.util.*;     //Importações
import java.math.*;

public class Main {
    public static void main(String[] args) {

        Queue<Cliente> filaClientes = new LinkedList<>();

        double tempoSimulacao;              //total de segundos a serem simulados
        double tempoDecorrido = 0;          //tempo já simulado até o instante atual

        double taxaClientes;                //valor médio do intervalo entre a chegada de clientes
        double esperaClienteAtual = 0;      //tempo até a chegada de mais um cliente á fila

        double tempoAtendimentoAtual = 0;   //tempo restante para a conclusão do atendimento atual

        Scanner scan = new Scanner(System.in);  // Objeto que realiza leitura dos dados de entrada

        //-----------------------------------------------------------------------------------------

        System.out.println("Primeirameente, informe o tempo a ser simulado em segundos");
        tempoSimulacao = scan.nextDouble();

        System.out.println("Informe o tempo médio de diferença de tempo da chegada de novos clientes em segundo");
        taxaClientes =  scan.nextDouble();
        taxaClientes = 1/taxaClientes;

        //--------Execucão da Simulação--------------------------------------------------------------

        while(tempoSimulacao>=tempoDecorrido){

            if(esperaClienteAtual<=0){
                esperaClienteAtual = (-1 / taxaClientes) * Math.log (aleatorio());
                Cliente x = new Cliente();
                filaClientes.add(x);
            }

            if(tempoAtendimentoAtual<=0 && !filaClientes.isEmpty()){
                tempoAtendimentoAtual = filaClientes.remove().getTempoServico();
            }

        // avançar tempo da simulação em milésimos de segundos
            tempoAtendimentoAtual-=0.001;
            esperaClienteAtual-=0.001;
            tempoDecorrido+=0.001;
        }

        System.out.println("Clientes na fila no final da simulação: "+ filaClientes.size());
    }

    public static double aleatorio(){
        Random gerador = new Random();
        double x = gerador.nextDouble();  //retorna valor entre 0 e 1
        if(x!=0){
            return x;
        }
        else{
            return x+0.001; //  impede o caso específico em que é gerado um 0
        }
    }
}
