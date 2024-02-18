package breadBarber;

public class hotdog extends weapon {
	private static hotdog instance;
	private hotdog() {
		this.weaponName = "핫도그";
	}
	public static hotdog getInstance() {
		if(instance == null)
			instance = new hotdog();
		return instance;
	}

    public void attack(Player target){
    	super.attack(target);
    	throww(target);
    }

    public void throww(Player target){
    	target.setHp(target.getHp()-7);
    }

}
