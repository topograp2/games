package breadBarber;

public class weapon {
	
    public String weaponName;
    
    public weapon() {
    	
    }
    public weapon(String n)
    {
    	this.weaponName = n;
    }
 
	public void attack(Player target){
		System.out.println(this.weaponName+"을 이용해 공격!");
    }

}
