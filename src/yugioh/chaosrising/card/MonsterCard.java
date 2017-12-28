/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yugioh.chaosrising.card;

import yugioh.chaosrising.MonsterAttribute;

/**
 *
 * @author mpk5206
 */
public class MonsterCard extends Card {
    private int monsterLevel = 1;
    private int monsterAttack = 1; 
    private int monsterDefense = 1;
    private MonsterAttribute monsterAttribute = MonsterAttribute.TEST;
    private MonsterType monsterType = MonsterType.TEST;
    
    public MonsterCard () {
	
    }
    public MonsterCard (String cardName, MonsterAttribute monsterAttribute, 
	    int monsterLevel, MonsterType monsterType, String cardDescription, 
	    int monsterAttack, int monsterDefense) {
        super(cardName, cardDescription, CardType.MONSTER);
	this.monsterAttribute = monsterAttribute;
	this.monsterLevel = monsterLevel;
	this.monsterType = monsterType;
        this.monsterAttack = monsterAttack;
        this.monsterDefense = monsterDefense;      
    }
    
    //Accessors
    public MonsterAttribute getMonsterAttribute() { return this.monsterAttribute; }
    public int getMonsterLevel() { return this.monsterLevel; }
    public MonsterType getMonsterType() { return this.monsterType; }
    public int getMonsterAttack() { return this.monsterAttack; }
    public int getMonsterDefense() { return this.monsterDefense; }
    
    
    //Mutators
    public void setMonsterAttack(int monsterAttack ) {
        this.monsterAttack = monsterAttack;
        this.monsterDefense = monsterDefense;
    }
}
