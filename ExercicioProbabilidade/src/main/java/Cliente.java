import java.util.Random;

public class Cliente {
    public int tipo;            // 0 = tratar negócios (2:30s) (30%)
                                // 1 = individual (1:00s) (50%)
                                // 2 = dúvidas (2:30s) (20%)
    public float tempoServico;

    Random gerador = new Random();

    public Cliente() {
        float r = gerador.nextInt(9)+1; // inteiros no intervalo aberto entre 1 e 10;
        if(r<=3){
            this.tipo = 0;
        }
        else if (r>=8){
            this.tipo = 2
        }
        else {
            this.tipo = 1;
        }
    }
}
