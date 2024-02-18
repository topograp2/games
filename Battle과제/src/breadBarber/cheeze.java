package breadBarber;

public class cheeze extends weapon {
	private static cheeze instance;
	
    private cheeze() {
    	this.weaponName = "치즈";
    }
    
    public static cheeze getInstance() {
    	if(instance == null)
    		instance = new cheeze();
    	return instance;
    }

    public void attack(Player target){
    	super.attack(target);
    	this.spread(target);
    }

    public void spread(Player target){
    	if((int)(Math.random()*100)%2 == 0)
    	{
    		System.out.println("이번 치즈는 맛있기만 하고 공격이 안되네...");
    	}
    	else
    	{
    		target.setHp(target.getHp()*(2/3));
    	}
    }

}
