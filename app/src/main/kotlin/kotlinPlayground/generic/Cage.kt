package kotlinPlayground.generic

fun main() {
    val cage = Cage()
    cage.add(Shark("상어"))

    // 1. Cage에는 Animal만 들어갈 수 있기 때문에 컴파일 에러 발생
    val shark1: Shark = cage.getFirst() // Type mismatch: inferred type is Animal but Shark was expected

    // 2. Type cast를 하면 컴파일 에러는 발생하지 않지만 런타임 에러 발생
    val shark2: Shark = cage.getFirst() as Shark // Type cast 하지만 위험하다.
    /**
     * 만약 아래와 같은 코드이면 런타임 에러 발생
     * val shark: Shark = cage.getFirst() as GoldFish // ClassCastException
     */

    // 3. safe type casting & elvis operator
    val shark3: Shark? = cage.getFirst() as? Shark ?: throw IllegalArgumentException("상어가 아닙니다.")
    /**
     * IllegalArgumentException 에러 발생으로 예측할순 있지만 에러 발생의 행위를 없앨순 없었다.
     */

    // 제네릭을 사용하여 타입 호환을 지키는 방법 => Cage2.kt 파일 참고
}

class Cage {
    private val animals = mutableListOf<Animal>()

    fun getFirst(): Animal {
        return this.animals.first()
    }

    fun add(animal: Animal) {
        this.animals.add(animal)
    }

    fun moveFrom(otherCage: Cage) {
        this.animals.addAll(otherCage.animals)
    }
}