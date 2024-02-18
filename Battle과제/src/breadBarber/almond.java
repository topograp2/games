package breadBarber;

public class almond extends weapon {
	
	private static almond instance;
	
	private almond() {
		this.weaponName = "아몬드";
	}
	
	public static almond getInstance() {
		if(instance == null)
			instance = new almond();
		return instance;
	}

    public void attack(Player target){
    	super.attack(target);
    	sprinkle(target);
    }

    public void sprinkle(Player target){
    	
    	target.setHp(target.getHp() - 7);
    }

}
