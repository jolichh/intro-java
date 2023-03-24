/* 
 *
 * Programa que fa de rellotje.
 * 
 * Inclou un main (al final del codi) que comprova la seva funcionabilitat
 *
 * Les propietats serán privades (hora, minut,segons) de tipus enter.
 * Els accessors són públics que asseguren que l'hora és sempre vàlida.
 *
 * Per defecte l'hora serà 0:00:00, encara que es pot inicialitzar amb altres valors vàlids: un constructor específic.
 *
 * Inclou validació de hores en boolean, comparació i duplicació d'hores
 *
 */

public class Hora {
    private int hores = 0;  
    private int minuts = 00;
    private int segons = 00;
    
    public Hora() {     //default 0:00:00
        hores = getHores();
        minuts = getMinuts();
        segons = getSegons();
    }
    
    public static boolean esValida(int hora, int min, int sec) {
        if (hora>=0 && hora<24 && min<=59 && min>=0 && sec<=59 && sec>=0) {return true;}
        return false;
    }
    public static int compareTo(Hora hora1, Hora hora2) {        
        if (hora1.hores == hora2.hores && hora1.minuts == hora2.minuts && hora1.segons==hora2.segons) {return 0;}
        
        if (hora1.hores == hora2.hores && hora1.minuts == hora2.minuts && hora1.segons>hora2.segons) {return 1;}
        if (hora1.hores == hora2.hores && hora1.minuts > hora2.minuts) {return -1;}
        if (hora1.hores > hora2.hores) {return -1;} //comparando horas
        
        return -1;
    }
    public Hora duplica() {     //duplica la instancia actual
        Hora hora2 = new Hora(this.hores, this.minuts, this.segons);
        return hora2;
    }
    public static Hora duplica(Hora hora1) {    //duplica la instancia que li passem
        Hora hora2 = new Hora(hora1.hores, hora1.minuts, hora1.segons);
        return hora2;
    }
    
    public Hora(int hores, int minuts, int segons) {
        if (hores>=0 && hores<24 && minuts<=59 && minuts>=0 && segons<=59 && segons>=0) {     //comprovar si son vàlids
            this.setHores(hores);          
            this.setMinuts(minuts);
            this.setSegons(segons);
        }
    }
    
    public int getHores() {return hores;}
    public int getMinuts() {return minuts;}
    public int getSegons() {return segons;}
    
    public void setHores(int hores) {
        this.hores = hores;
    }
    public void setMinuts(int minuts) {
        if (minuts<=59 && minuts>=0) {      //comprovar si són vàlids
            this.minuts = minuts;
        }
    }
    public void setSegons(int segons) {
        if (segons<=59 && segons>=0) {      //comprovar si són vàlids
            this.segons = segons;
        }
    }
    
    public void incrementa() {   //fa que l'hora tingui un segon més
        segons++;
        if (segons == 60) {
            segons = 0;
            minuts++;
            if (minuts == 60) {
                minuts = 0;
                hores++;
                if (hores == 24){
                    hores = 0;
                }
            }
        }
    }
    public void incrementa(int segons) {     //fa que l'hora incrementi
        if (segons < 0) {   //si es negativo lo mandamos a decrementaN
            segons = Math.abs(segons);
            decrementa(segons); 
            return;
        }  
        if (segons<=60) {   //atajo cuando incrementa pocos segundos
            for (int i=0; i<segons; i++) {
                incrementa();
            }
            return;
        }
        int seconds = this.segons + segons; //total de segundos
        //pasamos a corregir segundos
        int secTotal = seconds%60;  //guada total segons que quedaría al netejar
        int tmp1 = seconds-secTotal;
        int minSumar = tmp1/60;     //quant pertany a minuts
        
        int minutes = this.minuts + minSumar;   //total minuts
        //pasamos a corregir minutos
        int minTotal = minutes%60;
        int tmp2 = minutes-minTotal;
        int horsSum = tmp2/60;  //quant pertany a hores
        
        int hoursTotal = this.hores + horsSum;  //total hores
        //corretgim hores (només mostrarem 23~00)
        while (hoursTotal>=24) {
            hoursTotal = hoursTotal-24;
        }
        
        //asignamos a todos sus valores
        this.hores = hoursTotal;
        this.minuts = minTotal;
        this.segons = secTotal;
    }
    
