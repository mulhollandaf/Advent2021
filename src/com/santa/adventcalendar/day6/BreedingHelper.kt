package com.santa.adventcalendar.day6

class BreedingHelper(var fish: MutableList<Int>) {
    var daysLeft = Array(9) {0L}
    init {
        fish.forEach{
            daysLeft[it]++
        }
    }

    fun processDay(daysOfStudy: Int) {
        for(day in 1..daysOfStudy) {
            val newFish = daysLeft[0]
            for(x in 1..8){
                daysLeft[x-1] = daysLeft[x]
            }
            daysLeft[6] += newFish
            daysLeft[8] = newFish
        }
    }

    fun decreaseDaysToBreed(daysOfStudy:Int) {
        for(x in 1..daysOfStudy) {
            var newFish = 0
            fish = fish.map { daysToBreed ->
                if (daysToBreed > 0) {
                    daysToBreed - 1
                } else {
                    newFish++
                    6
                }
            } as MutableList<Int>
            for(y in 1..newFish){
                fish.add(8)
            }
        }
    }


    fun getDaysToBreed(): List<Int> {
        return fish
    }

    fun getNumberOfFish(): Long {
        return daysLeft.sum()
    }

}