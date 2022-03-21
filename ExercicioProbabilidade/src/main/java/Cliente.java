import java.util.Random;

public class Cliente {
    private int tipo;            // 0 = tratar negócios (2:30s) (30%)   (150s)
                                // 1 = individual (1:00s) (50%)         (60s)
                                // 2 = dúvidas (0:30s) (20%)            (30s)


    private double tempoServico; //Em segundos

    Random gerador = new Random();

    public Cliente() {
        float r = gerador.nextInt(9)+1; // inteiros no intervalo aberto entre 1 e 10;
        if(r<=3){
            this.tipo = 0;
            tempoServico = 150;
        }
        else if (r<=8){
            this.tipo = 1;
            tempoServico = 60;
        }
        else {
            this.tipo = 2;
            tempoServico = 30;
        }
    }
}
