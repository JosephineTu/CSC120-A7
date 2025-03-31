/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements{
    int nCoffeeounces=10;
    int nSugarPackets=5;
    int nCreams=5;
    int nCups=5;
    public Cafe(String name, String address, int nFloors) {
        super(name,address,nFloors);
        System.out.println("You have built a cafe: ☕");
    }
    public void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeounces+=nCoffeeOunces;
        this.nSugarPackets+=nSugarPackets;
        this.nCreams+=nCreams;
        this.nCups+=nCups;
    }
    public void sellCoffee(int size, int nSugarPackets,int nCreams){
        if((this.nCoffeeounces-=size)<0){
            this.restock(2*size,0,0,0);
        }
        if((this.nSugarPackets-=nSugarPackets)<0){
            this.restock(0, 2*nSugarPackets, 0, 0);
        }
        if((this.nCreams-=nCreams)<0){
            this.restock(0,0,nCreams*2,0);
        }    
        if((this.nCups==0)){
            this.restock(0,0,0,10);
        }
        this.nCoffeeounces-=size;
        this.nSugarPackets-=nSugarPackets;
        this.nCreams-=nCreams;
        this.nCups-=1;
        System.out.println("Your "+size+" oz coffee with "+nSugarPackets+" sugar and "+nCreams+" cream is made!");
    }
    public static void main(String[] args) {
        Cafe ccCafe=new Cafe("ccCafe","1 Chapin Way",1);
        ccCafe.sellCoffee(3,1,1);
    }
    
}
