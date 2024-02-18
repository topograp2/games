package breadBarber;

public class bread extends Player {
	
	
	public bread() {
		this.setHp(90);
		this.setPower(10);
		this.name = "브래드";
		this.img = "/images/bread.jpg";
		this.ownWeapon = scissor.getInstance();
	}



    public void train(){
    	super.train();
    	this.setPower(this.getPower()+5);
    	
    }

    public void selectWeapon(){
    	
    	//어떻게 하지
    	
    	super.selectWeapon();
  	
	    	if(this.ownWeapon.equals(scissor.getInstance()))
	    	{
	    		System.out.println("이제 브레드의 무기는 넥타이");
	    		
	    		this.ownWeapon = necktie.getInstance();
	    	}
	    	else
	    	{
	    		System.out.println("이제 브레드의 무기는 가위");
	    		this.ownWeapon = scissor.getInstance();
	    	}
    }

}
