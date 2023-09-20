package kotlinPlayground.generic

fun main() {
    val cage = Cage2<Shark>()
    cage.add(Shark("상어"))

    // Cage.kt 에서의 문제 해결
    val shark: Shark = cage.getFirst()

    // -- 또다른 문제 발생
    val goldFish = Cage2<GoldFish>()
    goldFish.add(GoldFish("금붕어"))

    val fish = Cage2<Fish>()
    fish.moveFrom(goldFish) // 컴파일 에러 발생
    /**
     * Fish 와 GoldFish는 상속 관계지만 Cage2<Fish> 와 Cage2<GoldFish>는 상속 관계가 아니다. 아무 관계도 아니다.
     * 즉, Cage2는 무공변(invariant)하다.
     *
     * 제네릭을 사용하는 리스트는 배열과 다르게 무공변 하다.
     * 무공변 하기때문에 좀더 타입 안전하며 Effective Java에서는 배열보다는 리스트를 사용하라고 권장한다.
     */

    // Cage2<Fish> 와 Cage2<GoldFish>를 상속관게로 이어주는 방법(공변하게 만드는 법) => Cage3.kt 파일 참고
}

class Cage2<T> {
    private val animals = mutableListOf<T>()

    fun getFirst(): T {
        return this.animals.first()
    }

    fun add(animal: T) {
        this.animals.add(animal)
    }

    fun moveFrom(otherCage: Cage2<T>) {
        this.animals.addAll(otherCage.animals)
    }
}