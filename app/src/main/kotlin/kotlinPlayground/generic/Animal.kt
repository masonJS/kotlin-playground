package kotlinPlayground.generic

abstract class Animal (val name: String)

abstract class Fish(name: String) : Animal(name)

class Shark(name: String) : Fish(name)

class GoldFish(name: String) : Fish(name)
