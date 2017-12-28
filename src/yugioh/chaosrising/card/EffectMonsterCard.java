/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yugioh.chaosrising.card;

import yugioh.chaosrising.magiceffects.MonsterEffect;

/**
 *
 * @author faust_000
 */
public class EffectMonsterCard extends MonsterCard {
    
    private MonsterEffect monsterEffect;
    
    public EffectMonsterCard(String cardName, MonsterAttribute monsterAttribute,
							 int monsterLevel, MonsterType monsterType, String cardDescription,
							 MonsterEffect monsterEffect, int monsterAttack, int monsterDefense) {
	super(cardName, monsterAttribute, monsterLevel, monsterType,
		cardDescription, monsterAttack, monsterDefense);
	this.monsterEffect = monsterEffect;
    }
    
    
}