    public void decrementa(){   //fa que l'hora tingui un segon menys
        segons--;
        if (segons < 0) {
            segons = 59;
            minuts--;
            if (minuts < 0) {
                minuts = 59;
                hores--;
                if (hores < 0) {
                    hores = 23;
                }
        }
        }        
    }
    public void decrementa(int segons){   //fa que l'hora decrementi els segons indicats
        if (segons<0) {
            segons = Math.abs(segons);  //removing negatives
            incrementa(segons);
            return;
        }
        if (segons<=60){
            for (int i=0; i<segons; i++) {
                decrementa();
            }
            return;
        }
        
        //pasamos los segundos a horas
        int sobra1 = segons%3600;
        int tmp1 = segons-sobra1;
        int restarH = tmp1/3600;     //horas a restar

        //pasamos lo sobrante a minutos
        int restarS = sobra1%60;     //segundos a restar
        int tmp2 = sobra1-restarS;
        int restarM = tmp2/60;   //minutos a restar

        //empezamos a restar por los segundos
        int sec = this.segons;    //aquí guardaremos los segundos de la resta
        int contador1 = 0;  //contador para restar minutos
        if ((this.segons-restarS)<0) {
            for (int i=0; i<restarS; i++) {  //bucle para ir restando los segundos
                sec--;
                if (sec<0) {    //cada vez que queda por debajo hay que restar un minuto que
                    contador1++;
                    sec = 59;
                }
            }
        }
        else {
            sec = this.segons -restarS;     //en caso que no sea negativo la resta
        }
        //empezamos a restar por los minutos
        int min = this.minuts;   //total de minutos
        restarM = restarM + contador1;  //sumamos la resta de minutos con las adicionales de arriba
        int contador2 = 0;  //contador de cuantas horas se van a restar
        if ((this.minuts-restarM)<0) {  //si la resta queda por debajo de 0 se resta una hora
            for (int i=0; i<restarM; i++) {
                min--;
                if (min<0) {
                    contador2++;
                    min = 59;
                }
            }
        } else {
            min = this.minuts-restarM;
        }
        //restamos horas
        restarH = restarH+contador2;
        int hor = this.hores;
        
        for (int i=0; i<restarH; i++) {
            hor--;
            if (hor<0) {
                hor = 23;
            }
        }
        //asignamos horas minutos y segundos
        this.hores = hor;
        this.minuts = min;
        this.segons = sec;
        
    }
    
    public int compareTo(Hora hora2) {        //compara la hora que tenim amb la que ens passa
        if (this.hores > hora2.hores) { return 1;}
        if (this.minuts > hora2.minuts) { return 1;}
        if (this.segons > hora2.segons) { return 1;}
        if (this.hores == hora2.hores && this.minuts == hora2.minuts && this.segons == hora2.segons) {return 0;}
        return -1;
    }
    
    @Override
    public String toString() {
        return String.format("%d:%02d:%02d", hores, minuts, segons);
    }
    
    /*
     * Compara dues hores i retorna l'operador corresponent
     * Per exemple, si hora1 és menor que hora2, l'operador serà "<". Els
     * altres dos valors possibles són ">" i "=="
     * @param hora1: primera hora a comparar
     * @param hora2: segona hora a comparar
     * @return operador resultant
     *
     */
    private static String composaOperadorComparacio(Hora hora1, Hora hora2) {
        int comparacio = hora1.compareTo(hora2);
        if (comparacio < 0) {
            return "<";
        } else if (comparacio > 0) {
            return ">";
        } else {
            return "==";
        }
    }
    public static void main(String[] args) {
        Hora hora1 = new Hora();
        Hora hora2 = new Hora(0, 0, 2);
        System.out.printf("Inicialment hora1: %s %s hora2: %s%n",
                hora1,
                composaOperadorComparacio(hora1, hora2),
                hora2);
        System.out.println("Incrementem 1 segon a la primera i decrementem 1 segon a la segona");
        hora1.incrementa();
        hora2.decrementa();
        System.out.printf("Finalment hora1: %s %s hora2: %s%n",
                hora1,
                composaOperadorComparacio(hora1, hora2),
                hora2);
    }
}
