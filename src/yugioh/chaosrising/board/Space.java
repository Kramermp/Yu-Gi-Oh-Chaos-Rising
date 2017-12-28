/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yugioh.chaosrising.board;

import yugioh.chaosrising.card.MonsterType;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author faust_000
 */
public class Space {
	public static final SpaceType DEFAULT_SPACETYPE = SpaceType.NORMAL;

    private SpaceType spaceType = DEFAULT_SPACETYPE;
    private ArrayList<MonsterType> monstersStrengthened = new ArrayList<MonsterType>();
    private ArrayList<MonsterType> monstersWeakened = new ArrayList<MonsterType>();
    //private MagicEffect spaceEffect = new MagicEffect();
    
    public Space (SpaceType spaceType) {
		this.spaceType = spaceType;
		buildStrengthsAndWeaknesses();
    }
    
    public SpaceType getSpaceType() {
		return this.spaceType;
    }
    
    public ArrayList<MonsterType> getMonstersStrengthened(){
		return monstersStrengthened;
    }
    
    public ArrayList<MonsterType> getMonstersWeakened() {
		return monstersWeakened;
    }
    
    public void setSpaceType(SpaceType spaceType) {
		this.spaceType = spaceType;
		buildStrengthsAndWeaknesses();
    }
    
    private void buildStrengthsAndWeaknesses() {
		//Any time we rebuild this we want to clear the list so we dont end up
		//stacking the lists
		monstersStrengthened.clear();
		monstersWeakened.clear();
		//spaceEffect = null;
		switch(this.spaceType) {
			case NORMAL:
				//Normal spaces reduce nothing and strengthen nothing just break
				break;
			case WASTELAND:
				monstersStrengthened.add(MonsterType.ROCK);
				monstersStrengthened.add(MonsterType.MACHINE);
				monstersStrengthened.add(MonsterType.ZOMBIE);
				monstersWeakened.add(MonsterType.FISH);
				monstersWeakened.add(MonsterType.AQUA);
				monstersWeakened.add(MonsterType.SEA_SERPENT);
				break;
			case DARK:
				monstersStrengthened.add(MonsterType.SPELLCASTER);
				monstersStrengthened.add(MonsterType.ZOMBIE);
				monstersStrengthened.add(MonsterType.FIEND);
				monstersWeakened.add(MonsterType.FAIRY);
				break;
			case WATER:
				monstersStrengthened.add(MonsterType.AQUA);
				monstersStrengthened.add(MonsterType.FISH);
				monstersStrengthened.add(MonsterType.SEA_SERPENT);
				monstersStrengthened.add(MonsterType.THUNDER);
				monstersWeakened.add(MonsterType.MACHINE);
				monstersWeakened.add(MonsterType.ROCK);
				monstersWeakened.add(MonsterType.PYRO);
				break;
			case FOREST:
				monstersStrengthened.add(MonsterType.BEAST);
				monstersStrengthened.add(MonsterType.PLANT);
				monstersStrengthened.add(MonsterType.PYRO);
				monstersStrengthened.add(MonsterType.BEAST_WARRIOR);
				//Forest Does not weaken any monsters leave this blank
				break;
			case MEADOW:
				monstersStrengthened.add(MonsterType.WARRIOR);
				monstersStrengthened.add(MonsterType.BEAST_WARRIOR);
				monstersWeakened.add(MonsterType.SPELLCASTER);
				break;
			case MOUNTAIN:
				monstersStrengthened.add(MonsterType.THUNDER);
				monstersStrengthened.add(MonsterType.DRAGON);
				monstersStrengthened.add(MonsterType.FAIRY);
				monstersStrengthened.add(MonsterType.WINGED_BEAST);
				//Mountain weakens no monsters leave this blank
				break;
			case TOON:
				monstersStrengthened.add(MonsterType.TOON);
				monstersWeakened.add(MonsterType.AQUA);
				monstersWeakened.add(MonsterType.BEAST);
				monstersWeakened.add(MonsterType.BEAST_WARRIOR);
				monstersWeakened.add(MonsterType.DINOSAUR);
				monstersWeakened.add(MonsterType.DRAGON);
				monstersWeakened.add(MonsterType.FAIRY);
				monstersWeakened.add(MonsterType.FIEND);
				monstersWeakened.add(MonsterType.FISH);
				monstersWeakened.add(MonsterType.INSECT);
				monstersWeakened.add(MonsterType.MACHINE);
				monstersWeakened.add(MonsterType.PLANT);
				monstersWeakened.add(MonsterType.PSYCHIC);
				monstersWeakened.add(MonsterType.PYRO);
				monstersWeakened.add(MonsterType.REPTILE);
				monstersWeakened.add(MonsterType.ROCK);
				monstersWeakened.add(MonsterType.SEA_SERPENT);
				monstersWeakened.add(MonsterType.SPELLCASTER);
				monstersWeakened.add(MonsterType.THUNDER);
				monstersWeakened.add(MonsterType.WARRIOR);
				monstersWeakened.add(MonsterType.WINGED_BEAST);
				monstersWeakened.add(MonsterType.WYRM);
				monstersWeakened.add(MonsterType.ZOMBIE);
				break;
			case LABYRINTH:
				// Labyrinth strengthens and weakens no monsters leave this blank
				//FIXME: ADD MAGIC EFFEECT
				break;
			case CRUSH:
				//Crush strengthens and weakens no monsters leave this blank
				//FIXME: ADD MAGIC EFFECT
				break;
			//Enum Switch no default case
		}
	}

	public static Space getTestSpace() {
		return new Space(getRandomSpaceType());
	}

	public static SpaceType getRandomSpaceType() {
    	Random rng = new Random();
    	switch(rng.nextInt(10)) {
			case 0:
				return SpaceType.MEADOW;
			case 1:
				return SpaceType.NORMAL;
			case 2:
				return SpaceType.WATER;
			case 3:
				return SpaceType.CRUSH;
			case 4:
				return SpaceType.DARK;
			case 5:
				return SpaceType.FOREST;
			case 6:
				return SpaceType.LABYRINTH;
			case 7:
				return SpaceType.MOUNTAIN;
			case 8:
				return SpaceType.TOON;
			case 9:
				return SpaceType.WASTELAND;
			default:
				return DEFAULT_SPACETYPE;
		}

	}
}
