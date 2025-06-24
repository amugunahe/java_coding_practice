package com.abstractex;

public interface Fightable extends Movable, Attackable{
@Override
default void attack(Unit u) {
	
}
@Override
default void move (int x, int y) {
	
}
}
