package breadBarber;

public class wilk extends Player {
	
	
	public wilk() {
		this.setHp(100);
		this.setPower(5);
		this.name = "윌크";
		this.img = "/images/wilk.jpg";
		this.ownWeapon = expiredMilk.getInstance();
	}
	public wilk(int hp, String name, int power, String img, weapon ownWeapon) {
		super();
	}

    public void train(){
    	this.setPower(getPower()+8);
    }

    public void selectWeapon(){
    	super.selectWeapon();
    	if(this.ownWeapon.equals(expiredMilk.getInstance()))
    	{
    		System.out.println("이제 윌크의 무기는 크림");
    		this.ownWeapon = cream.getInstance();
    	}
    	else {
    		System.out.println("이제 윌크의 무기는 썩은우유");
    		this.ownWeapon = expiredMilk.getInstance();
    	}
    }

}
