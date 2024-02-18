package breadBarber;

public class expiredMilk extends weapon {
	private static expiredMilk instance;
	private expiredMilk() {
		this.weaponName = "썩은우유";
	}
	
	
	public static expiredMilk getInstance() {
		if(instance == null)
			instance = new expiredMilk();
		return instance;
	}

    public void attack(Player target){
    	super.attack(target);
    	this.pour(target);
    }

    public void pour(Player target){
    	target.setHp(target.getHp()-7);
    }

}
