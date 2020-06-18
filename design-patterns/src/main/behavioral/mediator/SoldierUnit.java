package main.behavioral.mediator;

public class SoldierUnit implements ArmedUnit{
	
    private Mediator commander;
    
    public SoldierUnit(Mediator commander){
        this.commander=commander;
    }
    @Override
    public void attack(){
      if(commander.canAttack())
      {
          System.out.println("SoldierUnit: Attacking.....");
          commander.setAttackStatus(false);
      }
       else{
          System.out.println("SoldierUnit: Cannot attack now. Other units attacking....");
      }
    }
    @Override
    public void  stopAttack(){
        System.out.println("SoldierUnit: Stopped Attacking.....");
        commander.setAttackStatus(true);
    }
}