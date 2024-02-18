package breadBarber;

public class choco extends Player {

	
	public choco() {
		this.setHp(100);
		this.setPower(5);
		this.name = "초코";
		this.img = "/images/choco.jpg";
		this.ownWeapon = almond.getInstance();
	}
	public choco(int hp, String name, int power, String img, weapon ownWeapon) {
		super();
	}


    public void train(){
    	this.setPower(getPower()+8);
    }

    public void selectWeapon(){
    	super.selectWeapon();
    	if(this.ownWeapon == almond.getInstance())
    	{
    		System.out.println("이제 초코의 무기는 땅콩");
    		this.ownWeapon = penaut.getInstance();
    	}
    	else
    	{
    		System.out.println("이제 초코의 무기는 아몬드");
    		this.ownWeapon = almond.getInstance();
    	}
    }

}
