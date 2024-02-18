package breadBarber;

public class necktie extends weapon {
	private static necktie instance;
	
	private necktie() {
		this.weaponName = "넥타이";
	}
	
	public static necktie getInstance() {
		if(instance == null)
			instance = new necktie();
		return instance;
	}

    public void attack(Player target){
    	super.attack(target);
    	this.strain(target);
    }

    public void strain(Player target){
    	target.setHp(target.getHp() -((int)(Math.random()*100)%10 + 3) );
    }

}
