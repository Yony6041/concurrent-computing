package kas.concurrente;

import kas.concurrente.candados.Lock;
import kas.concurrente.candadosImpl.DekkerLock;

public class Main implements Runnable {
    
    public static final Integer DISCOS = 10;
    public static final Double OCELOT = (double) (9/10);
    public static final Double BOSS = (double) (8/10);

    private Integer contadorFinal = 0;
    private Lock lock = new DekkerLock();

    public Integer getContadorFinal() {
        return contadorFinal;
    }

    public void setContadorFinal(Integer contadorFinal) {
        this.contadorFinal = contadorFinal;
    }

    @Override
    public void run() {
        for(int balas = 0; balas < DISCOS; ++balas){
            lock.lock();
            contadorFinal++;
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Main campoDeTiro = new Main();

        Thread ocelot = new Thread(campoDeTiro, "0");
        Thread boss = new Thread(campoDeTiro, "1");

        ocelot.start(); 
        boss.start();

        ocelot.join(); 
        boss.join();

        System.out.println("Contador final: " + campoDeTiro.getContadorFinal());
    }
}
