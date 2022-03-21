import java.util.Random;

public class Cliente {
    private int tipo;            // 0 = tratar negócios (2:30s) (30%)   (150s)
                                // 1 = individual       (1:00s) (50%)   (60s)
                                // 2 = dúvidas          (0:30s) (20%)   (30s)


    private double tempoServico; //Em segundos

    Random gerador = new Random();

    public Cliente() {
        int r = (gerador.nextInt(10)+1); // inteiros entre 0 e 9 somados a 1,  = (1,2,3,4,5,6,7,8,9,10);

        if(r<=5){
            this.tipo = 1;
            tempoServico = 150;
        }
        else if (r>8){
            this.tipo = 2;
            tempoServico = 60;
        }
        else {
            this.tipo = 0;
            tempoServico = 30;
        }
    }

    public double getTempoServico() {
        return tempoServico;
    }
    public  int getTipo(){
        return tipo;
    }
}
