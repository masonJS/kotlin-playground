package kotlinPlayground.generic

fun main() {
    val goldFish = Cage3<GoldFish>()
    goldFish.add(GoldFish("금붕어"))

    val fish = Cage3<Fish>()
    // Cage2.kt 에서의 문제 해결
    // out 변성 어노테이션 (공변성) 사용
    fish.moveFrom(goldFish)

    val shark = Cage3<Shark>()
    // in 변성 어노테이션 (반공변성) 사용
    shark.moveTo(fish)
}

class Cage3<T> {
    private val animals = mutableListOf<T>()

    fun getFirst(): T {
        return this.animals.first()
    }

    fun add(animal: T) {
        this.animals.add(animal)
    }

    /**
     * out 변성 어노테이션 (공변성)
     * - Cage3<out T>는 Cage3<T>의 하위 타입이다.
     * - 오직 데이터를 꺼내는 생산자의 역할만 할 수 있다.
     *   - anmials: MutableList<T>
     *   - getFirst(): T
     * */
    fun moveFrom(otherCage: Cage3<out T>) {
        this.animals.addAll(otherCage.animals)
    }

    /**
     * in 변성 어노테이션 (반공변성)
     * - Cage3<in T>는 Cage3<T>의 상위 타입이다.
     * - 오직 데이터를 넣는 소비자의 역할만 할 수 있다.
     *   - add(animal: T)
     */
    fun moveTo(otherCage: Cage3<in T>) {
        otherCage.animals.addAll(this.animals)
    }
}