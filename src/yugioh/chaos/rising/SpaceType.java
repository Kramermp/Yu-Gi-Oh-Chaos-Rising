/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yugioh.chaos.rising;

/**
 *
 * @author faust_000
 */
public enum SpaceType {
    NORMAL,
    /*
    Boosts: None
    Weakens: None
    */
    WASTELAND,
    /*
    -Boosts: Rock, Machine, Zombie
    -Reduces: Fish, Aqua, Sea Serpent
    */
    DARK,
    /*
    -Boosts: Spellcaster, Zombie, Fiend
    -Reduces: Fairy
    -Examples of field changers: Yami
    */
    WATER,
    /*
    -Boosts: Aqua, Fish, Sea Serpent, Thunder,
    -Reduces: Machine, Rock, Pyro
    */
    FOREST,
    /*
    -Boosts: Beast, Plant, Pyro, Beast-Warrior
    -Reduce: none
    */
    MEADOW,
    /*
    -Boosts: Warrior, Beast-Warrior
    -Reduces: Spellcaster
    */
    MOUNTAIN,
    /*
    -Boosts: Thunder, Dragon, Fairy, Winged-Beast
    -Reduces:
    */
    LABYRINTH,
    /*
    -Boosts: None (Note: this terrain cannot be moved on, except by monsters with
	special effects)
    -Reduces: None
    */
    TOON,
    /*
    -Boosts: Toons (Note: Toon is not a type, it is a special attribute listed on
	certain cards)
    -Reduces: All but Toon and Immortal
    */
    CRUSH
    /*
    -Boosts: Immortal
    -Reduces: None (Note: a monster with 1500+ ATK will automatically be destroyed
	if it is on Crush Terrain)
    */

}
