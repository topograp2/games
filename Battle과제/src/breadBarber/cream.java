package breadBarber;

public class cream extends weapon {
	private static cream instance;
	
    private cream() {
    	this.weaponName = "생크림";
    }
    
    public static cream getInstance() {
    	if(instance == null)
    		instance = new cream();
    	return instance;
    }

    public void attack(Player target){
    	super.attack(target);
    	this.pour(target);
    }

    public void pour(Player target){
    	if((int)(Math.random()*100)%2 == 0)
    	{
    		System.out.println(target.name+"이(가) 생크림을 먹었다!!");
    		System.out.println(target.name+": 맛있기만 한데? 냠냠");
    	}
		else
		{
			target.setHp(target.getHp()- 15);
			System.out.println("생크림은 부드럽지만 강력해!!");
		}
    }

}
