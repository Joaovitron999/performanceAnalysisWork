//Atividade análise de desempenho
//João Vitor Fonseca / 2020.1.08.003 / março de 2020


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

        //Contadores perfis de Clientes
        int c0 = 0;
        int c1 = 1;
        int c2 = 2;
        //tempo ocupado
        double tempoOcupado = 0;

        double taxaTempoOcupado;
        //tamanho máximo da fila
        int maxFila = 0;

        double taxaOcupacao = 0;
        double tempoServico = 0;
        double intervalosChegada = 0;

        //-----------------------------------------------------------------------------------------

        System.out.println("Primeiramente, informe o tempo a ser simulado em segundos");
        tempoSimulacao = scan.nextDouble();

        System.out.println("Informe o tempo médio de diferença de tempo da chegada de novos clientes em segundo");
        taxaClientes =  scan.nextDouble();
        taxaClientes = 1/taxaClientes;

        //  Primeiro cliente
        esperaClienteAtual = (-1 / taxaClientes) * Math.log (aleatorio());
        intervalosChegada+=esperaClienteAtual;

        //--------Execucão da Simulação--------------------------------------------------------------

        while(tempoSimulacao>=tempoDecorrido){

            if(esperaClienteAtual<=0){
                esperaClienteAtual = (-1 / taxaClientes) * Math.log (aleatorio());
                Cliente x = new Cliente();
                filaClientes.add(x);
                intervalosChegada+=esperaClienteAtual;
            }

            if(tempoAtendimentoAtual<=0 && !filaClientes.isEmpty()){
                if(filaClientes.peek().getTipo()==0){
                    c0++;
                }else if(filaClientes.peek().getTipo()==1){
                    c1++;
                }else{
                    c2++;
                }

                tempoAtendimentoAtual = filaClientes.remove().getTempoServico();
                tempoServico += tempoAtendimentoAtual;
            }

            if(filaClientes.size()>maxFila){
                maxFila = filaClientes.size();
            }
            if(!filaClientes.isEmpty()){
                tempoOcupado+=0.001;
            }

        // avançar tempo da simulação em milésimos de segundos
            tempoAtendimentoAtual-=0.001;
            esperaClienteAtual-=0.001;
            tempoDecorrido+=0.001;
        }
        //Tempo ocupaçao
        taxaTempoOcupado=(tempoOcupado/(tempoSimulacao))*100;
        //Taxa ocupação total (tempo de serviço/intervalo de chegada)
        taxaOcupacao = tempoServico/intervalosChegada;

        System.out.println("______________________________________________");
        System.out.println("Clientes na fila no final da simulação: "+ filaClientes.size());
        System.out.println("_______________________");
        System.out.println("Clientes que trataram de negócios (30%):    "+c0);
        System.out.println("Clientes que atendimento individual (50%):    "+c1);
        System.out.println("Clientes que vieram tirar dúvidas (20%):    "+c2);
        System.out.println("_______________________");
        System.out.println("Taxa ocupação total: "+taxaOcupacao);
        System.out.println("Taxa de tempo ocupado: "+taxaTempoOcupado+"% do tempo");
        System.out.println("Valor máximo da fila: "+maxFila);
        System.out.println("______________________________________________");




    }

    public static double aleatorio(){
        Random gerador = new Random();
        double x = gerador.nextDouble();  //retorna valor entre 0 e 1
        if(x!=0){
            return x;
        }
        else{
            return x+0.001; //  impede o caso específico em que é gerado um 0.0
        }
    }
}
