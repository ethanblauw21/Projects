public class PC {

    private char ma;
    private int model;
    private float speed;
    private int ram;
    private int hd;
    private int price;

    public PC(char ma, int m , float s, int r, int h, int p){
        setMaker(ma);
        setModel(m);
        setSpeed(s);
        setRam(r);
        setHd(h);
        setPrice(p);
    }

    public char getMaker(){
        return ma;
    }

    public void setMaker(char ma){
        this.ma = ma;
    }

    public int getModel(){
        return model;
    }

    public void setModel(int m){
        this.model = m;
    }

    public float getSpeed(){
        return speed;
    }

    public void setSpeed(float s){
        this.speed = s;
    }

    public int getRam(){
        return ram;
    }

    public void setRam(int r){
        this.ram = r;
    }

    public int getHd(){
        return hd;
    }

    public void setHd(int h){
        this.hd = h;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int p){
        this.price = p;
    }
}
