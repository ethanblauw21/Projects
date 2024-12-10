public class Laptop {

    private char maker;
    private int model;
    private float speed;
    private int ram;
    private int hd;
    private float screen;
    private int price;

    public Laptop(char ma, int m, float sp, int r, int h, float sc, int p){
        setMaker(ma);
        setModel(m);
        setSpeed(sp);
        setRam(r);
        setHd(h);
        setScreen(sc);
        setPrice(p);
    }

    public char getMaker(){
        return maker;
    }

    public void setMaker(char ma){
        this.maker = ma;
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

    public float getScreen(){
        return screen;
    }

    public void setScreen(float s){
        this.screen = s;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int p){
        this.price = p;
    }
}
