package breadBarber;

public class Player {
    private int hp;
    public String name;
    private int power;
    public String img;
    protected weapon ownWeapon;
    
    public weapon getOwnWeapon() {
    	return ownWeapon;
    }
    
    public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
	public Player() {}
    public Player(int hp, String name, int power, String img, weapon ownWeapon) {
    	this.hp = hp;
    	this.name = name;
    	this.power = power;
    	this.img = img;
    	this.ownWeapon = ownWeapon;
    }

    public void attack(Player target){
    	System.out.println(this.name + "이(가) "+target.name +"을(를) 공격!");
    	ownWeapon.attack(target);
    	target.setHp(target.getHp()- this.getPower());
    }

    public void train(){
    	System.out.println(this.name + "이(가) 훈련합니다! 으쌰!");
    	//하위클래스 구현
    }

    public void selectWeapon(){
    	System.out.println(this.name+"가 무기를 바꿉니다!");
    }

    public void show_header(){
    	System.out.println("-------------------");
    	System.out.println("Welcome to breadbarbershop!");
    	System.out.println("-------------------");
    }

    public void showState(){
    	System.out.printf("[%10s] hp(%d) power(%d) weapon(%s)\n", this.name, this.hp, this.power, ownWeapon.weaponName);
    }

}
