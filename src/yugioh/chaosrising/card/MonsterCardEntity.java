/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yugioh.chaosrising.card;

import yugioh.chaosrising.player.Player;

/**
 *
 * @author faust_000
 */
public class MonsterCardEntity extends CardEntity {
    private int attack = 0;
    private int defense = 0;
    private MonsterType monsterType = MonsterType.TEST;
    private MonsterAttribute monsterAttribute = MonsterAttribute.TEST;
    
    public MonsterCardEntity (Player owner, MonsterCard baseCard, int[] cardCoordinates) {
	super(owner, baseCard, cardCoordinates);
	this.attack = baseCard.getMonsterAttack();
	this.defense = baseCard.getMonsterDefense();
	this.monsterType = baseCard.getMonsterType();
	this.monsterAttribute = baseCard.getMonsterAttribute();
    }
    
    public int getMonsterAttack() {
	return this.attack;
    }
    public int getMonsterDefense() {
	return this.defense;
    }
    public void modifyMonsterAttack(int attackChange) {
	//Attack Change can be positive or negative
	/*
	    Use a double test value in order to protect against an overflow
	*/
	double testValue = this.attack + (double) attackChange;
	if (testValue < 0 ) {
	    /*
		Attack cannot be allowed to go below 0 because it will break
		the logic that is applied in locations throught the game	    
	    */
	    this.attack = 0;
	} else if ( testValue > 100000) {
	    /*
		Attack cannot be allowed to go too high because it will break
		the logic that is applied in locations throughout the game. To 
		defend against this, the attack of MonsterCardEntities is capped
		at 99,999
	    */
	    this.attack = 99999;
	} else {
	    /*
	    	GoldiLocks Zone
		If the defense is not too low and not too high it will be changed
		to its expected value. Just cast testValue so we don't have to 
		recalculate it.
	    */
	    this.attack = (int) testValue;
	}
    }
    public void modifyMonsterDefense(int defenseChange) {
	//Defense change can be a negative or positve int
	//Use a double test value in order to protect against an overflow
	double testValue = defense + (double) defenseChange;
	if (testValue < 0 ) {
	    /*
		Defense cannot be allowed to go below 0 because it will break
		the logic that is applied in locations throught the game	    
	    */
	    this.defense = 0;
	} else if ( testValue > 100000) {
	    /*
		Defense cannot be allowed to go too high because it will break
		the logic that is applied in locations throughout the game. To 
		defend against this, the defense of MonsterCardEntities is capped
		at 99,999
	    */
	    this.defense = 99999;
	} else {
	    /*
	    	Goldilocks Zone
		If the defense is not too low and not too high it will be changed
		to its expected value. Just cast testValue so we don't have to 
		recalculate it.
	    */
	    this.defense = (int) testValue;
	}
    }
    public MonsterType getMonsterType() {
	return this.monsterType;
    }
    public MonsterAttribute getMonsterAttribute() {
	return this.monsterAttribute;
    }
    
    
    
}
