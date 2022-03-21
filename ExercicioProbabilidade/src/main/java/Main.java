public class Main {
    public static void main(String[] args) {

        int tipo0 = 0;
        int tipo1 = 0;
        int tipo2 = 0;

        for(int i = 0;i<100;i++){
            Cliente c = new Cliente();
            System.out.println(c.tipo);
            if(c.tipo==0){
                tipo0++;
            }
            if(c.tipo==1){
                tipo1++;
            }
            if(c.tipo==2){
                tipo2++;
            }
            System.out.println("-------------------------------");
            System.out.println("Tipo 0 (30%):  "+tipo0);
            System.out.println("Tipo 1 (50%):  "+tipo1);
            System.out.println("Tipo 2 (20%):  "+tipo2);
        }
    }
}
