public class SomaNNaturaisV1 {
    public static void main(String[] args) {

        int entrada = Integer.parseInt(args[0]);
        
        System.out.println(entrada);
        int soma = 0;
        Long comeco = System.currentTimeMillis();
        for (int i=0; i <= entrada; i++){
            soma+=i;
        }
        System.out.println(soma);
        Long tempoFinal = System.currentTimeMillis();
        Long tempoTotal = tempoFinal - comeco;
        System.out.println("Tempo:" + tempoTotal);
    }
}
