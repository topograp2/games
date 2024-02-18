package breadBarber;

public class penaut extends weapon {
	
	private static penaut instance;
	
    private penaut() {
    	this.weaponName = "땅콩";
    }
    
    public static penaut getInstance() {
    	if(instance == null)
    		instance = new penaut();
    	return instance;
    }

    public void attack(Player target){
    	super.attack(target);
    	this.sprinkle(target);
    }

    public void sprinkle(Player target){
    	//5 or 10
    	if((int)(Math.random()*100)%2 == 0)
    	{
    		target.setHp(target.getHp()- 10);
    		System.out.println("땅콩의 위력은 강력했다!!");
    	}
		else
		{
			target.setHp(target.getHp()- 5);
			System.out.println("땅콩은 작아서 무기론 별론가??...");
		}
    }

}
