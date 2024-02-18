package breadBarber;

public class sosi extends Player {

	public sosi() {
		this.setHp(100);
		this.setPower(5);
		this.name = "소시지";
		this.img = "/images/sausi.jpg";
		this.ownWeapon = hotdog.getInstance();
	}
	public sosi(int hp, String name, int power, String img, weapon ownWeapon) {
		super();
	}

    public void attack(Player target){
    	super.attack(target);
    }

    public void train(){
    	this.setPower(getPower()+9);
    }

    public void selectWeapon(){
    	super.selectWeapon();
    	if(this.ownWeapon == hotdog.getInstance())
    	{
    		System.out.println("무기를 치즈로 변경합니다.");
    		this.ownWeapon = cheeze.getInstance();
    		
    	}
    	else
    	{
    		System.out.println("무기를 핫도그로 변경");
    		this.ownWeapon = hotdog.getInstance();
    	}
    		
    		
    }

}
