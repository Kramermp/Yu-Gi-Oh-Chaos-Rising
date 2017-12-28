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
public interface Movable {
    //Will move entites along board on space
    public abstract void move(Direction direction);
    //Will move entites along board any number of spaces
    public abstract void move(Direction direction, int magnitude);
    
}
