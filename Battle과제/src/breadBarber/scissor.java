package breadBarber;

public class scissor extends weapon {
	
	private static scissor instance;
	
    private scissor() {
    	this.weaponName = "가위";
    }
    
    
    public static scissor getInstance() {
    	if(instance == null)
    		instance = new scissor();
    	return instance;
    }

    public void attack(Player target){
    	super.attack(target);
    	this.cutHair(target);
    }

    public void cutHair(Player target){
    	target.setHp(target.getHp()-5);
    	
    }

}
